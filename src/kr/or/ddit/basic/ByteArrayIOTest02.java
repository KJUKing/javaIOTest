package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        byte[] outSrc = null;

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        byte[] temp = new byte[4];

        try{
            // available -> 남아있는데이터개수를 반환
            while (input.available() > 0) { // 읽어올 자료가 있는지 확인
                input.read(temp);

                output.write(temp);

            }
            outSrc = output.toByteArray();

            System.out.println(" inSrc -> " + Arrays.toString(inSrc));
            System.out.println(" outSrc -> " + Arrays.toString(outSrc));

            input.close();
            output.close();
        }catch (IOException e){

        }
    }
}
