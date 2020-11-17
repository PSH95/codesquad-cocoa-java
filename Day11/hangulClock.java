package com.example.Day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hangulClock {

    private static final String ANSI_GREEN = "\u001B[32m"; //m 콘솔 색상 변경 by 새리
    private static final String ANSI_RESET = "\u001B[0m";
    private static final int HourMax = 12;
    private static final int hourPOS = 0;
    private static final int minutePOS = 1;
    private static Scanner sc = new Scanner(System.in);
    private static int nHour;
    private static int nTensMinute;
    private static int nUnitMinute;

    private static String colorPrint(String msg){
        String color_msg = ANSI_GREEN+msg+ANSI_RESET;
        return color_msg;
    }

    private static void ListInsert(List<String> hangul_Clock_List){

        //m 리스트에 6x6 한글시계 1차원으로 나열하여 삽입, 총 36개

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
    }

    private static void InsertTime(){
        System.out.print("\n▶ 한글시계의 시간을 입력하세요. ");
        String[] strTime = sc.nextLine().split(":"); //m 입력값 :을 기준으로 hour,minute 부분이 나뉨
        nHour = Integer.parseInt(strTime[hourPOS]); //m 시간,
        nTensMinute = Integer.parseInt(strTime[minutePOS]) / 10; //m 분, 10의자리
        nUnitMinute = Integer.parseInt(strTime[minutePOS]) % 10; //m 분,  1의자리

        if (nHour > HourMax) { //m 13시,14시.. 등 12시를 넘는경우
            nHour = nHour - HourMax;  //m 시간-12
            strTime[hourPOS] = Integer.toString(nHour);
        }

    }
    private static void chNightNoonToKor(int nHour, List<String> hangul_Clock_List){
        //m 리스트 set 수정함수와 리스트 indexOf 검색함수를 활용하여, 한글시계 요소 수정
        switch (nHour) {
            case 0:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("자"), colorPrint("자"));
                break;
            case 12:
                hangul_Clock_List.set(30, colorPrint("오"));
                break;
        }
        hangul_Clock_List.set(24, colorPrint("정"));
    }
    private static void chHourToKor(int nHour, List<String> hangul_Clock_List){
        switch (nHour) {
            case 1:
                hangul_Clock_List.set(0, colorPrint("한"));
                break;
            case 2:
                hangul_Clock_List.set(1, colorPrint("두"));
                break;
            case 3:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("세"), colorPrint("세"));
                break;
            case 4:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("네"), colorPrint("네"));
                break;
            case 5:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("다"), colorPrint("다"));
                hangul_Clock_List.set(5, colorPrint("섯"));
                break;
            case 6:
                hangul_Clock_List.set(6, colorPrint("여"));
                hangul_Clock_List.set(7, colorPrint("섯"));
                break;
            case 7:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("일"), colorPrint("일"));
                hangul_Clock_List.set(hangul_Clock_List.indexOf("곱"), colorPrint("곱"));
                break;
            case 8:
                hangul_Clock_List.set(10, colorPrint("여"));
                hangul_Clock_List.set(hangul_Clock_List.indexOf("덟"), colorPrint("덟"));
                break;
            case 9:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("아"), colorPrint("아"));
                hangul_Clock_List.set(hangul_Clock_List.indexOf("홉"), colorPrint("홉"));
                break;
            case 10:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("열"), colorPrint("열"));
                break;
            case 11:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("열"), colorPrint("열"));
                hangul_Clock_List.set(15, colorPrint("한"));
                break;
            case 12:
            case 0:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("열"), colorPrint("열"));
                hangul_Clock_List.set(16, colorPrint("두"));
                break;
        }
        hangul_Clock_List.set(hangul_Clock_List.indexOf("시"), colorPrint("시"));

    }
    private static void chTensMinuteToKor(int nTensMinute, List<String> hangul_Clock_List){

        switch (nTensMinute) {
            case 1: //m 십의 자리가 존재하지 않을 수 있으므로, 공통으로 빼지 않고 중복해서 사용함.
                hangul_Clock_List.set(hangul_Clock_List.indexOf("십"), colorPrint("십"));
                break;
            case 2:
                hangul_Clock_List.set(19, colorPrint("이"));
                hangul_Clock_List.set(hangul_Clock_List.indexOf("십"), colorPrint("십"));
                break;
            case 3:
                hangul_Clock_List.set(20, colorPrint("삼"));
                hangul_Clock_List.set(hangul_Clock_List.indexOf("십"), colorPrint("십"));
                break;
            case 4:
                hangul_Clock_List.set(21, colorPrint("사"));
                hangul_Clock_List.set(hangul_Clock_List.indexOf("십"), colorPrint("십"));
                break;
            case 5:
                hangul_Clock_List.set(22, colorPrint("오"));
                hangul_Clock_List.set(hangul_Clock_List.indexOf("십"), colorPrint("십"));
                break;
        }

    }
    private static void chUnitMinuteToKor(int nUnitMinute, List<String> hangul_Clock_List) {

        switch (nUnitMinute) {
            case 1:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("일"), colorPrint("일"));
                break;
            case 2:
                hangul_Clock_List.set(26, colorPrint("이"));
                break;
            case 3:
                hangul_Clock_List.set(27, colorPrint("삼"));
                break;
            case 4:
                hangul_Clock_List.set(28, colorPrint("사"));
                break;
            case 5:
                hangul_Clock_List.set(31, colorPrint("오"));
                break;
            case 6:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("육"), colorPrint("육"));
                break;
            case 7:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("칠"), colorPrint("칠"));
                break;
            case 8:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("팔"), colorPrint("팔"));
                break;
            case 9:
                hangul_Clock_List.set(hangul_Clock_List.indexOf("구"), colorPrint("구"));
                break;
        }
        hangul_Clock_List.set(hangul_Clock_List.indexOf("분"), colorPrint("분"));
    }
    private static void printClock(List<String> hangul_Clock_List){
        for(int i=0; i<hangul_Clock_List.size();i++)
        {
            if(i%6 ==0) {
                System.out.println();
            }
            System.out.print(String.format("%s",hangul_Clock_List.get(i)));

        }
        System.out.println();

    }

    public static void main(String[] args) {

        List<String> hangul_Clock_List = new ArrayList<>();
        ListInsert(hangul_Clock_List); //m 리스트에 한글 시계 기본 요소 삽입

        while (true) { //m 무한반복  -> 추후 쓰레드를 이용해서 실시간으로 변화되게 할 계획
            hangul_Clock_List.clear(); //m 과거 한글시계 기록 삭제
            ListInsert(hangul_Clock_List); //m 리스트에 한글 시계 기본 요소 삽입
            InsertTime(); //m 시간 정보 수동 입려

            if ((nHour==12 || nHour==0) && nTensMinute == 0 && nUnitMinute == 0) { //m 자정, 정오를 검사하는 조건문
                chNightNoonToKor(nHour, hangul_Clock_List); //m 한글시계 요소값 변경
            } else { //m 자정, 정오가 아닐 경우
                chHourToKor(nHour, hangul_Clock_List); //m 한글시계 '시간' 요소값 변경
                chTensMinuteToKor(nTensMinute, hangul_Clock_List); //m 한글시계 '십' 의자리 '분' 요소값 변경
                chUnitMinuteToKor(nUnitMinute, hangul_Clock_List); //m 한글시계 '일' 의자리 '분' 요소값 변경
            }
            printClock(hangul_Clock_List); //m 한글 시계 출력
        } //m while end

    }//m main end
}
