package com.example.Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class awtPractice extends JFrame {
    private MyPanel panel = new MyPanel();
    private Graphics2D g2d;
    awtPractice(){

        this.setTitle("테스트");
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel); // 스윙 컴포넌트들이 부착되는 공간


        panel.setBackground(Color.YELLOW);

        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //panel.setBackground(Color.yellow);
                //g2d.drawRect(20, 20, 100, 100);
            }
            @Override
            public void mouseMoved(MouseEvent e){
                //panel.setBackground(Color.green);
                //System.out.println("2");
            }
        });


        this.setLocationRelativeTo(null);
        this.setVisible(true);


        panel.requestFocus(); // 컴포넌트가 이벤트를 받을 수 있게함.
    }

    class MyPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g2d = (Graphics2D)g;
            g2d.setColor(Color.RED);
            g2d.drawLine((this.getWidth()/2), (this.getHeight()/2), 250, 250);
        }

    }




    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                awtPractice awt = new awtPractice();


                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while(true) {


                        }

                    }
                });
                th.start();


            }
        });




    }


}
