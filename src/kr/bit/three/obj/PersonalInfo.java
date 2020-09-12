package kr.bit.three.obj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonalInfo {
	private String name;
	private String regId;
	private String dept;
	private String idNo;
	private String phNo;
	private Map<String, Lecture> myLectures;
	public Scanner scanner;
	
	public PersonalInfo(String name, String regId, String dept, String idNo, String phNo) {
		super();
		this.name = name;
		this.regId = regId;
		this.dept = dept;
		this.idNo = idNo;
		this.phNo = phNo;
		this.myLectures = new HashMap<String, Lecture>();
		this.scanner = new Scanner(System.in);
	}
	
	public String getName() { return name; }
	public String getRegId() { return regId;}
	public String getDept() { return dept; }
	public String getIdNo() { return idNo; }
	public String getPhNo() { return phNo; }
	public Map<String, Lecture> getMyLectures() { return myLectures; }
	public Scanner getScanner() { return scanner; }
}