package kr.or.ddit.basic;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FIleIOTest01 {
    public static void main(String[] args) {
        // FileInputStream을 이요한 파일 내용읽기
        try {
            //읽어올 파일 정보를 매개변수로갖는 FileInputStream

            // 방법1)
//            FileInputStream fin = new FileInputStream("d:/d_other/'text.txt");

            // 방법2)
            File file = new File("d:/d_other/'text.txt");
            FileInputStream fin = new FileInputStream(file);

            int c; //읽어온 자료가 저장될 변수
            while ((c = fin.read()) != -1) {
                //읽어온 문자를 화면에 출력하기
                System.out.println((char) c);
            }

            fin.close(); //작업완료후 스트림닫기
        } catch (IOException e) {
            System.out.println("입출력 오류");

        }
    }
}
