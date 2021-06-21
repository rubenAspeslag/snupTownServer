package game.placables.service.fire;

import game.placables.service.Service;

public abstract class FireService extends Service {

    public FireService(int width, int length, int serviceRadius, int capasety, int price, int selPrice) {
        super(width, length, serviceRadius, capasety, price, selPrice,0, true);
    }
}
