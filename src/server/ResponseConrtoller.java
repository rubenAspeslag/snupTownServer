package server;

import exeptions.FailedLogin;
import loginSystem.LoginSystem;
import loginSystem.User;

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
        } if (action.equals("login")) {
            System.out.println(requestParameters);
            System.out.println("l30");
            System.out.println(requestParameters.get("username").get(0));
            System.out.println("l32");
            try {
                    return "[sessionID: " + LoginSystem.login(requestParameters.get("username").get(0), requestParameters.get("passord").get(0));
            } catch (FailedLogin ex) {
                return "[error: failed to login]";
            }
        }
        if (action.equals("register")) {
            return "[sessionID: " + new User(requestParameters.get("username").get(0), requestParameters.get("passord").get(0)).getSessionID() +"]";
        }
        throw new UnknownError();
    }
}
