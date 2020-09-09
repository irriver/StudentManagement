package kr.bit.three.obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Admin implements Serializable {

	/**
	 * 	version 1.00 20-09-08
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
			
			students.get(regId).setDept(newDept);
			students.get(regId).setPhNo(newPhNo);
		}
	}

	//학생 전체 목록 조회
	public  void stdLookUp() {
		for (Student eachStd : students.values()) {
			System.out.println(eachStd.toString());
		}
	}

//---------------------------- 교수 관련 업무 ------------------------------

	public void profRegister() {
		System.out.println("등록할 교수의 이름 입력 >> ");
		String name = input.nextLine().trim();
		
		System.out.println("등록할 교수의 교번 입력 >> ");
		String regId = input.nextLine().trim();
		
		System.out.println("등록할 교수의 학과 입력 >> ");
		String dept = input.nextLine().trim();
		
		System.out.println("등록할 교수의 주민 번호 입력 >> ");
		String idNo = input.nextLine().trim();

		System.out.println("등록할 학생의 전화번호 입력 >> ");
		String phNo = input.nextLine().trim();
		
		Professor newProf = new Professor(name, regId, dept, idNo, phNo);
		
		professors = new HashMap<String, Professor>();
		
		if (professors.containsKey(regId)) {
			professors.put(regId, newProf);
		} else {
			System.out.println("이미 등록된 교수입니다.");
			return;
		}
	}
	
	//교수 정보 수정 >> 학과, 전화번호
	public void profModify(String regId) {
		if (professors.containsKey(regId)) {

			System.out.println("수정하실 학과명을 입력 >> ");
			String newDept = input.nextLine().trim();

			System.out.println("수정하실 전화번호를 입력 >> ");
			String newPhNo = input.nextLine().trim();

			students.get(regId).setDept(newDept);
			students.get(regId).setPhNo(newPhNo);
		}
	}

	//교수 전체 목록 출력
	public void profLookUp() {
		for (Professor eachProf : professors.values()) {
			System.out.println(eachProf.toString());
		}
	}

	// ---------------------------- 강의 관련 업무 ------------------------------

	public void lecRegister() {
		
		//강의는 동일 강좌가 개설될 수 있으므로 중복 체크 하지 않음
		System.out.println("등록할 강의의 등록 코드 입력 >> ");
		String lecCode = input.nextLine().trim();
		
		System.out.println("등록할 강의명 입력 >> ");
		String lecName = input.nextLine().trim();
		
		System.out.println("등록할 강의의 담당 교수 입력 >> ");
		String profName = input.nextLine().trim();
		
		System.out.println("등록할 강의의 개설 학기 입력 >> ");
		String semester = input.nextLine().trim();

		System.out.println("등록할 강의의 학점  입력 >> ");
		int times = input.nextInt();
		
		System.out.println("등록할 강의의 수강 인원 입력 >> ");
		int maxStd = input.nextInt();
		
		Lecture newLec = new Lecture(lecCode, lecName, profName, semester, times, maxStd);
		lectures.put(lecCode, newLec);
	}

	// 일부 데이터만 수정할 경우 추가할 것***
	public void lecModify(String lecCode) {
		if (lectures.containsKey(lecCode)) {
			
			System.out.println("수정할 강의명 입력 >> ");
			String lecName = input.nextLine().trim();
			
			System.out.println("수정할 강의의 담당 교수 입력 >> ");
			String profName = input.nextLine().trim();
			
			System.out.println("수정할 강의의 개설 학기 입력 >> ");
			String semester = input.nextLine().trim();

			System.out.println("수정할 강의의 학점  입력 >> ");
			int times = input.nextInt();
			
			System.out.println("수정할 강의의 수강 인원 입력 >> ");
			int maxStd = input.nextInt();
			
			lectures.get(lecCode).setLecName(lecName);
			lectures.get(lecCode).setProfName(profName);
			lectures.get(lecCode).setSemester(semester);
			lectures.get(lecCode).setTimes(times);
			lectures.get(lecCode).setMaxStd(maxStd);
		}
	}

	public static void lecLookUp() {
		for (Lecture eachLec : lectures.values()) {
			System.out.println(eachLec.toString());
		}
	}

	public static Map<String, Lecture> getLectures() {
		return lectures;
	}
}