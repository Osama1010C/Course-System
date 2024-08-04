package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Course {

	Course(){
		
	}
	
	public void addCourse(String branch , String parent_course , String room , String price , String instructor , String Students , String start_date , String end_date , String days_of_course) throws IOException {
		File f = new File("Courses.txt");
		FileWriter write = new FileWriter("Courses.txt",true);
		if(!f.exists()) {
			f.createNewFile();		
		}
		branch = branch.toUpperCase();
		write.append(branch+"\n"+parent_course+"\n"+room+"\n"+price+"$\n"+instructor+"\n"+Students+"\n"+start_date+"\n"+end_date+"\n"+days_of_course+"\n___________________________________________\n");
		write.close();
		System.out.println("Course is added.");
	}
	
	public void updateCourse(String branch , String parent_course , String room , String price , String instructor , String Students , String start_date , String end_date , String days_of_course) throws IOException {
		File f = new File("Courses.txt");
		File ftmp = new File("CoursesTmp.txt");
		if(!f.exists()) {
			System.out.println("there is no courses in the system to update !");
			return;
		}
		
		branch = branch.toUpperCase();
		boolean lineFound = false;
		FileWriter write = new FileWriter("CoursesTmp.txt",true);
        BufferedReader br = new BufferedReader(new FileReader("Courses.txt")); 
        String line;
        while ((line = br.readLine()) != null) {
        	if(line.equals(branch)) {
        		write.append(branch+"\n"+parent_course+"\n"+room+"\n"+price+"\n"+instructor+"\n"+Students+"\n"+start_date+"\n"+end_date+"\n"+days_of_course+"\n___________________________________________\n");
        		br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();
        		lineFound = true;
        	}
        	else {
        		write.append(line+"\n");
        	}
        }
        if(lineFound == false) {
        	System.out.println("there is no course have that name !");
        	return;
        }
        write.close();
        br.close();
        f.delete();
        
       
        
        FileReader read = new FileReader("CoursesTmp.txt");
		 FileWriter writer = new FileWriter("Courses.txt");
       int data = read.read();
		while(data != -1) {
			writer.append((char)data);
			data = read.read();
		}
		read.close();
		writer.close();
       ftmp.delete();
        
        System.out.println("Information about this course is updated .");
		
	}
	
	public void deleteCourse(String branch) throws IOException {
		
		File f = new File("Courses.txt");
		File ftmp = new File("CoursesTmp.txt");
		if(!f.exists()) {
			System.out.println("there is no courses in the system to delte !");
			return;
		}
		
		branch = branch.toUpperCase();
		boolean lineFound = false;
		FileWriter write = new FileWriter("CoursesTmp.txt",true);
        BufferedReader br = new BufferedReader(new FileReader("Courses.txt")); 
        String line;
        while ((line = br.readLine()) != null) {
        	if(line.equals(branch)) {
        		br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();
        		lineFound = true;
        	}
        	else {
        		write.append(line+"\n");
        	}
        }
        if(lineFound == false) {
        	System.out.println("there is no course have that name !");
        	return;
        }
        write.close();
        br.close();
        f.delete();
        
       
        
        FileReader read = new FileReader("CoursesTmp.txt");
		 FileWriter writer = new FileWriter("Courses.txt");
       int data = read.read();
		while(data != -1) {
			writer.append((char)data);
			data = read.read();
		}
		read.close();
		writer.close();
       ftmp.delete();
        
        System.out.println("Course is deleted.");
	}
	
	public void showAllStudents(String branch) throws IOException {
		
		File f = new File("Courses.txt");
		if(!f.exists()) {
			System.out.println("there is no courses in the system to delte !");
			return;
		}
		
		branch = branch.toUpperCase();
		boolean lineFound = false;
        BufferedReader br = new BufferedReader(new FileReader("Courses.txt")); 
        String line;
        while ((line = br.readLine()) != null) {
        	if(line.equals(branch)) {
        		br.readLine();br.readLine();br.readLine();br.readLine();
        		System.out.println("Students : "+br.readLine());
        		lineFound = true;
        	}
        	
        }
        if(lineFound == false) {
        	System.out.println("there is no course have that name !");
        	return;
        } 
        br.close();
	}
	
	public void showAllInstructors(String branch) throws IOException {
		
		File f = new File("Courses.txt");
		if(!f.exists()) {
			System.out.println("there is no courses in the system to delte !");
			return;
		}
		
		branch = branch.toUpperCase();
		boolean lineFound = false;
        BufferedReader br = new BufferedReader(new FileReader("Courses.txt")); 
        String line;
        while ((line = br.readLine()) != null) {
        	if(line.equals(branch)) {
        		br.readLine();br.readLine();br.readLine();
        		System.out.println("Instructors : "+br.readLine());
        		lineFound = true;
        	}
        	
        }
        if(lineFound == false) {
        	System.out.println("there is no course have that name !");
        	return;
        } 
        br.close();
	}
	
	public void reportAboutToStart() throws IOException {
		File f = new File("Courses.txt");
		if(!f.exists()) {
			System.out.println("There is no courses in the system !");
			return;
		}
		
        BufferedReader br = new BufferedReader(new FileReader("Courses.txt")); 
        String line;
        String date;
        while ((line = br.readLine()) != null) {
        	br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();
        	date=br.readLine();
        	if(date.equals("2023-12-20")||date.equals("2023-12-21")||date.equals("2023-12-22")) {
        		System.out.println(line+" is about to start!");
        	}
        	br.readLine();br.readLine();br.readLine();       	
        }
        br.close();
	}
	
	public void reportAboutToEnd() throws IOException {
		
		File f = new File("Courses.txt");
		if(!f.exists()) {
			System.out.println("There is no courses in the system !");
			return;
		}
		
        BufferedReader br = new BufferedReader(new FileReader("Courses.txt")); 
        String line;
        String date;
        while ((line = br.readLine()) != null) {
        	br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();
        	date=br.readLine();
        	if(date.equals("2023-12-20")||date.equals("2023-12-19")||date.equals("2023-12-21")||date.equals("2023-12-22")) {
        		System.out.println(line+" is about to end!");
        	}
        	br.readLine();br.readLine();      	
        }
        br.close();
	}
	
	//overloading
	public void reportAboutToStart(String branch) throws IOException {
		File f = new File("Courses.txt");
		if(!f.exists()) {
			System.out.println("There is no courses in the system !");
			return;
		}
		
		branch = branch.toUpperCase();
		boolean lineFound = false;
        BufferedReader br = new BufferedReader(new FileReader("Courses.txt")); 
        String line;
        String date;
        while ((line = br.readLine()) != null) {
        	if(line.equals(branch)) {
        		br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();
            	date=br.readLine();
            	if(date.equals("2023-12-20")||date.equals("2023-12-21")||date.equals("2023-12-22")) {
            		System.out.println(branch+" is about to start!");
            	}
            	else {
            		System.out.println("there is still a time");
            	}
        	}	    	
        }
        br.close();
	}
	
	//overloading
	public void reportAboutToEnd(String branch) throws IOException {
		File f = new File("Courses.txt");
		if(!f.exists()) {
			System.out.println("There is no courses in the system !");
			return;
		}
		
		branch = branch.toUpperCase();
		boolean lineFound = false;
        BufferedReader br = new BufferedReader(new FileReader("Courses.txt")); 
        String line;
        String date;
        while ((line = br.readLine()) != null) {
        	if(line.equals(branch)) {
        		br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();
            	date=br.readLine();
            	if(date.equals("2023-12-19")||date.equals("2023-12-20")||date.equals("2023-12-21")||date.equals("2023-12-22")) {
            		System.out.println(branch+" is about to end!");
            	}
            	else {
            		System.out.println("there is still a time");
            	}
        	}	    	
        }
        br.close();
	}
	
	public boolean courseExist(String branch) throws IOException {
		File f = new File("Courses.txt");
		
		
		branch = branch.toUpperCase();
		boolean lineFound = false;
        BufferedReader br = new BufferedReader(new FileReader("Courses.txt")); 
        String line;
        String date;
        while ((line = br.readLine()) != null) {
        	if(line.equals(branch)) {
        		return true;
        	}	    	
        }
        br.close();
        return false;
	}
	
	public void showAllCourses() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Courses.txt")); 
        String line;
        String date;
        System.out.println("Courses :\n========");
        while ((line = br.readLine()) != null) {
        	System.out.println(line);
        	br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();
        }
        System.out.println("________________________________________________");
	}

}
