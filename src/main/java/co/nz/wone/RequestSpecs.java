package co.nz.wone;

import io.restassured.filter.log.*;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Consumer;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class RequestSpecs {

    private final String url;
    private final CrudEnum crudEnum;
    private RequestSpecification requestSpecification = given().filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    /**
     * Specify the cookies that'll be sent with the request as {@link Cookies}:
     * <pre>
     * Cookie cookie1 = Cookie.Builder("username", "John").setComment("comment 1").build();
     * Cookie cookie2 = Cookie.Builder("token", 1234).setComment("comment 2").build();
     * Cookies cookies = new Cookies(cookie1, cookie2);
     * </pre>
     * This will send a GET request to "/cookie" with two cookies:
     * <ol>
     * <li>username=John</li>
     * <li>token=1234</li>
     * </ol>
     * and expect that the response body is equal to "username, token".
     *
     * @param cookies The cookies to set in the request.
     * @return The request specification
     */
    public RequestSpecs cookies(final Cookies cookies) {
        requestSpecification.cookies(cookies);
        return this;
    }

    /**
     * Specify the query parameters that'll be sent with the request.
     *
     * @param queryParamMap The Map containing the parameter names and their values to send with the request.
     * @return The request specification
     */
    public RequestSpecs queryParams(final Map<String, ?> queryParamMap) {
        requestSpecification.queryParams(queryParamMap);
        return this;
    }

    /**
     * Specify multiple path parameter name-value pairs.
     * <p>
     * Example of use:
     * <pre>
     * $.templateParams();
     * </pre>
     *
     * @param pathParamMap A map containing the path parameters.
     * @return The request specification
     */
    public RequestSpecs templateParams(final Map<String, ?> pathParamMap) {
        requestSpecification.pathParams(pathParamMap);
        return this;
    }

    /**
     * Specify path parameter with single or multiple object type value.
     * <p>
     * Example of use:
     * <pre>
     * $.templateParams();
     * </pre>
     *
     * @param paramName A string containing the path parameter name.
     * @param paramValues A Object type containing the path parameter values.
     * @return The request specification
     */
    public RequestSpecs templateParam(String paramName, Object paramValues) {
        requestSpecification.pathParam(paramName, paramValues);
        return this;
    }

    /**
     * Specify a String request body (such as e.g. JSON or XML) that'll be sent with the request. This works for the
     * POST and PUT methods only.
     * <p>
     * Example of use:
     * <pre>
     * $.body("{ \"message\" : \"hello world\"}")
     * </pre>
     * This will send a request containing JSON to "/json" and expect that the response body equals to "hello world".
     *
     * @param payload The body to send.
     * @return The request specification
     */
    public RequestSpecs body(String payload) {
        requestSpecification.body(payload);
        return this;
    }

    /**
     * Specify the headers that'll be sent with the request as {@link Headers}, e.g:
     * <pre>
     * Header first = new Header("headerName1", "headerValue1");
     * Header second = new Header("headerName2", "headerValue2");
     * Headers headers = new Header(first, second);
     * $.headers(headers);
     * </pre>
     * This will send a headerName1 and headerName2 along with the request.
     * <ol>
     * <li>headerName1=headerValue1</li>
     * <li>headerName2=headerValue2</li>
     * </ol>
     * and expect that the response body is equal to "something".
     *
     * @param headers The headers to use in the request
     * @return The request specification
     */
    public RequestSpecs headers(Headers headers) {
        requestSpecification.headers(headers);
        return this;
    }

    /**
     * Specify the headers that'll be sent with the request as Map e.g:
     * <pre>
     * Map&lt;String, String&gt; headers = new HashMap&lt;String, String&gt;();
     * parameters.put("headerName1", "headerValue1");
     * parameters.put("headerName2", "headerValue2");
     * $.headers(headers);
     * </pre>
     * This will send a headerName1 and headerName2 along with the request.
     * <ol>
     * <li>headerName1=headerValue1</li>
     * <li>headerName2=headerValue2</li>
     * </ol>
     * and expect that the response body is equal to "something".
     *
     * @param headersMap The Map containing the header names and their values to send with the request.
     * @return The request specification
     */
    public RequestSpecs headers(Map<String, ? > headersMap) {
        requestSpecification.headers(headersMap);
        return this;
    }

    /**
     * Helps construct the request specifications using builder pattern.
     * @param builderFunction An Object of type RequestSpecs
     * @return The instance of Request Sender class
     * @see <a href="https://medium.com/beingprofessional/think-functional-advanced-builder-pattern-using-lambda-284714b85ed5">Advanced builder pattern using lambda</a>
     */
    public RequestSender with(Consumer<RequestSpecs> builderFunction) {
        builderFunction.accept(this);
        createRequestSpecs();
        return new RequestSender(this.requestSpecification, this.url, this.crudEnum);
    }

    /**
     * Calls constructor to create the request specifications.
     * @return The instance for RequestSpecs class.
     */
    private RequestSpecs createRequestSpecs() {
        return new RequestSpecs(this.url,this.crudEnum);
    }
}
