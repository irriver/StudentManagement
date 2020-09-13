package kr.bit.three.main;

import kr.bit.three.obj.Admin;
import kr.bit.three.uicontroller.MainController;

public class Program_Main {
	public static void main(String[] args) {
		Admin admin = Admin.getInstance();
/*		
		Student student = new Student("전선규", "s1", "컴공과", "91", "010");
		Professor professor = new Professor("임경균", "p1", "컴공과", "80", "010");
		Lecture testLecture = new Lecture("l1", "자바", "임경균", "2", 3, 3);
		admin.getStudents().put("s1", student);
		admin.getProfessors().put("p1", professor);
		admin.getLectures().put("l1", testLecture);
*/
		//professor 내 강의에도 추가
//		admin.getProfessors().get("p1").getMyLectures().put("l1", testLecture);
		
		
		MainController main = new MainController();
		main.mainMethod();
	}

}