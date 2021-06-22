package server;

import exeptions.FailedLogin;
import game.placables.Placeable;
import game.placables.service.Service;
import game.placables.service.fire.FireService;
import game.placables.service.garbage.GarbageService;
import game.placables.service.police.PoliceService;
import game.placables.service.whater.WhaterService;
import json.JSONjava.src.main.java.org.json.JSONArray;
import json.JSONjava.src.main.java.org.json.JSONObject;
import loginSystem.LoginSystem;
import loginSystem.User;

import java.util.List;
import java.util.Map;

public class ResponseConrtoller {
    private static final String[][] responses = {
            // demo
            {"/demo" , "GET" , "demo"},
            {"/demo02" , "GET" , "demo0"},
            // login
            {"/login" , "POST" , "login"},
            {"/register" , "POST" , "register"},
            // games
            {"/createGame" , "POST" , "createGame"},
            {"/getGames" , "POST" , "getGames"},
            //board
            {"/getBoard" , "POST" , "getBoard"},
            // getPlacebles
            {"/getPlaceables", "GET", "getPlaceables"},
            {"/getPlaceables/service", "GET", "getPlaceables:getServices"},
            {"/getPlaceables/service/fire", "GET", "getPlaceables:getFireStations"},
            {"/getPlaceables/service/police", "GET", "getPlaceables:getPoliceStations"},
            {"/getPlaceables/service/water", "GET", "getPlaceables:getWaterStations"},
            {"/getPlaceables/service/garbage", "GET", "getPlaceables:getGarvageStations"},


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
        }
        if (action.equals("login")) {
            return login(requestedBody);
        }
        if (action.equals("register")) {
          return registrer(requestedBody);
        }
        if (action.equals("getGames")) {
           return authorise(requestedBody).getGamesResponds();
        }
        if (action.equals("getBoard")) {
            return authorise(requestedBody).getGame(requestedBody.get("gameName").toString()).getBoard().getBoard();
        }
        if(action.equals("createGame")) {
            authorise(requestedBody).createGame(requestedBody.get("gameName").toString());
            return "{\"message\": \" game made\"}";
        }
        if (action.contains("getPlaceables")) {
            return getPlaceables(action);
        }
        throw new UnknownError();
    }

    private static String getPlaceables(String action) {
        if (action.equals("getPlaceables")) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.putAll(Placeable.getPlacables());
            return jsonArray.toString();
        }
        if(action.equals("getPlaceables:getFireStations")) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.putAll(FireService.getPlacables());
            return jsonArray.toString();
        }
        if(action.equals("getPlaceables:getPoliceStations")) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.putAll(PoliceService.getPlacables());
            return jsonArray.toString();
        }
        if(action.equals("getPlaceables:getWaterStations")) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.putAll(WhaterService.getPlacables());
            return jsonArray.toString();
        }
        if(action.equals("getPlaceables:getGarvageStations")) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.putAll(GarbageService.getPlacables());
            return jsonArray.toString();
        }
        if(action.equals("getPlaceables:getServices")) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.putAll(Service.getServices());
            return jsonArray.toString();
        }
        return "{\"error\":  \" not fount \"}";
    }

    public static User authorise(JSONObject requestedBody) {
        return LoginSystem.authorise(requestedBody.get("sessionID").toString());
    }

    private static String login(JSONObject requestedBody) {
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

    private static String registrer(JSONObject requestedBody) {
        System.out.println("l37");
        try {
            return "{\"sessionID\": \"" +LoginSystem.Register(requestedBody.get("username").toString(), requestedBody.get("password").toString()) +"\"}";
        } catch (Exception ex) {
            System.err.println(ex.getMessage()) ;
        }
        throw new UnknownError();
    }
}
