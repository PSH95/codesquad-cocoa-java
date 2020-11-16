package com.example.Day11;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class hangulClock {


    public static void main(String[] args) {

        final int HourMax = 12;
        final int hour = 0;
        final int minute = 1;
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String[] strTime = timeFormat.format(System.currentTimeMillis()).split(":");


        List<String> hangul_Clock_List= new ArrayList<>();

        hangul_Clock_List.add("한");
        hangul_Clock_List.add("두");
        hangul_Clock_List.add("세");
        hangul_Clock_List.add("네");
        hangul_Clock_List.add("다");
        hangul_Clock_List.add("섯");
        hangul_Clock_List.add("여");
        hangul_Clock_List.add("섯");
        hangul_Clock_List.add("일");
        hangul_Clock_List.add("곱");
        hangul_Clock_List.add("여");
        hangul_Clock_List.add("덟");
        hangul_Clock_List.add("아");
        hangul_Clock_List.add("홉");
        hangul_Clock_List.add("열");
        hangul_Clock_List.add("한");
        hangul_Clock_List.add("두");
        hangul_Clock_List.add("시");
        hangul_Clock_List.add("자");
        hangul_Clock_List.add("이");
        hangul_Clock_List.add("삼");
        hangul_Clock_List.add("사");
        hangul_Clock_List.add("오");
        hangul_Clock_List.add("십");
        hangul_Clock_List.add("정");
        hangul_Clock_List.add("일");
        hangul_Clock_List.add("이");
        hangul_Clock_List.add("삼");
        hangul_Clock_List.add("사");
        hangul_Clock_List.add("육");
        hangul_Clock_List.add("오");
        hangul_Clock_List.add("오");
        hangul_Clock_List.add("칠");
        hangul_Clock_List.add("팔");
        hangul_Clock_List.add("구");
        hangul_Clock_List.add("분");


        System.out.println("★ 현재시간: "+strTime[hour]+"시 "+strTime[minute]+"분");


        int nHour =Integer.parseInt(strTime[hour]); //m 시간,
        int nTensMinute =Integer.parseInt(strTime[minute])/10; //m 분, 10의자리
        int nUnitMinute =Integer.parseInt(strTime[minute])%10; //m 분,  1의자리

        if(nHour>HourMax) { //m 13시,14시.. 등 12시를 넘는경우
            nHour = nHour - HourMax;  //m 시간-12
            strTime[hour] = Integer.toString(nHour) ;
        }

        switch (nHour) {
            case 1:
                hangul_Clock_List.set(0,"(한)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 2:
                hangul_Clock_List.set(1,"(두)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 3:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("세"),"(세)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 4:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("네"),"(네)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 5:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("다"),"(다)");
                hangul_Clock_List.set(5,"(섯)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 6:
                hangul_Clock_List.set(6,"(여)");
                hangul_Clock_List.set(7,"(섯)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 7:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("일"),"(일)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("곱"),"(곱)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 8:
                hangul_Clock_List.set(10,"(여)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("덟"),"(덟)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 9:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("아"),"(아)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("홉"),"(홉)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 10:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("열"),"(열)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 11:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("열"),"(열)");
                hangul_Clock_List.set(15,"(한)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
            case 12:
            case 0:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("열"),"(열)");
                hangul_Clock_List.set(16,"(두)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("시"),"(시)");
                break;
        }

        switch (nTensMinute) {
            case 1:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("십"),"(십)");
                break;
            case 2:
                hangul_Clock_List.set(19,"(이)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("십"),"(십)");
                break;
            case 3:
                hangul_Clock_List.set(20,"(삼)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("십"),"(십)");
                break;
            case 4:
                hangul_Clock_List.set(21,"(사)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("십"),"(십)");
                break;
            case 5:
                hangul_Clock_List.set(22,"(오)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("십"),"(십)");
                break;
        }

        switch (nUnitMinute){
            case 1:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("일"),"(일)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("분"),"(분)");
                break;
            case 2:
                hangul_Clock_List.set(26,"(이)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("분"),"(분)");
                break;
            case 3:
                hangul_Clock_List.set(27,"(삼)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("분"),"(분)");
                break;
            case 4:
                hangul_Clock_List.set(28,"(사)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("분"),"(분)");
                break;
            case 5:
                hangul_Clock_List.set(31,"(오)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("분"),"(분)");
                break;
            case 6:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("육"),"(육)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("분"),"(분)");
                break;
            case 7:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("칠"),"(칠)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("분"),"(분)");
                break;
            case 8:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("팔"),"(팔)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("분"),"(분)");
                break;
            case 9:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("구"),"(구)");
                hangul_Clock_List.set(hangul_Clock_List.indexOf("분"),"(분)");
                break;


        }


        for(int i=0; i<hangul_Clock_List.size();i++)
        {
            if(i%6 ==0) {
                System.out.println();
            }
            System.out.print(String.format("%5s",hangul_Clock_List.get(i)));

        }
        System.out.println();
    }
}
