package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {
    public static void main(String[] args) {
        // File객체 만들기 연습

        //1. new File(String 파일또는 경로);
        //      -> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분 문자는
        //      슬래쉬 / 를 사용하거나 역슬래쉬 \ 사용가능

//        File file1 = new File("d:/d_other/test.txt");
        File file1 = new File("d:\\d_other\\test.txt");

        System.out.println("파일명 : " + file1.getName());
        System.out.println("파일인가 : " + file1.isFile());
        System.out.println("디렉토리인가 : " + file1.isDirectory());
        System.out.println();

        File file2 = new File("d:/d_other");
        System.out.println("파일명 : " + file2.getName());
        System.out.println("파일인가 : " + file2.isFile());
        System.out.println("디렉토리인가 : " + file2.isDirectory());
        System.out.println();

        // 2. new File(File parent, String child)
        //      -> 'parent'디렉토리 안에있는 child 파일을 의미
        File file3 = new File(file2, "test.txt");
        System.out.println("파일명 : " + file3.getName());
        System.out.println("파일인가 : " + file3.isFile());
        System.out.println("디렉토리인가 : " + file3.isDirectory());
        System.out.println();

        File file4 = new File("d:/D_Other", "test.txt");
        System.out.println("파일명 : " + file4.getName());
        System.out.println("파일인가 : " + file4.isFile());
        System.out.println("디렉토리인가 : " + file4.isDirectory());
        System.out.println();

        // 디렉토리(폴더) 만들기
        // - mkdir() -> File객체의 경로 중에서 마지막 위치의 디렉토리를 만든다.
        //           -> 반환값 : 만들기 성공(true) , 실패 (false)
        //           -> 중간의 경로가 모두 미리 만들어져있어야 마지막 위치의 경로 생성 가능

        // - mkdirs() -> 중간경로가없으면 만들면서 생성해줌
        File file5 = new File("d:/D_Other/연습용");

        System.out.println(file5.getName() + "의 존재 여부 : " + file5.exists());
        if (file5.mkdir()) {
            System.out.println(file5.getName() + " 만들기 성공");

        } else {
            System.out.println(file5.getName() + " 만들기 실패");
        }
        System.out.println();

        File file6 = new File("d:/d_other/test/java/src");
        System.out.println(file6.getName() + "존재 여부 : " + file6.exists());

        if (file6.mkdir()) {
            System.out.println(file6.getName() + " 만들기 성공");

        }else {
            System.out.println(file6.getName() + " 만들기 실패");
        }

        if (file6.mkdirs()) {
            System.out.println(file6.getName() + " 만들기 성공");

        }else {
            System.out.println(file6.getName() + " 만들기 실패");
        }
    }
}
