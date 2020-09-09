package kr.bit.three.obj;
import java.io.Serializable;
import java.util.Map;

public class Student extends PersonalInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Map<Lecture, Grade> gradeMap; 
	
	public boolean isExist(Student student) {
		return (student.getRegId() != null) ? true : false; 
	}
	
	//�닔媛� �떊泥�
	public void signUpLecture() {
		
	}
	
	//�닔媛� 痍⑥냼
	public void dropLecture() {
		
	}
	
	//�꽦�쟻 �솗�씤
	public void checkGrade() {
		
		
	}
}