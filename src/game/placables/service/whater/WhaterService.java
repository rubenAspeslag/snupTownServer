package game.placables.service.whater;

import game.placables.service.Service;

import java.util.HashSet;
import java.util.Set;

public class WhaterService extends Service {
    public WhaterService(int width, int length,int polutionRatio, int capasety, int price, int selPrice) {
        super(width, length, 0, capasety, price, selPrice, polutionRatio,false);
    }

    public static Set<String> getPlacables() {
        Set<String> placeables = new HashSet<>();
        placeables.add("WhaterPumper");
        placeables.add("WhaterTower");
        return placeables;
    }
}
