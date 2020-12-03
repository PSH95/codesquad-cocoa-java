package com.example.cocoaFinal;

import javax.swing.*;
import java.awt.*;

public class analogClock extends JFrame implements Runnable{
    private ClockPanel ClockPanel = new ClockPanel();
    private int i = 0;
    private final int ScreenWidth = 1000;
    private final int ScreenHeight = 1000;

    analogClock(){
        ClockInit();
    }

    private void ClockInit() {
        this.setTitle("아날로그 시계");
        this.setSize(ScreenWidth,ScreenHeight);

        this.setLocationRelativeTo(null); // 화면 중앙
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel remainTimePanel = new JPanel();
        remainTimePanel.setLayout(new BorderLayout());
        remainTimePanel.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight/10));
        remainTimePanel.setBackground(Color.WHITE);

        JLabel nextAlarmLabel1 = new JLabel("다음 알람");
        nextAlarmLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        nextAlarmLabel1.setVerticalAlignment(SwingConstants.CENTER);
        nextAlarmLabel1.setFont(new Font("나눔스퀘어", Font.BOLD, 30));
        JLabel nextAlarmLabel2 = new JLabel("16시간 30분 남음");
        remainTimePanel.add(nextAlarmLabel1,"North");
        remainTimePanel.add(nextAlarmLabel2,"South");
        nextAlarmLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        nextAlarmLabel2.setVerticalAlignment(SwingConstants.CENTER);
        nextAlarmLabel2.setFont(new Font("나눔스퀘어", Font.BOLD, 50));



        JPanel AlarmListPanel = new JPanel();
        AlarmListPanel.setLayout(new BorderLayout());
        AlarmListPanel.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight/10*3));
        AlarmListPanel.setBackground(Color.WHITE);

        this.add(remainTimePanel,"North");
        this.add(ClockPanel,"Center");
        this.add(AlarmListPanel,"South");
        System.out.println(ClockPanel.getWidth()+" "+ClockPanel.getHeight());
        System.out.println(AlarmListPanel.getWidth()+" "+AlarmListPanel.getHeight());
        System.out.println(nextAlarmLabel2.getWidth()+" "+nextAlarmLabel2.getHeight());


        this.setVisible(true);
    }

    class ClockPanel extends JPanel{

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            i = i+100;
            g.clearRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.YELLOW); // 노란 색상 g.fillRect(50, 50, 300, 300); // 채우기
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.black); // 노란 색상 g.fillRect(50, 50, 300, 300); // 채우기
            g.drawLine(0,0,i,1200);
        }

    }

    @Override
    public void run() {


        while (true){

            try {
                Thread.sleep(1000);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        analogClock ClockFrame = new analogClock();
        Thread thread = new Thread(ClockFrame);
        thread.start();
    }
}
