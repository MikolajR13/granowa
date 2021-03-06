package Viev;

import Model.CandleStick;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class GraphPanel extends JPanel {

    private ArrayList<CandleStick> candleStickArrayListToDraw;
    private int amountToDraw;

    //====================================================Public Methods==============================================//

    public GraphPanel() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
    }

    public void update(ArrayList<CandleStick> candleStickArrayList, int amountToDraw) {
        this.candleStickArrayListToDraw = new ArrayList<>();
        this.amountToDraw = amountToDraw;
        if(candleStickArrayList.size() > amountToDraw){
            for(int i = candleStickArrayList.size()-amountToDraw; i<=candleStickArrayList.size()-1; i++){
                this.candleStickArrayListToDraw.add(candleStickArrayList.get(i));
            }
        }else{
            this.candleStickArrayListToDraw = candleStickArrayList;
        }
        if(candleStickArrayList.size() == 0){
            System.out.println("Candlestick arraylist is empty or null");
            return;
        }
        System.out.println(candleStickArrayListToDraw.size());

        this.setIgnoreRepaint(false);
        this.repaint();
        System.out.println("plotpanel updated");
    }
    //====================================================Private Methods=============================================//
    private void paintCandleStick(int leftX, CandleStick candleStick, Graphics2D g2D, int width) {
        int y = (int) (candleStick.getOpenPricePercentHeight() * (double) this.getHeight());
        int height = (int) (((candleStick.getClosePricePercentHeight() - candleStick.getOpenPricePercentHeight()) * this.getHeight()));
        int middleOfCandle = leftX + width / 2;

        Color color;
        if(candleStick.getColor()){
            color = Color.GREEN;
        }else{
            color = Color.RED;
        }
        //drawing body of candle
        g2D.setColor(color);
        if (height > 0) {
            g2D.fill(new Rectangle(leftX, y, width, abs(height)));
        } else {
            g2D.fill(new Rectangle(leftX, y - abs(height), width, abs(height)));
        }

        //drawing the candlewick
        g2D.drawLine(middleOfCandle, (int) (candleStick.getMinPricePercentHeight() * this.getHeight()), middleOfCandle,
                (int) (candleStick.getMaxPricePercentHeight() * this.getHeight()));
    }

    private void paintAllCandleSticks(Graphics2D g2D) {
        if(candleStickArrayListToDraw == null || candleStickArrayListToDraw.size() == 0){
            System.out.println("Candlestick arraylist is empty or null");
            return;
        }

//        CandleStick lastCandleStick = candleStickArrayList.get(candleStickArrayList.size() - 1);
        int candleStickWidth = this.getWidth() / amountToDraw;
//        int middleOfLastCandleStick = candleStickArrayList.size() * candleStickWidth - candleStickWidth / 2;

        for (int i = 0; i < candleStickArrayListToDraw.size(); i++) {
            paintCandleStick(i * candleStickWidth, candleStickArrayListToDraw.get(i), g2D, candleStickWidth);
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.scale(1, -1);
        g2D.translate(0, -getHeight());

        paintAllCandleSticks(g2D);
        System.out.println("repainted!");

        g2D.scale(1, -1);
        g2D.translate(0, getHeight());
    }


}

