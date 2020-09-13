package kr.bit.three.uicontroller;

import kr.bit.three.obj.Admin;
import kr.bit.three.ui.AdminUi;

public class AdminController {
	String input;
	AdminUi admin_ui;
	Lib lib;
	
	public AdminController() {
		this.input = "";
		this.admin_ui = new AdminUi();
		this.lib = new Lib();
	}
	
	public void adminMethod() {
Loop_1 :while(true) {
			//admin 로그인 기능 대체
			Admin admin = Admin.getInstance();
			
			input = admin_ui.adminUi();
			if(input.equals("1")) { //학생 관리 선택
				lib.cls();
				adminStudentMethod(admin);
				lib.cls();
			}else if(input.equals("2")) { //교수 관리 선택
				lib.cls();
				adminProfessorMethod(admin);
				lib.cls();
			}else if(input.equals("3")) { //강의 관리 선택
				lib.cls();
				adminSubjectMethod(admin);
				lib.cls();
			}else if(input.equals("0")) { //이전메뉴
				lib.cls();
				System.out.println("이전 화면으로 돌아갑니다.");
				lib.cls();
				break Loop_1;
			}else {
				System.out.println("잘못 입력하였습니다.");
				System.out.println("다시 입력하여 주십시오.");
				lib.cls();
			}
		}
	}
	
	private void adminStudentMethod(Admin admin) {
		admin.setTypeCode("S");
Loop_2 :while(true) {
			input = admin_ui.manageStudent();
			if(input.equals("1")) { //학생정보 등록
				lib.cls();
				admin.storeData(admin.stdRegister());
				lib.cls();
			}else if(input.equals("2")) { //학생정보 수정
				lib.cls();
				admin.editData(admin.stdModify());
				lib.cls();
			}else if(input.equals("3")) { //전체 학생정보 조회
				lib.cls();
				admin.print();
				lib.cls();
			}else if(input.equals("0")) { //이전메뉴
				lib.cls();
				System.out.println("이전 화면으로 돌아갑니다.");
				lib.cls();
				break Loop_2;
			}else {
				System.out.println("잘못 입력하였습니다.");
				System.out.println("다시 입력하여 주십시오.");
				lib.cls();
			}
		}
	}	

	private void adminProfessorMethod(Admin admin) {
		admin.setTypeCode("P");
Loop_3 :while(true) {
			input = admin_ui.manageProfessor();
			if(input.equals("1")) { //교수정보 등록
				lib.cls();
				admin.storeData(admin.profRegister());
				lib.cls();
			}else if(input.equals("2")) { //교수정보 수정
				lib.cls();
				admin.editData(admin.profModify());
				lib.cls();
			}else if(input.equals("3")) { //전체 교수정보 조회
				lib.cls();
				admin.print();
				lib.cls();
			}else if(input.equals("0")) { //이전메뉴
				lib.cls();
				System.out.println("이전 화면으로 돌아갑니다.");
				lib.cls();
				break Loop_3;
			}else {
				System.out.println("잘못 입력하였습니다.");
				System.out.println("다시 입력하여 주십시오.");
				lib.cls();
			}
		}
	}	

	private void adminSubjectMethod(Admin admin) {
		admin.setTypeCode("L");
Loop_4 :while(true) {
			input = admin_ui.manageSubject();
			if(input.equals("1")) { //강의 개설
				lib.cls();
				admin.storeData(admin.lecRegister());
				lib.cls();
			}else if(input.equals("2")) { //강의 수정
				lib.cls();
				admin.editData(admin.lecModify());
				lib.cls();
			}else if(input.equals("3")) { //강의 조회
				lib.cls();
				admin.print();
				lib.cls();
			}else if(input.equals("0")) { //이전메뉴
				lib.cls();
				System.out.println("이전 화면으로 돌아갑니다.");
				lib.cls();
				break Loop_4;
			}else {
				System.out.println("잘못 입력하였습니다.");
				System.out.println("다시 입력하여 주십시오.");
				lib.cls();
			}
		}
	}	
}