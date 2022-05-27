//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Controller;

import Model.Model;
import Viev.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view = new View();
    private Model model = new Model();

    public Controller() {
        this.view.adactionbuy(new buyaction(1));
        this.view.adactionsell(new sellaction(1));
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
