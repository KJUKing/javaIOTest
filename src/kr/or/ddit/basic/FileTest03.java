package kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {
    public static void main(String[] args) {
        FileTest03 test = new FileTest03();

        test.dir(new File("d:/"));

    }

    //디렉토리 정보를 매개변수로 받아서 해당 디렉토리에 있는
    //모든 파일 및 디렉토리 목록 출력하는 메소드
    public void dir(File f) {
        if (!f.isDirectory()) {
            System.out.println("디렉토리(폴더)만 가능합니다");
            return;
        }
        System.out.println("[" + f.getAbsolutePath() + "] 디렉토리 내용");
        System.out.println();

        //해당 디렉토리안에 있는 모든 파일 및 디렉토리 목록을 구한다
        File[] fileArr = f.listFiles();
//        String[] strArr = f.list();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");

        //가져온 파일과 디렉토리 목록 갯수만큼 반복해서 처리한다
        for (File file : fileArr) {
            String fileName = file.getName();
            String attr = "";
            String size = "";

            if (file.isDirectory()) {
                attr = "<DIR>";

            } else {
                size = String.valueOf(file.length());
                attr = file.canRead() ? "R" : "";
                attr += file.canWrite() ? "W" : "";
                attr += file.isHidden() ? "H" : "";
            }

            // 파일 및 디렉토리의 최근 변경 날짜를 날짜형식에 맞게 변경한다
            String strDate = df.format(new Date(file.lastModified()));

            System.out.printf("%s %5s %12s %s\n", strDate, attr, size, fileName);

        }
    }
}


