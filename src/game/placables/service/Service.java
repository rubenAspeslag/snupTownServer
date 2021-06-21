package game.placables.service;

import game.placables.Placeable;

public abstract class Service extends Placeable {
    final int serviceRadius;
    int capasety;
    int price;
    int selPrice;
    boolean spaceBound;
    public Service(int width, int length, int serviceRadius, int capasety, int price, int selPrice,boolean spaceBound) {
        super(width, length);
        this.serviceRadius = serviceRadius;
        this.capasety = capasety;
        this.price = price;
        this.selPrice = selPrice;
        this.spaceBound = spaceBound;
    }
}
