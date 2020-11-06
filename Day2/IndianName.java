package com.example.Day2;
import java.util.Scanner;

/*
     # Day 3.

     미션 2-1: 인디언 이름 짓기
     다음과 같은 형태의 프로그램을 구현한다.

     참고자료는 '인디언 이름 짓기' 로 검색을 해 보자.

     ex)
     생년월일을 입력해 주세요>
     1999 12 9
     당신의 이름은 용감한 황소의 노래입니다.
  */

public class IndianName {

    public static int[] InputBirthDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("생년월일을 입력해주세요. ex) 1999 12 9");
        int[] takeBirth = new int[3];
        takeBirth[0] = (scanner.nextInt()%10)%10; // 년도의 끝부분만 take
        takeBirth[1] = scanner.nextInt(); // 월
        takeBirth[2] = scanner.nextInt(); // 일
        scanner.close();

        return takeBirth;
    }
    public static int[] MakeIndianName(int[] nInputBirth) {
        int[] nBirthArray = new int[3];

        nBirthArray[0] = nInputBirth[0];
        nBirthArray[1] = nInputBirth[1]-1;   // 월과 일은 1일부터 시작하므로 -1을 해줌.
        nBirthArray[2] = nInputBirth[2]-1;

        return nBirthArray;

    }
    public static void PrintIndianName(int[] nBirth) {

        // 인디언 이름 배열
        String[] YearName = new String[] {"시끄러운", "푸른","적색","조용한","웅크린","백색","지혜로운","용감한","날카로운","욕심많은"};
        String[] MonthName = new String[] {"늑대","태양","양","매","황소","불꽃","나무","달빛","말","돼지","하늘","바람"};
        String[] DayName = new String[]{"와(과)함께 춤을","의 기상","은(는) 그림자속에","없음","없음","없음","의 환생","의 죽음","아래에서","를(을)보라","~이(가)노래하다.", "그림자","의 일격","에게 쫒기는 남자","의 행진","의 왕","의 유령","을 죽인자","는(은) 맨날 잠잔다.","처럼","의 고찰","의 천사","은(는) 나의친구","의 노래","의 정령","의 파수꾼","의 악마","와(과)같은 사나이","를(을) 쓰러트린자","의 혼","은(는) 말이없다."
        };

        System.out.print("당신의 이름은 "+YearName[nBirth[0]]+" "+MonthName[nBirth[1]]+""+DayName[nBirth[2]]);

    }

    public static void main(String[] args) {

        int[] nInputBirth = InputBirthDay(); // 생년월일 입력 함수
        int[] nBirthArray = MakeIndianName(nInputBirth); // 인디언 이름 생성 함수
        PrintIndianName(nBirthArray); // 인디언 이름 출력 함수

    }

}

