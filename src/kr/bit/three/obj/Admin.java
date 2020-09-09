package kr.bit.three.obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Admin implements Serializable {

	private List<Student> students;
	private List<Professor> professors;
	private List<Lecture> lectures;
//	private List<Grade> grades;

//---------------------------- 학생 관련 업무 ------------------------------

	public void stdRegister(Student student) {
		students = new ArrayList<Student>();
		// 등록할 학생의 학번이 이미 있는지 확인
		if (student.isExist(student)) {
			students.add(student);
		} else {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}
	}

	public void stdModify() {
	}

	public void stdLookUp() {
	}

//---------------------------- 교수 관련 업무 ------------------------------

	public void profRegister(Professor professor) {
		professors = new ArrayList<Professor>();
		// 등록할 교수의 교번이 이미 있는지 확인
		if (professor.isExist(professor)) {
			professors.add(professor);
		} else {
			System.out.println("이미 등록된 교수입니다.");
			return;
		}
	}

	public void profModify() {
	}

	public void profLookUp() {
	}

	// ---------------------------- 강의 관련 업무 ------------------------------

	public void lecRegister(Lecture lecture) {
		//강의는 동일 강좌가 개설될 수 있으므로 중복 체크 하지 않음
		lectures.add(lecture);
	}

	public void lecModify() {
	}

	public void lecLookUp() {
	}
}