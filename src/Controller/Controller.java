//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Controller;

import Model.Model;
import Viev.View;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;


public class Controller {
    private View view = new View();
    private Model model = new Model();
    private Timer timer;


    private void nextframe() {
        model.updateStockworth();
        model.updatePrice();
        model.updateBalance();
        model.updateAmount();
        view.setActualstockworth(String.valueOf(model.getActualstockworth()));
        view.setStockprice(String.valueOf((model.getStockprice())));
        view.setActualbalance(String.valueOf(model.getActualbalance()));
        view.setActualstockamount(String.valueOf(model.getActualstockamount()));
        model.addpricetolist();
        view.updateGraph(model.getCandleSticks());
    }

    public Controller() {

        this.view.adactionbuy(new buyaction(1));
        this.view.adactionsell(new sellaction(1));
        timer = new Timer(1000,e->{this.nextframe();});
        timer.start();
        this.view.adactionbuy5(new buyaction(5));
        this.view.adactionsell5(new sellaction(5));

    }
    public class playmusic implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean success = true;
            Controller.this.model.play();

        }

    }
    public class buyaction implements ActionListener {
        private int amount = 1;

        public buyaction(int amount) {
            this.amount = amount;
        }

        public void actionPerformed(ActionEvent e) {
            boolean success = Controller.this.model.boughStock(this.amount);
            Controller.this.view.setActualbalance(String.valueOf(Controller.this.model.getActualbalance()));
            Controller.this.view.setActualstockamount(String.valueOf(Controller.this.model.getActualstockamount()));
            Controller.this.view.setActualstockworth(String.valueOf(Controller.this.model.getActualstockworth()));
            if (!success) {
                Controller.this.view.notenoughgold();
            }

        }
    }





    public class sellaction implements ActionListener {
        private int amount = 1;

        public sellaction(int amount) {
            this.amount = amount;
        }

        public void actionPerformed(ActionEvent e) {
            boolean success = Controller.this.model.sellStock(this.amount);
            Controller.this.view.setActualstockworth(String.valueOf(Controller.this.model.getActualstockworth()));
            Controller.this.view.setActualstockamount(String.valueOf(Controller.this.model.getActualstockamount()));
            Controller.this.view.setActualbalance(String.valueOf(Controller.this.model.getActualbalance()));
            if (!success) {
                Controller.this.view.notenoughstocks();
            }

        }
    }
}
