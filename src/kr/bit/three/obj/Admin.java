package kr.bit.three.obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Admin implements Serializable {

	/**
	 * 	Date created 2020-09-08
	 * 	Date latest 
	 * 	@author 안가람
	 */
	
	private static final long serialVersionUID = 1L;
	
	private Scanner input;
	private Map<String, Student> students;
	private Map<String, Professor> professors;
	private static Map<String, Lecture> lectures;
//	private List<Grade> grades;
	
	public Admin() {
		input = new Scanner(System.in);
		students = new HashMap<String, Student>();
		professors = new HashMap<String, Professor>();
		lectures = new HashMap<String, Lecture>();
	}

//---------------------------- 학생 관련 업무 ------------------------------

	public void stdRegister() {
		students = new HashMap<String, Student>();

		System.out.println("등록할 학생의 이름 입력 >> ");
		String name = input.nextLine().trim();
		
		System.out.println("등록할 학생의 학번 입력 >> ");
		String regId = input.nextLine().trim();
		
		System.out.println("등록할 학생의 학과 입력 >> ");
		String dept = input.nextLine().trim();
		
		System.out.println("등록할 학생의 주민 번호 입력 >> ");	// 정규표현식으로 검증
		String idNo = input.nextLine().trim();

		System.out.println("등록할 학생의 전화번호 입력 >> ");
		String phNo = input.nextLine().trim();
		
		Student newStd = new Student(name, regId, dept, idNo, phNo);
		
		// 등록할 학생의 학번이 이미 있는지 확인 >> Map에서 키가 있는지 조회
		if (students.containsKey(regId)) {
			students.put(regId, newStd);
		} else {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}
	}
	//기존 학생 정보 수정 >> 학과, 전화번호
	public void stdModify(String regId) {
		if (students.containsKey(regId)) {
			
			System.out.println("수정하실 학과명을 입력 >> ");
			String newDept = input.nextLine().trim();

			System.out.println("수정하실 전화번호를 입력 >> ");
			String newPhNo = input.nextLine().trim();
			students.get(regId).setDept(newPhNo);
		} 
	}

	//학생 전체 목록 조회
	public  void stdLookUp() {
		
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

	public static void lecLookUp() {
		for(Map.Entry lecture : lectures.entrySet()) {
			System.out.println(lecture.getValue());
		}
	}

	public static Map<String, Lecture> getLectures() {
		return lectures;
	}
}