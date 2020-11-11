package com.example.Day6.Misson;


// TODO     필수 요구사항
// TODO     간단한 가계부를 구현한다.
// TODO     키보드를 통해 데이터 입력을 받고 화면에 내용을 출력한다.

// TODO     사용자 등록: 사용자 이름 및 비밀번호를 입력받는다.
// TODO     [입력]: 날짜, 적요, 수입, 지출을 입력받는다.
// TODO     [삭제]: 특정 순번의 데이터를 삭제한다.
// TODO     [수정]: 특정 순번의 데이터를 수정할 수 있다.
// TODO     [출력]: 해당 월의 지출내역을 순번, 적요, 수입, 지출, 잔액으로 화면에 출력한다.

import java.io.IOException;
import java.util.Scanner;

public class AccountMain {

    public static Scanner sc = new Scanner(System.in);

    public static void Register(AccountDAO accountLog) throws IOException{

        System.out.println("----- 회원가입 -----");
        System.out.print("1. 이름:");
        String InputName = sc.nextLine();
        System.out.println();
        System.out.print("2. 비밀번호:");
        String InputPassword = sc.nextLine();
        boolean UserValidCheck = accountLog.checkName(InputName) && accountLog.checkName(InputPassword);

        if(UserValidCheck){
            System.out.println("\n▶ 이미 존재하는 계정입니다.");
        } else{
            accountLog.setName(InputName);
            accountLog.setPassword(InputPassword);
            System.out.println("\n▶ 회원가입 완료");
        }

    }
    public static void Login(AccountDAO accountLog) throws IOException{

        while(true) {
            System.out.println("----- 로그인 -----");
            System.out.print("1. 이름:");
            String InputName = sc.nextLine();
            System.out.println();
            System.out.print("2. 비밀번호:");
            String InputPassword = sc.nextLine();
            boolean UserValidCheck = accountLog.checkName(InputName) && accountLog.checkName(InputPassword);

            if (UserValidCheck) {
                System.out.println("\n▶ 로그인 완료");
                AccountMenu(accountLog); // 메인메뉴
            } else {
                System.out.println("\n▶ 존재하지 않는 계정");
            }
        }

    }
    public static void InsertAccount(AccountDAO accountLog) {

        System.out.println("----- 가계부 등록 -----");
        System.out.println();
        System.out.print("★ 날짜:");
        accountLog.addDATE(sc.next());
        System.out.print("☆ 적요:");
        accountLog.addCONTENTS(sc.next());
        System.out.print("★ 수입:");
        accountLog.addINCOME(sc.nextInt());
        System.out.print("☆ 지출:");
        int inputSpending = sc.nextInt();
        accountLog.addSPENDING(inputSpending);

        if (inputSpending>0) {
            System.out.print("☆ 소비유형 (현금/카드):");
            accountLog.addSPENDINGTYPE(sc.next());
        }
        else
            accountLog.addSPENDINGTYPE("X");
    }

    public static void AccountMenu(AccountDAO accountLog) {

        while(true) {
            System.out.println("----- 메뉴 -----");
            System.out.println("1. 삽입");
            System.out.println("2. 삭제");
            System.out.println("3. 수정");
            System.out.println("4. 출력");
            Scanner sc = new Scanner(System.in);

            int MenuInputKey = sc.nextInt();

            switch (MenuInputKey) {
                case 1:
                    InsertAccount(accountLog);
                    break;
                case 2:
                    accountLog.accountLogPrint();
                    System.out.println("♣ 삭제를 원하는 번호를 입력하세요.");
                    accountLog.deleteAccountLog(sc.nextInt());
                    break;
                case 3:
                    accountLog.accountLogPrint();
                    System.out.println("♣ 수정을 원하는 번호를 입력하세요.");
                    accountLog.modifyFunction(sc.nextInt());
                    break;
                case 4:
                    accountLog.accountLogPrint();
                    break;
                default:
                    break;
            }
        }

    }
    public static void main(String[] args) throws IOException {

        AccountDAO accountLog = new AccountDAO();

        System.out.println("가계부");
        System.out.println("1. 계정생성");
        System.out.println("2. 로그인");
        Scanner sc = new Scanner(System.in);

        int MenuInputKey = sc.nextInt();


        switch (MenuInputKey){
            case 1:
                Register(accountLog);
            case 2:
                Login(accountLog);
                break;
            default:
                break;
        }

        sc.close();

    }
}
