package project;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin implements Operations{
    private String AdminID;
    Admin(String AdminID) 
    {
       this.AdminID = AdminID;
    }
    @Override
    public void add()
    {
        System.out.println("Enter usertype to add (student/instructor): ");
        Scanner scan = new Scanner(System.in);
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
    }
    
    @Override
    public void update() {
    try {
        FileWriter write = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter user type(student/instructor) to update: ");
        String type = scan.nextLine();
        FileHandler f = new FileHandler();
        if(type.equalsIgnoreCase("student"))
        {
            System.out.println("Enter student id to update: ");
            int studentIdToUpdate = scan.nextInt();
            scan.nextLine();
            String id = Integer.toString(studentIdToUpdate);
            File file = new File(f.getDirectory() + File.separator + "Students.txt");
            File tmp = new File(f.getDirectory() + File.separator + "Students_tmp.txt");
            if (!file.exists()) {
                System.out.println("There is no user in the system.");
                return;
            }
            write = new FileWriter(f.getDirectory() + File.separator + "Students_tmp.txt", true);
            BufferedReader br = new BufferedReader(new FileReader(f.getDirectory() + File.separator + "Students.txt"));
            String line;
            boolean userfound = false;
            while ((line = br.readLine()) != null) {
                  if (line.trim().startsWith(id)) {
                      for (int i = 0; i < 3; i++) {
                          br.readLine();
                }
                write.append(line).append("\n");
                System.out.println("Enter new name: ");
                String new_name = scan.nextLine().trim();
                System.out.println("Enter new email: ");
                String new_email = scan.nextLine().trim();
                System.out.println("Enter new password: ");
                String new_password = scan.nextLine().trim();
                write.append(new_name+"\n"+new_email+"\n"+new_password+"\n__________________________________");
                userfound = true;
            } else {
                write.append(line+"\n");
            }
        }
        write.close();
        br.close();
        file.delete();
        File updatedfile = new File(f.getDirectory() + File.separator + "Students.txt");
        FileReader read = new FileReader(f.getDirectory() + File.separator + "Students_tmp.txt");
        FileWriter writer = new FileWriter(f.getDirectory() + File.separator + "Students.txt");
        int data = read.read();
        while (data != -1) {
            writer.append((char) data);
            data = read.read();
        }
        read.close();
        writer.close();
        tmp.delete();
        if (!userfound) {
            System.out.println("There is no user having this id");
        } else {
            System.out.println("User updated!");
        }
        }
        else if(type.equalsIgnoreCase("instructor"))
        {
        System.out.println("Enter instructor id to update: ");
        int instructorIdToUpdate = scan.nextInt();
        scan.nextLine();
        String id = Integer.toString(instructorIdToUpdate);
        File file = new File(f.getDirectory() + File.separator + "Instructors.txt");
        File tmp = new File(f.getDirectory() + File.separator + "Instructors_tmp.txt");
        if (!file.exists()) {
            System.out.println("There is no user in the system.");
            return;
        }
        write = new FileWriter(f.getDirectory() + File.separator + "Instructors_tmp.txt", true);
        BufferedReader br = new BufferedReader(new FileReader(f.getDirectory() + File.separator + "Instructors.txt"));
        String line;
        boolean userfound = false;

        while ((line = br.readLine()) != null) {
            if (line.trim().startsWith(id)) {
                for (int i = 0; i < 3; i++) {
                     br.readLine();
                }
                write.append(line).append("\n");
                System.out.println("Enter new name: ");
                String new_name = scan.nextLine().trim();
                System.out.println("Enter new email: ");
                String new_email = scan.nextLine().trim();
                System.out.println("Enter new password: ");
                String new_password = scan.nextLine().trim();
                write.append(new_name+"\n"+new_email+"\n"+new_password+"\n__________________________________");
                userfound = true;
            } else {
                write.append(line+"\n");
            }
        }
        write.close();
        br.close();
        file.delete();
        File updatedfile = new File(f.getDirectory() + File.separator + "Instructors.txt");
        FileReader read = new FileReader(f.getDirectory() + File.separator + "Instructors_tmp.txt");
        FileWriter writer = new FileWriter(f.getDirectory() + File.separator + "Instructors.txt");
        int data = read.read();
        while (data != -1) {
            writer.append((char) data);
            data = read.read();
        }
        read.close();
        writer.close();
        tmp.delete();
        if (!userfound) {
            System.out.println("There is no user having this id");
        } else {
            System.out.println("User updated!");
        }
        }
        else
            update();
    } catch (IOException ex) {
        System.out.println("Error in reading");
    }
}



    @Override
    public void delete() {
        try {
            FileWriter write = null;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter user type(student/instructor) to delete: ");
            String type = scan.nextLine();
            FileHandler f = new FileHandler();
        if(type.equalsIgnoreCase("student"))
        {
            System.out.println("Enter student id to delete: ");
            int studentIdToDelete = scan.nextInt();
            scan.nextLine();
            String id = Integer.toString(studentIdToDelete);
            File file = new File(f.getDirectory() + File.separator + "Students.txt");
            File tmp = new File(f.getDirectory() + File.separator + "Students_tmp.txt");
            if (!file.exists()) {
                System.out.println("There is no user in the system.");
                return;
            }
            write = new FileWriter(f.getDirectory() + File.separator + "Students_tmp.txt", true);
            BufferedReader br = new BufferedReader(new FileReader(f.getDirectory() + File.separator + "Students.txt"));
            String line;
            boolean userfound = false;
            while ((line = br.readLine()) != null) {
            if (line.trim().startsWith(id)) {
                for (int i = 0; i < 4; i++) {
                     br.readLine();
                }
                    userfound = true;
                }
                else {
                    write.append(line+"\n");
                }
            }
        write.close();
        br.close();
        file.delete();
        File updatedfile = new File(f.getDirectory() + File.separator + "Students.txt");
        FileReader read = new FileReader(f.getDirectory() + File.separator + "Students_tmp.txt");
        FileWriter writer = new FileWriter(f.getDirectory() + File.separator + "Students.txt");
        int data = read.read();
        while (data != -1) {
            writer.append((char) data);
            data = read.read();
        }
        read.close();
        writer.close();
        tmp.delete();
        if (!userfound) {
            System.out.println("There is no user having this id");
        } else {
            System.out.println("User deleted!");
        }
        }
        else if (type.equalsIgnoreCase("instructor"))
        {
            System.out.println("Enter instructor id to delete: ");
            int instructorIdToDelete = scan.nextInt();
            scan.nextLine();
            String id = Integer.toString(instructorIdToDelete);
            File file = new File(f.getDirectory() + File.separator + "Instructors.txt");
            File tmp = new File(f.getDirectory() + File.separator + "Instructors_tmp.txt");
            if (!file.exists()) {
                System.out.println("There is no user in the system.");
                return;
            }
            write = new FileWriter(f.getDirectory() + File.separator + "Instructors_tmp.txt", true);
            BufferedReader br = new BufferedReader(new FileReader(f.getDirectory() + File.separator + "Instructors.txt"));
            String line;
            boolean userfound = false;
            while ((line = br.readLine()) != null) {
                if (line.trim().startsWith(id)) {
                    for (int i = 0; i < 4; i++) {
                        br.readLine();
                    }
                    userfound = true;
                }
                else {
                    write.append(line+"\n");
                }
            }
            write.close();
            br.close();
            file.delete();
            File updatedfile = new File(f.getDirectory() + File.separator + "Instructors.txt");
            FileReader read = new FileReader(f.getDirectory() + File.separator + "Instructors_tmp.txt");
            FileWriter writer = new FileWriter(f.getDirectory() + File.separator + "Instructors.txt");
            int data = read.read();
            while (data != -1) {
                writer.append((char) data);
                data = read.read();
            }
            read.close();
            writer.close();
            tmp.delete();
            if (!userfound) {
                System.out.println("There is no user having this id");
            } else {
                System.out.println("User deleted!");
            }
        }
        else
            delete();
    } 
        catch (IOException ex) {
        System.out.println("Error in reading");
    }
    }
 
}
