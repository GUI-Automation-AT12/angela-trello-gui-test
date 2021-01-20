package org.fundacionjala.trello.trello.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.trello.trello.config.EnvironmentApi;

public final class Authentication {
    private static final String BASE_URL_API = EnvironmentApi.getInstance().getBaseUrlApi();
    private static final String API_KEY = EnvironmentApi.getInstance().getEnvApiKey();
    private static final String API_TOKEN = EnvironmentApi.getInstance().getEnvApiToken();
    private static final String KEY = "key";
    private static final String TOKEN = "token";

    /**
     * Constructor for Authentication.
     */
    private Authentication() {

    }

    /**
     * Get request specifications.
     *
     * @return request.
     */
    public static RequestSpecification getLoggedReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL_API)
                .contentType(ContentType.JSON.toString())
                .queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN);
        return request;
    }

    /**
     * Get request specifications.
     *
     * @return request.
     */
    public static RequestSpecification getNotLoggedReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL_API);
        return request;
    }

    /**
     * Get request specifications.
     *
     * @return request.
     */
    public static RequestSpecification getNotLoggedWithKeyReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL_API)
                .contentType(ContentType.JSON.toString())
                .queryParam(KEY, API_KEY);
        return request;
    }

    /**
     * Get request specifications.
     *
     * @return request.
     */
    public static RequestSpecification getNotLoggedWithTokenReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL_API)
                .contentType(ContentType.JSON.toString())
                .queryParam(TOKEN, API_TOKEN);
        return request;
    }
}
