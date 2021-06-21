package game;

import game.board.Board;
import loginSystem.IdGenerator;

import java.util.Date;

public class Game {
    private String name;
    private Date created;
    private Date updated;
    private final Board board = new Board();
    private final String id = IdGenerator.generate();

    public Game(String name) {
        this.name = name;
        this.created = new Date();
        this.updated = new Date();
    }

    public String getName() {
        return name;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public Board getBoard() {
        return board;
    }

    public String getId() {
        return id;
    }

}