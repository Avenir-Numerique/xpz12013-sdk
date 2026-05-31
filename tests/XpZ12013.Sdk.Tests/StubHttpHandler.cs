using System.Net;
using System.Net.Http;
using System.Text;

namespace XpZ12013.Sdk.Tests;

/// <summary>
/// Terminal <see cref="HttpMessageHandler"/> for tests: records every request (and its body)
/// and returns a response decided by the supplied responder.
/// </summary>
internal sealed class StubHttpHandler(Func<HttpRequestMessage, int, HttpResponseMessage> responder) : HttpMessageHandler
{
    private int _count;

    public List<HttpRequestMessage> Requests { get; } = [];
    public List<string?> Bodies { get; } = [];

    protected override async Task<HttpResponseMessage> SendAsync(HttpRequestMessage request, CancellationToken cancellationToken)
    {
        var body = request.Content is null ? null : await request.Content.ReadAsStringAsync(cancellationToken);
        Requests.Add(request);
        Bodies.Add(body);
        return responder(request, _count++);
    }

    public static HttpResponseMessage Json(HttpStatusCode code, string json) =>
        new(code) { Content = new StringContent(json, Encoding.UTF8, "application/json") };
}
