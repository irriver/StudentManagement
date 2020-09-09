package kr.bit.three.obj;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Professor extends PersonalInfo implements Serializable {

	/**
	 * Created-Date 20-09-09
	 * 
	 * @author 전선규
	 */
	private static final long serialVersionUID = 1L;

	private Scanner scanner;
	private Map<String, Lecture> myLectures;

	public Professor(String name, String regId, String dept, String idNo, String phNo) {
		super(name, regId, dept, idNo, phNo);

		scanner = new Scanner(System.in);
		myLectures = new HashMap<String, Lecture>();
	}

	// 성적 입력
	public void writeGrade() {
		showMyLectures(); // 1.myLectures 조회
		Lecture lecture = selectMyLecture(); // 2.myLecture 선택
		getStdList(lecture); // 3.myLecture가 가지고 있는 stdList 출력
		Student student = selectStd(lecture);// 4.stdList에서 성적 수을 원하는 std 선택

		// 5-1.std 성적 입력
		int score = Integer.parseInt(scanner.nextLine());
		writeStdGrade(lecture, student, score);
	}

	// 성적 수정
	public void modifyGrade() {
		showMyLectures(); // 1.myLectures 조회
		Lecture lecture = selectMyLecture(); // 2.myLecture 선택
		getStdList(lecture); // 3.myLecture가 가지고 있는 stdList 출력
		Student student = selectStd(lecture);// 4.stdList에서 성적 수을 원하는 std 선택

		// 5-2.std 성적 수정
		int score = Integer.parseInt(scanner.nextLine());
		modifyStdGrade(lecture, student, score);
	}

	// 성적 삭제
	public void delGrade() {
		showMyLectures(); // 1.myLectures 조회
		Lecture lecture = selectMyLecture(); // 2.myLecture 선택
		getStdList(lecture); // 3.myLecture가 가지고 있는 stdList 출력
		Student student = selectStd(lecture);// 4.stdList에서 성적 수을 원하는 std 선택
		delStdGrade(lecture, student); // 5-2.std 성적 삭제
	}

	// Template Method(성적 입력,수정,삭제)
	// 성적 처리 방식은 다음의 5단계로 이루어진다.
	// 1.나의 강의 조회
	// 2.나의 강의 선택
	// 3.나의 강의를 수강하는 학생 조회
	// 4.학생 선택
	// 5-1.성적 입력
	// 5-2.성적 수정
	// 5-3.성적 삭제

	// 1.myLectures 조회
	// 강의 수가 많을 경우 조회하지 않고 바로 코드 입력하는 곳으로 이동할 수 있는 것도 만들어야??
	private void showMyLectures() {
		for (Map.Entry lec : myLectures.entrySet()) {
			System.out.println(lec.getValue());
		}
	}

	// 2.myLecture 선택
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

	// 3.myLecture가 가지고 있는 stdList 출력
	private void getStdList(Lecture lecture) {
		for (Map.Entry lec : lecture.getSignedStdList().entrySet()) {
			System.out.println(lec.getValue());
		}
	}

	// 4.stdList에서 성적 입력을 원하는 std 선택
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

	// 5-1. std의 성적 입력
	private void writeStdGrade(Lecture lecture, Student student, int score) {
		student.getGradeMap().put(lecture.getLecName(), score);
		// 성적 입력 수정 삭제할 시에 각 과목을 찾는 key로 lecCode 사용
	}

	// 5-2. std 성적 수정(replace)
	private void modifyStdGrade(Lecture lecture, Student student, int score) {
		student.getGradeMap().replace(lecture.getLecName(), score);
	}

	// 5-3. std 성적 삭제(remove)
	private void delStdGrade(Lecture lecture, Student student) {
		student.getGradeMap().remove(lecture.getLecName());
	}

	@Override
	public String toString() {
		return "교번: " + getRegId() + "\t성명: " + getName()
		+ "\n주민번호: " + getIdNo()
		+ "\n소속학과: " + getDept() + "\t전화번호: " + getPhNo()
		+ "-----------------------";
	}
	
	
}
