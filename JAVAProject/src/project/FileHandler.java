package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandler {
    private String directory;
    public FileHandler()
    {
        this.directory = "C:\\Users\\TM\\eclipse-workspace\\JAVAProject";
    }
    public String getDirectory()
    {
        return directory;
    }
    public void setDirectory(String directory)
    {
        this.directory = directory;
    }
    public void storeFile(String filename,String Content)
    {
       try
       {
           FileWriter writer = new FileWriter((directory+File.separator+filename),true);
           writer.append(Content+"\n");
           writer.flush();
           writer.close();
       }
       catch (IOException e) {
            System.out.println("Error saving this file: "+filename);
        }
     }
    public String readFile(String filename)
    {
           StringBuilder Line = new StringBuilder() ;
            try {
            File file = new File(directory+File.separator+filename);
            Scanner fr = new Scanner(file);
            while(fr.hasNextLine())
            {   
                  Line.append(fr.nextLine()).append("\n");
            }   
        } catch (FileNotFoundException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
            return Line.toString();
    }
     public void deleteFile(String filename) 
     {
         try
         {
              Files.delete(Paths.get(directory,filename));
         }
         catch(IOException e){
             System.out.println("Couldn't delete file");
         }
         
     }
     
     public void delete(String filename) {
    	 File f = new File(filename);
    	 f.delete();
     }
public void createFileIfNotExists(String filename) {
    try {
        if (!doesFileExist(filename)) {
            File file = new File(directory + File.separator + filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + filename);
            } else {
                System.out.println("File already exists: " + filename);
            }
        } else {
            System.out.println("File already exists: " + filename);
        }
    } catch (IOException e) {
        System.out.println("Error creating file: " + filename);
    }
}
    public boolean doesFileExist(String filename) {
        File file = new File(directory + File.separator + filename);
        return file.exists();
    }
    public boolean searchFile(String filename) {
        return doesFileExist(filename);
    }
    public void appendToFile(String filename, String content) {
        storeFile(filename, content);
    }
public void updateFile(String filename,String oldContent, String newContent) {
 {
        try {
            FileHandler f = new FileHandler();
            File file = new File(f.getDirectory() + File.separator + filename);
            File tmp = new File(f.getDirectory() + File.separator + filename.replace(".txt", "_tmp.txt"));

            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }

            FileWriter write = new FileWriter(tmp);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.replaceAll(oldContent, newContent);
                write.write(line + "\n");
            }

            write.close();
            br.close();
            file.delete();

            File updatedFile = new File(f.getDirectory() + File.separator + filename);
            FileReader read = new FileReader(tmp);
            FileWriter writer = new FileWriter(updatedFile);

            int data = read.read();
            while (data != -1) {
                writer.write(data);
                data = read.read();
            }

            read.close();
            writer.close();
            tmp.delete();

        } catch (IOException ex) {
            System.out.println("Error in reading");
        }
}
}


public void insertIntoFile(String filename, int lineNumber, String newContent) {
    try {
        FileHandler f = new FileHandler();
        File file = new File(f.getDirectory() + File.separator + filename);
        File tmp = new File(f.getDirectory() + File.separator + filename.replace(".txt", "_tmp.txt"));

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        FileWriter write = new FileWriter(tmp);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int currentLineNumber = 1;
        boolean contentExists = false;
        while ((line = br.readLine()) != null) {
            if (currentLineNumber == lineNumber) {
                write.write(newContent + System.lineSeparator());
            }
            write.write(line + System.lineSeparator());
            currentLineNumber++;
        }

        if (lineNumber > currentLineNumber) {
            write.write(newContent + System.lineSeparator());
        }

        write.close();
        br.close();
        file.delete();

        File updatedFile = new File(f.getDirectory() + File.separator + filename);
        FileReader read = new FileReader(tmp);
        FileWriter writer = new FileWriter(updatedFile);

        int data = read.read();
        while (data != -1) {
            writer.write(data);
            data = read.read();
        }

        read.close();
        writer.close();
        tmp.delete();

    } catch (IOException ex) {
        System.out.println("Error in reading");
    }
}
    public void deleteFromFile(String filename, String dataToDelete) {
    try {
        FileHandler f = new FileHandler();
        File file = new File(f.getDirectory() + File.separator + filename);
        File tmp = new File(f.getDirectory() + File.separator + filename.replace(".txt", "_tmp.txt"));

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        FileWriter write = new FileWriter(tmp);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains(dataToDelete)) {
                continue;
            }
            write.write(line + System.lineSeparator());
        }

        write.close();
        br.close();
        file.delete();

        File updatedFile = new File(f.getDirectory() + File.separator + filename);
        FileReader read = new FileReader(tmp);
        FileWriter writer = new FileWriter(updatedFile);

        int data = read.read();
        while (data != -1) {
            writer.write(data);
            data = read.read();
        }

        read.close();
        writer.close();
        tmp.delete();

    } catch (IOException ex) {
        System.out.println("Error in reading");
    }
}

}
