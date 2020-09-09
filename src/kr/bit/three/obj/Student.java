package kr.bit.three.obj;
import java.io.Serializable;
import java.util.Map;

public class Student extends PersonalInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Map<Lecture, Grade> gradeMap; 
	
	//수강 신청
	public void signUpLecture() {
		
	}
	
	//수강 취소
	public void dropLecture() {
		
	}
	
	//성적 확인
	public void checkGrade() {
		
		
	}
}