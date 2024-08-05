package kr.or.ddit.basic;

import java.io.*;

/*
    문제) 'd:/d_other' 폴더에 있는 펭귄.jpg파일을
            'd:/d_other/연습용' 폴더에 '복사본_펭귄.jpg'파일로  복사하는 프로그램 작성하시오.
 */
public class FileCopyTest {

    public static void main(String[] args) throws FileNotFoundException {
        String c = "d:/d_other/펭귄.jpg";
        String v = "d:/d_other/연습용/복사용_펭귄.jpg";

        System.out.println("펭귄 그림갖고오기");
        try  {

            FileInputStream fis = new FileInputStream(c);
            FileOutputStream fos = new FileOutputStream(v);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buf = new byte[1024]; //버퍼 크기는 1kb설정
            int read;
//            while ((read = fis.read(buf)) != -1) {
//                fos.write(buf, 0, read);
//            }

            while ((read = bis.read(buf)) != -1) {
                fos.write(buf, 0, read);
            }
            bos.flush();

            bos.close();


            System.out.println("복사완료");
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}
