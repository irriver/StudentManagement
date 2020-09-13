package kr.bit.three.uicontroller;

import java.util.Scanner;

import kr.bit.three.obj.Admin;
import kr.bit.three.obj.Professor;
import kr.bit.three.ui.ProfessorUi;

public class ProfessorController {
	private String input;
	private ProfessorUi professor_ui;
	private Lib lib;
	
	//로그인 기능 대체를 위한 iv
	private Admin admin = Admin.getInstance();
	private Scanner scan = new Scanner(System.in);
	
	public ProfessorController() {
		this.input = "";
		this.professor_ui = new ProfessorUi();
		this.lib = new Lib();
	}
	
	public void professorMethod() {
		//로그인 기능 대체를 위한 professor 객체 호출
		String profID;
		while(true) {
			System.out.print("로그인할 교수의 교번을 입력하세요(이전화면:0): ");
			profID = scan.nextLine();
			if(admin.getProfessors().containsKey(profID)) {
				break;
			} else if(profID.equals("0")) {
				return;
			} else {
				System.out.println("일치하는 교번의 교수가 없습니다.");
				System.out.println("다시 입력하여 주십시오.");
			}
		}
		Professor prof = admin.getProfessors().get(profID);
		
Loop_1 :while(true) {
			input = professor_ui.professorMethod();
			if(input.equals("1")) { //내 강의 목록 조회
				lib.cls();
				prof.showMyLectures();
				System.out.println("내 강의 목록을 조회하였습니다.");
				lib.cls();
			}else if(input.equals("2")) { //성적 등록
				lib.cls();
				prof.writeGrade();
				System.out.println("성적을 등록하였습니다.");
				lib.cls();
			}else if(input.equals("3")) { //성적 수정
				lib.cls();
				prof.modifyGrade();
				System.out.println("성적을 수정하였습니다.");
				lib.cls();
			}else if(input.equals("4")) { //성적 삭제
				lib.cls();
				prof.delGrade();
				System.out.println("성적을 삭제하였습니다.");
				lib.cls();
			}else if(input.equals("0")) { //이전메뉴
				lib.cls();
				System.out.println("이전 화면으로 돌아갑니다.");
				lib.cls();
				break Loop_1;
			}
		}
	}
}