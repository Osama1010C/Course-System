package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Menu m = new Menu();
		while(true) {
			if(m.mainMenu()) {
				m.userMenu();
			}
			else {
				break;
			}
		}		
	}
}
