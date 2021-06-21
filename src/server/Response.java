package server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import json.JSONjava.src.main.java.org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Response {
    public static void sendRspond(HttpExchange he, String method, String METHOD_OPTIONS, String ALLOWED_METHODS, String action) throws Throwable {

            final Headers headers = he.getResponseHeaders();
            final String requestMethod = he.getRequestMethod().toUpperCase();
            if (requestMethod.equals(method)) {
                sendExpectedRespond(he,action);
            } else if (requestMethod.equals(METHOD_OPTIONS)) {
                headers.set(JsonServer.getHeaderAllow(), ALLOWED_METHODS);
                he.sendResponseHeaders(JsonServer.getStatusOk(), JsonServer.getNoResponseLength());
            } else {
                headers.set(JsonServer.getHeaderAllow(), ALLOWED_METHODS);
                he.sendResponseHeaders(JsonServer.getStatusMethodNotAllowed(), JsonServer.getNoResponseLength());
            }

            he.close();
        }

    private static void sendExpectedRespond(HttpExchange he,String action) throws Throwable{
        JSONObject requestedBody =  new JSONObject(getString(he.getRequestBody()));
        final Map<String, List<String>> requestParameters = Parameters.getRequestParameters(he.getRequestURI());
        final String responseBody = ResponseConrtoller.getResponse(action, requestParameters, requestedBody);
        System.out.println(responseBody);
        he.getResponseHeaders().set(JsonServer.getHeaderContentType(), String.format("application/json; charset=%s", JsonServer.getCHARSET()));
        final byte[] rawResponseBody = responseBody.getBytes(JsonServer.getCHARSET());
        he.sendResponseHeaders(JsonServer.getStatusOk(), rawResponseBody.length);
        he.getResponseBody().write(rawResponseBody);
    }

    private static String  getString(InputStream requestBody) throws IOException {
        byte[] xxx = requestBody.readAllBytes();
        String str = "";
        for (byte ch : xxx ) {
            str = str + ((char) ch);
        }
        System.out.println(str);
        return str;
    }
}
