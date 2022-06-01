//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Viev;

import Model.CandleStick;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

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
    private JButton buy = new JButton("Kup 1 Akcję");
    private JButton sell = new JButton("Sprzedaj 1 Akcję");
    private JButton stop = new JButton("Pauza");
    private JButton buy5 = new JButton("Kup 5 akcji");
    private JButton sell5 = new JButton("Sprzedaj 5 akcji");
    private JButton music = new JButton("start muzyki");
    private JButton music1 = new JButton("stop muzyki");

    private static final Dimension dimension = new Dimension(1200, 600);
    private static final Dimension dimension1 = new Dimension(1200,100);

    private void inicial() {
        this.inorth();
        this.ieast();
        this.icentre();
        this.isouth();
        this.iwest();
        this.south.setSize(dimension1);
        this.mainpanel.setLayout(new BorderLayout());
        this.mainpanel.add(this.north, BorderLayout.NORTH);
        this.mainpanel.add(this.west, BorderLayout.WEST);
        this.mainpanel.add(this.south, BorderLayout.SOUTH);
        this.mainpanel.add(this.east, BorderLayout.EAST);
        this.mainpanel.add(this.center, BorderLayout.CENTER);
        this.mainframe.add(this.mainpanel);
        this.mainframe.setVisible(true);
        this.mainframe.setSize(dimension);
    }

    public View() {
        this.inicial();
    }

    private void inorth() {
        this.north.setLayout(new GridLayout(1, 2));
        this.north.setBackground(Color.RED);
        this.north.setOpaque(true);
    }

    private void isouth() {
        JLabel text = new JLabel("");
        JLabel text1 = new JLabel("");
        JLabel text2 = new JLabel("");
        this.south.setLayout(new GridLayout(1, 5, 10, 10));
        this.south.setBackground(Color.WHITE);
        this.south.setOpaque(true);
        this.south.add(this.buy);
        this.south.add(this.buy5);
        this.south.add(text1);
        this.south.add(this.sell);
        this.south.add(this.sell5);
    }

    private void iwest() {
        this.west.setLayout(new GridLayout(10, 1, 10, 10));
        JLabel text = new JLabel("ChRLD");
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

    }

    private void ieast() {
        this.east.setLayout(new GridLayout(5, 1, 10, 10));
        this.east.setBackground((Color)null);
        this.east.setOpaque(false);
        this.actualbalance.setVerticalAlignment(JLabel.CENTER);
        this.actualbalance.setHorizontalAlignment(JLabel.CENTER);
        this.east.add(this.actualbalance);
        this.actualstockamount.setVerticalAlignment(JLabel.CENTER);
        this.actualstockworth.setHorizontalAlignment(JLabel.CENTER);
        this.east.add(this.actualstockamount);
        this.actualstockworth.setVerticalAlignment(JLabel.CENTER);
        this.actualstockamount.setHorizontalAlignment(JLabel.CENTER);
        this.east.add(this.actualstockworth);
    }

    private void icentre() {
        this.center.setLayout(new GridLayout(1, 1));
        this.center.setBackground(null);
        this.center.setOpaque(false);
        center.add(graphPanel);
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
    public void adactionbuy5(ActionListener action) {
        this.buy5.addActionListener(action);
    }
    public void adactionsell(ActionListener action){this.sell.addActionListener(action);}
    public void adactionsell5(ActionListener action){this.sell5.addActionListener(action);}
    public void startmusic(ActionListener action){this.music.addActionListener(action);}



    public void notenoughstocks() {
        JOptionPane.showMessageDialog(this.mainframe, "Nie możesz sprzedać tego co nie twoje", "Wiadomość od Wielkiego Potężnego Mao", 2);
    }

    public void updateGraph(ArrayList<CandleStick> candleStickArrayList){
        graphPanel.update(candleStickArrayList);
    }
}
