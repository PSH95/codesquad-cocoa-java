package com.example.Day16;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class notepadEX {
    public static void main(String[] args) {

            // Frame 설정 및 추가
            // Frame 생성 제목표시줄에 메모장이 표시되도록 합니다.
            JFrame frame = new JFrame("메모장");

            // Frame의 사이즈를 변경하지 못하도록 합니다.
            //frame.setResizable(false);

            // 창을 닫으면 프로그램이 종료되도록 합니다.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            // 패널 설정 및 추가
            // 패널 객체를 생성. (텍스트 영역)
            JPanel textPanel = new JPanel();
            JPanel alarmPanel = new JPanel();


            alarmPanel.setToolTipText("기타 사용을 위해 이용하는 부분입니다.");

            //위 아래 패널의 영역을 확인하기 위해서 패널에 배경색을 주었다.
            textPanel.setBackground(Color.gray);
            alarmPanel.setBackground(Color.pink);

            //frame 동서남북가운데 다섯 영역으로 구분했을 때 위쪽에 textPanel을 집어 넣습니다.
            frame.getContentPane().add(textPanel, "North");
            frame.getContentPane().add(alarmPanel, "South");

            // TextArea에 content가 가리키는 문자열을 표시하고 40행, 50열로 설정합니다.
            JTextArea ta = new JTextArea(content, 40, 50);

            //행 넘기기 기능 켜기
            ta.setLineWrap(true);

            //행 넘길 때 행의 마지막 단어가 두행에 걸쳐 나뉘지 않도록 하기
            ta.setWrapStyleWord(true);

            // 툴팁제작
            ta.setToolTipText("이곳에 텍스트를 입력하세요");

            // TextArea의 테두리선의 색을 검정 두깨를 3px로 설정합니다.
            Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);

            // 텍스트와 TextArea 경계 사이에 여백을 두기 위해서 emptyBorder를 생성합니다.
            Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);

            //TextArea에 lineBorder(검정테두리), emptyBorder(여백)로 구성된 복합 경계선을 설정합니다.
            ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));

            // TextArea에 스크롤 기능을 추가한 후 Panel안에 집어 넣습니다.
            textPanel.add(new JScrollPane(ta));






            // 메뉴바
            JMenuBar menuBar = new JMenuBar();

            // 메뉴
            JMenu fileMenu = new JMenu("파일");
            JMenu findMenu = new JMenu("찾기/바꾸기");

            // 메뉴 아이템 순서로 준비
            JMenuItem newItem = new JMenuItem("새 문서");
            JMenuItem openItem = new JMenuItem("열기");
            JMenuItem saveItem = new JMenuItem("저장");
            JMenuItem saveasItem = new JMenuItem("다른 이름으로 저장");
            JMenuItem closeItem = new JMenuItem("닫기");

            JMenuItem findItem = new JMenuItem("찾기");
            JMenuItem replaceItem = new JMenuItem("바꾸기");

            frame.setJMenuBar(menuBar);

            menuBar.add(fileMenu); // 파일
            menuBar.add(findMenu); // 찾기/바꾸기
            fileMenu.add(newItem); // 새 문서
            fileMenu.add(openItem); // 열기
            fileMenu.add(saveItem); // 저장
            fileMenu.add(saveasItem); // 다른 이름으로 저장
            fileMenu.add(closeItem); // 닫기

            findMenu.add(findItem); // 찾기
            findMenu.add(replaceItem); // 바꾸기


            // 텍스트 필드를 생성한다.(단어 찾기 위한 입력 공간)
            JTextField searchtext = new JTextField(10);
            // 알람 패널부분에 searchtext 텍스트 필드를 넣는다.
            alarmPanel.add(searchtext);
            // 찾기 버튼을 생성한다.
            JButton btn1 = new JButton("찾기");
            alarmPanel.add(btn1);


            // 텍스트 필드를 생성한다.(단어 바꾸기 위한 입력 공간)
            JTextField replacetext = new JTextField(10);

            // 알람 패널부분에 replacetext 텍스트 필드를 넣는다.
            alarmPanel.add(replacetext);

            // 찾기 버튼을 생성한다.
            JButton btn2 = new JButton("바꾸기");
            alarmPanel.add(btn2);


            // 출력 공간을 생성한다.
            JTextArea tf = new JTextArea("", 10,40);
            // 출력 공간을 알람 패널에 넣는다.
            alarmPanel.add(tf);
            // 적지는 못하도록 한다.
            tf.setEditable(false);

            //행 넘기기 기능 켜기
            tf.setLineWrap(true);

            // TextArea에 스크롤 기능을 추가한 후 Panel안에 집어 넣습니다.
            JScrollPane alarmscroll = (JScrollPane) alarmPanel.add(new JScrollPane(tf));


            // 툴팁을 통해 어떤 방식으로 이용하는것인지 알려준다.
            tf.setToolTipText("찾기 기능을 이용한 목록을 확인 할 수 있습니다.");
            searchtext.setToolTipText("찾기 기능을 이용할 수 있습니다.");
            replacetext.setToolTipText("바꾸기 기능을 이용할 수 있습니다.");
            tf.setVisible(false);
            searchtext.setVisible(false);
            replacetext.setVisible(false);
            btn1.setVisible(false);
            btn2.setVisible(false);
            alarmscroll.setVisible(false);
            tf.setVisible(false);

            FileDialog mSave = new FileDialog(frame,"저장",FileDialog.SAVE);
            FileDialog mOpen = new FileDialog(frame,"열기",FileDialog.LOAD);


            newItem.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    ta.setText(content);
                    frame.setTitle("메모장");
                    flag = 0;
                    frame.setSize(600,810);
                }
            });

            openItem.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){
                    mOpen.setVisible(true);
                    String data = mOpen.getDirectory()+ mOpen.getFile();
                    try{
                        String str="";
                        FileReader fr = new FileReader(data);
                        BufferedReader br = new BufferedReader(fr);


                        ta.setText("");  // 일단 초기화
                        while((str=br.readLine()) != null){   // str에 남아둔 내용이 null 이 아니면..

                            ta.append(str);  // str의 내용을 추가
                            ta.append("\r\n"); // readline은 개행을 못하니 개행까지 직접해준다.
                        }

                        br.close();
                        String Filename = mOpen.getFile();
                        frame.setTitle(Filename);
                        flag = 1;
                    } catch(Exception e1){
                    }
                }


            });

            saveItem.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){

                    if(flag == 0)
                    {
                        mSave.setVisible(true);
                        String data = mSave.getDirectory()+ mSave.getFile();  // 파일의 디렉토리 정보와 파일명을 얻는다.
                        try{
                            FileWriter fw = new FileWriter(data+".txt"); // txt파일로 저장한다.
                            BufferedWriter bw = new BufferedWriter(fw);

                            String str = ta.getText();
                            for(int i = 0 ; i < str.length(); i++)
                            {
                                if(str.charAt(i) == '\n')
                                {
                                    System.out.println("find");
                                    bw.newLine();
                                }
                                else
                                    bw.write(str.charAt(i));  // Textarea 에 bw객체에 있는 내용을 넣는다.
                            }

                            bw.close();
                            String Filename = mSave.getFile();  // 저장할 파일의 이름을 넣고..
                            frame.setTitle(Filename + ".txt");  // 프레임 명을 파일명으로 바꾼다..
                        }catch(Exception e1){

                        }
                        flag = 1;
                    }

                    else if(flag == 1)
                    {
                        String data = mSave.getDirectory()+ mSave.getFile();  // 파일의 디렉토리 정보와 파일명을 얻는다.

                        try{
                            FileWriter fw = new FileWriter(data+".txt"); // txt파일로 저장한다.
                            BufferedWriter bw = new BufferedWriter(fw);

                            String str = ta.getText();
                            for(int i = 0 ; i < str.length(); i++)
                            {
                                if(str.charAt(i) == '\n')
                                {
                                    System.out.println("find");
                                    bw.newLine();
                                }
                                else
                                    bw.write(str.charAt(i));  // Textarea 에 bw객체에 있는 내용을 넣는다.
                            }
                            bw.close();
                        }catch(Exception e2){

                        }

                    }

                }
            });

            saveasItem.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){
                    mSave.setVisible(true);
                    String data = mSave.getDirectory()+ mSave.getFile();  // 파일의 디렉토리 정보와 파일명을 얻는다.
                    try{
                        FileWriter fw = new FileWriter(data+".txt"); // txt파일로 저장한다.
                        BufferedWriter bw = new BufferedWriter(fw);

                        String str = ta.getText();
                        for(int i = 0 ; i < str.length(); i++)
                        {
                            if(str.charAt(i) == '\n')
                            {
                                System.out.println("find");
                                bw.newLine();

                            }
                            else
                                bw.write(str.charAt(i));  // Textarea 에 bw객체에 있는 내용을 넣는다.
                        }

                        bw.close();
                        String Filename = mSave.getFile();  // 저장할 파일의 이름을 넣고,
                        frame.setTitle(Filename + ".txt");  // 프레임 명을 파일명으로 바꾼다.
                    }catch(Exception e1){

                    }


                }
            });

            closeItem.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });


            findItem.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){

                    // 프레임 사이즈를 늘린다.
                    frame.setSize(800,1000);
                    searchtext.setVisible(true);
                    btn1.setVisible(true);

                    replacetext.setVisible(false);
                    btn2.setVisible(false);

                    tf.setVisible(true);
                    tf.setEditable(false);
                    alarmscroll.setVisible(true);

                    btn1.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){


                            // 찾을 단어를 가져온다.
                            String find = searchtext.getText();

                            // 메모장의 내용을 가져온다.
                            String str = ta.getText();

                            // 단어를 가리킬 위치의 첫 부분은 pos로 정한다.
                            pos = str.indexOf(find, fromindex);

                            // 만약 끝까지 찾았다면 0에서 다시 찾도록 한번더 기회준다.
                            if(pos == -1)
                            {
                                pos = 0;
                                fromindex = 0;
                                pos = str.indexOf(find,  fromindex);
                                tf.append("단어를 모두 찾았습니다. 처음부터 단어를 찾습니다.\r\n" + find + " 단어의 위치 :: " + pos );
                                tf.append("\r\n");
                                fromindex = pos + find.length();

                            }

                            else
                            {
                                fromindex = pos + find.length();

                                tf.append(find + " 단어의 위치 :: " + pos );
                                tf.append("\r\n");
                            }

                        }

                    });
                }

            });

            replaceItem.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){

                    // 프레임 사이즈를 늘린다.
                    frame.setSize(800,1000);

                    searchtext.setVisible(true);
                    btn1.setVisible(true);

                    replacetext.setVisible(true);
                    btn2.setVisible(true);

                    tf.setVisible(true);
                    tf.setEditable(false);
                    alarmscroll.setVisible(true);

                    btn1.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){


                            // 찾을 단어를 가져온다.
                            String find = searchtext.getText();

                            // 메모장의 내용을 가져온다.
                            String str = ta.getText();

                            // 단어를 가리킬 위치의 첫 부분은 pos로 정한다.
                            pos = str.indexOf(find, fromindex);

                            // 만약 끝까지 찾았다면 0에서 다시 찾도록 한번더 기회준다.
                            if(pos == -1)
                            {
                                pos = 0;
                                fromindex = 0;
                                pos = str.indexOf(find,  fromindex);
                                tf.append("단어를 모두 찾았습니다. 처음부터 단어를 찾습니다.\r\n" + find + " 단어의 위치 :: " + pos );
                                tf.append("\r\n");
                                fromindex = pos + find.length();

                            }

                            else
                            {
                                fromindex = pos + find.length();

                                tf.append(find + " 단어의 위치 :: " + pos );
                                tf.append("\r\n");
                            }

                        }

                    });


                    btn2.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){


                            // 찾을 단어를 가져온다.
                            String find = searchtext.getText();
                            String replace = replacetext.getText();

                            // 메모장의 내용을 가져온다.
                            String str = ta.getText();

                            // 단어를 가리킬 위치의 첫 부분은 pos로 정한다.
                            pos = str.indexOf(find, fromindex);

                            // 만약 끝까지 찾았다면 0에서 다시 찾도록 한번더 기회준다.
                            if(pos == -1)
                            {
                                pos = 0;
                                fromindex = 0;
                                tf.append("마지막 위치까지 단어를 모두 바꾸었습니다. \r\n아직 남아있다면 바꾸기 버튼을 다시 누르시고, 처음부터 다시 검색하여 바꿉니다.\r\n");
                                tf.append("\r\n");
                            }

                            else
                            {
                                fromindex = pos + find.length();
                                ta.replaceRange(replace, pos, pos+find.length());
                                tf.append(find + " 단어의 위치 :: " + pos );
                                tf.append("\r\n");
                            }

                        }

                    });

                }

            });

            // frame 안에 있는 모든 내용들이 보이도록 frame 사이즈를 조정합니다.
            frame.pack();

            // frame이 보이도록 설정합니다.
            frame.setVisible(true);
        }
        static String content = "";
        static int flag = 0; // 저장  및  다른 이름으로 저장에 이용

        static int pos = 0;
        static int fromindex = 0;

}
