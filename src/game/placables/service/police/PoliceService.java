package game.placables.service.police;

import game.placables.Placeable;
import game.placables.service.Service;
import game.placables.service.whater.WhaterPumper;
import game.placables.service.whater.WhaterTower;

import java.util.HashSet;
import java.util.Set;

public class PoliceService extends Service {

    public PoliceService(int width, int length, int serviceRadius, int capasety, int price, int selPrice) {
        super(width, length, serviceRadius, capasety, price, selPrice, 0, true);
    }

    public static Placeable getPlacable(String building) {
        if (building.equals("LargePoliceStation")) {return new LargePoliceStation();}
        if (building.equals("MediumPoliceStation")) {return new MediumPoliceStation();}
        if (building.equals("SmallPoliceStation")) {return new SmallPoliceStation();}
        return null;
    }
    public static Set<String> getPlacables() {
        Set<String> placeables = new HashSet<>();
        placeables.add("LargePoliceStation");
        placeables.add("MediumPoliceStation");
        placeables.add("SmallPoliceStation");
        return placeables;
    }
}
