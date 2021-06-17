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

public class JsonServer {
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 8080;
    private static final int BACKLOG = 1;

    private static final String HEADER_ALLOW = "Allow";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    private static final int STATUS_OK = 200;
    private static final int STATUS_METHOD_NOT_ALLOWED = 405;

    private static final int NO_RESPONSE_LENGTH = -1;

    private static final String METHOD_GET = "GET";
    private static final String METHOD_OPTIONS = "OPTIONS";
    private static final String ALLOWED_METHODS = METHOD_GET + "," + METHOD_OPTIONS;

    public static void main(final String... args) throws IOException {
        final HttpServer server = HttpServer.create(new InetSocketAddress(HOSTNAME, PORT), BACKLOG);
        server.createContext("/demo", he -> {
            Response.sendRspond(he ,"GET", "OPTIONS", "GET, OPTIONS" , "[test]");
        });

        server.start();
    }


    public static String getHOSTNAME() {
        return HOSTNAME;
    }

    public static int getPORT() {
        return PORT;
    }

    public static int getBACKLOG() {
        return BACKLOG;
    }

    public static String getHeaderAllow() {
        return HEADER_ALLOW;
    }

    public static String getHeaderContentType() {
        return HEADER_CONTENT_TYPE;
    }

    public static Charset getCHARSET() {
        return CHARSET;
    }

    public static int getStatusOk() {
        return STATUS_OK;
    }

    public static int getStatusMethodNotAllowed() {
        return STATUS_METHOD_NOT_ALLOWED;
    }

    public static int getNoResponseLength() {
        return NO_RESPONSE_LENGTH;
    }

    public static String getMethodGet() {
        return METHOD_GET;
    }

    public static String getMethodOptions() {
        return METHOD_OPTIONS;
    }

    public static String getAllowedMethods() {
        return ALLOWED_METHODS;
    }
}