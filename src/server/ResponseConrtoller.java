package server;

import java.util.List;
import java.util.Map;

public class ResponseConrtoller {
    private static final String[][] responses = {
            {"/demo" , "GET" , "demo"},
            {"/demo02" , "GET" , "demo0"},
            {"/login" , "POST" , "login"},
            {"/register" , "POST" , "register"}
    };

    public static String[][] getResponses() {
        return responses;
    }

    public static String getResponse(String action,Map<String, List<String>> requestParameters) {
        if (action.equals("demo")) {
            return "[testske]";
        }
        if (action.equals("demo0")) {
            return "[testske555]";
        }
        throw new UnknownError();
    }
}
