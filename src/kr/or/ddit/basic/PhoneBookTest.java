package kr.or.ddit.basic;

import java.io.*;
import java.util.*;


public class PhoneBookTest {
    private HashMap<String, PhoneBook> phonebookMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PhoneBookTest phoneBookTest = new PhoneBookTest();
        phoneBookTest.load();
        phoneBookTest.start();
        phoneBookTest.save(phoneBookTest.phonebookMap);
    }

    private void save(HashMap<String, PhoneBook> phonebookMap) {
        try{
            //출력용 스트림 객체 생성
            FileOutputStream fout = new FileOutputStream("d:/d_other/phoneData.dat");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            ObjectOutputStream oout = new ObjectOutputStream(bout);

            //쓰기 작업
            System.out.println("객체 저장 작업 시작...");
            oout.writeObject(phonebookMap);

            //객체를 저장할 때 마지막에 null을 저장하면 EOFException을 방지할수있다.
            oout.writeObject(null);

            //멤버객체는 직렬화가안된다
            System.out.println("객체 저장 작업 끝..");
            oout.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void load() {
        //객체를 파일에저장
        try {
            //출력용 스트림 객체 생성
            ObjectInputStream oin = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("d:/d_other/phoneData.dat")
                    )
            );
            System.out.println("객체 읽기 작업 시작");
                phonebookMap = (HashMap<String, PhoneBook>) oin.readObject();
            System.out.println("읽기작업끝");
            //쓰기 작업
            oin.close();
            //readObject()메소드는 데이터를 끝까지 다 읽으면 EOFException이 발생
        } catch (EOFException e ) {

        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void start() {
        while (true) {
            int choice = displayMenu();
            switch (choice) {
                case 1:
                    createPhoneNum();
                    break;
                case 2:
                    alterPhoneNum();
                    break;
                case 3:
                    deletePhoneNum();
                    break;
                case 4:
                    searchPhoneNum();
                    break;
                case 5:
                    searchAllPhoneNum();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다");
            }
        }
    }

    private void searchAllPhoneNum() {
        Map<String, PhoneBook> sortedMap = new TreeMap<>(phonebookMap);
        System.out.println("번호      이름      전화번호     주소");
        System.out.println("------------------------------------------");
        for (Map.Entry<String, PhoneBook> entry : sortedMap.entrySet()) {
            String number = entry.getKey();
            String name = entry.getValue().getName();
            String phoneNum = entry.getValue().getPhoneNum();
            String adrr = entry.getValue().getAdrr();
            System.out.println(number+"     "+name+"      "+phoneNum+"      "+adrr);
        }
    }

    private void searchPhoneNum() {
        Scanner sc = new Scanner(System.in);
        boolean isNameFound = false;
        System.out.println("찾으실 전화번호의 이름을 기입해주십시오");
        String name = sc.nextLine();
        for (String key : phonebookMap.keySet()) {
            PhoneBook phoneBook = phonebookMap.get(key);
            if (phoneBook.getName().equals(name)) {
                String name1 = phoneBook.name;
                String phoneNum = phoneBook.phoneNum;
                System.out.println(name1 + "님의 전화번호는 " + phoneNum+"입니다");
                isNameFound = true;
                break;
            }
        }
        if (!isNameFound) {
            System.out.println("회원 정보를 찾지 못했습니다");
        }
    }

    private void deletePhoneNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 전화번호의 이름을 기입해주십시오");
        String name = sc.nextLine();
        boolean isNameFound = false;

//        Set<Map.Entry<String, PhoneBook>> entries = phonebookMap.entrySet();
//        Iterator<Map.Entry<String, PhoneBook>> iterator = entries.iterator();
        //전체값 갖고오기위해서 이렇게 하나하나 불러내서 덮어 씌워도되지만
        Iterator<Map.Entry<String, PhoneBook>> iterator = phonebookMap.entrySet().iterator();
        //이렇게 한번에 해도된다.
        while (iterator.hasNext()) {
            Map.Entry<String, PhoneBook> entry = iterator.next();
            PhoneBook phoneValue = entry.getValue();
            if (phoneValue.getName().equals(name)) {
                iterator.remove(); //해당 엔드리(키 / 값) 삭제
                System.out.println(name+"님의 회원 삭제가 완료되었습니다 감사합니다.");
                isNameFound = true;
                break;
            }
        }
        //참값이면 실행시키기위해
        if (!isNameFound) {
            System.out.println("회원 정보를 찾을 수 없습니다");
        }
    }

    private void alterPhoneNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("바꾸실 전화번호의 이름을 기입해주십시오");
        String name = sc.nextLine();
        boolean isNameFound = false;
        for (String key : phonebookMap.keySet()) {
            PhoneBook phoneBook = phonebookMap.get(key);
            if (phoneBook.getName().equals(name)) {
                System.out.println(name + "님의 바꾸실 전화번호를 기입해주십시오");
                String phoneNum = sc.nextLine();
                phoneBook.setPhoneNum(phoneNum);
                System.out.println(name+"님의 전화번호 변경이 완료되었습니다");
                isNameFound = true;
                break;
            }
        }
        //참값이면 실행시키기위해
        if (!isNameFound) {
            System.out.println("회원 정보를 찾을 수 없습니다");
        }
    }

    //1번 전화번호 등록
    private void createPhoneNum() {
        Scanner sc = new Scanner(System.in);
//        새롭게 등록할 전화번호를 입력하세요
//        이름 >> 홍길동
//        전화번호 >> 010-1111-1111
//        주소 >> 대전시
        int count = phonebookMap.size() +1;
        boolean isNameDuplicate = false;
        System.out.println("새롭게 등록할 전화번호를 입력하세요");
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("전화번호 : ");
        String phoneNum = sc.nextLine();
        System.out.print("주소 : ");
        String addr = sc.nextLine();

        //이름 중복검사
        for (PhoneBook phoneBook : phonebookMap.values()) {
            if (phoneBook.getName().equals(name)) {
                isNameDuplicate = true;
                break;
            }
        }
        //이름 중복되면 true값 받고 거절 아니면 false로 통과
        if (!isNameDuplicate) {
            this.phonebookMap.put(count + "번", new PhoneBook(name, phoneNum, addr));
            System.out.println(name + "님 전화번호 등록 완료");
        } else {
            System.out.println(name+"의 이름은 중복입니다");
        }

        //제대로 회원가입됐는지 확인하는 로직
//        Set<Map.Entry<String, PhoneBook>> mapEntrySet = phonebookMap.entrySet();
//        Iterator<Map.Entry<String, PhoneBook>> entryIt = mapEntrySet.iterator();
//        while (entryIt.hasNext()) {
//            Map.Entry<String, PhoneBook> entry = entryIt.next();
//            System.out.println("key값 : " + entry.getKey());
//            System.out.println("Val값 : " + entry.getValue());
//        }
    }

    private int displayMenu() {
        System.out.println();
        System.out.println("==========================");
        System.out.println("전화번호 등록 프로그램");
        System.out.println("--------------------------");
        System.out.println("1. 전화번호 등록");
        System.out.println("2. 전화번호 수정");
        System.out.println("3. 전화번호 삭제");
        System.out.println("4. 전화번호 검색");
        System.out.println("5. 전화번호 전체출력");
        System.out.println("0. 프로그램 종료");
        System.out.println("==========================");
        System.out.print("메뉴선택 : ");
        return sc.nextInt();
    }

}

class PhoneBook implements Serializable {

    String name;
    String phoneNum;
    String adrr;

    public PhoneBook(String name, String phoneNum, String adrr) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.adrr = adrr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAdrr() {
        return adrr;
    }

    public void setAdrr(String adrr) {
        this.adrr = adrr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(name, phoneBook.name) && Objects.equals(phoneNum, phoneBook.phoneNum) && Objects.equals(adrr, phoneBook.adrr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNum, adrr);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", adrr='" + adrr + '\'' +
                '}';
    }
}


