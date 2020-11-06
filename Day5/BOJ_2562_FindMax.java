package com.example.Day5;


//TODO. 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성
//O 2번째 시도 : 배열 사용 X

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2562_FindMax {


    public static int InputNumber(){
        int a = 0;
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            a = Integer.parseInt(buf.readLine());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return a;
    }

    public static void main(String[] args) {

        int maxValue=0;
        int index = 0;

        for(int i=0;i<9;i++) {
            int number = 0;
            number = InputNumber();

            if(maxValue < number) {
                maxValue = number;
                index = i+1;
            }

        }
        System.out.println(maxValue);
        System.out.println(index);
    }

}
