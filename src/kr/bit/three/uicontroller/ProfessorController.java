package kr.bit.three.uicontroller;

import kr.bit.three.obj.Professor;
import kr.bit.three.ui.ProfessorUi;

public class ProfessorController {
	String input;
	ProfessorUi professor_ui;
	Lib lib;
	
	public ProfessorController() {
		this.input = "";
		this.professor_ui = new ProfessorUi();
		this.lib = new Lib();
	}
	
	public void professorMethod(Professor prof) {
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