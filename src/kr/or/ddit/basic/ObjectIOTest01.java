package kr.or.ddit.basic;

import java.io.*;

public class ObjectIOTest01  {
    public static void main(String[] args) {
        // Member클래스의 인스턴스 생성
        Member mem1 = new Member("홍길동", 20, "대전");
        Member mem2 = new Member("금강선", 30, "부산");
        Member mem3 = new Member("전재학", 40, "전주");
        Member mem4 = new Member("김창섭", 50, "서울");


        //객체를 파일에저장
        try{
            //출력용 스트림 객체 생성
            FileOutputStream fout = new FileOutputStream("d:/d_other/memObj.dat");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            ObjectOutputStream oout = new ObjectOutputStream(bout);

            //쓰기 작업
            System.out.println("객체 저장 작업 시작...");
            oout.writeObject(mem1);
            oout.writeObject(mem2);
            oout.writeObject(mem3);
            oout.writeObject(mem4);

            //객체를 저장할 때 마지막에 null을 저장하면 EOFException을 방지할수있다.
            oout.writeObject(null);

            //멤버객체는 직렬화가안된다
            System.out.println("객체 저장 작업 끝..");
            oout.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
