package com.example.Day18;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btAction implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){

            case "연필":
                paintFrame.ToolStatus = 1;
                paintFrame.g2D.setColor(Color.BLACK);
                break;
            case "지우개":
                paintFrame.ToolStatus = 2;
                paintFrame.g2D.setColor(Color.white);
                break;
            case "사각형":
                paintFrame.ToolStatus = 3;
                paintFrame.g2D.setColor(Color.BLACK);
                break;
            case "원":
                paintFrame.ToolStatus = 4;
                paintFrame.g2D.setColor(Color.BLACK);
                break;
            case "직선":
                paintFrame.ToolStatus = 5;
                paintFrame.g2D.setColor(Color.BLACK);
                break;
            default:
                break;


        }

    }
}
