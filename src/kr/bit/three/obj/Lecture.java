package kr.bit.three.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
			saveSignedStdList();
		} else {
			System.out.println("수강인원을 초과했습니다. 다른 강의를 신청해주세요.");
		}
	}

	// 수강인원 삭제(학생명단에서 학생 삭제)
	public void subStd(Student student) {
		if (!signedStdList.isEmpty() && signedStdList.containsKey(student.getRegId())) {
			signedStdList.remove(student.getRegId());
			saveSignedStdList();
		} else {
			System.out.println("수강학생 목록에 없습니다.");
		}
	}

	// 해당 강의를 수강신청한 학생 목록 출력
	public void showSignedStdList() {
		for (Map.Entry student : loadSignedStdList().entrySet()) {
			System.out.println(student.getValue());
		}
	}
	
	//signedStdList 데이터 save(직렬화)
	private void saveSignedStdList() {
		File file = new File("C:\\Temp\\StdManagement\\" + lecCode + ".txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(signedStdList);
			
			oos.close();
			fos.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("signedStdList 저장 완료");
	}
	
	//signedStdList 데이터 load(역직렬화)
	private HashMap<String, Student> loadSignedStdList() {
		FileInputStream fis = null;
		ObjectInputStream oos = null;
		HashMap<String, Student> data = null;
		
		try{
			File file = new File("C:\\Temp\\StdManagement\\" + lecCode + ".txt");
			fis = new FileInputStream(file);
			oos = new ObjectInputStream(fis);
			data = (HashMap)oos.readObject();
		}catch(Exception e){
			System.out.println("불러오는 데 실패하였습니다.");
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	// getter
	public String getLecCode() { return lecCode; }
	public String getLecName() { return lecName; }
	public Map<String, Student> getSignedStdList() { return signedStdList; }
	public String getProfName() { return profName; }
	public int getTimes() { return times; }
	public String getSemester() { return semester; }
	public int getMaxStd() { return maxStd; }
	
	// setter
	public void setLecName(String lecName) { this.lecName = lecName; }
	public void setLecCode(String lecCode) { this.lecCode = lecCode; }
	public void setProfName(String profName) { this.profName = profName; }
	public void setTimes(int times) { this.times = times; }
	public void setSemester(String semester) { this.semester = semester; }
	public void setMaxStd(int maxStd) { this.maxStd = maxStd; }
	public void setSignedStdList(Map<String, Student> signedStdList) { this.signedStdList = signedStdList; }
	
	@Override
	public String toString() {
		return "강의코드: " + lecCode
		+ "\t강의명: " + lecName
		+ "\n담당교수: " + profName
		+ "\t개설학기: " + semester
		+ "\t학점: " + times
		+ "\t수강인원: " + signedStdList.size();
	}


}
