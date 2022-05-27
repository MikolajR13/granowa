//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Model;

public class Model {
    private pricecalcstrategy pricecalcalgorithm = new Pricecalc();
    private double stockprice = 1000.0;
    private double actualbalance = 10000.0;
    private double actualstockamount = 5.0;
    private double actualstockworth = 5000.0;

    public Model() {
    }

    public void updateStockworth() {
        this.setActualstockworth(this.actualstockamount * this.stockprice);
    }

    public void updatePrice() {
        this.stockprice = this.pricecalcalgorithm.calculateprice(this.stockprice);
        this.updateStockworth();
    }

    public boolean boughStock(int amount) {
        if ((double)amount * this.stockprice > this.actualbalance) {
            return false;
        } else {
            this.actualstockamount += (double)amount;
            this.actualbalance -= (double)amount * this.stockprice;
            this.updateStockworth();
            this.updatePrice();
            return true;
        }
    }

    public boolean sellStock(int amount) {
        if ((double)amount > this.actualstockamount) {
            return false;
        } else {
            this.actualstockamount -= (double)amount;
            this.actualbalance += (double)amount * this.stockprice;
            this.updateStockworth();
            return true;
        }
    }

    public double getStockprice() {
        return this.stockprice;
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
