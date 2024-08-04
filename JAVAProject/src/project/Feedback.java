package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Feedback {
	
	 
	private  String student_name;
	private  String course_name;
	
	
	
	Feedback(String student_name , String course_name){
		this.student_name = student_name;
		this.course_name = course_name;
	}
	Feedback(String course_name){
		this.course_name = course_name;
	}
	Feedback(){
		
	}

	public void makeSurvey() {

//		if(this.student_name == null) {
//			Scanner scan = new Scanner(System.in);
//			System.out.print("Enter the name of the student : ");
//			this.student_name = scan.nextLine();
//		}
		if(this.course_name == null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the name of the course : ");
			this.course_name = scan.nextLine();
		}
		this.course_name = this.course_name.toUpperCase(); 
		
		Scanner scan = new Scanner(System.in);
		
		int rate;
		String comment;

		FileHandler file = new FileHandler();
		
		System.out.print("Enter the rate of "+this.course_name+" course from 10 : ");
		while(true) {
			if(scan.hasNextInt()) {
				rate = scan.nextInt();
				if(rate>=0 && rate<=10) {
					break;
				}
				else {
					System.out.print("ERROR : Invalid number , please enter number between 0 and 10 : ");
				}
			}
			else {
				System.out.print("ERROR : Invalid input please enter only number : ");
				scan.next();
			}	
		}
		System.out.println("Enter comment about this course : ");
		scan.nextLine();
		comment = scan.nextLine();
			
		String content = ("Name : "+this.student_name+"\nRate : "+rate+"/10\nComment : "+comment+"\n____________________________________________");
		file.storeFile(this.course_name+"-Survey.txt", content);
		System.out.println("Your survey is added.");
	}
	
	public void readAllSurvey() {
		if(this.course_name == null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the name of the course : ");
			this.course_name = scan.nextLine();
		}

		FileHandler file = new FileHandler();
		if(!file.searchFile(this.course_name+"-Survey.txt")) {
			System.out.println("There is no reviews about this course");
			return;
		}
		

		String content = file.readFile(this.course_name+"-Survey.txt");
		System.out.println(content);
		
	}
}
