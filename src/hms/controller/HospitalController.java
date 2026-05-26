package hms.controller;

import hms.view.HospitalView;

public class HospitalController {
private HospitalView view;
private PatientController patientcontrol;
private DoctorController doctorcontrol;
private DepartmentController departmentcontrol;
private BillController billcontrol;
private AppointmentController appointmentcontrol;


public HospitalController(HospitalView view, PatientController patientcontrol, DoctorController doctorcontrol,
		DepartmentController departmentcontrol, BillController billcontrol, AppointmentController appointmentcontrol) {
	super();
	this.view = view;
	this.patientcontrol = patientcontrol;
	this.doctorcontrol = doctorcontrol;
	this.departmentcontrol = departmentcontrol;
	this.billcontrol = billcontrol;
	this.appointmentcontrol = appointmentcontrol;
}


public void start() {
	while(true) {
		int choice = view.showmenu();
		switch(choice) {
		case 1 :
			patientcontrol.run();
			break;
		case 2 :
			doctorcontrol.run();
			break;
		case 3 :
			departmentcontrol.run();
			break;
		case 4 : 
			billcontrol.run();
			break;
		case 5 :
			appointmentcontrol.run();
			break;
		case 6 :
			return;
		default :
			System.out.println("Invalid choice");
			break;
		}
	}
}


}
