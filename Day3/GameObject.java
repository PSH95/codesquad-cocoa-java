package com.example.Day3;

import java.util.ArrayList;
import java.util.Random;

public class GameObject {

    public int objectCount;
    public String strName;
    public int xPos, yPos; //플레이어 위치 좌표 정보
    public ArrayList object_xPos = new ArrayList(); // 오브젝트 위치 정보 리스트
    public ArrayList object_yPos = new ArrayList();


    public String getName(){ // 오브젝트 이름 반환 함수
        return this.strName;
    }
    public int getX(){ // 현재 좌표 반환 함수
        return this.xPos;
    }
    public int getY(){
        return this.yPos;
    }

    public void PlySet_X(int xPos){  // 오브젝트 좌표 설정 함수
        this.xPos = xPos;
    }
    public void PlySet_Y(int yPos){
        this.yPos = yPos;
    }

    public void setX(int xPos){  // 오브젝트 좌표 설정 함수
        this.object_xPos.add(xPos);
    }
    public void setY(int yPos){
        this.object_yPos.add(yPos);
    }

    public int get_Ob_xPos(int index){ // 현재 좌표 반환 함수
        return Integer.parseInt(this.object_xPos.get(index).toString());
    }
    public int get_Ob_YPos(int index){
        return Integer.parseInt(this.object_yPos.get(index).toString());
    }

    public GameObject(String objectName,int SetCount) {

        Random r = new Random();
        this.objectCount = SetCount;
        this.strName = objectName;

        double dValue = Math.random();

        int iValue = (int)(dValue * 10);

        for(int i=0;i<SetCount;i++) {
            this.object_xPos.add(r.nextInt(10)+1); // 랜덤위치
            this.object_yPos.add(r.nextInt(10)+1); // 랜덤위치
        }

    }

    public GameObject(String objectName,int xPos, int yPos) { // 함수 오버라이딩
        this.objectCount = 1;
        this.strName = objectName;
        this.xPos = xPos; // 설정위치
        this.yPos = yPos;
    }

}
