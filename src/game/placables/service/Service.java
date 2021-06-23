package game.placables.service;

import game.placables.Placeable;
import game.placables.service.fire.FireService;
import game.placables.service.garbage.GarbageService;
import game.placables.service.police.PoliceService;
import game.placables.service.whater.WhaterService;

import java.util.HashSet;
import java.util.Set;

public abstract class Service extends Placeable {
    final int serviceRadius;
    final int polutionRatio;
    int capasety;
    int price;
    int selPrice;
    boolean spaceBound;
    public Service(int width, int length, int serviceRadius, int capasety, int price, int selPrice,int polutionRatio,boolean spaceBound) {
        super(width, length);
        this.serviceRadius = serviceRadius;
        this.capasety = capasety;
        this.price = price;
        this.selPrice = selPrice;
        this.spaceBound = spaceBound;
        this.polutionRatio = polutionRatio;
    }
    public static Placeable getPlacable(String building) {
        if (FireService.getPlacable(building) != null ) {return Service.getPlacable(building);}
        if (GarbageService.getPlacable(building) != null ) {return Service.getPlacable(building);}
        if (PoliceService.getPlacable(building) != null ) {return Service.getPlacable(building);}
        if (WhaterService.getPlacable(building) != null ) {return Service.getPlacable(building);}
        return null;
    }

    public static Set<String> getPlacables() {
        Set<String> serviceMap = new HashSet<>();
        serviceMap.addAll(FireService.getPlacables());
        serviceMap.addAll(GarbageService.getPlacables());
        serviceMap.addAll(PoliceService.getPlacables());
        serviceMap.addAll(WhaterService.getPlacables());
        return serviceMap;
    }

    public static Set<String> getServices() {
        Set<String> serviceMap = new HashSet<>();
        serviceMap.add("fire");
        serviceMap.add("police");
        serviceMap.add("water");
        serviceMap.add("garbage");
        return serviceMap;
    }
}
