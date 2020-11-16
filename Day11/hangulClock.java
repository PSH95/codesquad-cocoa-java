package com.example.Day11;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class hangulClock {


    public static void main(String[] args) {

        final int HourMax = 12;
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String[] strTime = timeFormat.format(System.currentTimeMillis()).split(":");

        List<String> hour = new ArrayList<>();
        List<String> tens_minute = new ArrayList<>();
        List<String> units_minute = new ArrayList<>();

        hour.add("시");
        hour.add("한");
        hour.add("두");
        hour.add("세");
        hour.add("네");
        hour.add("다 섯");
        hour.add("여 섯");
        hour.add("일 곱");
        hour.add("여 덟");
        hour.add("아 홉");
        hour.add("열");
        hour.add("열 한");
        hour.add("열 두");


        tens_minute.add(".");
        tens_minute.add("십");
        tens_minute.add("이");
        tens_minute.add("삼");
        tens_minute.add("사");
        tens_minute.add("오");



        units_minute.add("분");
        units_minute.add("일");
        units_minute.add("이");
        units_minute.add("삼");
        units_minute.add("사");
        units_minute.add("오");
        units_minute.add("육");
        units_minute.add("칠");
        units_minute.add("팔");
        units_minute.add("구");


        int nHour = Integer.parseInt(strTime[0]);
        int nMinute = Integer.parseInt(strTime[1]);
        int nTenMinute = nMinute/10;
        int nUnitMinute = nMinute%10;

        if(nHour>HourMax) {
            nHour = nHour -HourMax;
            strTime[0] = Integer.toString(nHour);
        }


        System.out.println(strTime[1]);
        System.out.println(hour.get(nHour));
        System.out.println(tens_minute.get(nTenMinute));
        System.out.println(units_minute.get(nUnitMinute));

        String[][] print = {
                {"한", "두", "세", "네", "다", "섯"},
                {"여", "섯", "일", "곱", "여", "덟"},
                {"아", "홉", "열", "한", "두", "시"},

                {"자", "이", "삼", "사", "오", "십"},
                {"정", "일", "이", "삼", "사", "육"},
                {"오", "오", "칠", "팔", "구", "분"},
        };


        System.out.println();

        for(int y=0;y< print.length;y++) {
            for(int x=0;x<print[0].length;x++){

                System.out.print(String.format("%3s\t",print[y][x]));
            }
            System.out.println();
        }
    }
}
