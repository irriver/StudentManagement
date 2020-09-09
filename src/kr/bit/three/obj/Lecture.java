package kr.bit.three.obj;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Lecture implements Serializable {
	
	private String lecName;
	private String lecCode;
	private String profName;
	private int times;
	private String semester;
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
	
	//수강인원 추가(학생명단에 신청학생 추가)
		public void addStd(Student student) {
			if(signedStdList.size() < maxStd) {
				signedStdList.put(student.getRegId(), student);
			} else {
				System.out.println("수강인원을 초과했습니다. 다른 강의를 신청해주세요.");
			}
		}
		
		//수강인원 삭제(학생명단에서 학생 삭제)
		public void subStd(Student student) {
			if(!signedStdList.isEmpty() && signedStdList.containsKey(student.getRegId())) {
				signedStdList.remove(student.getRegId());
			} else {
				System.out.println("수강학생 목록에 없습니다.");
			}
		}
		
		//해당 강의를 수강신청한 학생 목록 출력
		public void showSignedStdList() {
			for(Map.Entry student : signedStdList.entrySet()) {
				System.out.println(student.getValue());
			}
		}
		
		//getter, setter
		public String getLecCode() {
			return lecCode;
		}
		public String getLecName() {
			return lecName;
		}
		public Map<String, Student> getSignedStdList() {
			return signedStdList;
		}

		
		@Override
		public String toString() {
			return "Lecture [lecCode=" + lecCode + ", lecName=" + lecName + ", profName=" + profName + ", semester="
					+ semester + ", times=" + times + ", singedStdNum=" + signedStdList.size() + ", maxStd=" + maxStd + "]";
		}
}
