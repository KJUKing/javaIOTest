package kr.or.ddit.basic;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class DialogTest {
    public static void main(String[] args) {
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
//        chooser/.

        //Dialog창 열기
//        int result = chooser.showOpenDialog(new Panel()); //열기
        int result = chooser.showSaveDialog(new Panel()); //저장

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("선택한 파일 :  " + selectedFile.getAbsolutePath());
        }
    }
}
