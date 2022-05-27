//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Model;

import java.util.Random;

public class Pricecalc implements pricecalcstrategy {
    public Pricecalc() {
    }

    public double calculateprice(double previousprice) {
        Random random = new Random();
        return previousprice + random.nextDouble(-previousprice / 25.0, previousprice / 25.0);
    }
}
