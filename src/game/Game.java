package game;

import game.board.Board;

import java.util.Date;

public class Game {
    private String name;
    private Date created;
    private Date updated;
    private final Board board = new Board();

    public String getName() {
        return name;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

}