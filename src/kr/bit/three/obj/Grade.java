package kr.bit.three.obj;
import java.io.Serializable;

public class Grade implements Serializable {
	
	private Lecture lecture;  //Lecture 정보(강의코드, 강의명, (학생명), 담당교수명, 학기, 학점)
	private String stdName;
	
	public Grade(Lecture lecture, String stdName) {
		this.lecture = lecture;
		this.stdName = stdName;
	}
	
	
	
	
}
