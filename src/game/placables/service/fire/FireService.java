package game.placables.service.fire;

import game.placables.service.Service;

import java.util.HashSet;
import java.util.Set;

public abstract class FireService extends Service {

    public FireService(int width, int length, int serviceRadius, int capasety, int price, int selPrice) {
        super(width, length, serviceRadius, capasety, price, selPrice,0, true);
    }
    public static Set<String> getPlacables() {
        Set<String> placeables = new HashSet<>();
        placeables.add("LargeFireStation");
        placeables.add("MediumFireStation");
        placeables.add("SmallFireStation");
        return placeables;
    }
}
