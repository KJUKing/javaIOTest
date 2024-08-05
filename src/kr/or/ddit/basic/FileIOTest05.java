package kr.or.ddit.basic;

import java.io.*;

public class FileIOTest05 {
    public static void main(String[] args) {
        //한글이 저장된 파일 읽어오기

        try {
//            FileReader fr = new FileReader("d:/d_other/test_ansi.txt");
//            FileReader fr = new FileReader("d:/d_other/test_utf8.txt");

            FileInputStream fin = new FileInputStream("d:/d_other/test_ansi.txt");

            //인코딩 방식을 이용해서 읽어옴
//            InputStreamReader isr = new InputStreamReader(fin);

            //인코딩 방식을 지정해서 읽어오기
            //인코딩 방식 예시
            // - MS949(또는 CP949) -> 윈도우즈에서 사용하는 기본한글 인코딩(ANSI방식과 동일)
            // - UTF-8 -> 유니코드 UTF-8 인코딩 방식
            // - US_ASCII -> 영문전용 인코딩 방식
//            InputStreamReader isr = new InputStreamReader(fin, "UTF-8");
            InputStreamReader isr = new InputStreamReader(fin, "ms949");
                        BufferedReader br = new BufferedReader(isr);

            int c;
            while ((c = br.read()) != -1) {
                System.out.print((char) c);
            }

            br.close();

        }catch (IOException e){

        }
    }
}
