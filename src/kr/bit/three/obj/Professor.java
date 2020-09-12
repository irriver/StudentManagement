package kr.bit.three.obj;

import java.io.Serializable;
import java.util.Map;

public class Professor extends PersonalInfo implements Serializable {

	public Professor(String name, String regId, String dept, String idNo, String phNo) {
		super(name, regId, dept, idNo, phNo);
	}

	// 성적 입력
	public void writeGrade() {
		try {
			//1.myLecture 선택
			//강의 코드 입력하지 않을 시 return
			Lecture lecture = selectMyLecture();
			if(lecture.equals(null)) return;
			
			// 2.myLecture가 가지고 있는 stdList 출력
			getStdList(lecture);

			// 3.stdList에서 성적 입력을 원하는 std 선택
			// 일치하는 std 없을 시 return
			Student student = selectStd(lecture);
			if(student.equals(null)) return;
			
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
			//1.myLecture 선택
			//강의 코드 입력하지 않을 시 return
			Lecture lecture = selectMyLecture();
			if(lecture.equals(null)) return;
			
			// 2.myLecture가 가지고 있는 stdList 출력
			getStdList(lecture);
			
			// 3.stdList에서 성적 수정을 원하는 std 선택
			// 일치하는 std 없을 시 return
			Student student = selectStd(lecture);
			if(student.equals(null)) return;
			
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
			//1.myLecture 선택
			//강의 코드 입력하지 않을 시 return
			Lecture lecture = selectMyLecture();
			if(lecture.equals(null)) return;
			
			// 2.myLecture가 가지고 있는 stdList 출력
			getStdList(lecture);
			
			// 3.stdList에서 성적 삭제를 원하는 std 선택
			// 일치하는 std 없을 시 return
			Student student = selectStd(lecture);
			if(student.equals(null)) return;
			
			// 4-3.std 성적 삭제
			delStdGrade(lecture, student); 
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
		while(true) {
			System.out.print("성적 입력을 원하는 강의 코드를 입력하세요(이전 메뉴:0): ");
			String lecCode = scanner.nextLine();
			
			// 일치하는 코드 있을 시 return the lecture;
			if(getMyLectures().containsKey(lecCode)) {
				return getMyLectures().get(lecCode);
			} else if(lecCode.equals("0")) {
				break;
			} else {
				System.out.println("일치하는 강의 코드가 없습니다.");
			}
		}
		return null;
	}

	// 2.myLecture가 가지고 있는 stdList 출력
	private void getStdList(Lecture lecture) {
		System.out.println(lecture.getLecName() + "강의를 수강하는 학생 명단");
		System.out.println(lecture.getSignedStdList().values().toString());
	}

	// 3.stdList에서 성적 입력을 원하는 std 선택
	private Student selectStd(Lecture lecture) {
		System.out.print("성적을 입력할 학생의 학번을 입력하세요: ");
		String stdID = scanner.nextLine();
		
		// 일치하는 학번 있을 시 return the student
		if(lecture.getSignedStdList().containsKey(stdID)) {
			return lecture.getSignedStdList().get(stdID);
		} else {
			System.out.println("일치하는 학생의 학번이 없습니다.");
			return null;
		}
	}
	
	// 4-1. std의 성적 입력
	private void writeStdGrade(Lecture lecture, Student student) {
		try {
			System.out.print(student.getName() +" 학생의 성적을 입력하세요: ");
			int score = Integer.parseInt(scanner.nextLine().trim());
			
			//성적의 범위(0~100점) 설정
			//해당 과목의 학생 성적이 등록되어 있는지 확인
			if(!(0 <= score && score <= 100)) {
				System.out.println("올바른 점수의 범위가 아닙니다.");
				System.out.println("0~100점 사이의 점수 입력");
			} else {
				if(student.getGradeMap().containsKey(lecture.getLecName())) {
					System.out.println("이미 성적을 등록한 학생입니다.");
				} else {
					student.getGradeMap().put(lecture.getLecName(), score);	
					System.out.println(student.getName() + " 학생 성적 입력 완료");					
				}
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
		for (Lecture lec : getMyLectures().values()) {
			System.out.println(lec.toString());
		}
	}
	
	//getter
	public Map<String, Lecture> getMyLectures() {
		return getMyLectures();
	}

	@Override
	public String toString() {
		String profInfo = "교번: " + getRegId()
						+ "\t성명: " + getName()
						+ "\t주민번호: " + getIdNo()
						+ "\t소속학과: " + getDept()
						+ "\t전화번호: " + getPhNo()
						+ "\n";
		return profInfo;
	}
}
