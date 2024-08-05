package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferedIOTest02 {
    public static void main(String[] args) {
        // 문자 기반의 Buffered 스트림 사용예제
        try {
            // 자바 소스 파일 중  'FileTest01.java'파일을 읽어와 출력하기
            FileReader fr = new FileReader(
                    "C:\\Users\\PC-14\\Desktop\\javaIOTest\\src\\kr\\or\\ddit\\basic\\FileTest01.java");
            BufferedReader br = new BufferedReader(fr);

            String temp = "";

            StringTokenizer st = new StringTokenizer(br.readLine());

            //문자기반의 입력용 버퍼의 readLine()메소드 -> 데이터를 줄 단위로 읽어온다
            for (int i = 1; (temp=br.readLine()) != null; i++) {
                System.out.printf("%4d : %s\n", i, temp);
            }

            br.close();
        } catch (IOException e) {
        }
    }
}
