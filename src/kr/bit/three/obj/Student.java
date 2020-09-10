package kr.bit.three.obj;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student extends PersonalInfo implements Serializable {

	/**
	 * Created-Date 20-09-09
	 * 
	 * @author 전선규
	 */
	private static final long serialVersionUID = 1L;
	
	private Scanner scanner;
	private Map<String, Integer> gradeMap;
	private Map<String, Lecture> myLectures;

	public Student(String name, String regId, String dept, String idNo, String phNo) {
		super(name, regId, dept, idNo, phNo);
		this.myLectures = new HashMap<String, Lecture>();
		this.gradeMap = new HashMap<String, Integer>();

		scanner = new Scanner(System.in);
	Map<Lecture, Grade> gradeMap; 
	
	//�닔媛� �떊泥�
	public void signUpLecture() {
		
	}

	private Scanner scanner;
	
	private Map<String, Lecture> myLectures;
	private Map<String, Integer> myGrades;
	
	public Student(String name, String regId, String dept, String idNo, String phNo) {
		super(name, regId, dept, idNo, phNo);
		this.myLectures = new HashMap<String, Lecture>();
		this.myGrades = new HashMap<String, Integer>();
	//�닔媛� 痍⑥냼
	public void dropLecture() {
		
		scanner = new Scanner(System.in);
	}

	private static final long serialVersionUID = 1L;
	
	// 수강 신청
	public void signUpLecture(Student student) {
		// 강의 목록 출력
		Admin.lecLookUp();

		// Lectures 배열에 담겨있는 강의 중 하나를 선택하여 myLectures에 추가
		// 선택 시에는 lecCode를 선택하여 추가

		// input: 학생이 선택한 강의코드
		System.out.print("수강 신청을 원하는 강의코드를 입력하세요: ");
		String input = scanner.nextLine();

		// lecture목록에서 사용자가 입력한 lecCode와 일치하는 lecture가 있는지 for문 실행
		for (Map.Entry lec : Admin.getLectures().entrySet()) {
			if (lec.getKey().equals(input)) { // 일치하는 lecCode가 있을 시 아래 실행
				myLectures.put((String) lec.getKey(), (Lecture) lec.getValue()); // 내 강의목록에 신청한 강의 추가

				Lecture signedStdList = (Lecture) lec.getValue();
				signedStdList.getSignedStdList().put(student.getRegId(), student); // 신청한 강의에 학생 추가
				break;
			}
		}

		// 일치하는 코드가 없으면 "일치하는 강의코드가 없음" 출력해야 함

	}

	// 수강 취소
	public void dropLecture(Student student) {
		// 내 강의 목록 출력
		showMyLectures();

		// input: 학생이 선택한 강의코드
		System.out.print("수강 취소를 원하는 강의코드를 입력하세요: ");
		String input = scanner.nextLine();

		// mylectures목록에서 사용자가 입력한 lecCode와 일치하는 lecture가 있는지 for문 실행
		for (Map.Entry lec : Admin.getLectures().entrySet()) {
			if (lec.getKey().equals(input)) { // 일치하는 lecCode가 있을 시 아래 실행
				myLectures.remove((String) lec.getKey()); // 내 강의목록에 신청한 강의 삭제

				Lecture signedStdList = (Lecture) lec.getValue();
				signedStdList.getSignedStdList().remove(student.getRegId()); // 신청한 강의에서 학생 삭제
				break;
			}
		}

		// 일치하는 코드가 없으면 "일치하는 강의코드가 없음" 출력해야 함

	}

	// 성적 확인
	//�꽦�쟻 �솗�씤
	public void checkGrade() {

	}

	// myLectures 조회
	private void showMyLectures() {
		for (Map.Entry lec : myLectures.entrySet()) {
			System.out.println(lec.getValue());
		}
	}

	// getter, setter
	public Map<String, Integer> getGradeMap() {
		return gradeMap;
		return myGrades;
	}

	@Override
	public String toString() {
		return "학번: " + getRegId() + "\t성명: " + getName()
		+ "\n주민번호: " + getIdNo()
		+ "\n소속학과: " + getDept() + "\t전화번호: " + getPhNo()
		+ "-----------------------";
	}
	
	
	
	
	
	
}