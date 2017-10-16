package cn.jcomm.test.thridpack.packtest.netty.letty.ctx;

/**
 * Enumeration of states a request can be in.
 */
public enum StateType {
    /**
     * A connection has not been made yet.
     */
    Connecting,
    /**
     * A connection has been made.
     */
    Connected,
    /**
     * About to send a request
     */
    SendRequest,
    /**
     * The request has been sent.
     */
    AwaitingResponse,
    /**
     * The response headers have been received, but the response body has not
     * yet (or there will not be one).
     */
    HeadersReceived,
    /**
     * One chunk of content has been received - not necessarily the entire
     * response, but some content.
     */
    ContentReceived,
    /**
     * The response was a 300-307 HTTP redirect and the redirect is being
     * followed. Note this event will only be seen if the HttpClient is set to
     * follow redirects - otherwise, you will just see the redirect headers and
     * body.
     */
    Redirect,
    /**
     * The entire content of the response has arrived.
     */
    FullContentReceived,
    /**
     * The connection was closed.
     */
    Closed,
    /**
     * Similar to FullContentReceived, this event gives you a Netty
     * FullHttpRequest with the entire response.
     */
    Finished,
    /**
     * An exception was thrown.
     */
    Error,
    /**
     * Called when a timeout occurs.
     */
    Timeout,
    /**
     * The call was cancelled; useful for cleaning up resources.
     */
    Cancelled;


}
