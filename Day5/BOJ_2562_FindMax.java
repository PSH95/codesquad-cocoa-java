package com.example.day5;


//TODO. 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성
// 하 결과는 나오지만..런타임에러..

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

        int[] number = new int[9];
        for(int i=0;i<number.length;i++) {
            number[i] = InputNumber();
        }

        int temp = 0;
        int index = 0;
        for(int i=0;i<number.length-1;i++) {
            if(temp<number[i]){
                temp = number[i];
                index = i+1;
            }
        }

        System.out.println(temp);
        System.out.println(index);

    }

}
