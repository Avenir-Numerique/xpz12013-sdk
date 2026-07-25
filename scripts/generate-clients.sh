#!/usr/bin/env bash
#
# Generates the Java / TypeScript / Python clients from the OpenAPI specs in spec/.
# No-op (exit 0) when the specs are absent — generation is gated on the AFNOR licensing
# decision (NEOTIMO-1417). Requires Node.js (npx) and a JRE (openapi-generator runs on the JVM).
#
# Usage: scripts/generate-clients.sh [version]   (version defaults to 1.3.0)

set -euo pipefail

VERSION="${1:-1.3.0}"
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SPEC_DIR="$ROOT/spec"
CONFIG_DIR="$ROOT/clients/generator-config"
OUT_DIR="$ROOT/clients"

FLOW_SPEC="$SPEC_DIR/flow-service.json"
DIRECTORY_SPEC="$SPEC_DIR/directory-service.json"

if [[ ! -f "$FLOW_SPEC" || ! -f "$DIRECTORY_SPEC" ]]; then
  echo "WARN  Specs OpenAPI absentes de spec/ (flow-service.json, directory-service.json)."
  echo "      Generation multi-langue ignoree -- cf. NEOTIMO-1417 (juridique des annexes AFNOR)."
  exit 0
fi

# The norm models `ReasonCode` as an extensible set: oneOf[ReasonCodeEnum, string]. The
# openapi-generator (typescript-fetch) mis-handles that oneOf-with-primitive and emits a broken
# `import { string } from './string'`, breaking `npm run build`. We flatten ReasonCode to a plain
# string (its faithful open form) in throwaway copies fed to the generator — spec/ stays pristine
# and 1:1 with the norm. This mirrors the .NET NSwag side (An.Platform.Module.XpZ12013).
WORK="$(mktemp -d)"
trap 'rm -rf "$WORK"' EXIT

flatten_reasoncode() { # <src> <dst>
  python - "$1" "$2" <<'PY'
import json, sys
src, dst = sys.argv[1], sys.argv[2]
doc = json.load(open(src, encoding='utf-8'))
schemas = doc.get('components', {}).get('schemas', {})
rc = schemas.get('ReasonCode')
if isinstance(rc, dict) and 'oneOf' in rc:
    schemas['ReasonCode'] = {'type': 'string', 'description': rc.get('description', '')}
json.dump(doc, open(dst, 'w', encoding='utf-8'), ensure_ascii=False)
PY
}

flatten_reasoncode "$FLOW_SPEC"      "$WORK/flow-service.json"
flatten_reasoncode "$DIRECTORY_SPEC" "$WORK/directory-service.json"
FLOW_SPEC="$WORK/flow-service.json"
DIRECTORY_SPEC="$WORK/directory-service.json"

OG=(npx --yes @openapitools/openapi-generator-cli generate)

generate() { # <generator> <spec> <out> <config> [extra args...]
  local generator="$1" spec="$2" out="$3" config="$4"; shift 4
  echo "-> ${generator}: $(basename "$spec") -> ${out#"$ROOT/"}"
  rm -rf "$out"
  "${OG[@]}" -g "$generator" -i "$spec" -o "$out" -c "$config" "$@"
}

# --- TypeScript (fetch, no runtime deps) ---
generate typescript-fetch "$FLOW_SPEC"      "$OUT_DIR/typescript/flow"      "$CONFIG_DIR/typescript.json" \
  --additional-properties="npmName=@neotimo/xpz12013-flow,npmVersion=${VERSION}"
generate typescript-fetch "$DIRECTORY_SPEC" "$OUT_DIR/typescript/directory" "$CONFIG_DIR/typescript.json" \
  --additional-properties="npmName=@neotimo/xpz12013-directory,npmVersion=${VERSION}"

# --- Python (urllib3) ---
generate python "$FLOW_SPEC"      "$OUT_DIR/python/flow"      "$CONFIG_DIR/python.json" \
  --additional-properties="packageName=neotimo_xpz12013_flow,projectName=neotimo-xpz12013-flow,packageVersion=${VERSION}"
generate python "$DIRECTORY_SPEC" "$OUT_DIR/python/directory" "$CONFIG_DIR/python.json" \
  --additional-properties="packageName=neotimo_xpz12013_directory,projectName=neotimo-xpz12013-directory,packageVersion=${VERSION}"

# --- Java (java.net.http, no runtime deps) ---
generate java "$FLOW_SPEC"      "$OUT_DIR/java/flow"      "$CONFIG_DIR/java.json" \
  --additional-properties="groupId=fr.neotimo,artifactId=xpz12013-flow,artifactVersion=${VERSION},invokerPackage=fr.neotimo.xpz12013.flow,apiPackage=fr.neotimo.xpz12013.flow.api,modelPackage=fr.neotimo.xpz12013.flow.model"
generate java "$DIRECTORY_SPEC" "$OUT_DIR/java/directory" "$CONFIG_DIR/java.json" \
  --additional-properties="groupId=fr.neotimo,artifactId=xpz12013-directory,artifactVersion=${VERSION},invokerPackage=fr.neotimo.xpz12013.directory,apiPackage=fr.neotimo.xpz12013.directory.api,modelPackage=fr.neotimo.xpz12013.directory.model"

echo "OK  Clients generes dans clients/ (TypeScript, Python, Java)."
