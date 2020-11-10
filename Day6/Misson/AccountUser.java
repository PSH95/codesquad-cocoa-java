package com.example.Day6.Misson;

import java.util.LinkedList;

public class AccountUser {

    private LinkedList<String > NAME = new LinkedList<String>();
    private LinkedList<String > PASSWORD = new LinkedList<String>();


    public boolean checkName(String NAME){
        return this.NAME.contains(NAME); //0 반환값: 참/거짓
    }

    public void setName(String NAME){
        this.NAME.add(NAME);
    }
    public void setPassword(String PASSWORD){
        this.NAME.add(PASSWORD);
    }


}
