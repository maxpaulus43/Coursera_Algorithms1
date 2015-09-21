package week0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class RefresherStuff {

	public static void refresherStuff(String[] args) {
		
		try {
			Scanner fin = new Scanner(new FileInputStream("src/" + args[0]));
			System.out.println(fin.nextLine());
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("no such file");
		}
		
		try {
			PrintWriter fout = new PrintWriter(new FileOutputStream("output.txt", true));
			fout.println("Julia is one awesome gal!");
			fout.close();
		} catch (FileNotFoundException e) {
			System.out.println("cannot write to file");
		}

	}
	
}
