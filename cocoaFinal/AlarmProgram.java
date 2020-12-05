package com.example.cocoaFinal;

import javax.swing.*;
import java.awt.*;

public class AlarmProgram extends JFrame {

    public static AlarmProgram ClockFrame = null;
    private final int ScreenWidth = 500;
    private final int ScreenHeight = 1000;


    AlarmProgram() {
        ClockInit();
    }

    private void ClockInit() {
        this.setTitle("간단 알람");
        this.setSize(ScreenWidth,ScreenHeight);

        this.setLocationRelativeTo(null); // 화면 중앙
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar menuBar = new menuBar();

        this.setJMenuBar(menuBar.menu);

        JPanel remainTimePanel = new JPanel();
        remainTimePanel.setLayout(new BorderLayout());
        remainTimePanel.setBackground(new Color(234,234,234));


        JLabel nextAlarmLabel1 = new JLabel("다음 알람");
        nextAlarmLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        nextAlarmLabel1.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
        JLabel nextAlarmTimeLabel = new JLabel("16시간 30분 남음");
        remainTimePanel.add(nextAlarmLabel1,"North");
        remainTimePanel.add(nextAlarmTimeLabel,"South");
        nextAlarmTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nextAlarmTimeLabel.setFont(new Font("나눔스퀘어", Font.BOLD, 35));


        ClockPanel ClockPanel = new ClockPanel();
        AlarmListPanel AlarmListPanel = new AlarmListPanel();

        remainTimePanel.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight/15));
        AlarmListPanel.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight/10*5));
        //m center panel 사이즈는 north/south 사이즈 조정후 자동으로 지정됨.

        this.add(remainTimePanel,"North");
        this.add(ClockPanel,"Center");
        this.add(AlarmListPanel,"South");


        this.setVisible(true);
    }



    public static void main(String[] args) {

        ClockFrame = new AlarmProgram();


    }
}
