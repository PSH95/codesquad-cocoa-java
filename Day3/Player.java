package com.example.Day3;

public class Player extends GameObject {

    public Player(String objectName, int xPos, int yPos) {
        super(objectName,xPos,yPos);
    }

    public void move(int x, int y){

        super.PlySet_X(x);
        super.PlySet_Y(y);

    }


}
