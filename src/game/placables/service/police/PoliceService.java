package game.placables.service.police;

import game.placables.service.Service;

public class PoliceService extends Service {

    public PoliceService(int width, int length, int serviceRadius, int capasety, int price, int selPrice) {
        super(width, length, serviceRadius, capasety, price, selPrice, 0, true);
    }
}
