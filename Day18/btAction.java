package com.example.Day18;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btAction implements ActionListener {

    private final int Pen = 1;
    private final int Erase = 2;
    private final int Rect = 3;
    private final int Ellipse = 4;
    private final int Line = 5;

    @Override
    public void actionPerformed(ActionEvent e) {

        paintFrame.g2D.setColor(paintFrame.selColor);

        switch (e.getActionCommand()){

            case "연필":
                paintFrame.ToolStatus = Pen;
                break;
            case "지우개":
                paintFrame.ToolStatus = Erase;
                paintFrame.g2D.setColor(Color.white);
                break;
            case "사각형":
                paintFrame.ToolStatus = Rect;
                break;
            case "원":
                paintFrame.ToolStatus = Ellipse;
                break;
            case "직선":
                paintFrame.ToolStatus = Line;
                break;
            default:
                break;


        }

    }
}
