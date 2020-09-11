package kr.bit.three.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin implements Serializable {
	
	public static void main(String[] args) {
		Admin ram = new Admin();
		ram.stdRegister();
		ram.storeData();
		ram.putData();
		
	}

	/**
	 * 	version 1.00
	 * 	Created 20-09-08
	 * 	Updated 20-09-11
	 * 	@author 안가람
	 */
	
	private static final long serialVersionUID = 1L;
	
	private Scanner input;
	private static Map<String, Student> students;
	private Map<String, Professor> professors;
	private static Map<String, Lecture> lectures;
//	private List<Grade> grades;
	
//	 Singleton pattern
	private static Admin admin = null;
	
	public static Admin getInstance() {
		if (admin == null) {
			admin = new Admin();
		}
		return admin;
	}
	
	public Admin() {
		input = new Scanner(System.in);
		students = new HashMap<String, Student>();
		professors = new HashMap<String, Professor>();
		lectures = new HashMap<String, Lecture>();
	}
	
//----------------------------- 학생 데이터 입력 -----------------------------
	
	private void storeData() {
		File file = new File("/Users/sungyujeon/Student-List.txt");
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			
			oos.writeObject(students);
			oos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//----------------------------- 학생 데이터 출력 -----------------------------
	
	private void putData() {
		File file = new File("/Users/sungyujeon/Student-List.txt");
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			ois.close();
			
			students = (HashMap)ois.readObject();
			while (students.entrySet() != null) {
				System.out.println(students.toString());
				students = (HashMap)ois.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//---------------------------- 학생 관련 업무 ------------------------------

	public Student stdRegister() {
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
		if (!students.containsKey(regId)) {
			students.put(regId, newStd);
			return newStd;
		} else {
			System.out.println("이미 등록된 학번입니다.");
			return null;
		}
//		등록한 학생은 학생 정보 저장 파일로 내보내는 함수 호출 +++++++++
	}
	
	//기존 학생 정보 수정 >> 학과, 전화번호
	public void stdModify() {
		System.out.println("수정할 학생의 학번 입력");
		String regId = input.nextLine().trim();
		
		if (students.containsKey(regId)) {
//			수정할 데이터 고르기 ++++
			System.out.println("수정하실 학과명을 입력 >> ");
			String newDept = input.nextLine().trim();

			System.out.println("수정하실 전화번호를 입력 >> ");
			String newPhNo = input.nextLine().trim();
			
			students.get(regId).setDept(newDept);
			students.get(regId).setPhNo(newPhNo);
		} else {
			System.out.println("입력하신 학번이 잘못 됐습니다.");
			stdModify();
			return;
		}
//		수정 내역 콘솔 출력으로 확인하는 기능
		for (Student modifiedStd : students.values()) {
			System.out.println(modifiedStd);
		}
	}

	//학생 전체 목록 조회
	public  void stdLookUp() {
		System.out.println("전체 학생 목록을 조회합니다.");
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
		
		if (!professors.containsKey(regId)) {
			professors.put(regId, newProf);
		} else {
			System.out.println("이미 등록된 교수입니다.");
			return;
		}
	}
	
	//교수 정보 수정 >> 학과, 전화번호
	public void profModify() {
		System.out.println("수정할 교수의 교번을 입력");
		String regId = input.nextLine().trim();
		
		if (professors.containsKey(regId)) {

			System.out.println("수정하실 학과명을 입력 >> ");
			String newDept = input.nextLine().trim();

			System.out.println("수정하실 전화번호를 입력 >> ");
			String newPhNo = input.nextLine().trim();

			students.get(regId).setDept(newDept);
			students.get(regId).setPhNo(newPhNo);
		} else {
			System.out.println("입력하신 교번이 존재하지 않습니다.");
			profModify();
			return;
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
	public void lecModify() {
		System.out.println("수정을 원하는 강의의 코드를 입력하세요.");
		String lecCode = input.nextLine().trim();
		
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
		} else {
			System.out.println("입력하신 강의코드가 잘못 됐습니다.");
			lecModify();
			return;
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