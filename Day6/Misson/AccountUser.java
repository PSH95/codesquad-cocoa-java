package com.example.Day6.Misson;

import java.util.ArrayList;

public class AccountUser extends AccountData{

    private ArrayList<String > NAME = new ArrayList<String>();
    private ArrayList<String > PASSWORD = new ArrayList<String>();


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
