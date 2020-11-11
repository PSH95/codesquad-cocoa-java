package com.example.Day6.Misson;

import java.util.ArrayList;

public class AccountDTO {

    private String NAME = "";
    private String PASSWORD = "";

    private ArrayList<String > DATE = new ArrayList<String>();
    private ArrayList<String > CONTENTS = new ArrayList<String>();
    private ArrayList<Integer > INCOME = new ArrayList<Integer>();
    private ArrayList<Integer > SPENDING = new ArrayList<Integer>();
    private ArrayList<String > SPENDINGTYPE = new ArrayList<String>(); // 소비유형

    public boolean checkName(String NAME){
        return this.NAME.equals(NAME);
    }
    public boolean checkPassword(String PASSWORD){
        return this.PASSWORD.equals(PASSWORD);
    }
    public void setName(String NAME){
        this.NAME = NAME;
    }
    public void setPassword(String PASSWORD){
        this.PASSWORD = PASSWORD;
    }

    public void addDATE(String DATE){
        this.DATE.add(DATE);
    }
    public void addCONTENTS(String CONTENTS){
        this.CONTENTS.add(CONTENTS);
    }
    public void addINCOME(Integer INCOME){
        this.INCOME.add(INCOME);
    }
    public void addSPENDING(Integer SPENDING){
        this.SPENDING.add(SPENDING);
    }
    public void addSPENDINGTYPE(String SPENDINGTYPE){
        this.SPENDINGTYPE.add(SPENDINGTYPE);
    }

    public String getName()
    {
        return this.NAME;
    }

    public ArrayList<String > getDATE(){
        return DATE;
    }
    public ArrayList<String > getCONTENTS(){
        return CONTENTS;
    }
    public ArrayList<Integer > getINCOME(){
        return INCOME;
    }
    public ArrayList<Integer > getSPENDING(){
        return SPENDING;
    }
    public ArrayList<String > getSpendingType(){
        return SPENDINGTYPE;
    }

}
