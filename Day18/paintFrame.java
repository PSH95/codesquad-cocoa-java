package com.example.Day18;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class paintFrame extends JFrame {

    public static Graphics2D g2D;
    public static int ToolStatus = 1; //m 도구(연필,사각형 등 선택하는 것)
    public static Color selColor = Color.BLACK;

    private Graphics g;
    private BufferedImage background;
    private int startX = 0;
    private int startY = 0;
    private int endX = 0;
    private int endY = 0;

    private int selThick = 5;

    private final int Pen = 1; //m ToolStatus 를 구분하기 위한 상수들
    private final int Erase = 2;
    private final int Rect = 3;
    private final int Ellipse = 4;
    private final int Line = 5;

    private final ImageIcon iconPen = new ImageIcon("./resource/icon/pencil.png");
    private final ImageIcon iconErase = new ImageIcon("./resource/icon/eraser.png");
    private final ImageIcon iconRect = new ImageIcon("./resource/icon/rectangle.png");
    private final ImageIcon iconCircle = new ImageIcon("./resource/icon/circle.png");
    private final ImageIcon iconLine= new ImageIcon("./resource/icon/line.png");
    private final ImageIcon iconColor= new ImageIcon("./resource/icon/painting.png");
    private final ImageIcon iconThick= new ImageIcon("./resource/icon/width.png");

    private FileDialog dlgSave = new FileDialog(this,"저장",FileDialog.SAVE);
    private FileDialog dlgOpen = new FileDialog(this,"열기",FileDialog.LOAD);


    public paintFrame(){
        init();
        addEvent();
        makeMenu();
        makeButton();
    }

    @Override
    public void paint(Graphics g) {
        g2D.drawImage(background, 0, 0, this);
    }
    public void init(){

        setTitle("색칠공부");
        setSize(1000,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground( Color.white );   //m getContentPane()을 하니까 색변경이 됬다.. 왜지??? 찾아보기...
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null); //m 정중앙으로 옮겨주는 메소드
        setLayout(new BorderLayout());

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

        mSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlgSave.setVisible(true);
                String data = dlgSave.getDirectory()+ dlgSave.getFile();;  // 파일의 디렉토리 정보와 파일명을 얻는다.

                try{

                    ImageIO.write(background, "PNG", new File(data));
                    String Filename = dlgSave.getFile();  // 저장할 파일의 이름을 넣고..
                    setTitle(Filename);  // 프레임 명을 파일명으로 바꾼다..
                }catch(Exception e1){

                }
            }
        });

        Menu mEdit = new Menu("편집(E)");
        MenuItem mAllDelete = new MenuItem("모두지우기");
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

        /***
         *m  North 컴포넌트(연필,사각형,색변경 등..)
         */
        Panel p = new Panel();
        p.setLayout(new GridLayout(1,7));
        p.setBackground(Color.cyan);


        JButton btDrawPencil= new JButton("연필");
        JButton btDrawRect= new JButton("사각형");
        JButton btDrawEllipse = new JButton("원");
        JButton btDrawLine = new JButton("직선");

        JButton btErase = new JButton("지우개");
        JButton btSelColor = new JButton();
        JButton btSelThick= new JButton ();


        btDrawRect.setPreferredSize(new Dimension(100,100));

        p.add(btDrawPencil);
        p.add(btErase);

        p.add(btDrawRect);
        p.add(btDrawEllipse);
        p.add(btDrawLine);
        p.add(btSelColor);
        p.add(btSelThick);

        /***
         *m  South 컴포넌트(도면 리스트..)
         */

        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(1,3));
        p2.setBackground(Color.yellow);

        Label answerLabel = new Label("도안 리스트");
        answerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        answerLabel.setAlignment(Label.CENTER);

        Choice selectGame = new Choice();
        selectGame.add("0");
        selectGame.add("1");
        selectGame.add("2");
        selectGame.add("3");
        selectGame.add("4");
        selectGame.add("5");
        selectGame.setFont(new Font("Serif", Font.PLAIN, 30));

        JButton btSelectImage = new JButton("선택");
        btSelectImage.setFont(new Font("Serif", Font.PLAIN, 30));
        btSelectImage.setPreferredSize(new Dimension(20,20));


        p2.add(answerLabel);
        p2.add(selectGame);
        p2.add(btSelectImage);


        add(p,"North");
        add(p2,"South");


        Dialog DlgSelectThick = new Dialog(this, "두께변경", true);

        Label DlgMsg = new Label("변경할 두께를 클릭하세요.", Label.CENTER);
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


        /**
         *m 툴 버튼 아이콘,폰트 추가
         */

        btDrawPencil.setIcon(iconPen);
        btErase.setIcon(iconErase);
        btDrawRect.setIcon(iconRect);
        btDrawEllipse.setIcon(iconCircle);
        btDrawLine.setIcon(iconLine);
        btSelColor.setIcon(iconColor);
        btSelThick.setIcon(iconThick);

        btDrawPencil.setFont(new Font("Serif", Font.BOLD, 20));
        btDrawRect.setFont(new Font("Serif", Font.BOLD, 20));
        btDrawRect.setFont(new Font("Serif", Font.BOLD, 20));
        btDrawEllipse.setFont(new Font("Serif", Font.BOLD, 20));
        btDrawLine.setFont(new Font("Serif", Font.BOLD, 20));
        btErase.setFont(new Font("Serif", Font.BOLD, 20));


        /***
         *m  버튼 컴포넌트의 리스너들
         */

        btDrawPencil.addActionListener(new btAction());
        btDrawRect.addActionListener(new btAction());
        btDrawEllipse.addActionListener(new btAction());
        btDrawLine.addActionListener(new btAction());
        btErase.addActionListener(new btAction());

        btSelColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser chooser = new JColorChooser(); // 색 선택
                selColor = chooser.showDialog(null, "색상 변경", Color.ORANGE);
                g2D.setColor(selColor);
                btSelColor.setBackground(selColor);
            }
        });

        btSelectImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    background = ImageIO.read(new File("./resource/bg" + selectGame.getSelectedItem() + ".jpg"));

                    repaint();
                } catch (IOException d) {
                    d.printStackTrace();
                }
            }
        });

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
                   case Rect:
                       endX = e.getX();
                       endY = e.getY();

               }


           }

       });



    }

}
