package kr.bit.three.obj;

public class PersonalInfo {
	
	private String name;
	private String regId;
	private String dept;
	private String idNo;
	private String phNo;
	
	//Constructor
	public PersonalInfo(String name, String regId, String dept, String idNo, String phNo) {
		super();
		this.name = name;
		this.regId = regId;
		this.dept = dept;
		this.idNo = idNo;
		this.phNo = phNo;
	}
<<<<<<< HEAD
	
=======

>>>>>>> 18a04930881ce0633350018e51928745dd77e3c2
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	
	@Override
	public String toString() {
		return "PersonalInfo [name=" + name + ", regId=" + regId + ", dept=" + dept + ", idNo=" + idNo + ", phNo="
				+ phNo + "]";
	}
}