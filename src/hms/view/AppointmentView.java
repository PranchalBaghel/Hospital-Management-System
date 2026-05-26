package hms.view;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class AppointmentView {
	private static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("---------- Appointment Module ---------- ");
		System.out.println(" 1. insert Appointment");
		System.out.println(" 2. update Appointment");
		System.out.println(" 3. delete Appointment");
		System.out.println(" 4. read all Appointment");
		System.out.println(" 5. search Appointment");
		System.out.println(" 6. Patient visit history ");
		System.out.println(" 7. Exit ");
		return sc.nextInt();
	}
	
	public int getAppointmentId() {
		System.out.println("Enter Appointment id : ");
		return sc.nextInt();
	}
	
	public int getPatientId() {
		System.out.println("Enter patient id : ");
		return sc.nextInt();
	}
	
	public int getDoctorId() {
		System.out.println("Enter doctor id : ");
		return sc.nextInt();
	}
	

	public Date getApt_date() {
		sc.nextLine();
		System.out.println("Enter apt_date (yyyy-mm-dd): ");
		String date = sc.nextLine();
		return Date.valueOf(date);
	}
	
	public Time getApt_time() {
		System.out.println("Enter apt_time (hh:mm:ss): ");
		String time = sc.nextLine();
		return Time.valueOf(time);
	}
	
}
