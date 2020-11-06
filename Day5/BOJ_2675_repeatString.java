package com.example.Day5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2675_repeatString {

    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int testCaseNum = Integer.parseInt(buff.readLine());

        String InputData= buff.readLine();

        int idx = InputData.indexOf(" ");

        int repeatCount = Integer.parseInt(InputData.substring(0,idx));
        String InputStr = InputData.substring(idx+1);

        System.out.println(testCaseNum);
        System.out.println(repeatCount);
        System.out.println(InputStr);


    }
}
