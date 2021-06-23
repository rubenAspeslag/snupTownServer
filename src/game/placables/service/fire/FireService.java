package game.placables.service.fire;

import game.placables.Placeable;
import game.placables.service.Service;
import game.placables.service.garbage.DumpingGround;

import java.util.HashSet;
import java.util.Set;

public abstract class FireService extends Service {

    public FireService(int width, int length, int serviceRadius, int capasety, int price, int selPrice) {
        super(width, length, serviceRadius, capasety, price, selPrice,0, true);
    }
    public static Placeable getPlacable(String building) {
        if (building.equals("LargeFireStation")) {return new DumpingGround();}
        if (building.equals("MediumFireStation")) {return new DumpingGround();}
        if (building.equals("SmallFireStation")) {return new DumpingGround();}

        return null;
    }
    public static Set<String> getPlacables() {
        Set<String> placeables = new HashSet<>();
        placeables.add("LargeFireStation");
        placeables.add("MediumFireStation");
        placeables.add("SmallFireStation");
        return placeables;
    }
}
