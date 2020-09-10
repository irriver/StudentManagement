package kr.bit.three.uicontroller;

import kr.bit.three.ui.AdminUi;

public class AdminController {
	String input;
	
	public String adminMethod() {
		input = "";

		Lib lib = new Lib();
		AdminUi admin_ui = new AdminUi();
		MainController main_c = new MainController();
		
		
		input = admin_ui.adminUi();
		if(input.equals("1")) { //학생 계정 선택
			lib.cls();
			System.out.println("학생 관리 페이지입니다.");
			lib.cls();
			this.adminStudentMethod();
		}else if(input.equals("2")) {//교수 계정 선택
			lib.cls();
			System.out.println("교수  관리 페이지입니다.");
			lib.cls();
			this.adminProfessorMethod();
		}else if(input.equals("3")) { //관리자 계정 선택
			lib.cls();
			System.out.println("강의 관리 페이지입니다.");
			lib.cls();
			this.adminSubjectMethod();
		}else if(input.equals("0")) { //관리자 계정 선택
			lib.cls();
			main_c.mainMethod();
		}
		return input;
	}
	
	public String adminStudentMethod() {
		input = "";

		Lib lib = new Lib();
		AdminUi admin_ui = new AdminUi();
		
		input = admin_ui.manageStudent();
		if(input.equals("1")) { //학생 계정 선택
			lib.cls();
			System.out.println("학생 정보가 등록되었습니다.");
			lib.cls();
			this.adminStudentMethod();
		}else if(input.equals("2")) {//교수 계정 선택
			lib.cls();
			System.out.println("학생 정보가 수정되었습니다.");
			lib.cls();
			this.adminStudentMethod();
		}else if(input.equals("3")) { //관리자 계정 선택
			lib.cls();
			System.out.println("전체 학생 정보를 조회하였습니다.");
			lib.cls();
			this.adminStudentMethod();
		}else if(input.equals("4")) { //관리자 계정 선택
			lib.cls();
			System.out.println("강의 수강 학생 정보를 조회하였습니다.");
			lib.cls();
			this.adminStudentMethod();
		}else if(input.equals("0")) { //관리자 계정 선택
			lib.cls();
			this.adminMethod();
		}
		return input;
	}	

	public String adminProfessorMethod() {
		input = "";

		Lib lib = new Lib();
		AdminUi admin_ui = new AdminUi();
		
		input = admin_ui.manageProfessor();
		if(input.equals("1")) { //학생 계정 선택
			lib.cls();
			System.out.println("교수 정보가 등록되었습니다.");
			lib.cls();
			this.adminProfessorMethod();
		}else if(input.equals("2")) {//교수 계정 선택
			lib.cls();
			System.out.println("교수 정보가 수정되었습니다.");
			lib.cls();
			this.adminProfessorMethod();
		}else if(input.equals("3")) { //관리자 계정 선택
			lib.cls();
			System.out.println("교수 정보를 조회하였습니다.");
			lib.cls();
			this.adminProfessorMethod();
		}else if(input.equals("4")) { //관리자 계정 선택
			lib.cls();
			System.out.println("수강 관리 페이지입니다.");
			lib.cls();
			this.adminProfessorMethod();
		}else if(input.equals("0")) { //관리자 계정 선택
			lib.cls();
			this.adminMethod();
		}
		return input;
	}	

	public String adminSubjectMethod() {
		input = "";

		Lib lib = new Lib();
		AdminUi admin_ui = new AdminUi();
		
		input = admin_ui.manageSubject();
		if(input.equals("1")) { //학생 계정 선택
			lib.cls();
			System.out.println("강의를 개설하였습니다.");
			lib.cls();
			this.adminSubjectMethod();
		}else if(input.equals("2")) {//교수 계정 선택
			lib.cls();
			System.out.println("강의 정보를 수정하였습니다.");
			lib.cls();
			this.adminSubjectMethod();
		}else if(input.equals("3")) { //관리자 계정 선택
			lib.cls();
			System.out.println("강의 정보를 삭제하였습니다.");
			lib.cls();
			this.adminSubjectMethod();
		}else if(input.equals("4")) { //관리자 계정 선택
			lib.cls();
			System.out.println("강의 정보를 조회하였습니다.");
			lib.cls();
			this.adminSubjectMethod();
		}else if(input.equals("0")) { //관리자 계정 선택
			lib.cls();
			this.adminMethod();
		}
		return input;
	}	
}