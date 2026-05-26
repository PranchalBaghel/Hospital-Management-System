package hms.view;

import java.util.Scanner;

public class DepartmentView {
	private static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("---------- Department Module ---------- ");
		System.out.println(" 1. insert Department");
		System.out.println(" 2. update Department");
		System.out.println(" 3. delete Department");
		System.out.println(" 4. read all Department");
		System.out.println(" 5. search Department");
		System.out.println(" 6. Exit ");
		return sc.nextInt();
	}
	
	public int getDepartmentId() {
		System.out.println("Enter Department id : ");
		return sc.nextInt();
	}
	
	public String getDepartmentName() {
		sc.nextLine();
		System.out.println("Enter Department name : ");
		return sc.nextLine();
	}

}
