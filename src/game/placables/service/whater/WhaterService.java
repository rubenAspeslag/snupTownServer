package game.placables.service.whater;

import game.placables.Placeable;
import game.placables.service.Service;

import java.util.HashSet;
import java.util.Set;

public class WhaterService extends Service {
    public WhaterService(int width, int length,int polutionRatio, int capasety, int price, int selPrice) {
        super(width, length, 0, capasety, price, selPrice, polutionRatio,false);
    }

    public static Placeable getPlacable(String building) {
        if (building.equals("WhaterPumper")) {return new WhaterPumper();}
        if (building.equals("WhaterTower")) {return new WhaterTower();}
        return null;
    }

    public static Set<String> getPlacables() {
        Set<String> placeables = new HashSet<>();
        placeables.add("WhaterPumper");
        placeables.add("WhaterTower");
        return placeables;
    }
}
