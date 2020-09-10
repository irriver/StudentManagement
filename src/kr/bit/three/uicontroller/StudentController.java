package kr.bit.three.uicontroller;

import kr.bit.three.ui.StudentUi;

public class StudentController {
	String input;
	
	public String studentMethod() {
		input = "";

		Lib lib = new Lib();
		StudentUi student_ui = new StudentUi();
		MainController main_c = new MainController();
		
		
		input = student_ui.studentMethod();
		if(input.equals("1")) { //학생 계정 선택
			lib.cls();
			System.out.println("수강 신청이 완료되었습니다.");
			lib.cls();
			this.studentMethod();
		}else if(input.equals("2")) {//교수 계정 선택
			lib.cls();
			System.out.println("수강 취소가 완료되었습니다.");
			lib.cls();
			this.studentMethod();
		}else if(input.equals("3")) { //관리자 계정 선택
			lib.cls();
			System.out.println("수강 목록이 조회되었습니다.");
			lib.cls();
			this.studentMethod();
		}else if(input.equals("4")) { //관리자 계정 선택
			lib.cls();
			System.out.println("성적이 조회되었습니다.");
			lib.cls();
			this.studentMethod();
		}else if(input.equals("0")) { //관리자 계정 선택
			lib.cls();
			main_c.mainMethod();
		}
		return input;
	}
}