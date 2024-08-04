package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student extends User {
	
	private  String student_id;
	private  String student_name;
	
	Student(String student_id , String student_name){
		this.student_id = student_id;
		this.student_name = student_name;
	}
	Student(String student_id){
		this.student_id = student_id;
	}
	Student(){
		
	}
	
	public void getGrade(String course_name) {	
		Grade grade = new Grade(this.student_id,course_name);
		grade.getGrade();
	}
	
	public void makeSurvey(String course_name) {
		Feedback feedback = new Feedback(this.student_name,course_name);
		feedback.makeSurvey();
	}
	
	public void readAllSurvey(String course_name) {
		Feedback feedback = new Feedback(course_name);
		feedback.readAllSurvey();
	}
	
	public void MyInfo() {
		UserInfo info = new UserInfo(this.student_id);
		info.Myinfo();
	}
	
	public void UpdateInfo() {
		UserInfo info = new UserInfo(this.student_id);
		info.UpdateMyInfo();
	}
	
	public void showAllCourses() {
		Course c = new Course();
		try {
			c.showAllCourses();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
