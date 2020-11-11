package com.example.Day7;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO_Practice {

    public static void main(String[] args) throws IOException {

        String name = "홍길동";
        try (BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream("C:/Users/psh/Desktop/data/"+name+".txt",true))) { // true 일 경우 이어쓰기
            String str = "2/아이스크림/0/10000/현금\r\n";
            bs.write(str.getBytes()); // 바이트형

        } catch (Exception e) {
            e.getStackTrace();
        }

        try {
            // 바이트 단위로 파일읽기
            String filePath = "C:/Users/psh/Desktop/data/"+name+".txt"; // 대상 파일
            FileInputStream fileStream = null; // 파일 스트림

            fileStream = new FileInputStream( filePath );// 파일 스트림 생성
            //버퍼 선언
            byte[ ] readBuffer = new byte[fileStream.available()];
            while (fileStream.read( readBuffer ) != -1){}
            System.out.println(new String(readBuffer)); //출력

            fileStream.close(); //스트림 닫기
        } catch (Exception e) {
            e.getStackTrace();
        }



    }
}
