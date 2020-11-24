package com.example.Day16;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class awtPractice extends Frame {

    public void initFrame(){
        setSize(500,500);
        setVisible(true);
        setLocation(this.getWidth()/2,this.getHeight()/2);
    }

    public awtPractice(){
        initFrame();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                awtPractice fr = new awtPractice();

                fr.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {

                        e.getWindow().setVisible(false);  //Frame을 화면에서 보이지 않도록 하고
                        e.getWindow().dispose();    //메모리에서 제거한다.

                        System.exit(0);  //프로그램을 종료하다.
                    }
                });

            }
        });

    }
}
