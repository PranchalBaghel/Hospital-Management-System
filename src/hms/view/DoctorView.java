package hms.view;

import java.util.Scanner;

public class DoctorView {
	private static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("---------- Doctor Module ---------- ");
		System.out.println(" 1. insert Doctor");
		System.out.println(" 2. update Doctor");
		System.out.println(" 3. delete Doctor");
		System.out.println(" 4. read all Doctor");
		System.out.println(" 5. search Doctor");
		System.out.println(" 6. Doctor workload report");
		System.out.println(" 7. Exit ");
		return sc.nextInt();
	}
	
	public int getDoctorId() {
		System.out.println("Enter Doctor id : ");
		return sc.nextInt();
	}
	public int getDoctorDeptId() {
		System.out.println("Enter Doctor dept_id : ");
		return sc.nextInt();
	}
	public String getDoctorName() {
		sc.nextLine();
		System.out.println("Enter Doctor name : ");
		return sc.nextLine();
	}
	public String getDoctorSpecialist() {
		System.out.println("Enter Doctor specialist : ");
		return sc.nextLine();
	}
	
}
