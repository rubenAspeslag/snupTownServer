package loginSystem;

import game.Game;
import json.JSONjava.src.main.java.org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String sessionID = IdGenerator.generate();
    private List<Game> games = new ArrayList();
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String login(String username, String password) {
        if (this.username.equals(username) || this.password.equals(password)) {
            return sessionID;
        } else {
            return "login failed";
        }
    }

    public String getSessionID() {
        return sessionID;
    }
    public List<Game> getGames() {
        return games;
    }

    public Game getGame(String id) {
        for (Game game : games) {
            if (game.getId().equals(id)) {
                return game;
            }
        }
        return null;
    }
    public String getGamesResponds() {
        JSONArray getGames = new JSONArray();
        for (Game game : games) {
            getGames.put(game.getName());
        }
        return getGames.toString();
    }

    public void createGame(String gameName) {
        System.out.println("l51");
        games.add(new Game(gameName));
    }
}
