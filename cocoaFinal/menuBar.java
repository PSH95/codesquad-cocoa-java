package com.example.cocoaFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class menuBar extends JMenuBar {
    public JMenuBar menu;
    public JFrame ClockFrame;

    menuBar(){
        menu = new JMenuBar();
        menu.setBackground(Color.DARK_GRAY);

        JMenu AddAlarmMenu = new JMenu("추가(+)");
        AddAlarmMenu.setBackground(Color.DARK_GRAY);
        AddAlarmMenu.setForeground(Color.CYAN);
        menu.add(AddAlarmMenu);

        JMenuItem QuickMenu = new JMenuItem("퀵 알람");
        QuickMenu.setBackground(Color.DARK_GRAY);
        QuickMenu.setForeground(Color.yellow);
        AddAlarmMenu.add(QuickMenu);

        QuickMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddQuickAlarmDlg dialog = new AddQuickAlarmDlg(ClockFrame, "퀵 알람",true);
                dialog.setVisible(true); // 다이얼로그를 출력하고 작동시킨다.
            }
        });
    }
}