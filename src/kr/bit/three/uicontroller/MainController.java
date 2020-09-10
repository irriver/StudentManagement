package kr.bit.three.uicontroller;

import kr.bit.three.ui.MainUi;

public class MainController{
	String input;
	
	public String mainMethod() {
		input = "";

		Lib lib = new Lib();
		MainUi ui = new MainUi();
		StudentController student_c = new StudentController();
		ProfessorController professor_c= new ProfessorController();
		AdminController admin_c = new AdminController();
		
		input = ui.UiMethod();
		if(input.equals("1")) { //학생 계정 선택
			lib.cls();
			student_c.studentMethod(); //학생 화면 출력
		}else if(input.equals("2")) {//교수 계정 선택
			lib.cls();
			professor_c.professorMethod(); //교수 화면 출력
		}else if(input.equals("3")) { //관리자 계정 선택
			lib.cls();
			admin_c.adminMethod();//관리자 계정 출력
		}
		return input;
	}
}