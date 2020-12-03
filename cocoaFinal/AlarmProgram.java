package com.example.cocoaFinal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AlarmProgram extends JFrame implements Runnable{

    private int i = 0;
    private final int ScreenWidth = 500;
    private final int ScreenHeight = 1000;
    private final Image clockBackground = ImageIO.read(new File("./resource/ClockBackground.png"));

    private GregorianCalendar time;
    private int hour = 0;
    private int min = 0;
    private int sec = 0;

    AlarmProgram() throws IOException {
        ClockInit();
    }

    private void ClockInit() {
        this.setTitle("아날로그 시계");
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
        this.add(AlarmListPanel,"South");
        this.add(ClockPanel,"Center");



        this.setVisible(true);
    }

    class menuBar extends JMenuBar{
        private JMenuBar menu;
        menuBar(){
            menu = new JMenuBar();
            menu.setBackground(Color.DARK_GRAY);

            JMenu AddAlarmMenu = new JMenu("추가(+)");
            AddAlarmMenu.setBackground(Color.DARK_GRAY);
            AddAlarmMenu.setForeground(Color.CYAN);
            menu.add(AddAlarmMenu);

            JMenuItem QuickMenu = new JMenuItem("퀵 알람");
            JMenuItem NormalMenu = new JMenuItem("알람");
            QuickMenu.setBackground(Color.DARK_GRAY);
            QuickMenu.setForeground(Color.white);
            NormalMenu.setBackground(Color.DARK_GRAY);
            NormalMenu.setForeground(Color.yellow);
            AddAlarmMenu.add(QuickMenu);
            AddAlarmMenu.add(NormalMenu);

            QuickMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("퀵알람");
                }
            });
        }
    }


    class AlarmListPanel extends JPanel{

        AlarmListPanel(){


            ScrollPane sp = new ScrollPane();

            JPanel ListPanel = new JPanel();
            sp.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight/10*5)); //m AlarmListPanel 사이즈와 동일
            ListPanel.setLayout(new GridLayout(1000,1,0,5));


            GridContentPanel GridContentPanel = new GridContentPanel(15);

            ListPanel.add(GridContentPanel);


            sp.add(ListPanel);

            this.add(sp);



        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            this.setLayout(new BorderLayout());
            this.setBackground(Color.WHITE);

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
            JLabel[] setAlarmDayLabel = new JLabel[this.AlarmCount];
            JButton[] AlarmSetting = new JButton[this.AlarmCount];



            for(int i=0;i<this.AlarmCount;i++) {

                contentPanel[i] = new JPanel();
                contentPanel[i].setLayout(new BorderLayout());

                contentPanel[i].add(AlarmCheck[i] = new JCheckBox(), "West");
                contentPanel[i].add(setAlarmTimeLabel[i] = new JLabel("알람"+i), "Center");
                contentPanel[i].add(setAlarmDayLabel[i] = new JLabel("시간"+i), "South");
                contentPanel[i].add(AlarmSetting[i] = new JButton("버튼"+i), "East");

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


                setAlarmDayLabel[i].setFont(new Font("나눔스퀘어", Font.BOLD, 20));
                setAlarmDayLabel[i].setForeground(Color.yellow);
                setAlarmDayLabel[i].setHorizontalAlignment(SwingConstants.CENTER);


                this.add(contentPanel[i]);

            }
        }


    }


    class ClockPanel extends JPanel{


        /***
         *m 삼감함수 공식을 이용한 아날로그 시계 알고리즘  ex) cos(theta) = R/x  → x = R*cos(theta)
         *m 직교좌표계(CCW)와 아날로그 시계(CW)는 진행 방향 다르므로, 변환과정(-90도)이 필요
         *m Math.cos 는 degree 가 아닌 Radian 연산을 하여 변환이 필요함.
         *m cf) Time Shift: cos(x-pi/2) == sin(x)
         *m 12시간 = 360도 → 1시간 = [30도]  → 60분 = 30도 → 1분 = [30/60도] → 60초 = 30/60 → 1초 = [30/60/60도]
         *m 60분 = 360도 → 1분 = [6도] → 60초 = 6도 → 1초 = [6/60도]
         *m 60초 = 360도 → 1초 = [6도]
         */


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

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

            g.setColor(Color.GRAY);
            g.setFont(new Font("나눔스퀘어", Font.BOLD, 20));
            g.drawString(hour+":"+min+":"+sec,this.getWidth()/2-20,this.getHeight()/2+5); //m 디지털 시간 출력

        }

        private double ToRadian(int degree) { //m degree -> radian
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
        AlarmProgram ClockFrame = null;
        try {
            ClockFrame = new AlarmProgram();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(ClockFrame);
        thread.start();
    }
}
