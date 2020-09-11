package kr.bit.three.ui;

import java.util.Scanner;

public class MainUi {
	Scanner scan = new Scanner(System.in);

	public String UiMethod() {	
		System.out.println();
		System.out.println("======================");
		System.out.println();
		System.out.println("            비트 대학교 학사관리 시스템");
		System.out.println();
		System.out.println("======================");
		System.out.println();
		System.out.println("    1. 학생");
		System.out.println("    2. 교수");
		System.out.println("    3. 관리자");
		System.out.println("    4. 종료");
		System.out.println();
		System.out.println("------------------------------------");
		System.out.printf("사용자 계정을 선택해 주세요 >> ");
		String inputNum = scan.nextLine();
		return inputNum;
	}
}