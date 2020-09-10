package kr.bit.three.obj;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Professor extends PersonalInfo implements Serializable {
	private Scanner scanner;
	private Map<String, Lecture> myLectures;

	public Professor(String name, String regId, String dept, String idNo, String phNo) {
		super(name, regId, dept, idNo, phNo);

		scanner = new Scanner(System.in);
		myLectures = new HashMap<String, Lecture>();
	}

	// 성적 입력
	public void writeGrade() {
		Lecture lecture = selectMyLecture(); // 1.myLecture 선택
		getStdList(lecture); 				 // 2.myLecture가 가지고 있는 stdList 출력
		Student student = selectStd(lecture);// 3.stdList에서 성적 수을 원하는 std 선택

		// 4-1.std 성적 입력
		int score = Integer.parseInt(scanner.nextLine());
		writeStdGrade(lecture, student, score);
	}

	// 성적 수정
	public void modifyGrade() {
		Lecture lecture = selectMyLecture(); // 1.myLecture 선택
		getStdList(lecture); 				 // 2.myLecture가 가지고 있는 stdList 출력
		Student student = selectStd(lecture);// 3.stdList에서 성적 수을 원하는 std 선택

		// 4-2.std 성적 수정
		int score = Integer.parseInt(scanner.nextLine());
		modifyStdGrade(lecture, student, score);
	}

	// 성적 삭제
	public void delGrade() {
		Lecture lecture = selectMyLecture(); // 1.myLecture 선택
		getStdList(lecture); 				 // 2.myLecture가 가지고 있는 stdList 출력
		Student student = selectStd(lecture);// 3.stdList에서 성적 수을 원하는 std 선택
		delStdGrade(lecture, student); 		 // 4-3.std 성적 삭제
	}
	
	
	// Template Method(성적 입력,수정,삭제)
	// 성적 처리 방식은 다음의 5단계로 이루어진다.
	// 1.나의 강의 선택
	// 2.나의 강의를 수강하는 학생 조회
	// 3.학생 선택
	// 4-1.성적 입력
	// 4-2.성적 수정
	// 4-3.성적 삭제

	// 1.myLecture 선택
	private Lecture selectMyLecture() {
		System.out.print("성적 입력을 원하는 강의 코드를 입력하세요: ");
		String input = scanner.nextLine();

		// 일치하는 코드 있을 시 return the lecture;
		for (Map.Entry lec : myLectures.entrySet()) {
			if (lec.getKey().equals(input)) {
				return (Lecture) lec;
			}
		}

		// 일치하는 코드 없을 시 return null
		System.out.println("일치하는 강의 코드가 없습니다.");
		return null;
	}

	// 2.myLecture가 가지고 있는 stdList 출력
	private void getStdList(Lecture lecture) {
		for (Map.Entry lec : lecture.getSignedStdList().entrySet()) {
			System.out.println(lec.getValue());
		}
	}

	// 3.stdList에서 성적 입력을 원하는 std 선택
	private Student selectStd(Lecture lecture) {
		System.out.print("성적을 입력할 학생의 학번을 입력하세요: ");
		String input = scanner.nextLine();

		// 일치하는 학번 있을 시 return the student
		for (Map.Entry lec : lecture.getSignedStdList().entrySet()) {
			if (lec.getKey().equals(input)) {
				return (Student) lec.getValue();
			}
		}

		// 일치하는 학번 없을 시 return null
		System.out.println("일치하는 학생의 학번이 없습니다.");
		return null;
	}
	
	// 4-1. std의 성적 입력
	private void writeStdGrade(Lecture lecture, Student student, int score) {
		student.getGradeMap().put(lecture.getLecName(), score);
		// 성적 입력 수정 삭제할 시에 각 과목을 찾는 key로 lecCode 사용
	}
	// 4-2. std 성적 수정(replace)
	private void modifyStdGrade(Lecture lecture, Student student, int score) {
		student.getGradeMap().replace(lecture.getLecName(), score);
	}
	// 4-3. std 성적 삭제(remove)
	private void delStdGrade(Lecture lecture, Student student) {
		student.getGradeMap().remove(lecture.getLecName());
	}
	
	// myLectures 조회
	// 강의 수가 많을 경우 조회하지 않고 바로 코드 입력하는 곳으로 이동할 수 있는 것도 만들어야??
	public void showMyLectures() {
		for (Map.Entry lec : myLectures.entrySet()) {
			System.out.println(lec.getValue());
		}
	}
	
	@Override
	public String toString() {
		return "교번: " + getRegId() + "\t성명: " + getName()
		+ "\n주민번호: " + getIdNo()
		+ "\n소속학과: " + getDept() + "\t전화번호: " + getPhNo()
		+ "-----------------------";
	}
}
