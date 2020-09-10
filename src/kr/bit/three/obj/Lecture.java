package kr.bit.three.obj;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Lecture implements Serializable {

	private String lecCode;
	private String lecName;
	private String profName;
	private String semester;
	private int times;
	private int maxStd;
	private Map<String, Student> signedStdList;

	public Lecture(String lecCode, String lecName, String profName, String semester, int times, int maxStd) {
		super();
		this.lecCode = lecCode;
		this.lecName = lecName;
		this.profName = profName;
		this.semester = semester;
		this.times = times;
		this.maxStd = maxStd;

		this.signedStdList = new HashMap<String, Student>();
	}

	// 수강인원 추가(학생명단에 신청학생 추가)
	public void addStd(Student student) {
		if (signedStdList.size() < maxStd) {
			signedStdList.put(student.getRegId(), student);
		} else {
			System.out.println("수강인원을 초과했습니다. 다른 강의를 신청해주세요.");
		}
	}

	// 수강인원 삭제(학생명단에서 학생 삭제)
	public void subStd(Student student) {
		if (!signedStdList.isEmpty() && signedStdList.containsKey(student.getRegId())) {
			signedStdList.remove(student.getRegId());
		} else {
			System.out.println("수강학생 목록에 없습니다.");
		}
	}

	// 해당 강의를 수강신청한 학생 목록 출력
	public void showSignedStdList() {
		for (Map.Entry student : signedStdList.entrySet()) {
			System.out.println(student.getValue());
		}
	}

	// getter
	public String getLecCode() {
		return lecCode;
	}

	public String getLecName() {
		return lecName;
	}

	public Map<String, Student> getSignedStdList() {
		return signedStdList;
	}

	public String getProfName() {
		return profName;
	}

	public int getTimes() {
		return times;
	}

	public String getSemester() {
		return semester;
	}

	public int getMaxStd() {
		return maxStd;
	}

	// setter
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}

	public void setLecCode(String lecCode) {
		this.lecCode = lecCode;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public void setMaxStd(int maxStd) {
		this.maxStd = maxStd;
	}

	public void setSignedStdList(Map<String, Student> signedStdList) {
		this.signedStdList = signedStdList;
	}

	@Override
	public String toString() {
		return "강의코드: " + getLecCode() 
		+ "\t\t강의명: " + getLecName() 
		+ "\n담당교수: " + getProfName() 
		+ "\t개설학기: " + getSemester() 
		+ "\t학점: " + getTimes() 
		+ "\t수강인원: " + getMaxStd();
	}
}
