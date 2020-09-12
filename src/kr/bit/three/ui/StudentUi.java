package kr.bit.three.ui;

import java.util.Scanner;

public class StudentUi {
	public String studentMethod(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("                                                                      ");
		System.out.println("            비트대학교 학사관리 시스템(학생)          ");
		System.out.println("        ㅡㅡㅡㅡㅡㅡㅡ* 메뉴 *ㅡㅡㅡㅡㅡㅡ       ");
		System.out.println("                     1.         수강 신청                           ");
		System.out.println("                     2.         수강 취소                           ");
		System.out.println("                     3.         성적 조회                           ");
		System.out.println("                     4.         수강 강의 목록 조회                           ");
		System.out.println("                     5.         전체 강의 목록 조회                           ");
		System.out.println("                     0.         이전 화면으로 돌아가기                          ");
		System.out.println("       ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ      ");
		System.out.println("                                                                      ");
		System.out.println("*******************************************");
		System.out.printf("메뉴 번호를 입력해 주세요 : ");
		String inputNum = scan.nextLine();
		return inputNum;
	}
}
