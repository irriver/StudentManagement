package kr.bit.three.obj;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student extends PersonalInfo implements Serializable {
	private Scanner scanner;
	
	private Map<String, Lecture> myLectures;
	private Map<String, Integer> myGrades;
	
	public Student(String name, String regId, String dept, String idNo, String phNo) {
		super(name, regId, dept, idNo, phNo);
		this.myLectures = new HashMap<String, Lecture>();
		this.myGrades = new HashMap<String, Integer>();
		this.scanner = new Scanner(System.in);
	}
	
	// 수강 신청
	public void signUpLecture(Student student) {
		System.out.print("수강 신청을 원하는 강의코드를 입력하세요: ");
		String lecCode = scanner.nextLine();
		try {
			// 전체 강의 목록에서 수강희망 강의코드 존재 시 해당 학생을 아래에 추가
			// 1.myLectures, 2.강의 클래스의 signedStdList
			if(Admin.getLectures().containsKey(lecCode)) {
				Lecture stdLecture = Admin.getLectures().get(lecCode);
				myLectures.put(lecCode, stdLecture);
				stdLecture.addStd(student);
			} else {
				throw new Exception("일치하는 강의코드가 없습니다.");
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 수강 취소
	public void dropLecture(Student student) {
		System.out.print("수강 취소를 원하는 강의코드를 입력하세요: ");
		String input = scanner.nextLine();

		// 전체 강의 목록에서 수강취소를 원하는 강의코드 존재 시 해당 학생을 아래에서 삭제
		// 1.myLEctures, 2.강의 클래스의 signedStdList
		if(Admin.getLectures().containsKey(input)) {
			Lecture stdLecture = Admin.getLectures().get(input);
			myLectures.remove(input);
			stdLecture.subStd(student);
		} else {
			System.out.println("일치하는 강의코드가 없습니다.");
		}
	}

	// 성적 확인
	public void checkGrade() {
		//myGrades map의 key: LecName, value: score
		for(Map.Entry<String, Integer> grade : myGrades.entrySet()) {
			System.out.printf("%s: %d점\n", grade.getKey(), grade.getValue());
		}
	}

	// myLectures 조회
	public void showMyLectures() {
		for(Lecture lec : myLectures.values()) {
			System.out.println(lec.toString());
		}
	}
	
	// 강의 목록 출력
	public void showLectures() {
		Admin.lecLookUp();
	}
	
	// getter, setter
	public Map<String, Integer> getGradeMap() {
		return myGrades;
	}

	@Override
	public String toString() {
		String stdInfo = "학번: " + getRegId()
						+ "\t성명: " + getName()
						+ "\t주민번호: " + getIdNo()
						+ "\t소속학과: " + getDept()
						+ "\t전화번호: " + getPhNo()
						+ "\n";
		return stdInfo;
	}
}