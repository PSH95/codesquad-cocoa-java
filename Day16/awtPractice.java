package com.example.Day16;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class awtPractice extends Frame {

    static final Dimension res = Toolkit.getDefaultToolkit().getScreenSize(); // 해상도 불러오는 함수
    private MenuBar menuBar;
    private Menu menuFile; // 파일 메뉴
    private Menu menuEdit; // 편집 메뉴
    private Menu menuView; // 보기 메뉴
    private Menu menuHelp; // 도움말 메뉴

    private MenuItem menuFileNew; // 새로만들기
    private MenuItem menuFileOpen; // 파일 열기



    public void initFrame(){

        setSize(res.width/2,res.height/2);
        setVisible(true);
        setLocation(res.width/2-this.getWidth()/2,res.height/2-this.getHeight()/2); // 절반의 해상도에서 프레임 크기의 절반을 빼줘야 정중앙으로 옮길 수 있다.

        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);
        this.setLayout(fl);

        Panel area = new Panel();
        area.setBackground(Color.BLACK);
        area.setLocation(50,520);

        Button b1 = new Button("테스트");
        b1.setPreferredSize(new Dimension(160, 40)); // 버튼 크기 설정
        Button b2 = new Button("테스트2");
        b2.setPreferredSize(new Dimension(160, 40)); // 버튼 크기 설정

        area.add(b1);
        area.add(b2);

        this.add(area,"North");

        this.menuBar = new MenuBar();
        this.setMenuBar(this.menuBar);

        this.menuFile = new Menu ("파일(F)");
        this.menuBar.add(this.menuFile);

        this.menuEdit = new Menu ("편집(E)");
        this.menuBar.add(this.menuEdit);

        this.menuView = new Menu ("보기(V)");
        this.menuBar.add(this.menuView);

        this.menuHelp = new Menu ("도움말(H)");
        this.menuBar.add(this.menuHelp);

        this.menuFileNew = new MenuItem("새로 만들기(N)");
        this.menuFile.add(this.menuFileNew);

        this.menuFileOpen = new MenuItem("파일 열기(O)");
        this.menuFile.add(this.menuFileOpen);

        this.setVisible(true);
    }

    public awtPractice(){
        initFrame();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                awtPractice fr = new awtPractice();

                fr.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {

                        e.getWindow().setVisible(false);  //Frame을 화면에서 보이지 않도록 하고
                        e.getWindow().dispose();    //메모리에서 제거한다.

                        System.exit(0);  //프로그램을 종료하다.
                    }
                });


            }
        });

    }
}
