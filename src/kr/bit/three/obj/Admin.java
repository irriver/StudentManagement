package kr.bit.three.obj;
import java.util.Iterator;
import java.util.List;

public class Admin {
	
	private List<Student> students;
	private List<Professor> professors;
	private static List<Lecture> lectures;
//	private List<Grade> grades;
	
	public void stdRegister() {}
	
	public void stdModify() {}
	
	public void stdLookUp() {}
	
	public void profRegister() {
		//회원가입에서 객체를 생성해주지 않을까?
	}
		
	
	public void profModify() {}
	
	public void profLookUp() {}
	
	public void lecRegister(Lecture lecture) {}
	

	public void lecModify() {}
	
	public static void lecLookUp() {
		Iterator it = lectures.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	//getter
	public static List<Lecture> getLectures() {
		return lectures;
	}

	
	
}