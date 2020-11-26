package com.example.Day18;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btAction implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){

            case "연필":
                paintFrame.g2D.setColor(Color.BLACK);
                break;
            case "지우개":
                paintFrame.g2D.setColor(Color.white);
                break;
            case "사각형":
                paintFrame.g2D.setColor(Color.BLACK);
                break;
            case "원":
                paintFrame.g2D.setColor(Color.BLACK);
                break;
            case "직선":
                paintFrame.g2D.setColor(Color.BLACK);
                break;
            case "곡선":
                paintFrame.g2D.setColor(Color.BLACK);
                break;
            default:
                break;


        }

    }
}
