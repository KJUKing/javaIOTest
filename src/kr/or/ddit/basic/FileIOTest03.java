package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {
    //파일에 데이터를 출력하는 예제
    public static void main(String[] args) {
        try {
            // 파일에 출력처리를 수행하는 출력용 스트림 객체 생성
            FileReader fr = new FileReader("d:/d_other/test.txt");

            int c;

            while ((c = fr.read()) != -1) {
                System.out.println((char) c);
            }

            System.out.println("출력 작업 완료");
            fr.close();
        }catch (IOException e){

        }
    }
}
