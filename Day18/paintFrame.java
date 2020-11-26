package com.example.Day18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class paintFrame extends JFrame {
    private int startX = 0;
    private int startY = 0;
    private int endX = 0;
    private int endY = 0;
    public static Color selColor = Color.BLACK;
    private int selThick = 5;
    Graphics g;
    public static Graphics2D g2D;

    public static int ToolStatus = 1;
    private final int Pen = 1;
    private final int Erase = 2;
    private final int Rect = 3;
    private final int Ellipse = 4;
    private final int Line = 5;



    static final Dimension res = Toolkit.getDefaultToolkit().getScreenSize(); // 해상도 불러오는 함수

    public void init(){
        setTitle("색칠공부");
        setSize(res.width/2,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground( Color.white );   //m getContentPane()을 하니까 색변경이 됬다.. 왜지??? 찾아보기...
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null); //m 정중앙으로 옮겨주는 메소드
        setLayout(new BorderLayout());


        makeMenu();
        makeButton();

        addEvent();

        g = getGraphics();
        g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(selThick, BasicStroke.CAP_ROUND, 0)); //m 도형의 외각선 모양을 결정하는 속성, Graphic2D에서 지원함.
    }


    private void makeMenu() {

        MenuBar menuBar = new MenuBar();
        menuBar.setFont(new Font("Serif", Font.PLAIN, 20));

        Menu mFile = new Menu("파일(F)");
        MenuItem mSave = new MenuItem("그림저장(S)");
        MenuItem mLoad= new MenuItem("불러오기(L)");

        mFile.add(mSave);
        mFile.add(mLoad);


        Menu mEdit = new Menu("편집(E)");
        MenuItem mAllDelete = new MenuItem("모두 지우기");
        mEdit.add(mAllDelete);

        menuBar.add(mFile);
        menuBar.add(mEdit);

        setMenuBar(menuBar);

        mAllDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();

            }
        });

    }
    private void makeButton() {


        Panel p = new Panel();
        p.setLayout(new GridLayout(1,7));
        p.setBackground(Color.cyan);


        JButton btDrawPencil= new JButton("연필");
        JButton btDrawRect= new JButton("사각형");
        JButton btDrawEllipse = new JButton("원");
        JButton btDrawLine = new JButton("직선");

        JButton btErase = new JButton("지우개");
        JButton btSelColor = new JButton("색상");
        JButton btSelThick= new JButton ("두께");



        btSelColor.setForeground(Color.white);
        btSelColor.setBackground(selColor);


        btDrawPencil.addActionListener(new btAction());
        btDrawRect.addActionListener(new btAction());
        btDrawEllipse.addActionListener(new btAction());
        btDrawLine.addActionListener(new btAction());
        btErase.addActionListener(new btAction());

        btDrawRect.setPreferredSize(new Dimension(100,100));


        p.add(btDrawPencil);
        p.add(btErase);

        p.add(btDrawRect);
        p.add(btDrawEllipse);
        p.add(btDrawLine);
        p.add(btSelColor);
        p.add(btSelThick);

       // p.add(colorStatus);



        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(1,3));
        p2.setBackground(Color.yellow);

        Label answerLabel = new Label("색칠 리스트");
        answerLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        answerLabel.setAlignment(Label.CENTER);

        Choice selectGame = new Choice();
        selectGame.add("뽀로로");
        selectGame.add("펭하");
        selectGame.add("엘사");
        selectGame.setFont(new Font("Serif", Font.PLAIN, 30));

        JButton btAnswerSend = new JButton("확인");
        btAnswerSend.setPreferredSize(new Dimension(20,20));



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
                g2D.setColor(selColor);
                btSelColor.setBackground(selColor);
            }
        });

        Dialog DlgSelectThick = new Dialog(this, "Information", true);

        Label DlgMsg = new Label("두께를 클릭하세요.", Label.CENTER);
        DlgMsg.setBackground(Color.white);
        DlgMsg.setFont(new Font("Serif", Font.PLAIN, 30));
        Choice DlgListThick = new Choice();
        DlgListThick.add("5");
        DlgListThick.add("20");
        DlgListThick.add("60");
        DlgListThick.add("150");
        DlgListThick.setFont(new Font("Serif", Font.PLAIN, 30));
        Button DlgOK = new Button("확인");


        DlgSelectThick.setSize(500,200);
        DlgSelectThick.setBackground(Color.BLACK);
        DlgSelectThick.setLayout(new BorderLayout());
        DlgSelectThick.setLocationRelativeTo(null);
        DlgSelectThick.add(DlgMsg,"North");
        DlgSelectThick.add(DlgListThick,"Center");
        DlgSelectThick.add(DlgOK,"South");

        btSelThick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DlgSelectThick.setVisible(true);
                g2D.setStroke(new BasicStroke(selThick, BasicStroke.CAP_ROUND, 0)); //m 도형의 외각선 모양을 결정하는 속성, Graphic2D에서 지원함.
            }
        });

        DlgOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selThick = Integer.parseInt(DlgListThick.getSelectedItem());
                DlgSelectThick.setVisible(false);  //Frame을 화면에서 보이지 않도록 하고
                DlgSelectThick.dispose();    //메모리에서 제거한다.
            }
        });

        btDrawPencil.setFont(new Font("Serif", Font.PLAIN, 30));
        btDrawRect.setFont(new Font("Serif", Font.PLAIN, 30));
        btDrawRect.setFont(new Font("Serif", Font.PLAIN, 30));
        btDrawEllipse.setFont(new Font("Serif", Font.PLAIN, 30));
        btDrawLine.setFont(new Font("Serif", Font.PLAIN, 30));
        btErase.setFont(new Font("Serif", Font.PLAIN, 30));
        btSelColor.setFont(new Font("Serif", Font.PLAIN, 30));
        btSelThick.setFont(new Font("Serif", Font.PLAIN, 30));

    }

    private void addEvent() {

      addMouseListener(new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
              super.mousePressed(e);
              startX = e.getX();
              startY = e.getY();
          }
          @Override
          public void mouseReleased(MouseEvent e) {

              switch (ToolStatus){
                  case Rect:
                      endX = e.getX();
                      endY = e.getY();
                      g2D.drawRect(startX, startY, endX, endY);
                      break;
                  case Ellipse:
                      endX = e.getX();
                      endY = e.getY();
                      g2D.drawOval(startX, startY, endX, endY);
                      break;
                  case Line:
                      endX = e.getX();
                      endY = e.getY();
                      g2D.drawLine(startX, startY, endX, endY);
                      break;

              }
          }
      });

       addMouseMotionListener(new MouseMotionAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {

               switch (ToolStatus){
                   case Pen:
                   case Erase:

                       endX = e.getX();
                       endY = e.getY();

                       g2D.drawLine(startX, startY, endX, endY);

                       startX = endX; // 연속적으로 그려지기 위해서, 움직였을 때 마지막 좌표를 시작좌표로 초기화
                       startY = endY;
                       break;
               }


           }
       });

    }


    public paintFrame(){
        init();
        addEvent();

    }

}
