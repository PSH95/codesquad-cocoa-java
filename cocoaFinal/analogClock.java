package com.example.cocoaFinal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class analogClock extends JFrame implements Runnable{
    private ClockPanel ClockPanel = new ClockPanel();
    private AlarmListPanel AlarmListPanel = new AlarmListPanel();
    private int i = 0;
    private final int ScreenWidth = 1000;
    private final int ScreenHeight = 1000;
    private final Image clockBackground = ImageIO.read(new File("./resource/ClockBackground.png"));

    private GregorianCalendar time;
    private int hour = 0;
    private int min = 0;
    private int sec = 0;

    analogClock() throws IOException {
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
        JLabel nextAlarmTimeLabel = new JLabel("16시간 30분 남음");
        remainTimePanel.add(nextAlarmLabel1,"North");
        remainTimePanel.add(nextAlarmTimeLabel,"South");
        nextAlarmTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nextAlarmTimeLabel.setVerticalAlignment(SwingConstants.CENTER);
        nextAlarmTimeLabel.setFont(new Font("나눔스퀘어", Font.BOLD, 50));


        this.add(remainTimePanel,"North");
        this.add(ClockPanel,"Center");

        AlarmListPanel.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight/10*5));
        this.add(AlarmListPanel,"South");



        this.setVisible(true);
    }

    class AlarmListPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            this.setLayout(new BorderLayout());
            this.setBackground(Color.WHITE);

        }
    }

    class ClockPanel extends JPanel{

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.clearRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.pink);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            int Clock_X = this.getWidth()/2-clockBackground.getWidth(null)/2;  //m 시계 배경 ClockPanel 중앙 X좌표
            int Clock_Y = this.getHeight()/2-clockBackground.getHeight(null)/2; //m 시계 배경 ClockPanel 중앙 Y좌표

            g.drawImage(clockBackground,Clock_X,Clock_Y,this); //m 시계 배경 출력

            g.setColor(Color.black);

            /***
             *m 삼감함수 공식을 이용한 아날로그 시계 알고리즘  ex) cos(theta) = R/x  → x = R*cos(theta)
             *m 직교좌표계(CCW)와 아날로그 시계(CW)는 진행 방향 다르므로, 변환과정(-90도)이 필요
             *m Math.cos 는 degree 가 아닌 Radian 연산을 하여 변환이 필요함.
             *m cf) Time Shift: cos(x-pi/2) == sin(x)
             *m 12시간 = 360도 → 1시간 = [30도]  → 60분 = 30도 → 1분 = [30/60도] → 60초 = 30/60 → 1초 = [30/60/60도]
             *m 60분 = 360도 → 1분 = [6도] → 60초 = 6도 → 1초 = [6/60도]
             *m 60초 = 360도 → 1초 = [6도]
             */


            g.drawString(hour+":"+min+":"+sec,this.getWidth()/2-20,this.getHeight()/2); //m 디지털 시간 출력


            int HourX = this.getWidth()/2 + (int) (90 * Math.cos( ToRadian ( (hour * 30) -90 + (min * 30/60) + (sec * 30/60/60) ) ));
            int HourY = this.getHeight()/2 + (int) (90 * Math.sin( ToRadian ( (hour * 30) -90 + (min * 30/60) + (sec * 30/60/60) ) ));
            g.setColor(Color.yellow);
            g.drawLine(this.getWidth()/2,this.getHeight()/2, HourX,HourY);

            int MinX = this.getWidth()/2 + (int) (120 * Math.cos( ToRadian ( (min * 6)-90+ (sec * 6/60) ) ));
            int MinY = this.getHeight()/2 + (int) (120 * Math.sin( ToRadian ( (min * 6)-90 + (sec * 6/60) ) ));
            g.setColor(Color.RED);
            g.drawLine(this.getWidth()/2,this.getHeight()/2, MinX,MinY);


            int SecX = this.getWidth()/2 + (int) (150 * Math.cos( ToRadian ( (sec * 6) -90) ));
            int SecY = this.getHeight()/2 + (int) (150 * Math.sin( ToRadian ( (sec * 6) -90) ));
            g.setColor(Color.BLUE);
            g.drawLine(this.getWidth()/2,this.getHeight()/2, SecX,SecY);

        }

        private double ToRadian(int degree) {
            double radian = 0.0;
            radian = degree * (Math.PI/180.0f);
            return radian;
        }

    }

    @Override
    public void run() {


        while (true){

            time = new GregorianCalendar();

            // 시간 정보를 가져온다.
            min = time.get(Calendar.MINUTE);
            hour = time.get(Calendar.HOUR);
            sec = time.get(Calendar.SECOND);

            if (sec == 60) {
                sec = 0;
                min++;
            }
            if (min == 60) {
                min = 0;
                hour++;
            }
            if (min == 60 && hour == 12) {
                hour = 0;
            }

            try {
                Thread.sleep(1000);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        analogClock ClockFrame = null;
        try {
            ClockFrame = new analogClock();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(ClockFrame);
        thread.start();
    }
}
