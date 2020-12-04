package com.example.cocoaFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btnAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {



        switch (e.getActionCommand()){

            case "5분":
                AddQuickAlarmDlg.SetTime[1]+= 5;
                break;
            case "10분":
                AddQuickAlarmDlg.SetTime[1] += 10;
                break;
            case "15분":
                AddQuickAlarmDlg.SetTime[1] += 15;
                break;
            case "20분":
                AddQuickAlarmDlg.SetTime[1] += 20;
                break;
            case "25분":
                AddQuickAlarmDlg.SetTime[1] += 25;
                break;
            case "30분":
                AddQuickAlarmDlg.SetTime[1] += 30;
                break;
            case "35분":
                AddQuickAlarmDlg.SetTime[1] += 35;
                break;
            default:
                break;



        }


    }
}
