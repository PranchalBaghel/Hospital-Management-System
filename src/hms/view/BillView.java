package hms.view;

import java.util.Scanner;

public class BillView {
	private static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("---------- Bill Module ---------- ");
		System.out.println(" 1. insert Bill");
		System.out.println(" 2. update Bill");
		System.out.println(" 3. delete Bill");
		System.out.println(" 4. read all Bill");
		System.out.println(" 5. search Bill");
		System.out.println(" 6. Exit ");
		return sc.nextInt();
	}
	
	public int getBillId() {
		System.out.println("Enter Bill id : ");
		return sc.nextInt();
	}
	public int getPatientId() {
		System.out.println("Enter patient id : ");
		return sc.nextInt();
	}
	public int getAppointmentId() {
		System.out.println("Enter Appointment id : ");
		return sc.nextInt();
	}
	public double getAmount() {
		System.out.println("Enter amount : ");
		return sc.nextDouble();
	}
	public Boolean getisPaid() {
		sc.nextLine();
		System.out.println("is_paid : ");
		return sc.nextBoolean();
	}
	
}
