package kr.bit.three.obj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin implements Serializable {

	/**
	 * version 2.00
	 * Created 20-09-08
	 * Updated 20-09-13
	 * 
	 * @author 안가람, 전선규
	 */

	private static final long serialVersionUID = 1L;

	private Scanner input;
	private static Map<String, Student> students;
	private Map<String, Professor> professors;
	private static Map<String, Lecture> lectures;
	private String path = "C:\\Temp\\StdManagement\\";
	private String typeCode;

	private static Admin admin = null;

	public static Admin getInstance() {
		if (admin == null) {
			admin = new Admin();
		}
		return admin;
	}

	public Admin() {
		input = new Scanner(System.in);
		students = new HashMap<String, Student>();
		professors = new HashMap<String, Professor>();
		lectures = new HashMap<String, Lecture>();
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

//----------------------------- 데이터 저장 -----------------------------

	// 학번을 넘겨받아 파일에 데이터 기록
	public void storeData(Student student) {
		String idToSave = student.getRegId();
		File fDir = new File(path + typeCode);

		try {
			File newFile = new File(path + typeCode + idToSave + ".txt");
			if (!newFile.exists()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

				bw.write(students.get(idToSave).getName() + ",");
				bw.write(students.get(idToSave).getRegId() + ",");
				bw.write(students.get(idToSave).getDept() + ",");
				bw.write(students.get(idToSave).getIdNo() + ",");
				bw.write(students.get(idToSave).getPhNo());

				bw.close();
			} else {
				System.out.println("이미 존재하는 파일 입니다.");
				return;
			}
			System.out.println(students.get(idToSave).toString());
			System.out.println("입력하신 데이터가 저장됐습니다.");
			return;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void storeData(Professor professor) {
		String idToSave = professor.getRegId();
		File fDir = new File(path + typeCode);

		try {
			File newFile = new File(path + typeCode + idToSave + ".txt");

			if (!newFile.exists()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

				bw.write(professors.get(idToSave).getName() + ",");
				bw.write(professors.get(idToSave).getRegId() + ",");
				bw.write(professors.get(idToSave).getDept() + ",");
				bw.write(professors.get(idToSave).getIdNo() + ",");
				bw.write(professors.get(idToSave).getPhNo());

				bw.close();
			} else {
				System.out.println("이미 존재하는 파일 입니다.");
				return;
			}
			// 기록한 데이터 콘솔 출력
			System.out.println(professors.get(idToSave).toString());
			System.out.println("입력하신 데이터가 저장됐습니다.");
			return;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void storeData(Lecture lecture) {
		String idToSave = lecture.getLecCode();
		File fDir = new File(path + typeCode);

		try {
			File newFile = new File(path + typeCode + idToSave + ".txt");

			if (!newFile.exists()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

				bw.write(lectures.get(idToSave).getLecName() + ",");
				bw.write(lectures.get(idToSave).getProfName() + ",");
				bw.write(lectures.get(idToSave).getSemester() + ",");
				bw.write(lectures.get(idToSave).getTimes() + ",");
				bw.write(lectures.get(idToSave).getMaxStd() + ",");
				bw.write(lectures.get(idToSave).getSignedStdList().toString());

				bw.close();
			} else {
				System.out.println("이미 존재하는 파일 입니다.");
				return;
			}
			// 기록한 데이터 콘솔 출력
			System.out.println(lectures.get(idToSave).toString());
			System.out.println("입력하신 데이터가 저장됐습니다.");
			return;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//----------------------------- 데이터 수정 -----------------------------

	public void editData(Student student) {
		String key = student.getRegId();
		File file = new File(path + typeCode + key + ".txt");

		try {
			if (file.exists()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));

				bw.write(students.get(key).getName() + ",");
				bw.write(students.get(key).getRegId() + ",");
				bw.write(students.get(key).getDept() + ",");
				bw.write(students.get(key).getIdNo() + ",");
				bw.write(students.get(key).getPhNo());

				bw.close();
			} else {
				System.out.println("수정하려는 파일이 존재하지 않습니다.");
				return;
			}
			// 기록한 데이터 콘솔 출력
			System.out.println(students.get(key).toString());
			return;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void editData(Professor professor) {
		String key = professor.getRegId();
		File file = new File(path + typeCode + key + ".txt");

		try {
			if (file.exists()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));

				bw.write(professors.get(key).getName() + ",");
				bw.write(professors.get(key).getRegId() + ",");
				bw.write(professors.get(key).getDept() + ",");
				bw.write(professors.get(key).getIdNo() + ",");
				bw.write(professors.get(key).getPhNo());

				bw.close();
			} else {
				System.out.println("수정하려는 파일이 존재하지 않습니다.");
				return;
			}
			// 기록한 데이터 콘솔 출력
			System.out.println(professors.get(key).toString());
			return;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void editData(Lecture lecture) {
		String key = lecture.getLecCode();
		File file = new File(path + typeCode + key + ".txt");

		try {
			if (file.exists()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));

				bw.write(lectures.get(key).getLecName() + ",");
				bw.write(lectures.get(key).getProfName() + ",");
				bw.write(lectures.get(key).getSemester() + ",");
				bw.write(lectures.get(key).getTimes() + ",");
				bw.write(lectures.get(key).getMaxStd() + ",");
				bw.write(lectures.get(key).getSignedStdList().toString());

				bw.close();
			} else {
				System.out.println("수정하려는 파일이 존재하지 않습니다.");
				return;
			}
			// 기록한 데이터 콘솔 출력
			System.out.println(lectures.get(key).toString());
			return;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//----------------------------- 데이터 불러오기 -----------------------------

	public void readData(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//---------------------------- 학생 관련 업무 ------------------------------

	public Student stdRegister() {
		Student stdToReg = null;

		System.out.println("등록할 학생의 이름 입력 >> ");
		String name = input.nextLine().trim();

		System.out.println("등록할 학생의 학번 입력 >> ");
		String regId = input.nextLine().trim();

		System.out.println("등록할 학생의 학과 입력 >> ");
		String dept = input.nextLine().trim();

		System.out.println("등록할 학생의 주민 번호 입력 >> ");
		String idNo = input.nextLine().trim();

		System.out.println("등록할 학생의 전화번호 입력 >> ");
		String phNo = input.nextLine().trim();

		Student newStd = new Student(name, regId, dept, idNo, phNo);

		// 등록할 학생의 학번이 이미 있는지 확인 >> Map에서 키가 있는지 조회
		if (!students.containsKey(regId)) {
			students.put(regId, newStd);
			stdToReg = newStd;
		} else {
			System.out.println("이미 등록된 학번입니다.");
		}
		return stdToReg;
	}

	// 기존 학생 정보 수정 >> 학과, 전화번호
	public Student stdModify() {
		Student modifiedStd = null;

		System.out.println("수정할 학생의 학번 입력");
		String regId = input.nextLine().trim();

		if (students.containsKey(regId)) {
			System.out.println("수정하실 학과명을 입력 >> ");
			String newDept = input.nextLine().trim();

			System.out.println("수정하실 전화번호를 입력 >> ");
			String newPhNo = input.nextLine().trim();

			students.get(regId).setDept(newDept);
			students.get(regId).setPhNo(newPhNo);

			modifiedStd = students.get(regId);
			students.put(regId, modifiedStd);

		} else {
			System.out.println("입력하신 학번이 잘못 됐습니다.");
			stdModify();
		}
		return modifiedStd;
	}

	// 학생 전체 목록 조회
	public void print() {
		String pattern = this.typeCode;

		String fileList[] = new File(path).list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith(typeCode);
			}
		});

		for (String fileName : fileList) {
			readData(new File(path + fileName));
		}
	}

//---------------------------- 교수 관련 업무 ------------------------------

	public Professor profRegister() {
		Professor profToReg = null;

		System.out.println("등록할 교수의 이름 입력 >> ");
		String name = input.nextLine().trim();

		System.out.println("등록할 교수의 교번 입력 >> ");
		String regId = input.nextLine().trim();

		System.out.println("등록할 교수의 학과 입력 >> ");
		String dept = input.nextLine().trim();

		System.out.println("등록할 교수의 주민 번호 입력 >> ");
		String idNo = input.nextLine().trim();

		System.out.println("등록할 교수의 전화번호 입력 >> ");
		String phNo = input.nextLine().trim();

		Professor newProf = new Professor(name, regId, dept, idNo, phNo);

		professors = new HashMap<String, Professor>();

		if (!professors.containsKey(regId)) {
			professors.put(regId, newProf);
			profToReg = newProf;
		} else {
			System.out.println("이미 등록된 교수입니다.");
			profModify();
		}
		return newProf;
	}

	// 교수 정보 수정 >> 학과, 전화번호
	public Professor profModify() {
		Professor modifiedProf = null;

		System.out.println("수정할 교수의 교번을 입력");
		String regId = input.nextLine().trim();

		if (professors.containsKey(regId)) {

			System.out.println("수정하실 학과명을 입력 >> ");
			String newDept = input.nextLine().trim();

			System.out.println("수정하실 전화번호를 입력 >> ");
			String newPhNo = input.nextLine().trim();

			professors.get(regId).setDept(newDept);
			professors.get(regId).setPhNo(newPhNo);

			modifiedProf = professors.get(regId);
			professors.put(regId, modifiedProf);
		} else {
			System.out.println("입력하신 교번이 존재하지 않습니다.");
			profModify();
		}
		return modifiedProf;
	}

	// 교수 전체 목록 출력
	public void profLookUp() {
		System.out.println("전체 교수 목록을 조회합니다.");
		for (Professor eachProf : professors.values()) {
			System.out.println(eachProf.toString());
		}
	}

	// ---------------------------- 강의 관련 업무 ------------------------------

	public Lecture lecRegister() {
		Lecture regLecture = null;

		// 강의는 동일 강좌가 개설될 수 있으므로 중복 체크 하지 않음
		System.out.println("등록할 강의의 등록 코드 입력 >> ");
		String lecCode = input.nextLine().trim();

		System.out.println("등록할 강의명 입력 >> ");
		String lecName = input.nextLine().trim();

		System.out.println("등록할 강의의 담당 교수 입력 >> ");
		String profName = input.nextLine().trim();

		System.out.println("등록할 강의의 개설 학기 입력 >> ");
		String semester = input.nextLine().trim();

		System.out.println("등록할 강의의 학점  입력 >> ");
		int times = input.nextInt();

		System.out.println("등록할 강의의 수강 인원 입력 >> ");
		int maxStd = input.nextInt();

		Lecture newLec = new Lecture(lecCode, lecName, profName, semester, times, maxStd);
		lectures.put(lecCode, newLec);

		regLecture = newLec;
		// Professor 클래스 myLecturs에도 추가
		for (Professor professor : professors.values()) {
			if (professor.getName().equals(profName)) {
				professor.getMyLectures().put(lecCode, newLec);
				professor.saveMyLectures();
			}
		}
		return regLecture;

	}

	public Lecture lecModify() {
		Lecture modifiedLec = null;

		System.out.println("수정을 원하는 강의의 코드를 입력하세요.");
		String lecCode = input.nextLine().trim();

		if (lectures.containsKey(lecCode)) {

			System.out.println("수정할 강의명 입력 >> ");
			String lecName = input.nextLine().trim();

			System.out.println("수정할 강의의 담당 교수 입력 >> ");
			String profName = input.nextLine().trim();

			System.out.println("수정할 강의의 개설 학기 입력 >> ");
			String semester = input.nextLine().trim();

			System.out.println("수정할 강의의 학점  입력 >> ");
			int times = input.nextInt();

			System.out.println("수정할 강의의 수강 인원 입력 >> ");
			int maxStd = input.nextInt();

			lectures.get(lecCode).setLecName(lecName);
			lectures.get(lecCode).setProfName(profName);
			lectures.get(lecCode).setSemester(semester);
			lectures.get(lecCode).setTimes(times);
			lectures.get(lecCode).setMaxStd(maxStd);

			modifiedLec = lectures.get(lecCode);
			lectures.put(lecCode, modifiedLec);
		} else {
			System.out.println("입력하신 강의코드가 잘못 됐습니다.");
			lecModify();
		}
		return modifiedLec;
	}

	public static void lecLookUp() {
		for (Lecture eachLec : lectures.values()) {
			System.out.println(eachLec.toString());
		}
	}

	public static Map<String, Lecture> getLectures() {
		return lectures;
	}

	public Map<String, Student> getStudents() {
		return students;
	}

	public Map<String, Professor> getProfessors() {
		return professors;
	}

}