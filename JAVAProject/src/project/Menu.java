package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

	private String type;
	private String id;
	private String name;
	
	Menu(){
		
	}
	
	public boolean mainMenu() {
		
		Scanner scan = new Scanner(System.in);
		String reset = "\u001B[0m";
        String bold = "\u001B[1m";
        String cyan = "\u001B[36m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";
        String green = "\u001B[32m";
        String brightgreen = "\u001B[92m";     
        String red = "\u001B[91m";

        System.out.println(cyan + "**********************************************************");
        System.out.println("*\t\t" + bold + yellow + "Welcome to the Course System" + reset + cyan + "\t\t\t *");
        System.out.println("**********************************************************" + reset);
        System.out.println("");
        System.out.println(green + "\n╔══════════════════════════════════════════════════╗");
        System.out.println("║\t\t" + bold + brightgreen + "Register/Login Page" + reset + green + "\t\t           ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + reset);
		System.out.println("\n\n1]Register\n\n2]Login\n\n3]Exit\n\n:");
		

        
		int choice = scan.nextInt();
		if(choice == 1) {
			scan.nextLine();
            System.out.println("Enter usertype (student/instructor): ");
            String userType = scan.nextLine();
            while (!userType.equalsIgnoreCase("student") && !userType.equalsIgnoreCase("instructor") && !userType.equalsIgnoreCase("admin")) {
                System.out.println("Invalid type. Try again");
                System.out.println("Enter usertype: ");
                userType = scan.nextLine();
            }
            System.out.println("Enter username: ");
            String username = scan.nextLine();
            System.out.println("Enter email: ");
            String email = scan.nextLine();
            System.out.println("Enter password: ");
            String pass = scan.nextLine();
            User u = new User();
            u.register(userType, username, email, pass);
            id=u.getId();
            name=u.getname();
            type=u.getType();
            return true;
		}
		else if(choice == 2) {
			User u = new User();
            scan.nextLine();
            System.out.println("Enter usertype: ");
            String userType = scan.nextLine();
            while (!userType.equalsIgnoreCase("student") && !userType.equalsIgnoreCase("instructor") && !userType.equalsIgnoreCase("admin")) {
                System.out.println("Invalid type. Try again");
                System.out.println("Enter usertype: ");
                userType = scan.nextLine();
            }
            System.out.println("Enter userID: ");
            String userID = scan.nextLine();
			System.out.println("Enter password: ");
            String pass = scan.nextLine();
            boolean success = u.login(userType,userID,pass);
            id=u.getId();
			name=u.getname();
			type=u.getType();
            while (success == false) {
                  System.out.println("Invalid credentials. Try again.");
                  System.out.println("Enter userID: ");
                  userID = scan.nextLine();
                  System.out.println("Enter password: ");
                  pass = scan.nextLine();
                  success = u.login(userType, userID, pass);
                  id=u.getId();
			      name=u.getname();
			      type=u.getType();
                }
	        return true;
            }
            else
                return false;
        }
	
	public void userMenu() throws IOException  {
		Scanner scan = new Scanner(System.in);
		if(type.equals("student")) {
			String reset = "\u001B[0m";
	        String bold = "\u001B[1m";
	        String blue = "\u001B[34m";
	        String green = "\u001B[32m";
	        String yellow = "\u001B[33m";

	        System.out.println(blue + "\n╔════════════════════════════════════════════╗");
	        System.out.println("║\t\t" + bold + yellow + "Student Page" + reset + blue + "\t\t             ║");
	        System.out.println("╚════════════════════════════════════════════╝" + reset);
			while(true) {
				System.out.println("\n\n1]add feedback about course\n\n2]read all feedbacks about course\n\n3]get the grade about course\n\n4]show your information\n\n5]update your information\n\n6]Show all courses\n\n7]Reports about courses\n\n8]Logout\n\n:");
				int choice = scan.nextInt();
				scan.nextLine();
				System.out.println("\n");
				if(choice == 1) {
					Student s = new Student(id,name);
					System.out.println("enter the name of the course : ");
					String c_name = scan.nextLine();					
					s.makeSurvey(c_name);
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
					
				}
				else if(choice == 2) {
					Student s = new Student(id,name);
					System.out.println("enter the name of the course : ");
					String c_name = scan.nextLine();
					s.readAllSurvey(c_name);
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 3) {
					Student s = new Student(id,name);
					System.out.println("enter the name of the course : ");
					String c_name = scan.nextLine();
					s.getGrade(c_name);
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 4) {
					Student s = new Student(id,name);
					s.MyInfo();
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 5) {
					Student s = new Student(id,name);
					s.UpdateInfo();
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 6) {
					Student s = new Student(id,name);
					s.showAllCourses();
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 7) {
					Course c = new Course();
					
					System.out.println("Courses about to start :\n=======================\n");
					c.reportAboutToStart();
					System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
					System.out.println("Courses about to end :\n=======================\n");
					c.reportAboutToEnd();
					System.out.println("____________________________________________________");
					
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 8) {
					break;
				}
				else {
					System.out.println("unvalidated choice !");
				}
			}
		}
		else if(type.equals("instructor")) {
			String reset = "\u001B[0m";
		    String bold = "\u001B[1m";
		    String blue = "\u001B[34m";
		    String green = "\u001B[32m";
		    String yellow = "\u001B[33m";
		    String brightYellow = "\u001B[93m";

		    System.out.println(brightYellow + "\n╔══════════════════════════════════════════════╗");
		    System.out.println("║\t\t" + bold + yellow + "Instructor Page" + reset + brightYellow +  "\t               ║");
		    System.out.println("╚══════════════════════════════════════════════╝"+reset);
			while(true) {
				System.out.println("\n\n1]Add grade\n\n2]Publish grades\n\n3]View grades\n\n4]Logout\n:");
				int choice = scan.nextInt();
				scan.nextLine();
				System.out.println("\n");
				if(choice == 1) {
					Instructor i = new Instructor();
					System.out.println("enter the name of the course : ");
					String c_name = scan.nextLine();
					
					System.out.println("how many grades you want to add : ");
					int n = scan.nextInt();
					for(int j = 0; j<n ; j++) {
						i.addGrade(c_name);
					}		
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
					String back2 = scan.nextLine();
				}
				
				else if(choice == 2) {
					Instructor i = new Instructor();
					System.out.println("enter the name of the course : ");
					String c_name = scan.nextLine();
					i.publishGrades(c_name);
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 3) {
					Instructor i = new Instructor();
					System.out.println("enter the name of the course : ");
					String c_name = scan.nextLine();
					i.viewGrades(c_name);
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				
				else if(choice == 4) {
					break;
				}
				else {
					System.out.println("unvalidated choice !");
				}
			}
		}
		else if(type.equals("admin")) {
			String reset = "\u001B[0m";
	        String bold = "\u001B[1m";
	        String blue = "\u001B[34m";
	        String green = "\u001B[32m";
	        String yellow = "\u001B[33m";
	        String red = "\u001B[91m";
	        String cyan = "\u001B[96m";

	        System.out.println(cyan + "\n╔═════════════════════════════════════════╗");
	        System.out.println("║\t\t" + bold + red + "Admin Page" + reset + red + "\t\t          ║");
	        System.out.println("╚═════════════════════════════════════════╝" + reset);
	        while(true) {
	        	System.out.println("\n\n1]Add User\n\n2]Update User\n\n3]Delete User\n\n4]Add Course\n\n5]Update Course\n\n6]Delete Course\n\n7]Logout\n:");
	        	int choice = scan.nextInt();
				scan.nextLine();
				System.out.println("\n");
				if(choice == 1) {
					Admin a = new Admin("0");
					a.add();	
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 2) {
					Admin a = new Admin("0");
					a.update();	
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 3) {
					Admin a = new Admin("0");
					a.delete();
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 4) {
					Course c = new Course();
					String branch = null,parent_course = null,room = null,price = null,instructor = "",student = "",start_date = null,end_date = null,days_of_course = null;
					while(true) {
						System.out.println("Branch : ");
						branch = scan.nextLine();
						if(!c.courseExist(branch)) {
							break;
						}
						System.out.println("this course is already exist!\nPlease enter another course");						
					}
					
					System.out.println("parent_course : ");
					parent_course = scan.nextLine();
					System.out.println("room : ");
					room = scan.nextLine();
					System.out.println("price : ");
					price = scan.nextLine();
					
					while(true) {
						System.out.println("name of instructor : ");
						instructor = scan.nextLine();
						BufferedReader br = new BufferedReader(new FileReader("instructorNames.txt")); 
				        String line;
				        boolean linefound = false;
				        while ((line = br.readLine()) != null) {
				        	if(line.equals(instructor)) {
				        		linefound = true;			        		
				        	}				        	
				        }				        			        
				        br.close();
				        if(!linefound) {
				        	System.out.println("this instructor is not in the system!");
				        }
				        else {
				        	break;
				        }
					}
					String students = "";
					System.out.println("Enter number of students to add : ");
					
					
					int n = scan.nextInt();
					scan.nextLine();
					
					for(int i = 0 ; i<n ; i++) {
						
						while(true) {
							
							System.out.println("name of student : ");
							
							student = scan.nextLine();
							
							BufferedReader br = new BufferedReader(new FileReader("studentNames.txt")); 
					        String line;
					        boolean linefound = false;
					        while ((line = br.readLine()) != null) {
					        	if(line.equals(student)) {
					        		linefound = true;			        		
					        	}				        	
					        }				        			        
					        br.close();
					        if(!linefound) {
					        	System.out.println("this student is not in the system!");			        	
					        }
					        else {
					        	break;
					        }
						}
						
						students+=student+"|";
						
					}
					
					
					
					System.out.println("start date of course (yy-mm-dd) : ");
					start_date = scan.nextLine();
					System.out.println("end date of course (yy-mm-dd) : ");
					end_date = scan.nextLine();
					System.out.println("number of days of this course : ");
					days_of_course = scan.nextLine();
					c.addCourse(branch, parent_course, room, price, instructor, students, start_date, end_date, days_of_course);
					
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 5) {
					Course c = new Course();
					String branch = null,parent_course = null,room = null,price = null,instructor = "",student = "",start_date = null,end_date = null,days_of_course = null;
					while(true) {
						System.out.println("New Branch : ");
						branch = scan.nextLine();
						if(c.courseExist(branch)) {
							break;
						}
						System.out.println("this course is Not exist!\nPlease enter an existance course to update");						
					}
					
					System.out.println("New parent_course : ");
					parent_course = scan.nextLine();
					System.out.println("New room : ");
					room = scan.nextLine();
					System.out.println("New price : ");
					price = scan.nextLine();
					
					while(true) {
						System.out.println("New name of instructor : ");
						instructor = scan.nextLine();
						BufferedReader br = new BufferedReader(new FileReader("instructorNames.txt")); 
				        String line;
				        boolean linefound = false;
				        while ((line = br.readLine()) != null) {
				        	if(line.equals(instructor)) {
				        		linefound = true;			        		
				        	}				        	
				        }				        			        
				        br.close();
				        if(!linefound) {
				        	System.out.println("this instructor is not in the system!");
				        }
				        else {
				        	break;
				        }
					}
					String students = "";
					System.out.println("Enter number of students to add : ");
					
					
					int n = scan.nextInt();
					
					for(int i = 0 ; i<n ; i++) {
						
						while(true) {
							
							System.out.println("New name of student : ");
							
							student = scan.nextLine();
							
							BufferedReader br = new BufferedReader(new FileReader("studentNames.txt")); 
					        String line;
					        boolean linefound = false;
					        while ((line = br.readLine()) != null) {
					        	if(line.equals(student)) {
					        		linefound = true;			        		
					        	}				        	
					        }				        			        
					        br.close();
					        if(!linefound) {
					        	System.out.println("this student is not in the system!");			        	
					        }
					        else {
					        	break;
					        }
						}
						
						students+=student+"|";
						
					}
					
					
					
					System.out.println("New start date of course (yy-mm-dd) : ");
					start_date = scan.nextLine();
					System.out.println("New end date of course (yy-mm-dd) : ");
					end_date = scan.nextLine();
					System.out.println("New number of days of this course : ");
					days_of_course = scan.nextLine();
					c.updateCourse(branch, parent_course, room, price, instructor, students, start_date, end_date, days_of_course);
					
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				else if(choice == 6) {
					
					Course c = new Course();
					String branch = null,parent_course = null,room = null,price = null,instructor = "",student = "",start_date = null,end_date = null,days_of_course = null;
					while(true) {
						System.out.println("New Branch : ");
						branch = scan.nextLine();
						if(c.courseExist(branch)) {
							break;
						}
						System.out.println("this course is Not exist!\nPlease enter an existance course to update");						
					}
					c.deleteCourse(branch);
				
					System.out.println("\n____________________________________________________");
					System.out.println("\nClick (Enter) to back to the page \n");
					String back = scan.nextLine();
				}
				
				else if(choice == 7) {
					break;
				}
				else {
					System.out.println("unvalidated choice !");
				}
	        }
		}
		
		else {
			System.out.println("you don't have an account");
		}
	}
}
