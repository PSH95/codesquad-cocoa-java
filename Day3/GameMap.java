package com.example.day3;

public class GameMap {

    private static int rowRange;
    private static int colRange;
    private static int[][] mapSize;
    private static String[][] mapObject; // 기본 네모칸

    public GameMap(int x, int y){

        mapSize = new int[y][x]; // Y, X 맵 사이즈
        rowRange = mapSize.length; // 세로
        colRange = mapSize[0].length; // 가로
        mapObject =  new String[rowRange][colRange]; // 기본 네모칸
    }
    public void conflictCheck(Mob mob, int x, int y){
        if(mapObject[y][x].equals("♨")) { //  지뢰인 경우
            clearScreen();
            System.out.println("사망");
            System.exit(0);

        }
        if(mapObject[y][x].equals("♬")) { //  지뢰인 경우
            clearScreen();
            mob.objectCount = mob.objectCount*5;

        }
    }
    public static void clearScreen() {
        for (int i = 0; i < 80; i++)
            System.out.println("");
    }
    public void deleteObject(int x, int y){
        mapObject[y][x]="□";
    }

    public static void PrintMap(Player player, Item item, Mob mob) {


        int itemCount = item.object_xPos.size();
        int[] itemGet_xPos = new int[rowRange];
        int[] itemGet_yPos = new int[rowRange];

        for(int t=0;t<itemCount;t++) {
            itemGet_xPos[t] = Integer.parseInt(item.object_xPos.get(t).toString());
            itemGet_yPos[t] = Integer.parseInt(item.object_yPos.get(t).toString());

            mapObject[ itemGet_yPos[t] ][ itemGet_xPos[t] ] = "♬"; // 아이템

        }

        int mobCount = mob.object_xPos.size();
        int[] mobGet_xPos = new int[rowRange];
        int[] mobGet_yPos = new int[rowRange];

        System.out.println("※ 몬스터 좌표");

        for(int t=0;t<mobCount;t++) {
            mobGet_xPos[t] = Integer.parseInt(mob.object_xPos.get(t).toString());
            mobGet_yPos[t] = Integer.parseInt(mob.object_yPos.get(t).toString());


            mapObject[ mobGet_yPos[t] ][ mobGet_xPos[t] ] = "♨"; // 지뢰

            System.out.print( "(" +  mobGet_xPos[t] );
            System.out.print( ",\t"+ mobGet_yPos[t]+")" );
            System.out.println();
        }

        System.out.println("---------------------------");
        System.out.println("↑: 유저, ♨: 지뢰, ♬: 아이템");
        System.out.println("---------------------------");


        for (int i = 0; i < rowRange; i++) { // 11x11
            for (int j = 0; j < colRange; j++) {

                    if(i == player.getY() && j == player.getX()) {
                        mapObject[i][j] = "↑"; // 기본 오브젝트 삽입
                    }
                    else if(mapObject[i][j] == null) {
                        mapObject[i][j] = "□"; // 기본 오브젝트 삽입
                    }
                    System.out.print(mapObject[i][j] + " ");
                }
                 System.out.println();
            }

        }


}





