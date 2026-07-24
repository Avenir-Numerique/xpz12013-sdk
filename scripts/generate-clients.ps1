<#
.SYNOPSIS
  Génère les clients Java / TypeScript / Python depuis les specs OpenAPI de spec/.
.DESCRIPTION
  No-op si les specs sont absentes (génération conditionnée au juridique AFNOR — NEOTIMO-1417).
  Requiert Node.js (npx) et un JRE (openapi-generator tourne sur la JVM).
.EXAMPLE
  pwsh scripts/generate-clients.ps1 -Version 1.3.0
#>
param([string]$Version = "1.3.0")

$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $PSScriptRoot
$specDir = Join-Path $root "spec"
$configDir = Join-Path $root "clients/generator-config"
$outDir = Join-Path $root "clients"

$flowSpec = Join-Path $specDir "flow-service.json"
$directorySpec = Join-Path $specDir "directory-service.json"

if (-not (Test-Path $flowSpec) -or -not (Test-Path $directorySpec)) {
    Write-Warning "Specs OpenAPI absentes de spec/ (flow-service.json, directory-service.json)."
    Write-Warning "Generation multi-langue ignoree -- cf. NEOTIMO-1417 (juridique des annexes AFNOR)."
    return
}

function Invoke-Generate {
    param([string]$Generator, [string]$Spec, [string]$Out, [string]$Config, [string]$AdditionalProperties)
    Write-Host "-> $Generator : $(Split-Path $Spec -Leaf) -> $Out"
    if (Test-Path $Out) { Remove-Item -Recurse -Force $Out }
    npx --yes "@openapitools/openapi-generator-cli" generate -g $Generator -i $Spec -o $Out -c $Config --additional-properties=$AdditionalProperties
}

# TypeScript (fetch)
Invoke-Generate "typescript-fetch" $flowSpec      "$outDir/typescript/flow"      "$configDir/typescript.json" "npmName=@neotimo/xpz12013-flow,npmVersion=$Version"
Invoke-Generate "typescript-fetch" $directorySpec "$outDir/typescript/directory" "$configDir/typescript.json" "npmName=@neotimo/xpz12013-directory,npmVersion=$Version"

# Python (urllib3)
Invoke-Generate "python" $flowSpec      "$outDir/python/flow"      "$configDir/python.json" "packageName=neotimo_xpz12013_flow,projectName=neotimo-xpz12013-flow,packageVersion=$Version"
Invoke-Generate "python" $directorySpec "$outDir/python/directory" "$configDir/python.json" "packageName=neotimo_xpz12013_directory,projectName=neotimo-xpz12013-directory,packageVersion=$Version"

# Java (java.net.http)
Invoke-Generate "java" $flowSpec      "$outDir/java/flow"      "$configDir/java.json" "groupId=fr.neotimo,artifactId=xpz12013-flow,artifactVersion=$Version,invokerPackage=fr.neotimo.xpz12013.flow,apiPackage=fr.neotimo.xpz12013.flow.api,modelPackage=fr.neotimo.xpz12013.flow.model"
Invoke-Generate "java" $directorySpec "$outDir/java/directory" "$configDir/java.json" "groupId=fr.neotimo,artifactId=xpz12013-directory,artifactVersion=$Version,invokerPackage=fr.neotimo.xpz12013.directory,apiPackage=fr.neotimo.xpz12013.directory.api,modelPackage=fr.neotimo.xpz12013.directory.model"

Write-Host "OK  Clients generes dans clients/ (TypeScript, Python, Java)."
