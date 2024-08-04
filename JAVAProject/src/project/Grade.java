package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Grade {

	private String course_name;
	private String student_id;
	
	Grade(String student_id,String course_name){
		this.student_id = student_id;
		this.course_name = course_name;
	}
	Grade(String course_name){
		this.course_name = course_name;
	}
	Grade(){
		
	}
	
	public void addGrade() {
		if(this.course_name == null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the name of the course : ");
			this.course_name = scan.nextLine();
		}
		String std_id;
		int std_grade;
		Scanner scan = new Scanner(System.in);
		this.course_name = this.course_name.toUpperCase();
		System.out.print("Enter the student ID : ");
		std_id = scan.nextLine();
		//
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("Students.txt"));
			String line;
			boolean flag = false;
	        while ((line = br.readLine()) != null) {
	        	if(line.equals(std_id)) {
	        		flag = true;
	        	}
	        }
	        if(!flag) {
	        	System.out.println("There is no student with this ID !");
	        	return;
	        }
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
        //
		System.out.print("Enter the student Grade (from 100) : ");
		while(true) {
			if(scan.hasNextInt()) {
				std_grade = scan.nextInt();
				if(std_grade>=0 && std_grade<=100) {
					break;
				}
				else {
					System.out.print("ERROR : Invalid number , please enter grade between 0 and 100 : ");
				}
			}
			else {
				System.out.print("ERROR : Invalid input please enter only number : ");
				scan.next();
			}	
		}
	
		FileHandler f = new FileHandler();
		String content = "ID : "+std_id+"\nGrade : "+std_grade+"/100\n_______________________________";
		f.storeFile(this.course_name+"-gradesTmp.txt", content);
		
	}
	
	public void publishGrades() {
		if(this.course_name == null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the name of the course : ");
			this.course_name = scan.nextLine();
		}
		this.course_name = this.course_name.toUpperCase();

		FileHandler file = new FileHandler();
		if(!file.searchFile(this.course_name+"-gradesTmp.txt")) {
			System.out.println("There is no grades for this course !");
			return;
		}
		
		try {

			BufferedReader br = new BufferedReader(new FileReader(this.course_name+"-gradesTmp.txt"));
			String line;
            while ((line = br.readLine()) != null) {
            	file.storeFile(this.course_name+"-grades.txt", line);
            }
			
            br.close();
			System.out.println(this.course_name+" Grades is published");
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
		file.deleteFile(this.course_name+"-gradesTmp.txt");
	}
		
	public void viewGrades() {
		if(this.course_name == null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the name of the course : ");
			this.course_name = scan.nextLine();
		}
		this.course_name = this.course_name.toUpperCase();

		FileHandler file = new FileHandler();
		if(!file.searchFile(this.course_name+"-grades.txt")) {
			System.out.println("There is no grades for "+this.course_name+" course !");
			return;
		}
		String content = file.readFile(this.course_name+"-grades.txt");
		System.out.println(content);
			
	}
	
	public void getGrade() {
		if(this.student_id == null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the id of the student : ");
			this.student_id = scan.nextLine();
		}
		if(this.course_name == null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the name of the course : ");
			this.course_name = scan.nextLine();
		}
		this.course_name = this.course_name.toUpperCase();
		File file = new File(this.course_name+"-grades.txt");
		if(!file.exists()) {
			System.out.println("there is no grade published yet !");
			return;
		}
		boolean lineFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader(this.course_name+"-grades.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (lineFound) {
                    System.out.println(line);
                    break;
                } else if (line.equals("ID : "+this.student_id)) {
                    lineFound = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(lineFound == false) {
        	System.out.println("there is no grade for this student id !");
        }
	}
	
	
	
}
