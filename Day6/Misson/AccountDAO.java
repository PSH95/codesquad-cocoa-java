package com.example.Day6.Misson;

public class AccountDAO extends AccountDTO {

    //0 계정마다 구분할 방법 아직 못찾음


    public void accountLogPrint() {
        int totalMoney = 0;
        for(int i=0;i<super.getDATE().size();i++){

            totalMoney = (totalMoney+super.getINCOME().get(i))-super.getSPENDING().get(i);

            System.out.println(

                    "["+i+"번] 아이디 "+super.getName()+" / 날짜: "+super.getDATE().get(i) + "/ 적요: "+super.getCONTENTS().get(i)+ " / 수입: "+super.getINCOME().get(i)
                    + " / 지출: "+super.getSPENDING().get(i)  + " / 지출유형: "+super.getSpendingType().get(i)  + " / 남은잔액: "+totalMoney
            );

        }
    }
    public void deleteAccountLog(int index) {
        super.getDATE().remove(index);
        super.getCONTENTS().remove(index);
        super.getINCOME().remove(index);
        super.getSPENDING().remove(index);
    }

    public void modifyFunction(int index){
        super.getDATE().set(index,"수정됨");
        super.getCONTENTS().set(index,"수정됨");
        super.getINCOME().set(index,99999);
        super.getSPENDING().set(index,12345);

    }

}
