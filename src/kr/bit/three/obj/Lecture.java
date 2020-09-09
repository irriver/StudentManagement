package kr.bit.three.obj;
import java.io.Serializable;

public class Lecture implements Serializable {
	
	private String lecCode;
	private String lecName;
	private String professor;
	private String semester;
	private int times;
	private int	numOfStd;
	private int maxStd;
	
	@Override
	public String toString() {
		return "Lecture [lecCOde=" + lecCode + ", lecName=" + lecName + ", professor=" + professor + ", semester="
				+ semester + ", times=" + times + ", maxStd=" + maxStd + "]";
	}

	
	public void addNumOfStd() {
		if(numOfStd < maxStd) {
			numOfStd++;
		} else {
			System.out.println("수강인원을 초과했습니다. 다른 강의를 신청해주세요.");
		}
	}
	
	public void subNumOfStd() {
		numOfStd--;
	}
	
	//getter, setter
	public String getLecCode() {
		return lecCode;
	}
	
	
}
