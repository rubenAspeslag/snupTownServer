package game.board;

public abstract class Placeable {
    private final int width;
    private final int length;

    public Placeable(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
}
