package game.placables;

import game.placables.service.Service;

import java.util.HashSet;
import java.util.Set;

public abstract class Placeable {
    private final int width;
    private final int length;
    private static Set<String> placeableList = initPlaceables();
    public Placeable(int width, int length) {
        this.width = width;
        this.length = length;
        initPlaceables();
    }

    private static Set<String> initPlaceables() {
        Set<String> placeableList = new HashSet<>();
        placeableList.addAll(Service.getPlacables());
        return placeableList;
    }

    public static Placeable getPlacable(String building) {
        if (Service.getPlacable(building) != null ) {return Service.getPlacable(building);}
        return null;
    }
    public static Set<String> getPlacables() {
        Set<String> placeables = new HashSet<>();
        placeables.addAll(Service.getPlacables());
        return placeables;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
}
