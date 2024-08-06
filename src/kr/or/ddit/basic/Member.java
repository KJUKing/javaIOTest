package kr.or.ddit.basic;

import java.io.Serializable;
// 직렬화 : 메모리상의 객체를 저장 또는 전송하기 위해 다른형태로 변환하는 기술
// 직렬하가 가능하게 하려면 serialiazable인터페이스 구현해야함
public class Member implements Serializable {
    private static final long serialVersionUID = 1L; // serialVersionUID 추가

    private String name;
    private transient int age;
    private transient String addr;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddr() {
        return addr;
    }

    public Member(String name, int age, String addr) {
        super();
        this.name = name;
        this.age = age;
        this.addr = addr;
    }
}
