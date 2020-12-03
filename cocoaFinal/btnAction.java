package com.example.cocoaFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btnAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {



        switch (e.getActionCommand()){

            case "5분":
                AddQuickAlarmDlg.SetMinute += 5;
                break;
            case "10분":
                AddQuickAlarmDlg.SetMinute += 10;
                break;
            case "15분":
                AddQuickAlarmDlg.SetMinute += 15;
                break;
            case "20분":
                AddQuickAlarmDlg.SetMinute += 20;
                break;
            case "25분":
                AddQuickAlarmDlg.SetMinute += 25;
                break;
            case "30분":
                AddQuickAlarmDlg.SetMinute += 30;
                break;
            case "35분":
                AddQuickAlarmDlg.SetMinute += 35;
                break;
            default:
                break;



        }


    }
}
