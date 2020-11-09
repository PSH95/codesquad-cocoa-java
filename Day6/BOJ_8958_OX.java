package com.example.Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX {


    public static int seriesFunction(int cnt){
        if(cnt<=1){
            return cnt;
        }
        else {
            return cnt+seriesFunction(cnt-1);
        }

     }
    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String InputSTR = "";


        int testCaseNum = Integer.parseInt(buff.readLine());

        for(int i=0;i<testCaseNum;i++) {
            int totalSUM = 0;
            int cnt = 0;
            InputSTR = buff.readLine();
            int strLen = InputSTR.length();

            for(int j=0;j<strLen;j++) {

                if(InputSTR.charAt(j) == 'O') {
                    cnt = cnt+1;
                }
                else if(InputSTR.charAt(j) == 'X'){
                    totalSUM += seriesFunction(cnt);
                    cnt = 0;
                }

            }

            if(cnt !=0) {
                totalSUM += seriesFunction(cnt);
            }
            System.out.println(totalSUM);

        }

    }
}
