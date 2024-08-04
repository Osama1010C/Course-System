package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public  class User {
    private static String userId;
    private static String name;
    private static String type;
    public void register(String userType, String userName, String userEmail, String userPassword) {
        try {
            boolean success = false;
            while (!success) {
                FileHandler file = new FileHandler();
                StringBuilder str = new StringBuilder();
                type = userType;
                userId =  User.generateRandomId();
                name = userName;
                String email = userEmail;
                String password = userPassword;
                str.append(userId + "\n" + name + "\n" + email + "\n" + password + "\n__________________________________");

                if (type.equalsIgnoreCase("student")) {
                    file.storeFile("Students.txt", str.toString());
                    file.storeFile("studentNames.txt", name);
                    System.out.println("User registered successfully!");
                    success = true;
                } else if (type.equalsIgnoreCase("instructor")) {
                    file.storeFile("Instructors.txt", str.toString());
                    file.storeFile("studentNames.txt", name);
                    System.out.println("User registered successfully!");
                    success = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error in Registration");
        }
    }

public boolean login(String userType, String userID, String password) {
    BufferedReader reader = null;
    try {
        boolean success = false;
        String filename = "";
        if (userType.equalsIgnoreCase("student"))
            filename = "Students.txt";
        else if (userType.equalsIgnoreCase("instructor"))
            filename = "Instructors.txt";
        else if (userType.equalsIgnoreCase("admin"))
            filename = "Admin.txt";

        reader = new BufferedReader(new FileReader(new FileHandler().getDirectory() + File.separator + filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String ID = line.trim();
            String userName = reader.readLine();
            String userEmail = reader.readLine();
            String pass = reader.readLine();

            if (ID != null && userName != null && userEmail != null && pass != null) {
                userName = userName.trim();
                userEmail = userEmail.trim();
                pass = pass.trim();

                if (pass.equals(password) && ID.equals(userID)) {
                    System.out.println("login successful!");
                    success = true;
                    this.type = userType;
                    this.userId = userID;
                    this.name = userName;
                    return true;
                }
            }
            reader.readLine();
        }
        return false;
    } catch (IOException e) {
        System.out.println("Error in Login");
    } 
      return false;
}
public boolean login(String userID, String password) {
    BufferedReader reader = null;
    Scanner scan = new Scanner(System.in);
    try {
        boolean success = false;
        String filename = "";
        String userType = scan.nextLine();
        while (!userType.equalsIgnoreCase("student") && !userType.equalsIgnoreCase("instructor") && !userType.equalsIgnoreCase("admin")) {
            System.out.println("Invalid type. Try again");
            System.out.println("Enter usertype: ");
            userType = scan.nextLine();
        }
        if (userType.equalsIgnoreCase("student"))
            filename = "Students.txt";
        else if (userType.equalsIgnoreCase("instructor"))
            filename = "Instructors.txt";
        else if (userType.equalsIgnoreCase("admin"))
            filename = "Admin.txt";

        reader = new BufferedReader(new FileReader(new FileHandler().getDirectory() + File.separator + filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String ID = line.trim();
            String userName = reader.readLine();
            String userEmail = reader.readLine();
            String pass = reader.readLine();

            if (ID != null && userName != null && userEmail != null && pass != null) {
                userName = userName.trim();
                userEmail = userEmail.trim();
                pass = pass.trim();

                if (pass.equals(password) && ID.equals(userID)) {
                    System.out.println("login successful!");
                    success = true;
                    this.type = userType;
                    this.userId = userID;
                    this.name = userName;
                    return true;
                }
            }
            reader.readLine();
        }
        return false;
    } catch (IOException e) {
        System.out.println("Error in Login");
    } 
      return false;
}	
    public static String getId() {
        return userId;
    }

    public static String getname() {
        return name;
    }
    public static String getType()
    {
        return type;
    }
    public static int getNumberOfUsers(User u) {
    FileHandler file = new FileHandler();
    String filename = "";
    System.out.println("Enter usertype: (student/instructor)");
    Scanner scan = new Scanner(System.in);
    type = scan.nextLine();
    if (type.equalsIgnoreCase("student")) {
        filename = "Students.txt";
    } else if (type.equalsIgnoreCase("instructor")) {
        filename = "Instructors.txt";
    } else {
        System.out.println("Invalid user type");
        return -1;
    }

    File userFile = new File(file.getDirectory() + File.separator + filename);

    if (!userFile.exists()) {
        try {
            userFile.createNewFile();
        } catch (IOException ex) {
            System.out.println("Couldn't create file");
        }
    }

    try (BufferedReader reader = new BufferedReader(
            new FileReader(file.getDirectory() + File.separator + filename))) {
        int userCount = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals("__________________________________")) {
                userCount++;
            }
        }
        return userCount;
    } catch (FileNotFoundException ex) {
        System.out.println("Couldn't find file");
    } catch (IOException ex) {
        System.out.println("Error in reading");
    }
    return 0;
}

    private static String generateRandomId() {
        Random random = new Random();
        int length = 6;

        StringBuilder idBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randomDigit = (char) (random.nextInt(10) + '0');
            idBuilder.append(randomDigit);
        }

        return idBuilder.toString();
    }
}