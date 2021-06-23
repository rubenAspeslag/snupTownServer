package game.placables;

import game.placables.service.Service;
import json.JSONjava.src.main.java.org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

public abstract class Placeable {
    private final int width;
    private final int length;
    public Placeable(int width, int length) {
        this.width = width;
        this.length = length;
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

    public  JSONObject getJSON() {
        JSONObject placeable = new JSONObject();
        placeable.put("width",width);
        placeable.put("length",length);
        return placeable;
    }
}
