package com.example.Day3;


import java.util.Scanner;

public class easyRPG_Main {

    public static int map_X_SIZE = 11;  // 맵 X 좌표 최대 크기
    public static int map_Y_SIZE = 11;

    public static void KeyControl(GameMap easyRPG,Player player, Item item, Mob mob){

        while(true) {

            Scanner scanner = new Scanner(System.in);

            System.out.println();
            System.out.print("▶ 어느곳으로 이동하시겠습니까? (W,A,S,D):");


            String InputKey = scanner.nextLine();

            switch (InputKey) {

                case "W": // Y 좌표 -1
                    if(player.getY()<=0)
                        System.out.println("※ 맵을 벗어날 수 없어, 기존 자리가 유지됩니다.");
                    else {
                        easyRPG.conflictCheck(mob, player.getX(), player.getY() - 1);
                        easyRPG.deleteObject(player.getX(), player.getY());
                        player.move(player.getX(), player.getY() - 1);
                    }
                    easyRPG.PrintMap(player, item, mob); // 게임 화면 업데이트
                    break;
                case "A": // X 좌표 -1
                    if(player.getX()<=0)
                        System.out.println("※ 맵을 벗어날 수 없어, 기존 자리가 유지됩니다.");
                    else {
                        easyRPG.conflictCheck(mob, player.getX() - 1, player.getY());
                        easyRPG.deleteObject(player.getX(), player.getY());
                        player.move(player.getX() - 1, player.getY());
                    }
                    easyRPG.PrintMap(player, item, mob); // 게임 화면 업데이트
                    break;
                case "S": // Y 좌표 +1
                    if(player.getY()>=map_Y_SIZE-1)
                        System.out.println("※ 맵을 벗어날 수 없어, 기존 자리가 유지됩니다.");
                    else {
                        easyRPG.conflictCheck(mob, player.getX(), player.getY() + 1);
                        easyRPG.deleteObject(player.getX(), player.getY());
                        player.move(player.getX(), player.getY() + 1);
                    }
                    easyRPG.PrintMap(player, item, mob); // 게임 화면 업데이트트
                    break;
                case "D": // X 좌표 +1
                    if(player.getX()>=map_X_SIZE-1)
                        System.out.println("※ 맵을 벗어날 수 없어, 기존 자리가 유지됩니다.");
                    else {
                        easyRPG.conflictCheck(mob, player.getX() + 1, player.getY());
                        easyRPG.deleteObject(player.getX(), player.getY());
                        player.move(player.getX() + 1, player.getY());
                    }
                    easyRPG.PrintMap(player, item, mob); // 게임 화면 업데이트
                    break;
                default:
                    System.out.println("▼ 잘못된 키 입력입니다.");
                    easyRPG.PrintMap(player, item, mob); // 게임 화면 업데이트
                    break;
            }

            //scanner.close();  무한루프를 돌기 위해 스캐너를 닫으면 안됨.
        } // while

    }
    public static void main(String[] args) {

        Player player = new Player("◐", map_X_SIZE / 2, map_Y_SIZE / 2);  // 맵 사이즈 절반으로 플레이어 정중앙 위치
        Item item = new Item("★",8);
        Mob mob = new Mob("X",3);

        GameMap easyRPG = new GameMap(map_X_SIZE, map_Y_SIZE); // 게임맵 사이즈 조절
        easyRPG.PrintMap(player, item, mob); // 게임 화면 업데이트

        KeyControl(easyRPG,player,item,mob); // 키보드 조작 함수

    }
}
