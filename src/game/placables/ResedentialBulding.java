package game.placables;

public abstract class  ResedentialBulding extends Placeable{
    public double value;
    public final int MaxInhabitantsCount;
    public int inhabitantsCount;
    public int happynesRate;
    public ResedentialBulding(int width, int length, double value, int maxInhabitantsCount, int inhabitantsCount, int happynesRate) {
        super(width, length);
        this.value = value;
        MaxInhabitantsCount = maxInhabitantsCount;
        this.inhabitantsCount = inhabitantsCount;
        this.happynesRate = happynesRate;
    }

    public double getValue() {
        return value;
    }

    public int getMaxInhabitantsCount() {
        return MaxInhabitantsCount;
    }

    public int getInhabitantsCount() {
        return inhabitantsCount;
    }

    public int getHappynesRate() {
        return happynesRate;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setInhabitantsCount(int inhabitantsCount) {
        this.inhabitantsCount = inhabitantsCount;
    }

    public void setHappynesRate(int happynesRate) {
        this.happynesRate = happynesRate;
    }
}
