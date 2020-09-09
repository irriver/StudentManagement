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
	
	public void profRegister() {}
	
	public void profModify() {}
	
	public void profLookUp() {}
	
	public void lecRegister() {}
	
	public void lecModify() {}
	
	public void lecLookUp() {}
	
	//getter
	public static List<Lecture> getLectures() {
		Iterator it = lectures.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		return lectures;
	}
	
	
}