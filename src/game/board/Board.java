package game.board;

import game.placables.Placeable;
import json.JSONjava.src.main.java.org.json.JSONArray;


public class Board {
    private final Field[][] board = new Field[500][500];

    public String getBoard() {
        JSONArray getBoard = new JSONArray();
        for (Field[] row : board) {
            JSONArray getRow = new JSONArray();
            for (Field field : row) {
                 getRow.put(field.getField());
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
