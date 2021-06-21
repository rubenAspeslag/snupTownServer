package server;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class JsonServer {
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 8080;
    private static final int BACKLOG = 1;

    private static final String HEADER_ALLOW = "Allow";
    private static final String HEADER_CONTENT_TYPE = "os";

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    private static final int STATUS_OK = 200;
    private static final int STATUS_METHOD_NOT_ALLOWED = 405;

    private static final int NO_RESPONSE_LENGTH = -1;

    private static final String METHOD_GET = "GET";
    private static final String METHOD_OPTIONS = "OPTIONS";
    private static final String ALLOWED_METHODS = METHOD_GET + "," + METHOD_OPTIONS;

    public static void main(final String... args) throws IOException {
        final HttpServer server = HttpServer.create(new InetSocketAddress(HOSTNAME, PORT), BACKLOG);
        for(String[] response : ResponseConrtoller.getResponses()) {
            server.createContext(response[0], he -> {
                try {
                    Response.sendRspond(he ,response[1], "OPTIONS", response[1] + ", OPTIONS" , response[2]);
                } catch (Throwable throwable) {
                   System.err.println("failed request: " + throwable.getMessage());
                   System.err.println(throwable.getCause().toString());
                   System.err.println(throwable.fillInStackTrace().toString());
                }
            });
        }
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