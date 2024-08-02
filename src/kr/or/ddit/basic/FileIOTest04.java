package kr.or.ddit.basic;

import java.io.*;
import java.util.StringTokenizer;

public class FileIOTest04 {
    public static void main(String[] args) {
        //사용자가 입력한 내용을 그대로 파일로 저장하기

        try {
            // System.in -> 콘솔(표준입력출력장치) 입력 장치
//            System.out.print("자료입력 : ");
//            int c = System.in.read();
//            System.out.println((char) c);

            // 바이트 기반의 입력용 스트림을 문자 기반의 입력용 스트림으로 변환하기
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(br.readLine());
            //핵심일은 system.in이하지만 InputStreamReader보조스트림을 쓰면 얘가 문자열로 바꿔줌
            InputStreamReader isr = new InputStreamReader(System.in);

            // 출력용 스트림 객체 생성
            FileWriter fw = new FileWriter("d:/d_other/charTest.txt");
            System.out.println("아무 내용이나 입력하세요");
            System.out.println("ctrl -z 를 누르면 입력 종료"                                                                                              );

            int c;
            while((c = isr.read()) != -1) {
                fw.write(c);
            }
            isr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
