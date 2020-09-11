package kr.bit.three.uicontroller;

import kr.bit.three.obj.Student;
import kr.bit.three.ui.StudentUi;

public class StudentController {
	String input;
	StudentUi student_ui;
	Lib lib;
	
	public StudentController() {
		this.input = "";
		this.student_ui = new StudentUi();
		this.lib = new Lib();
	}
	
	public void studentMethod(Student student) {
Loop_1 :while(true) {
			input = student_ui.studentMethod();
			
			
			if(input.equals("1")) { //수강 신청
				lib.cls();
				student.signUpLecture(student);
				System.out.println("수강 신청이 완료되었습니다.");
				lib.cls();
			}else if(input.equals("2")) { //수강 취소
				lib.cls();
				student.dropLecture(student);
				System.out.println("수강 취소가 완료되었습니다.");
				lib.cls();
			}else if(input.equals("3")) { //성적 조회
				lib.cls();
				student.checkGrade();
				System.out.println("성적이 조회되었습니다.");
				lib.cls();
			}else if(input.equals("4")) { //수강 강의 목록 조회
				lib.cls();
				student.showMyLectures();
				System.out.println("수강 강의 목록이 조회되었습니다.");
				lib.cls();
			}else if(input.equals("5")) { //전체 강의 목록 조회
				lib.cls();
				student.showLectures();
				System.out.println("전체 강의 목록이 조회되었습니다.");
				lib.cls();
			}else if(input.equals("6")) { //이전 화면으로 돌아가기
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
}