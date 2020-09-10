package kr.bit.three.ui;

import java.util.Scanner;

public class AdminUi {
	String input;
	
	public String adminUi() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("======================");
		System.out.println();
		System.out.println("        비트 대학교 학사관리 시스템(관리자)");
		System.out.println();
		System.out.println("======================");
		System.out.println();
		System.out.println("    1. 학생 관리");
		System.out.println("    2. 교수 관리");
		System.out.println("    3. 강의 관리");
		System.out.println("    4. 수강 관리");
		System.out.println("    0. 이전메뉴");
		System.out.println();
		System.out.println("------------------------------------");
		System.out.printf("사용자 계정을 선택해 주세요 >> ");
		String inputNum = scan.nextLine();
		
		return inputNum;
	}
	
	public String manageStudent(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("======================");
		System.out.println();
		System.out.println("        학생 관리");
		System.out.println();
		System.out.println("======================");
		System.out.println();
		System.out.println("    1. 학생 등록");
		System.out.println("    2. 학생 수정");
		System.out.println("    3. 전체 학생 조회");
		System.out.println("    4. 강의 수강 학생 조회");
		System.out.println("    0. 이전메뉴");
		System.out.println();
		System.out.println("------------------------------------");
		System.out.printf("사용자 계정을 선택해 주세요 >> ");
		String inputNum = scan.nextLine();
		return inputNum;
	}
	
	public String manageProfessor(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("======================");
		System.out.println();
		System.out.println("        교수 관리");
		System.out.println();
		System.out.println("======================");
		System.out.println();
		System.out.println("    1. 교수 등록");
		System.out.println("    2. 교수 수정");
		System.out.println("    3. 교수 조회");
		System.out.println("    0. 이전메뉴");
		System.out.println();
		System.out.println("------------------------------------");
		System.out.printf("사용자 계정을 선택해 주세요 >> ");
		String inputNum = scan.nextLine();
		return inputNum;
	}
	
	public String manageSubject(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("======================");
		System.out.println();
		System.out.println("        강의 관리");
		System.out.println();
		System.out.println("======================");
		System.out.println();
		System.out.println("    1. 강의 개설");
		System.out.println("    2. 강의 수정");
		System.out.println("    3. 강의 삭제");
		System.out.println("    4. 강의 조회");
		System.out.println("    0. 이전메뉴");
		System.out.println();
		System.out.println("------------------------------------");
		System.out.printf("사용자 계정을 선택해 주세요 >> ");
		String inputNum = scan.nextLine();
		return inputNum;
	}		
}