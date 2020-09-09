package kr.bit.three.obj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Student extends PersonalInfo implements Serializable {
	private Scanner scanner;
	
	private List<Lecture> myLectures;
//	public Map<String, Lecture> myLectures = new HashMap<String, Lecture>();

	
	private Map<String, Integer> gradeMap;
	
	public Student(String name, String regId, String dept, String idNo, String phNo) {
		super(name, regId, dept, idNo, phNo);
		this.myLectures = new ArrayList<Lecture>();
		this.gradeMap = new HashMap<String, Integer>();
		
		
		scanner = new Scanner(System.in);
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//수강 신청
	public void signUpLecture(Student student) {
		//강의 목록 출력
		Admin.lecLookUp();
		
		//Lectures 배열에 담겨있는 강의 중 하나를 선택하여 myLectures에 추가
		//선택 시에는 lecCode를 선택하여 추가
		
		//input: 학생이 선택한 강의코드
		System.out.print("수강 신청을 원하는 강의코드를 입력하세요: ");
		String input = scanner.nextLine();
		
		//lecture목록에서 사용자가 입력한 lecCode와 일치하는 lecture가 있는지 for문 실행
		
		
		for(Lecture lecture : Admin.getLectures()) {
			if(lecture.getLecCode().equals(input)) { //일치하는 lecCode가 있을 시 아래 실행
				myLectures.add(lecture); 			   //내 강의목록에 신청한 강의 추가
				lecture.addStd(student);			   //신청한 강의에 학생 추가
				break;
			}
		}
		
		//일치하는 코드가 없으면 "일치하는 강의코드가 없음" 출력해야 함
		
	}
	
	//수강 취소
	public void dropLecture(Student student) {
		//내 강의 목록 출력
		showMyLectures();
		
		//input: 학생이 선택한 강의코드
		System.out.print("수강 취소를 원하는 강의코드를 입력하세요: ");
		String input = scanner.nextLine();
		
		//mylectures목록에서 사용자가 입력한 lecCode와 일치하는 lecture가 있는지 for문 실행
		for(Lecture lecture : myLectures) {
			if(lecture.getLecCode().equals(input)) { //일치하는 lecCode가 있을 시 아래 실행
				myLectures.remove(lecture); 		   //내 강의목록에 신청한 강의 삭제
				lecture.subStd(student);			   //신청한 강의에서 학생 삭제
				break;
			}
		}
		
		//일치하는 코드가 없으면 "일치하는 강의코드가 없음" 출력해야 함
		
	}
	
	//성적 확인
	public void checkGrade() {
		
		
	}
	
	//myLectures 조회
	private void showMyLectures() {
		Iterator it = myLectures.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	//getter, setter
	public Map<String, Integer> getGradeMap() {
		return gradeMap;
	}


	@Override
	public String toString() {
		return "Student [name()=" + getName() + ", regId()=" + getRegId() + ", dept()=" + getDept()
				+ ", idNo()=" + getIdNo() + ", phNo()=" + getPhNo() + "]";
	}
	
	
	
	
	
}