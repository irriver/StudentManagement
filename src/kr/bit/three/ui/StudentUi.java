package kr.bit.three.ui;

import java.util.Scanner;

public class StudentUi {
	public String studentMethod(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("======================");
		System.out.println();
		System.out.println("        비트 대학교 학사관리 시스템(학생)");   
		System.out.println();
		System.out.println("======================");
		System.out.println();
		System.out.println("    1. 수강 신청");
		System.out.println("    2. 수강 취소");
		System.out.println("    3. 수강 목록 조회");
		System.out.println("    4. 성적 조회");
		System.out.println("    0. 이전메뉴");
		System.out.println();
		System.out.println("------------------------------------");
		System.out.printf("사용자 계정을 선택해 주세요 >> ");
		String inputNum = scan.nextLine();
		
		return inputNum;
	}
}