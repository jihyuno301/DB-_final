package net.skhu.dto;

public class MyCell {
	String id; // id로 찾기 위해
	int year;
	String semester;
	String subjectId;
	String subjectName;
	String completeType;
	int subjectScore ;
	String grade;
	
	public String getId() {
		return id; 
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getCompleteType() {
		return completeType;
	}
	public void setCompleteType(String completeType) {
		this.completeType = completeType;
	}
	public int getSubjectScore() {
		return subjectScore;
	}
	public void setSubjectScore(int subjectScore) {
		this.subjectScore = subjectScore;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
