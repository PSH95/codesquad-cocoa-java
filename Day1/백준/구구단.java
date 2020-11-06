package com.example.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구구단 {
    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("시작 단 : ");
            String strStartNumber = br.readLine();

            System.out.print("끝 단 : ");
            String strEndNumber = br.readLine();

            int nStart = Integer.parseInt(strStartNumber);
            int nEnd = Integer.parseInt(strEndNumber);

            for(int i=nStart;i<=nEnd;i++)
            {
                System.out.println("\n "+i+"단");
                for(int j=1;j<=9;j++)
                {
                    System.out.println(i+"x"+j+"="+i*j);
                }
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
