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
		System.out.println("    3. 성적 조회");
		System.out.println("    4. 수강 강의 목록 조회");
		System.out.println("    5. 전체 강의 목록 조회");
		System.out.println("    0. 이전 화면으로 돌아가기");
		System.out.println();
		System.out.println("------------------------------------");
		System.out.print("번호 입력 >> ");
		String inputNum = scan.nextLine().trim();
		return inputNum;
	}
}
