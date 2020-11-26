package com.example.Day18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class paintFrame extends JFrame {
    private int startX = 0;
    private int startY = 0;
    private int endX = 0;
    private int endY = 0;
    private Color selColor;
    Graphics g;
    public static Graphics2D g2D;

    static final Dimension res = Toolkit.getDefaultToolkit().getScreenSize(); // 해상도 불러오는 함수

    public void init(){
        setTitle("색칠공부");
        setSize(res.width/2,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.white);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null); //m 정중앙으로 옮겨주는 메소드
        setLayout(new BorderLayout());

        makeMenu();
        makeButton();
        makeSketchFrame();

        addEvent();

        g = getGraphics();
        g2D = (Graphics2D)g;

    }


    private void makeMenu() {

        MenuBar menuBar = new MenuBar();

        Menu mFile = new Menu("파일(F)");
        MenuItem mSave = new MenuItem("그림저장(S)");
        MenuItem mLoad= new MenuItem("불러오기(L)");

        mFile.add(mSave);
        mFile.add(mLoad);

        menuBar.add(mFile);

        setMenuBar(menuBar);

    }
    private void makeButton() {

        Panel p = new Panel();
        p.setLayout(new GridLayout(1,8));
        p.setBackground(Color.cyan);


        Button btDrawPencil= new Button("연필");
        Button btDrawRect= new Button("사각형");
        Button btDrawEllipse = new Button("원");
        Button btDrawLine = new Button("직선");
        Button btDrawCurve = new Button("곡선");

        Button btErase = new Button("지우개");
        Button btSelColor = new Button("색상변경");
        Button btSelThick= new Button("굵기변경");

        btDrawPencil.addActionListener(new btAction());
        btDrawRect.addActionListener(new btAction());
        btDrawEllipse.addActionListener(new btAction());
        btDrawLine.addActionListener(new btAction());
        btDrawCurve.addActionListener(new btAction());
        btErase.addActionListener(new btAction());


        btDrawRect.setPreferredSize(new Dimension(100,100));

        p.add(btDrawPencil);
        p.add(btErase);

        p.add(btDrawRect);
        p.add(btDrawEllipse);
        p.add(btDrawLine);
        p.add(btDrawCurve);
        p.add(btSelColor);
        p.add(btSelThick);


        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(1,3));

        Label answerLabel = new Label("색칠 리스트");
        answerLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        answerLabel.setAlignment(Label.CENTER);

        Choice selectGame = new Choice();
        selectGame.add("뽀로로");
        selectGame.add("펭하");
        selectGame.add("엘사");
        selectGame.setFont(new Font("Serif", Font.PLAIN, 30));

        Button btAnswerSend = new Button("확인");
        btAnswerSend.setPreferredSize(new Dimension(60,60));



        p2.add(answerLabel);
        p2.add(selectGame);
        p2.add(btAnswerSend);


        add(p,"North");
        add(p2,"South");

        btSelColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser chooser = new JColorChooser(); // 색 선택
                selColor = chooser.showDialog(null, "색상 변경", Color.ORANGE);
                g.setColor(selColor);
            }
        });

    }


    private void makeSketchFrame(){


    }

    private void addEvent() {

      addMouseListener(new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
              super.mousePressed(e);
              startX = e.getX();
              startY = e.getY();
          }
      });

       addMouseMotionListener(new MouseMotionAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {

               endX = e.getX();
               endY = e.getY();

               g2D.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, 0)); //m 도형의 외각선 모양을 결정하는 속성, Graphic2D에서 지원함.
               g2D.drawLine(startX,startY,endX,endY);

               startX = endX; // 연속적으로 그려지기 위해서, 움직였을 때 마지막 좌표를 시작좌표로 초기화
               startY = endY;


           }
       });

    }


    public paintFrame(){
        init();
        addEvent();

    }

}
