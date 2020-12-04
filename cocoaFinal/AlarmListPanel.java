package com.example.cocoaFinal;

import javax.swing.*;
import java.awt.*;

class AlarmListPanel extends JPanel {

    private final int ScreenWidth = 500;
    private final int ScreenHeight = 1000;

    AlarmListPanel(){

        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);


        ScrollPane sp = new ScrollPane();

        JPanel ListPanel = new JPanel();
        sp.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight/10*5)); //m AlarmListPanel 사이즈와 동일
        ListPanel.setLayout(new GridLayout(1000,1,0,5));


        GridContentPanel GridContentPanel = new GridContentPanel(15);

        ListPanel.add(GridContentPanel);


        sp.add(ListPanel);

        this.add(sp);



    }

}

class GridContentPanel extends JPanel{

    private int AlarmCount = 0;
    GridContentPanel(int AlarmCount){

        this.AlarmCount = AlarmCount;
        this.setLayout(new GridLayout(1000,1,0,5));


        /***
         *   원하는 알람 박스를 만들기 위해, BorderLayout 레이아웃의  contentPanel을 배열로 설계한 뒤,  GridContentPanel에 grid 형식으로 차곡차곡 담는다.
         */
        JPanel[] contentPanel = new JPanel[AlarmCount];


        JCheckBox[] AlarmCheck = new JCheckBox[this.AlarmCount];
        JLabel[] setAlarmTimeLabel = new JLabel[this.AlarmCount];
        // JLabel[] setAlarmDayLabel = new JLabel[this.AlarmCount];
        JButton[] AlarmSetting = new JButton[this.AlarmCount];



        for(int i=0;i<this.AlarmCount;i++) {

            contentPanel[i] = new JPanel();
            contentPanel[i].setLayout(new BorderLayout());

            contentPanel[i].add(AlarmCheck[i] = new JCheckBox(), "West");
            contentPanel[i].add(setAlarmTimeLabel[i] = new JLabel("AM "+(i+1)+":"+(i+10)), "Center");
            // contentPanel[i].add(setAlarmDayLabel[i] = new JLabel("매일"), "South");
            contentPanel[i].add(AlarmSetting[i] = new JButton(), "East");

            ImageIcon icon = new ImageIcon("./resource/delete.png");
            Image img = icon.getImage();
            Image changeImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon changeIcon = new ImageIcon(changeImg);

            AlarmSetting[i].setIcon(changeIcon);


            if(i%2==0) {
                contentPanel[i].setBackground(new Color(38, 30, 0));
                AlarmCheck[i].setBackground(new Color(38, 30, 0));
            }
            else{
                contentPanel[i].setBackground(new Color(147, 62, 0));
                AlarmCheck[i].setBackground(new Color(147, 62, 0));
            }


            setAlarmTimeLabel[i].setFont(new Font("나눔스퀘어", Font.BOLD, 20));
            setAlarmTimeLabel[i].setForeground(Color.white);
            setAlarmTimeLabel[i].setHorizontalAlignment(SwingConstants.CENTER);


            //setAlarmDayLabel[i].setFont(new Font("나눔스퀘어", Font.BOLD, 20));
            //setAlarmDayLabel[i].setForeground(Color.yellow);
            //setAlarmDayLabel[i].setHorizontalAlignment(SwingConstants.CENTER);


            this.add(contentPanel[i]);

        }
    }


}
