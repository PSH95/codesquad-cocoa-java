package com.example.Day16;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class awtPractice extends Frame {

    static final Dimension res = Toolkit.getDefaultToolkit().getScreenSize(); // 해상도 불러오는 함수
    private BufferedImage background;

    public void initFrame(){

        setSize(res.width/2,res.height/2);
        setVisible(true);
        setLocation(res.width/2-this.getWidth()/2,res.height/2-this.getHeight()/2); // 절반의 해상도에서 프레임 크기의 절반을 빼줘야 정중앙으로 옮길 수 있다.


        MenuBar mb = new MenuBar();
        Menu mFile = new Menu("File");
        MenuItem miNew = new MenuItem("New");
        MenuItem miOpen = new MenuItem("Open");
        Menu mOthers = new Menu("Others"); // MenuItem Menu 이 아니라 임에 주의
        MenuItem miExit = new MenuItem("Exit");

        mFile.add(miNew); // Menu MenuItem . 에 들을 추가한다
        mFile.add(miOpen);
        mFile.add(mOthers); // Menu Menu . 에 를 추가한다
        mFile.addSeparator(); // .

        mFile.add(miExit);
        MenuItem miPrint = new MenuItem("Print ...");
        MenuItem miPreview = new MenuItem("Print Preview");
        MenuItem miSetup = new MenuItem("Print Setup ...");
        mOthers.add(miPrint);
        mOthers.add(miPreview);
        mOthers.add(miSetup);
        Menu mEdit = new Menu("Edit");
        Menu mView = new Menu("View");
        Menu mHelp = new Menu("Help");
        CheckboxMenuItem miStatusbar = new CheckboxMenuItem("Statusbar");
        mView.add(miStatusbar);
        mb.add(mFile); // MenuBar Menu . 에 를 추가한다
        mb.add(mEdit);
        mb.add(mView);
        mb.setHelpMenu(mHelp); // mHelp HelpMenu .

        setMenuBar(mb); // Frame MenuBar . 에 를 포함시킨다

    }

    @Override
    public void paint(Graphics g) {
        g = this.getGraphics();
        g.drawImage(background, 0, 0, this);
    }

    public awtPractice(){
        initFrame();

        try {
            File f = new File("./");
            System.out.println(f.getAbsolutePath());
            background = ImageIO.read(new File("./resources/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(),
                    "BG loading error: " + e.getMessage(),
                    "Loading Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
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
