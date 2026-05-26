package hms.view;

import java.util.Scanner;

public class PatientView {
	private static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("---------- Patient Module ---------- ");
		System.out.println(" 1. insert patient");
		System.out.println(" 2. update patient");
		System.out.println(" 3. delete patient");
		System.out.println(" 4. read all patient");
		System.out.println(" 5. search patient");
		System.out.println(" 6. Exit ");
		return sc.nextInt();
	}
	
	public int getPatientId() {
		System.out.println("Enter Patient id : ");
		return sc.nextInt();
	}
	public int getPatientAge() {
		System.out.println("Enter Patient age : ");
		return sc.nextInt();
	}
	public String getPatientName() {
		sc.nextLine();
		System.out.println("Enter Patient name : ");
		return sc.nextLine();
	}
	public String getPatientDisease() {
		sc.nextLine();
		System.out.println("Enter Patient disease : ");
		return sc.nextLine();
	}
	
	
	
}
