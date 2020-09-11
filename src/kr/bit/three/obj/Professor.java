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
		try {
			Lecture lecture = selectMyLecture(); 		// 1.myLecture 선택
			if(selectMyLecture().equals(null)) return;  // 일치하는 강의 코드 없을 시 return
			
	//(std 출력 이후에 같은 과목에서 여러 학생들의 성적만 계속 입력할 수 있는 기능 구현할까??)
			getStdList(lecture); 				 		// 2.myLecture가 가지고 있는 stdList 출력
			Student student = selectStd(lecture);		// 3.stdList에서 성적 입력을 원하는 std 선택
			if(student.equals(null)) return;			// 일치하는 std 없을 시 return
			
			// 4-1.std 성적 입력
			writeStdGrade(lecture, student);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("잘못된 값을 입력하였습니다.");
		}
	}

	// 성적 수정
	public void modifyGrade() {
		try {
			Lecture lecture = selectMyLecture(); 		// 1.myLecture 선택
			if(selectMyLecture().equals(null)) return;  // 일치하는 강의 코드 없을 시 return
			
			getStdList(lecture); 				 		// 2.myLecture가 가지고 있는 stdList 출력
			Student student = selectStd(lecture);		// 3.stdList에서 성적 수을 원하는 std 선택
			if(student.equals(null)) return;			// 일치하는 std 없을 시 return
			
			// 4-2.std 성적 수정
			modifyStdGrade(lecture, student);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("잘못된 값을 입력하였습니다.");
		}
	}

	// 성적 삭제
	public void delGrade() {
		try {
			Lecture lecture = selectMyLecture(); 		// 1.myLecture 선택
			if(selectMyLecture().equals(null)) return;  // 일치하는 강의 코드 없을 시 return
			
			getStdList(lecture); 				 		// 2.myLecture가 가지고 있는 stdList 출력
			Student student = selectStd(lecture);		// 3.stdList에서 성적 수을 원하는 std 선택
			if(student.equals(null)) return;			// 일치하는 std 없을 시 return
			
			delStdGrade(lecture, student); 				// 4-3.std 성적 삭제
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("잘못된 값을 입력하였습니다.");
		}
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
		if(myLectures.containsKey(input)) {
			return myLectures.get(input);
		} else {
			System.out.println("일치하는 강의 코드가 없습니다.");
			return null;
		}
	}

	// 2.myLecture가 가지고 있는 stdList 출력
	private void getStdList(Lecture lecture) {
		lecture.getSignedStdList().values().toString();
	}

	// 3.stdList에서 성적 입력을 원하는 std 선택
	private Student selectStd(Lecture lecture) {
		System.out.print("성적을 입력할 학생의 학번을 입력하세요: ");
		String input = scanner.nextLine();
		
		// 일치하는 학번 있을 시 return the student
		if(lecture.getSignedStdList().containsKey(input)) {
			return lecture.getSignedStdList().get(input);
		} else {
			System.out.println("일치하는 학생의 학번이 없습니다.");
			return null;
		}
	}
	
	// 4-1. std의 성적 입력
	private void writeStdGrade(Lecture lecture, Student student) {
		try {
			System.out.print(student.getName() +" 학생의 성적을 입력하세요: ");
			int score = Integer.parseInt(scanner.nextLine());
			
			//성적의 범위(0~100점) 설정
			if(!(0 <= score && score <= 100)) {
				System.out.println("올바른 점수의 범위가 아닙니다.");
				System.out.println("0~100점 사이의 점수 입력");
			} else {
				student.getGradeMap().put(lecture.getLecName(), score);	
				System.out.println(student.getName() + " 학생 성적 입력 완료");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("잘못된 성적을 입력하였습니다.");
		}
	}
	// 4-2. std 성적 수정
	private void modifyStdGrade(Lecture lecture, Student student) {
		try {
			System.out.print(student.getName() +" 학생의 수정할 성적을 입력하세요: ");
			int score = Integer.parseInt(scanner.nextLine());
			
			//성적의 범위(0~100점) 설정
			if(!(0 <= score && score <= 100)) {
				System.out.println("올바른 점수의 범위가 아닙니다.");
				System.out.println("0~100점 사이의 점수 입력");
			} else {
				System.out.printf("%s 학생의 점수가 %d에서 %d로 변경되었습니다.\n",
									student.getName(),
									student.getGradeMap().get(lecture.getLecName()),
									score);
				student.getGradeMap().replace(lecture.getLecName(), score);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("잘못된 성적을 입력하였습니다.");
		}
	}
	
	// 4-3. std 성적 삭제(remove)
	private void delStdGrade(Lecture lecture, Student student) {
		try {
			System.out.println("삭제하시겠습니까?(Y:삭제 / N:보류");
			String input = scanner.nextLine();
			
			if(input.equalsIgnoreCase("Y")) {
				student.getGradeMap().remove(lecture.getLecName());	
				System.out.println(student.getName() + " 학생의 성적이 삭제되었습니다.");
			} else if(input.equalsIgnoreCase("N")) {
				System.out.println("보류되었습니다.");
			} else {
				System.out.println("잘못된 값을 입력하였습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// myLectures 조회
	public void showMyLectures() {
		System.out.println("==========내 강의 목록==========");
		for (Lecture lec : myLectures.values()) {
			System.out.println(lec.toString());
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
