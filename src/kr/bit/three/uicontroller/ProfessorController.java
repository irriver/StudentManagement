package kr.bit.three.uicontroller;

import kr.bit.three.ui.ProfessorUi;

public class ProfessorController {
	String input;
	
	public String professorMethod() {
		input = "";

		Lib lib = new Lib();
		ProfessorUi professor_ui = new ProfessorUi();
		MainController main_c = new MainController();
		
		
		input = professor_ui.professorMethod();
		if(input.equals("1")) { //학생 계정 선택
			lib.cls();
			System.out.println("내 강의 목록을 조회하였습니다.");
			lib.cls();
			this.professorMethod();
		}else if(input.equals("2")) {//교수 계정 선택
			lib.cls();
			System.out.println("성적을 등록하였습니다.");
			lib.cls();
			this.professorMethod();
		}else if(input.equals("3")) { //관리자 계정 선택
			lib.cls();
			System.out.println("성적을 수정하였습니다.");
			lib.cls();
			this.professorMethod();
		}else if(input.equals("0")) { //관리자 계정 선택
			lib.cls();
			main_c.mainMethod();
		}
		return input;
	}
}