package game.placables.service.garbage;

import game.placables.Placeable;
import game.placables.service.Service;

import java.util.HashSet;
import java.util.Set;

public class GarbageService extends Service {

    public GarbageService(int width, int length, int capasety, int price, int selPrice, int polutionRatio) {
        super(width, length, 0, capasety, price, selPrice, polutionRatio, false);
    }
    public static Placeable getPlacable(String building) {
        if (building.equals("DumpingGround")) {return new DumpingGround();}
        return null;
    }
    public static Set<String> getPlacables() {
        Set<String> placeables = new HashSet<>();
        placeables.add("DumpingGround");
        return placeables;
    }
}
