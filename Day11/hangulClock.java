package com.example.Day11;

import java.text.SimpleDateFormat;

public class hangulClock {


    public static void main(String[] args) {

        final int HourMax = 12;
        SimpleDateFormat timeFormat = new SimpleDateFormat ( "HH:mm");
        String[] strTime = timeFormat.format (System.currentTimeMillis()).split(":");

        String[][] hour = {
                {"한","두","세","네","다","섯"},
                {"여","섯","일","곱","여","덟"},
                {"아","홉","열","한","두","시"},
        };
        String[][] minute = {
                {"자","이","삼","사","오","십"},
                {"정","일","이","삼","사","육"},
                {"오","오","칠","팔","구","분"},
        };


        int nHour = Integer.parseInt(strTime[0]);

        if(nHour>12) {
            strTime[0] = Integer.toString(nHour - HourMax);
            nHour = Integer.parseInt(strTime[0]);
        }
        System.out.println(strTime[0]);

        if (nHour < 5 ) {
            System.out.print(hour[0][nHour-1]+" ");
            System.out.println(hour[2][5]+" ");
        }
        else if (nHour < 10) {
            System.out.print(hour[0][nHour-1]+" ");
            System.out.println(hour[2][5]+" ");
        }

        System.out.println();

        for (int i=0;i<hour.length;i++) {
            for(int j=0;j<hour[i].length;j++) {

                System.out.print(hour[i][j] + " ");
            }
            System.out.println();
        }
        for (int i=0;i<minute.length;i++) {
            for(int j=0;j<minute[i].length;j++) {

                System.out.print(minute[i][j] + " ");
            }
            System.out.println();
        }

    }



}
