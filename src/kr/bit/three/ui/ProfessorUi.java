package kr.bit.three.ui;

import java.util.Scanner;

public class ProfessorUi {
	public String professorMethod() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("                                                                      ");
		System.out.println("            비트대학교 학사관리 시스템(교수)            ");
		System.out.println("        ㅡㅡㅡㅡㅡㅡㅡ* 메뉴 *ㅡㅡㅡㅡㅡㅡ       ");
		System.out.println("                     1.         내 강의 목록 조회                           ");
		System.out.println("                     2.         성적 등록                           ");
		System.out.println("                     3.         성적 수정                          ");
		System.out.println("                     4.         성적 삭제                          ");
		System.out.println("                     0.         이전 메뉴                          ");
		System.out.println("       ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ      ");
		System.out.println("                                                                      ");
		System.out.println("*******************************************");
		System.out.printf("메뉴 번호를 입력해 주세요 : ");
		String inputNum = scan.nextLine();
		return inputNum;
	}
}