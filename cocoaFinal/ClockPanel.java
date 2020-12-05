package com.example.cocoaFinal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

class ClockPanel extends JPanel implements Runnable{

    private Graphics2D g2d;
    private GregorianCalendar time;
    private int hour = 0;
    private int min = 0;
    private int sec = 0;
    private Image clockBackground = null;

    /***
     *m 삼감함수 공식을 이용한 아날로그 시계 알고리즘  ex) cos(theta) = R/x  → x = R*cos(theta)
     *m 직교좌표계(CCW)와 아날로그 시계(CW)는 진행 방향 다르므로, 변환과정(-90도)이 필요
     *m Math.cos 는 degree 가 아닌 Radian 연산을 하여 변환이 필요함.
     *m cf) Time Shift: cos(x-pi/2) == sin(x)
     *m 12시간 = 360도 → 1시간 = [30도]  → 60분 = 30도 → 1분 = [30/60도] → 60초 = 30/60 → 1초 = [30/60/60도]
     *m 60분 = 360도 → 1분 = [6도] → 60초 = 6도 → 1초 = [6/60도]
     *m 60초 = 360도 → 1초 = [6도]
     */

    ClockPanel(){
        try {
            clockBackground=ImageIO.read(new File("./resource/ClockBackground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(15, BasicStroke.CAP_ROUND, 0)); //m 라인 굵기
        this.setLayout(new BorderLayout());


        g.clearRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(new Color(189,189,189));
        g.fillRect(0,0,this.getWidth(),this.getHeight());

        int Clock_X = this.getWidth()/2-clockBackground.getWidth(null)/2;  //m 시계 배경 ClockPanel 중앙 X좌표
        int Clock_Y = this.getHeight()/2-clockBackground.getHeight(null)/2; //m 시계 배경 ClockPanel 중앙 Y좌표

        g.drawImage(clockBackground,Clock_X,Clock_Y,this); //m 시계 배경 출력

        g.setColor(Color.black);

        int HourX = this.getWidth()/2 + (int) (90 * Math.cos( ToRadian ( (hour * 30) -90 + (min * 30/60) + (sec * 30/60/60) ) ));
        int HourY = this.getHeight()/2 + (int) (90 * Math.sin( ToRadian ( (hour * 30) -90 + (min * 30/60) + (sec * 30/60/60) ) ));
        g2d.setColor(Color.yellow);
        g2d.drawLine(this.getWidth()/2,this.getHeight()/2, HourX,HourY);

        int MinX = this.getWidth()/2 + (int) (120 * Math.cos( ToRadian ( (min * 6)-90+ (sec * 6/60) ) ));
        int MinY = this.getHeight()/2 + (int) (120 * Math.sin( ToRadian ( (min * 6)-90 + (sec * 6/60) ) ));
        g2d.setColor(Color.RED);
        g2d.drawLine(this.getWidth()/2,this.getHeight()/2, MinX,MinY);


        int SecX = this.getWidth()/2 + (int) (150 * Math.cos( ToRadian ( (sec * 6) -90) ));
        int SecY = this.getHeight()/2 + (int) (150 * Math.sin( ToRadian ( (sec * 6) -90) ));
        g2d.setColor(Color.BLUE);
        g2d.drawLine(this.getWidth()/2,this.getHeight()/2, SecX,SecY);

        g.setColor(Color.WHITE);
        g.setFont(new Font("나눔스퀘어", Font.BOLD, 20));
        g.drawString(hour+":"+min+":"+sec,20,50); //m 디지털 시간 출력

    }

    private double ToRadian(int degree) { //m degree -> radian
        double radian = 0.0;
        radian = degree * (Math.PI/180.0f);
        return radian;
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
}