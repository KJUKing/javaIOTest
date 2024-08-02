package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        byte[] outSrc = null;

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data;

        //read가 더이상 읽어올자료가없으면 -1반환
        while ((data = input.read()) != -1) {
            output.write(data);

        }
        outSrc = output.toByteArray();
        //스트림 사용완료시 자원 반납해야함
        try{
            input.close();
            output.close();
        } catch (IOException e) {

        }
        System.out.println(" inSrc -> " + Arrays.toString(inSrc));
        System.out.println(" outSrc -> " + Arrays.toString(outSrc));
    }
}
