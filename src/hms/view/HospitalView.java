package hms.view;

import java.util.Scanner;

public class HospitalView {
private static Scanner sc = new Scanner(System.in);

public static int showmenu() {
	System.out.println("---------- Hospital Management System ----------");
	System.out.println(" 1. Show Patient Module");
	System.out.println(" 2. Show Doctor Module");
	System.out.println(" 3. Show Department Module");
	System.out.println(" 4. Show Bill Module");
	System.out.println(" 5. Show Appointment Module");
	System.out.println(" 6. Exit");
	System.out.println("------------------------------------------------");
	System.out.println();
	System.out.println("Enter your choice : ");
	return sc.nextInt();
}


}
