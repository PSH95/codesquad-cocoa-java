package com.example.Day16;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class awtPractice extends Frame {

    static final Dimension res = Toolkit.getDefaultToolkit().getScreenSize(); // 해상도 불러오는 함수

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
