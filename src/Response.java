import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;

public class Response {
    public static void sendRspond(HttpExchange he, String method, String METHOD_OPTIONS, String ALLOWED_METHODS,String respons) {
        try {
            final Headers headers = he.getResponseHeaders();
            final String requestMethod = he.getRequestMethod().toUpperCase();
            if (requestMethod.equals(method)) {
                final Map<String, List<String>> requestParameters = Parameters.getRequestParameters(he.getRequestURI());
                // do something with the request parameters
                final String responseBody = respons;
                headers.set(JsonServer.getHeaderContentType(), String.format("application/json; charset=%s", JsonServer.getCHARSET()));
                final byte[] rawResponseBody = responseBody.getBytes(JsonServer.getCHARSET());
                he.sendResponseHeaders(JsonServer.getStatusOk(), rawResponseBody.length);
                he.getResponseBody().write(rawResponseBody);
            } else if (requestMethod.equals(METHOD_OPTIONS)) {
                headers.set(JsonServer.getHeaderAllow(), ALLOWED_METHODS);
                he.sendResponseHeaders(JsonServer.getStatusOk(), JsonServer.getNoResponseLength());
            } else {
                headers.set(JsonServer.getHeaderAllow(), ALLOWED_METHODS);
                he.sendResponseHeaders(JsonServer.getStatusMethodNotAllowed(), JsonServer.getNoResponseLength());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            he.close();
        }
    }
}
