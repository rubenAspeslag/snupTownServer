package game.board;

import game.placables.Placeable;
import json.JSONjava.src.main.java.org.json.JSONArray;

public class Board {
    private final Placeable[][] board = new Placeable[500][500];

    public String getBoard() {
        JSONArray getBoard = new JSONArray();
        for (Placeable[] row : board) {
            JSONArray getRow = new JSONArray();
            for (Placeable placeable : row) {
                 getRow.put(placeable);
            }
            getBoard.put(getRow);
        }
        System.out.println(getBoard.toString());
        return getBoard.toString();
    }
    public String placeOnBoard(String building) {
        Placeable placeable = Placeable.getPlacable(building);
        return "{\"message\": placed on board";
    }


}
