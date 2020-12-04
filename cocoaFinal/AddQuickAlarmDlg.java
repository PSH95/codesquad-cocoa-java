package com.example.cocoaFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddQuickAlarmDlg extends JDialog implements Runnable{


    public static int[] SetTime = new int[2];
    private JLabel TimeTagLabel;


    public AddQuickAlarmDlg(JFrame frame, String title, boolean check) {
        super(frame,title,check);

        Thread thread = new Thread(this);
        thread.start();

        JButton okButton = new JButton("저장");
        TimeTagLabel = new JLabel("00:00");

        JPanel timeGridPane = new JPanel();

        JButton[] btnTime = new JButton[8];
        getContentPane().setBackground(Color.darkGray);
        setLayout(new BorderLayout());

        this.addWindowListener(new WindowAdapter() {   //m X(닫기)버튼 눌렀을 경우 이벤트 핸들러
            @Override
            public void windowClosing(WindowEvent e) {
                SetTime[0] = 0;
                SetTime[1] = 0;
                e.getWindow().setVisible(false);  //Frame을 화면에서 보이지 않도록 하고
                e.getWindow().dispose();    //메모리에서 제거한다.
            }
        });


        timeGridPane.setLayout(new GridLayout(2,4,5,5));

        for(int i=0;i<8;i++) {
            btnTime[i] = new JButton(((i + 1) * 5) + "분");
            btnTime[i].setFont(new Font("나눔스퀘어", Font.BOLD, 13));
            timeGridPane.add(btnTime[i]);
            if (i == 7) {
                btnTime[i].setText("");

                ImageIcon icon = new ImageIcon("./resource/back-arrow.png");
                Image img = icon.getImage();
                Image changeImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                ImageIcon changeIcon = new ImageIcon(changeImg);

                btnTime[i].setIcon(changeIcon);
            }

            btnTime[i].addActionListener(new btnAction());
        }


        TimeTagLabel.setForeground(Color.yellow);
        TimeTagLabel.setFont(new Font("나눔스퀘어", Font.BOLD, 50));;
        TimeTagLabel.setPreferredSize(new Dimension(300,200));
        TimeTagLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(TimeTagLabel,"North");
        add(timeGridPane,"Center");
        add(okButton,"South");


        setSize(300, 400);
        setLocationRelativeTo(null);


        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SetTime[0]=0;
                SetTime[1]=0;
                setVisible(false);
                dispose();

            }
        });
    }

    @Override
    public void run() {

        while (true){


            if(TimeTagLabel != null) {
                TimeTagLabel.setText(SetTime[0] + ":" + SetTime[1]);
            }


            if( SetTime[1] >= 60){
                SetTime[0]+= 1;
                SetTime[1] = SetTime[1]-60;
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
