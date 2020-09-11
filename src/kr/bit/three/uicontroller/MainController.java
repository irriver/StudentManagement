package kr.bit.three.uicontroller;

import kr.bit.three.ui.MainUi;

public class MainController{
	private String input;
	private MainUi ui;
	private StudentController student_c;
	private ProfessorController professor_c;
	private AdminController admin_c;
	private Lib lib;
	
	public MainController() {
		this.input = "";
		this.ui = new MainUi();
		this.student_c = new StudentController();
		this.professor_c = new ProfessorController();
		this.admin_c = new AdminController();
		this.lib = new Lib();
	}

	public void mainMethod() {	
		while(true) {
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
			}else if(input.equals("4")) { //시스템 종료
				System.exit(0);
			}else {
				System.out.println("잘못 입력하였습니다.");
				System.out.println("다시 입력하여 주십시오.");
			}
		}
	}
}