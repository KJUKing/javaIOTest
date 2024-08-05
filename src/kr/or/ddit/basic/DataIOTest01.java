package kr.or.ddit.basic;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest01 {
    public static void main(String[] args) {
        try {
            FileOutputStream fout =
                    new FileOutputStream("d:/d_other/test.dat");
            //자료형 단위로 출력할 보조 스트림 객체 생성
            DataOutputStream dout = new DataOutputStream(fout);
            dout.writeInt(200); //정수형으로 출력
            dout.writeFloat(123.45f);
            dout.writeBoolean(true);
            dout.writeUTF("ABCDEFabcd1234");

            System.out.println("출력 작업 완료");

            dout.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
