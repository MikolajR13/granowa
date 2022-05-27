//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Viev;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class View {
    private JFrame mainframe = new JFrame("GRA");
    private JPanel mainpanel = new JPanel();
    private JPanel north = new JPanel();
    private JPanel south = new JPanel();
    private JPanel east = new JPanel();
    private JPanel west = new JPanel();
    private JPanel center = new JPanel();
    private GraphPanel graphPanel = new GraphPanel();
    private JLabel stockprice = new JLabel("aktualna cena:");
    private JLabel actualbalance = new JLabel("aktualny stan konta:");
    private JLabel actualstockamount = new JLabel("ilość posiadanych akcji:");
    private JLabel actualstockworth = new JLabel("wartość twoich akcji:");
    private JButton buy = new JButton("Kup Akcje");
    private JButton sell = new JButton("Sprzedaj Akcje");
    private JButton stop = new JButton("Pauza");
    private static final Dimension dimension = new Dimension(1200, 600);

    private void inicial() {
        this.inorth();
        this.ieast();
        this.icentre();
        this.isouth();
        this.iwest();
        this.mainpanel.add(this.north, "North");
        this.mainpanel.add(this.west, "West");
        this.mainpanel.add(this.south, "South");
        this.mainpanel.add(this.east, "East");
        this.mainpanel.add(this.center, "Center");
        this.mainframe.add(this.mainpanel);
        this.mainframe.setVisible(true);
        this.mainframe.setSize(dimension);
    }

    public View() {
        this.inicial();
    }

    private void inorth() {
        this.north.setLayout(new GridLayout(1, 2));
        this.north.setBackground((Color)null);
        this.north.setOpaque(false);
        this.stop.setVerticalAlignment(1);

        BufferedImage image1;
        try {
            image1 = ImageIO.read(new File("src/Mao.jpg"));
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }

        JLabel im = new JLabel(new ImageIcon(image1));
        im.setVerticalAlignment(1);
        Dimension dimension = new Dimension(50, 50);
        this.stop.setMaximumSize(dimension);
        this.north.add(this.stop);
    }

    private void isouth() {
        this.south.setLayout(new GridLayout(1, 5, 10, 10));
        this.south.setBackground((Color)null);
        this.south.setOpaque(false);
        this.south.add(this.sell);
    }

    private void iwest() {
        this.west.setLayout(new GridLayout(10, 1, 10, 10));
        JLabel text = new JLabel("Orlen");
        text.setVerticalAlignment(1);
        text.setHorizontalAlignment(0);
        this.west.setBackground((Color)null);
        this.west.setOpaque(false);

      //  BufferedImage image;
       // try {
        //    image = ImageIO.read(new File("src/instrybutor.jpg"));
      //  } catch (IOException var4) {
       //     throw new RuntimeException(var4);
      //  }

       // JLabel im = new JLabel(new ImageIcon(image));
       // im.setVerticalAlignment(1);
       // im.setHorizontalAlignment(2);
        text.setVerticalAlignment(1);
        text.setHorizontalAlignment(2);
       // this.west.add(im);
        this.west.add(text);
        this.stockprice.setVerticalAlignment(1);
        this.stockprice.setHorizontalAlignment(2);
        this.west.add(this.stockprice);
        this.west.add(this.buy);
    }

    private void ieast() {
        this.east.setLayout(new GridLayout(10, 1, 10, 10));
        this.east.setBackground((Color)null);
        this.east.setOpaque(false);
        this.actualbalance.setVerticalAlignment(1);
        this.actualbalance.setHorizontalAlignment(4);
        this.east.add(this.actualbalance);
        this.actualstockamount.setVerticalAlignment(1);
        this.actualstockworth.setHorizontalAlignment(4);
        this.east.add(this.actualstockamount);
        this.actualstockworth.setVerticalAlignment(1);
        this.actualstockamount.setHorizontalAlignment(4);
        this.east.add(this.actualstockworth);
    }

    private void icentre() {
    }

    public void setStockprice(String stockprice) {
        this.stockprice.setText("aktualna cena:" + stockprice);
    }

    public void setActualbalance(String actualbalance) {
        this.actualbalance.setText("aktualny stan konta:" + actualbalance);
    }

    public void setActualstockamount(String actualstockamount) {
        this.actualstockamount.setText("ilość posiadanych akcji:" + actualstockamount);
    }

    public void setActualstockworth(String actualstockworth) {
        this.actualstockworth.setText("wartość twoich akcji:" + actualstockworth);
    }

    public void notenoughgold() {
        JOptionPane.showMessageDialog(this.mainframe, "Pracuj ciężej... Nie masz tyle pieniędzy", "Wiadomość od Wielkiego Potężnego Mao", 2);
    }

    public void adactionbuy(ActionListener action) {
        this.buy.addActionListener(action);
    }
    public void adactionsell(ActionListener action){this.sell.addActionListener(action);}

    public void notenoughstocks() {
        JOptionPane.showMessageDialog(this.mainframe, "Nie możesz sprzedać tego co nie twoje", "Wiadomość od Wielkiego Potężnego Mao", 2);
    }
}
