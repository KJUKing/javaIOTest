package kr.or.ddit.basic;

import java.io.*;

public class ObjectIOTest02 {
    public static void main(String[] args) {


        //객체를 파일에저장
        try {
            //출력용 스트림 객체 생성
            ObjectInputStream oin = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("d:/d_other/memObj.dat")
                    )
            );

            Object obj = null;

            System.out.println("객체 읽기 작업 시작");
            while ((obj = oin.readObject()) != null) {
                Member mem = (Member) obj;
                System.out.println("mem.getName() = " + mem.getName());
                System.out.println("mem.getAge() = " + mem.getAge());
                System.out.println("mem.getAddr() = " + mem.getAddr());

            }
            //쓰기 작업
            //readObject()메소드는 데이터를 끝까지 다 읽으면 EOFException이 발생
//      } catch (EOFException e ) {
//           System.out.println("읽기작업끝");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
        e.printStackTrace();
        }
    }
}
