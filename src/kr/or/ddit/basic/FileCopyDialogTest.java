package kr.or.ddit.basic;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDialogTest {
    public static void main(String[] args) {

        FileCopyDialogTest test =new FileCopyDialogTest();
//        File file = new File("d:/d_other/펭귄.jpg");
        File file = test.selectFile("OPEN");

        if (file == null) {
            System.out.println("복사할 원본 파일을 선택하세요");
            return;
        }
        //원본파일 있는지 검사
        if (!file.exists()) {
            System.out.println(file.getAbsolutePath() + " not exist");
            System.out.println("복사 작업중지..");
            return;
        }

        File saveFile = test.selectFile("SAVE");
        if (saveFile == null) {
            System.out.println("대상파일을 선택하세요");
            return;
        }


        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream(file);

//            fout = new FileOutputStream("d:/d_other/연습용/복사용_펭귄.jpg");
            fout = new FileOutputStream(saveFile);

            System.out.println("복사 시작");

            int data;

            while((data = fin.read()) != -1) {
                fout.write(data);

            }
            System.out.println("복사 작업 끝");

        }catch (IOException e){
            e.printStackTrace();
        }finally {
             //사용했던 스트림 닫기...
            if (fin!=null) try {fin.close();}catch (IOException e){}
        }
    }

    //열기용 또는 저장용 창을 나타내는 메소드
    // 매개변수가
    public File selectFile(String option) {
        //SWING에서 제공하는 파일 열기, 저장 창 연습
        JFileChooser chooser = new JFileChooser();

        //선택할 파일 유형 중 '모든 파일'

        // 선택할 파일의 확장자 설정
        FileNameExtensionFilter txt =
                new FileNameExtensionFilter("text파일(*.txt)", "txt");
        FileNameExtensionFilter doc =
                new FileNameExtensionFilter("MS Word File", "doc", "docx");
        FileNameExtensionFilter img =
                new FileNameExtensionFilter("Image File", new String[] {"jpg", "jpeg", "png", "gif", "bmp"});

        //확장자 목록을 FileChooser에 등록
        chooser.addChoosableFileFilter(txt);
        chooser.addChoosableFileFilter(doc);
        chooser.addChoosableFileFilter(img);

        // 전체 확장자 목록(파일 유형)
        chooser.setFileFilter(txt);

        // Dialog 기본 위치 설정
        chooser.setCurrentDirectory(new File("d:d_other"));

        //Dialog창 열기
//        int result = chooser.showOpenDialog(new Panel()); //열기
//        int result = chooser.showSaveDialog(new Panel()); //저장
        int result;
        if ("SAVE".equals(option.toUpperCase())) {
            result = chooser.showSaveDialog(new Panel()); //저장

        } else if ("OPEN".equals(option.toUpperCase())) {
            result = chooser.showOpenDialog(new Panel()); //열기
        }else{
            System.out.println("메소드를 호출할 때 매개변수에 'save' 또는 'open'을 지정하세요..");
            return null;
        }

        File selectedFile = null;
        // 창에서 '열기' 또는 '저장' 버트을 눌렀는지 확인
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            System.out.println("선택한 파일 :  " + selectedFile.getAbsolutePath());
        }
        return selectedFile;
    }
}
