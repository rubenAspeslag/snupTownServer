package server;

import exeptions.FailedLogin;
import json.JSONjava.src.main.java.org.json.JSONObject;
import loginSystem.LoginSystem;

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

    public static String getResponse(String action,Map<String, List<String>> requestParameters, JSONObject requestedBody) {
        if (action.equals("demo")) {
            return "[testske]";
        }
        if (action.equals("demo0")) {
            return "[testske555]";
        } if (action.equals("login")) {
            try {
                System.out.println("l31");
                return "{\"sessionID\": \"" + LoginSystem.login(requestedBody.get("username").toString(), requestedBody.get("password").toString()) + "\"}";
            } catch (FailedLogin ex) {
                System.out.println("l33");
                return "{\"error\": \"failed to login\"}";
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return "{\"error\": \"server error\"}";
            }
        }
        if (action.equals("register")) {
            System.out.println("l37");
            try {
            return "{\"sessionID\": \"" +LoginSystem.Register(requestedBody.get("username").toString(), requestedBody.get("password").toString()) +"\"}";
            } catch (Exception ex) {
               System.err.println(ex.getMessage()) ;
            }
        }
        throw new UnknownError();
    }
}
