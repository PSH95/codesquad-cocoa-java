package com.example.Day6.Misson;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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

    public void createDataFile(String name, StringBuilder accountData){

        try (BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream("C:/Users/psh/Desktop/data/"+name+".txt",true))) { // true 일 경우 이어쓰기

            String str = "3/아이스크림/0/10000/현금\r\n";

            bs.write(str.getBytes()); // 바이트형

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public void readDataFile(){
String name = "1";
        try {
            // 바이트 단위로 파일읽기
            String filePath = "C:/Users/psh/Desktop/data/"+name+".txt"; // 대상 파일
            FileInputStream fileStream = null; // 파일 스트림

            fileStream = new FileInputStream( filePath );// 파일 스트림 생성
            //버퍼 선언
            byte[ ] readBuffer = new byte[fileStream.available()];
            while (fileStream.read( readBuffer ) != -1){}
            System.out.println(new String(readBuffer)); //출력

            fileStream.close(); //스트림 닫기
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
