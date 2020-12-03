package com.example.cocoaFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddQuickAlarmDlg extends JDialog{


    public static int SetHour = 0;
    public static int SetMinute = 0;


    public AddQuickAlarmDlg(JFrame frame, String title, boolean check) {
        super(frame,title,check);

        JButton okButton = new JButton("저장");
        JLabel TimeTagLabel = new JLabel("00:00");
        JPanel timeGridPane = new JPanel();

        JButton[] btnTime = new JButton[8];
        getContentPane().setBackground(Color.darkGray);
        setLayout(new BorderLayout());

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
                setVisible(false);
                dispose();

            }
        });
    }
}
