package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInfo {

	private String userId;
	
	UserInfo(String userId){
		this.userId = userId;
	}
	
	public void Myinfo() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("Students.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				if(line.equals(this.userId)) {
					System.out.println("ID : "+line+"\n"+"Name : "+br.readLine()+"\n"+"Email : "+br.readLine()+"\n"+"Password : "+br.readLine());
					return;
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void UpdateMyInfo() {
		
		Scanner scan = new Scanner(System.in);
	
		//read from user and insert in usertmp all info without updated one
		File file = new File("Students.txt");
		FileHandler thefile = new FileHandler();
        
		try {
			BufferedReader br = new BufferedReader(new FileReader("Students.txt"));
			String line;
	            
			while ((line = br.readLine()) != null) {
			    if (line.equals(this.userId)) {
			 
			    	thefile.storeFile("StudentsTmp.txt", line);
			    	
			        System.out.println("enter new name : ");
			        String new_name = scan.nextLine();
			        
			        System.out.println("enter new email : ");
			        String new_email = scan.nextLine();
			        
			        System.out.println("enter new password : ");
			        String new_password = scan.nextLine();
			        			        
			        String content = new_name+"\n"+new_email+"\n"+new_password;
			        thefile.storeFile("StudentsTmp.txt", content);
			        br.readLine();
			        br.readLine();
			        br.readLine();
			    
			        
			    }
			    else {
			    	thefile.storeFile("StudentsTmp.txt", line);
			    }
			}
			 
			br.close();
			 file.delete();
			//thefile.deleteFile("Students.txt");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
        
		
        
      
        
      //read from usertmp and insert in user all info
		
       
		try {
			 File oldfile = new File("StudentsTmp.txt"); 
			 FileReader read = new FileReader("StudentsTmp.txt");
			 FileWriter writer = new FileWriter("Students.txt");
	        int data = read.read();
			while(data != -1) {
				writer.append((char)data);
				data = read.read();
			}
			read.close();
			writer.close();
	        oldfile.delete();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("your information is updated.");
       
        
        

	}
}
