package by.it.plehanova.jd02_03;

import java.util.ArrayList;

class Basket {

    private final ArrayList<Good> goodsInBasket = new ArrayList<>();

    public ArrayList<Good> getGoodsInBasket() {
        return goodsInBasket;
    }

    public void putGoods(Good good) {
        goodsInBasket.add(good);
    }
}
