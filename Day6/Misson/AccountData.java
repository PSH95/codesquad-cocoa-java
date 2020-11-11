package com.example.Day6.Misson;

import java.util.ArrayList;

public class AccountData {

    //0 계정마다 구분할 방법 아직 못찾음

    private ArrayList<String > DATE = new ArrayList<String>();
    private ArrayList<String > CONTENTS = new ArrayList<String>();
    private ArrayList<Integer > INCOME = new ArrayList<Integer>();
    private ArrayList<Integer > SPENDING = new ArrayList<Integer>();

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
        int totalMoney = 0;
        for(int i=0;i<this.DATE.size();i++){
            System.out.println("["+i+"번] 날짜: "+this.DATE.get(i) + "/ 적요: "+this.CONTENTS.get(i)+ " / 수입: "+this.INCOME.get(i)+ " / 지출: "+this.SPENDING.get(i));
            totalMoney = (totalMoney+this.INCOME.get(i))-this.SPENDING.get(i);
        }
        System.out.println("→ 남은 잔액: "+totalMoney+"원");
    }
    public void deleteAccountLog(int index) {
        this.DATE.remove(index);
        this.CONTENTS.remove(index);
        this.INCOME.remove(index);
        this.SPENDING.remove(index);
    }

    public void modifyFunction(int index){
        this.DATE.set(index,"수정됨");
        this.CONTENTS.set(index,"수정됨");
        this.INCOME.set(index,99999);
        this.SPENDING.set(index,12345);

    }

}
