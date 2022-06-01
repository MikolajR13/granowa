//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Model;

import java.util.ArrayList;


public class Model {
    private int framesUntilNewCandlestick = 0;
    private pricecalcstrategy pricecalcalgorithm = new Pricecalc();
    private Balance balance = new Balance();
    private Stockamount stockamount = new Stockamount();
    private double stockprice = 1000.0;
    private double actualbalance = 10000.0;
    private double actualstockamount = 5.0;
    private double actualstockworth = 5000.0;
    ArrayList<CandleStick> candleSticks = new ArrayList<>();

    public void play() {
        Music music = new Music();
        music.setFile("Piosenka.wav");
        music.play();
    }


    public Model() {
    }

    public void updateStockworth() {
        this.setActualstockworth(this.actualstockamount * this.stockprice);
    }


    public void updatePrice() {
        this.stockprice = this.pricecalcalgorithm.calculateprice(this.stockprice);
        this.updateStockworth();
    }

    public void updateAmount() {
        this.actualstockamount = this.stockamount.amount(this.actualstockamount);
    }

    public void updateBalance() {
        this.actualbalance = this.balance.returnbalance(this.actualbalance);
    }

    public boolean boughStock(int amount) {
        if ((double) amount * this.stockprice > this.actualbalance) {
            return false;
        } else {
            this.actualstockamount += (double) amount;
            this.actualbalance -= (double) amount * this.stockprice;
            this.updateStockworth();
            this.updatePrice();
            return true;
        }
    }

    public boolean sellStock(int amount) {
        if ((double) amount > this.actualstockamount) {
            return false;
        } else {
            this.actualstockamount -= (double) amount;
            this.actualbalance += (double) amount * this.stockprice;
            this.updateStockworth();
            return true;
        }
    }

    public double getStockprice() {
        return this.stockprice;
    }

    public void addpricetolist() {
        if (framesUntilNewCandlestick % 5 == 0){
            candleSticks.add(new CandleStick(stockprice,stockprice,stockprice,stockprice));
        }
        framesUntilNewCandlestick++;
            CandleStick lastCandleStick = candleSticks.get(candleSticks.size()-1);
        lastCandleStick.updatePrices(stockprice);
    }

    public ArrayList<CandleStick> getCandleSticks() {
        return candleSticks;
    }

    public double getActualbalance() {
        return this.actualbalance;
    }

    public void setActualbalance(double actualbalance) {
        this.actualbalance = actualbalance;
    }

    public double getActualstockamount() {
        return this.actualstockamount;
    }

    public void setActualstockamount(double actualstockamount) {
        this.actualstockamount = actualstockamount;
    }

    public double getActualstockworth() {
        return this.actualstockworth;
    }

    public void setActualstockworth(double actualstockworth) {
        this.actualstockworth = actualstockworth;
    }

}

