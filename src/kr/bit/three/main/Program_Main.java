package kr.bit.three.main;

import kr.bit.three.obj.Admin;
import kr.bit.three.obj.Lecture;
import kr.bit.three.obj.Professor;
import kr.bit.three.obj.Student;
import kr.bit.three.uicontroller.MainController;

public class Program_Main {
	public static void main(String[] args) {
		
		
		Admin admin = Admin.getInstance();
		admin.getStudents().put("s1", new Student("전선규", "s1", "컴공과", "91", "010"));
		admin.getProfessors().put("p1", new Professor("임경균", "p1", "컴공과", "80", "010"));
		admin.getLectures().put("l1", new Lecture("l1", "자바", "임경균", "2", 3, 3));
		
		MainController main = new MainController();
		main.mainMethod();
	}

}