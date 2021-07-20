package model;

import java.util.HashMap;

public class MarksRecord {
	private String name, className, section, _id;
	private int attendance;
	private HashMap<String,HashMap<String,Integer>> subjectMarks;
	
	public MarksRecord(String name, String className, String section, String _id,
			HashMap<String, HashMap<String, Integer>> subjectMarks) {
		super();
		this.name = name;
		this.className = className;
		this.section = section;
		this._id = _id;
		this.subjectMarks = subjectMarks;
		//this.attendance = attendance;
	}
	
//	public int get_attendance() {
//		return attendance;
//	}
//	public void set_attendance(int attendance) {
//		this.attendance = attendance;
//	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public HashMap<String, HashMap<String, Integer>> getSubjectMarks() {
		return subjectMarks;
	}
	public void setSubjectMarks(HashMap<String, HashMap<String, Integer>> subjectMarks) {
		this.subjectMarks = subjectMarks;
	}
	
}
