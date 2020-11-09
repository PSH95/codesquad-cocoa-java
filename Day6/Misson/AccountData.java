package com.example.Day6.Misson;

import java.util.LinkedList;

public class AccountData {

    //0 계정마다 구분할 방법 아직 못찾음

    private LinkedList<String > DATE = new LinkedList<String>();
    private LinkedList<String > CONTENTS = new LinkedList<String>();
    private LinkedList<Integer > INCOME = new LinkedList<Integer>();
    private LinkedList<Integer > SPENDING = new LinkedList<Integer>();

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

    public void accountLogPrint() {
        for(int i=0;i<this.DATE.size();i++){
            System.out.println("["+i+"번] 날짜: "+this.DATE.get(i) + "/ 적요: "+this.CONTENTS.get(i)+ " / 수입: "+this.INCOME.get(i)+ " / 지출: "+this.SPENDING.get(i));
        }
    }
    public void deleteAccountLog(int index) {
        this.DATE.remove(index);
        this.CONTENTS.remove(index);
        this.INCOME.remove(index);
        this.SPENDING.remove(index);
    }

}
