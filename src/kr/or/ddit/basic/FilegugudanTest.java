package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
    문제) Scanner를 이용하여 출력할 단을 입력받고
        입력한 단을 파일에 출력하는 프로그램을 작성하시오
        ( 출력할 파일명 : gugudan.txt)

    실행예시)
        출력할 단 입력 >> 3
    -gugudan.txt파일의 내용
    3단
    3 * 1 = 3
    3 * 2 = 6
 ...
    3 * 9 = 27
 */
public class FilegugudanTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            FileOutputStream gugu = new FileOutputStream("d:/d_other/gugudan.txt");
            System.out.print("출력할 단 입력하시오 : ");
            int input = sc.nextInt();

            for (int i = 1; i <= 9; i++) {
                String x = input + " * " + i + " = " + (input * i) + "\n";
                System.out.println(x);

                gugu.write(x.getBytes());
            }
            gugu.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
