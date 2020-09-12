package kr.bit.three.ui;

import java.util.Scanner;


public class AdminUi {
	Scanner scan = new Scanner(System.in);
	
	public String adminUi() {
		System.out.println("*******************************************");
		System.out.println("                                                                      ");
		System.out.println("           비트대학교 학사관리 시스템(관리자)          ");
		System.out.println("        ㅡㅡㅡㅡㅡㅡㅡ* 메뉴 *ㅡㅡㅡㅡㅡㅡ        ");
		System.out.println("                     1.         학생 관리                           ");
		System.out.println("                     2.         교수 관리                           ");
		System.out.println("                     3.         강의 관리                          ");
		System.out.println("                     0.         이전 메뉴                          ");
		System.out.println("       ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ       ");
		System.out.println("                                                                      ");
		System.out.println("*******************************************");
		System.out.printf("메뉴 번호를 입력해 주세요 : ");
		String inputNum = scan.nextLine();
		return inputNum;
	}
	
	public String manageStudent(){
		System.out.println("*******************************************");
		System.out.println("                                                                      ");
		System.out.println("                                학생 관리                          ");
		System.out.println("        ㅡㅡㅡㅡㅡㅡㅡ* 메뉴 *ㅡㅡㅡㅡㅡㅡ       ");
		System.out.println("                     1.         학생정보 등록                           ");
		System.out.println("                     2.         학생정보 수정                          ");
		System.out.println("                     3.         전체 학생정보 조회                   ");
		System.out.println("                     4.         강의 수강 학생 조회            ");
		System.out.println("                     0.         이전 메뉴                          ");
		System.out.println("       ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ      ");
		System.out.println("                                                                      ");
		System.out.println("*******************************************");
		System.out.printf("메뉴 번호를 입력해 주세요 : ");
		String inputNum = scan.nextLine();
		return inputNum;
	}
	
	public String manageProfessor(){
		System.out.println("*******************************************");
		System.out.println("                                                                      ");
		System.out.println("                                교수 관리                            ");
		System.out.println("        ㅡㅡㅡㅡㅡㅡㅡ* 메뉴 *ㅡㅡㅡㅡㅡㅡ        ");
		System.out.println("                     1.         교수정보 등록                             ");
		System.out.println("                     2.         교수정보 수정                            ");
		System.out.println("                     3.         전체 교수정보 등록                            ");
		System.out.println("                     0.         이전 메뉴                          ");
		System.out.println("       ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ      ");
		System.out.println("                                                                      ");
		System.out.println("********************************************");
		System.out.printf("메뉴 번호를 입력해 주세요 : ");
		String inputNum = scan.nextLine();
		return inputNum;
	}
	
	public String manageSubject(){
		System.out.println("*******************************************");
		System.out.println("                                                                      ");
		System.out.println("                                강의 관리                           ");
		System.out.println("        ㅡㅡㅡㅡㅡㅡㅡ* 메뉴 *ㅡㅡㅡㅡㅡㅡ        ");
		System.out.println("                     1.         강의 개설                           ");
		System.out.println("                     2.         강의 수정                           ");
		System.out.println("                     3.         강의 삭제                          ");
		System.out.println("                     3.         강의 조회                          ");
		System.out.println("                     0.         이전 메뉴                          ");
		System.out.println("       ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ      ");
		System.out.println("                                                                      ");
		System.out.println("*******************************************");
		System.out.printf("메뉴 번호를 입력해 주세요 : ");
		String inputNum = scan.nextLine();
		return inputNum;
	}		
}