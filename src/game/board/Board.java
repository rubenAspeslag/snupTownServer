package game.board;

public class Board {
    private final Placeable[][] board = new Placeable[500][500];

    public Placeable[][] getBoard() {
        return board;
    }
    public String toString() {
        String string = "[";
        for (Placeable[] row : board) {
            string = string + "[";
            for (Placeable placeable : row) {
                string = string + placeable;
            }
            string = string + "]";
        }
        string = string + "]";
        return string;
    }
}
