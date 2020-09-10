package kr.bit.three.obj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Admin {
	
	private Map<String, Student> students;
	private Map<String, Professor> professors;
	private static Map<String, Lecture> lectures;
	
	Admin() {
		students = new HashMap<String, Student>();
		professors = new HashMap<String, Professor>();
		lectures = new HashMap<String, Lecture>();
	}
	
	public void stdRegister() {}
	
	public void stdModify() {}
	
	public void stdLookUp() {}
	
	public void profRegister() {}
		
	
	public void profModify() {}
	
	public void profLookUp() {}
	
	public void lecRegister(Lecture lecture) {}
	

	public void lecModify() {}
	
	public static void lecLookUp() {
		for(Map.Entry lecture : lectures.entrySet()) {
			System.out.println(lecture.getValue());
		}
	}

	//getter
	public static Map<String, Lecture> getLectures() {
		return lectures;
	}

	
	
	
	
}