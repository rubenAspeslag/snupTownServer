package game.placables.service.whater;

import game.placables.service.Service;

public class WhaterService extends Service {
    public WhaterService(int width, int length,int polutionRatio, int capasety, int price, int selPrice) {
        super(width, length, 0, capasety, price, selPrice, polutionRatio,false);
    }
}
