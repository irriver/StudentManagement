package kr.bit.three.uicontroller;

import java.util.Scanner;

import kr.bit.three.obj.Admin;
import kr.bit.three.obj.Student;
import kr.bit.three.ui.StudentUi;

public class StudentController {
	private String input;
	private StudentUi student_ui;
	private Lib lib;
	
	//로그인 기능 대체를 위한 iv
	private Admin admin = Admin.getInstance();
	private Scanner scan = new Scanner(System.in);
	
	public StudentController() {
		this.input = "";
		this.student_ui = new StudentUi();
		this.lib = new Lib();
	}
	
	public void studentMethod() {
		//로그인 기능 대체를 위한 student 객체 호출
		String stdID;
		while(true) {
			System.out.print("로그인할 학생의 학번을 입력하세요(이전화면:0): ");
			stdID = scan.nextLine().trim();
			if(admin.getStudents().containsKey(stdID)) {
				break;
			} else if(stdID.equals("0")) {
				return;
			} else {
				System.out.println("일치하는 학번의 학생이 없습니다.");
				System.out.println("다시 입력하여 주십시오.");
			}
		}
		Student student = admin.getStudents().get(stdID);
		
Loop_1 :while(true) {
			input = student_ui.studentMethod();
			if(input.equals("1")) { //수강 신청
				lib.cls();
				student.signUpLecture(student);
				lib.cls();
			}else if(input.equals("2")) { //수강 취소
				lib.cls();
				student.dropLecture(student);
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
			}else if(input.equals("0")) { //이전 화면으로 돌아가기
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