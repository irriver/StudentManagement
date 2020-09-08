package kr.bit.three.obj;
import java.io.Serializable;

public class Grade implements Serializable {
	
	private String lecId;
	private Student student;
	private Professor professor;
	private String semester;
	private int score;
	private int times;
	
	public String getLecId() {
		return lecId;
	}
	public void setLecId(String lecId) {
		this.lecId = lecId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	@Override
	public String toString() {
		return "Grade [lecId=" + lecId + ", student=" + student + ", professor=" + professor + ", semester=" + semester
				+ ", score=" + score + ", times=" + times + "]";
	}
}
