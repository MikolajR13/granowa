//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Model {
    private pricecalcstrategy pricecalcalgorithm = new Pricecalc();
    private  Balance balance = new Balance();
    private Stockamount stockamount= new Stockamount();
    private double stockprice = 1000.0;
    private double actualbalance = 10000.0;
    private double actualstockamount = 5.0;
    private double actualstockworth = 5000.0;
    ArrayList<Double>price = new ArrayList<Double>();
    public void play(){
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
    public void updateAmount(){
        this.actualstockamount=this.stockamount.amount(this.actualstockamount);
    }
    public void updateBalance(){
        this.actualbalance=this.balance.returnbalance(this.actualbalance);
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
    public void addpricetolist(){
        price.add(actualstockworth);
    }
    public ArrayList<Double> getPrice(){
        return price;
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

