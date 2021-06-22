package game.placables.service.police;

import game.placables.service.Service;

import java.util.HashSet;
import java.util.Set;

public class PoliceService extends Service {

    public PoliceService(int width, int length, int serviceRadius, int capasety, int price, int selPrice) {
        super(width, length, serviceRadius, capasety, price, selPrice, 0, true);
    }

    public static Set<String> getPlacables() {
        Set<String> placeables = new HashSet<>();
        placeables.add("LargePoliceStation");
        placeables.add("MediumPoliceStation");
        placeables.add("SmallPoliceStation");
        return placeables;
    }
}
