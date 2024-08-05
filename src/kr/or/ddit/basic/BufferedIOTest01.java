package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {
    public static void main(String[] args) {
        // 입출력의 성능향상을 위해서 Buffered스트림을 사용한다.

        try {
            FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
            //버퍼의 크기가 5인 버퍼스트림 객체 생성
            // 버퍼의 크기를 지정하지 않으면 기본적으로 8kb(8192byte로 지정한다)

            BufferedOutputStream bout = new BufferedOutputStream(fout, 5);

            for(char c='1'; c<='9'; c++) {
                bout.write(c);

            }
            bout.flush();

//            fout.close();
            bout.close(); //close안에 flush기능이 자동으로 호출된다.
                            //보조스트림을 닫으면 기반이 되는 스트림도 같이 닫힌다.

            System.out.println("작업 끝 ...");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
