package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Instructor extends User {

	private String instructor_id;
	private String instructor_name;
	
	
	public void addGrade(String course_name) {
		Grade grade = new Grade(course_name);
		grade.addGrade();
	}
	
	public void publishGrades(String course_name)  {
		Grade grade = new Grade(course_name);
		grade.publishGrades();
	}
	
	public void viewGrades(String course_name) {
		Grade grade = new Grade(course_name);
		grade.viewGrades();
	}
	
	public void readAllSurvey(String course_name) {
		Feedback feedback = new Feedback(course_name);
		feedback.readAllSurvey();
	}
}
