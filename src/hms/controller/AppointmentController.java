package hms.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import hms.dao.AppointmentDao;
import hms.model.Appointment;
import hms.view.AppointmentView;

public class AppointmentController {
	
private AppointmentView view;
private AppointmentDao model;

public AppointmentController(AppointmentView view, AppointmentDao model) {
	super();
	this.view = view;
	this.model = model;
}

public void run() {
	  while(true) {
		  int choice = view.menu();
		  switch(choice) {
		  case 1 :{
			  int patient_id = view.getPatientId();
			  int doctor_id = view.getDoctorId();
			  Date apt_date = view.getApt_date();
			  Time apt_time = view.getApt_time();
			  Appointment a1 = new Appointment(apt_date, apt_time ,patient_id , doctor_id);
			  int i = model.insert(a1);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 2:{
			  int patient_id = view.getPatientId();
			  int doctor_id = view.getDoctorId();
			  Date apt_date = view.getApt_date();
			  Time apt_time = view.getApt_time();
			  int id = view.getAppointmentId();
			  Appointment a1 = new Appointment(id, apt_date, apt_time ,patient_id , doctor_id);
			  int i = model.update(a1);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 3:{
			  int id = view.getAppointmentId();
			  int i = model.delete(id);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 4:{
			  List<Appointment> list = model.read();
			  for(Appointment a : list) {
				  System.out.println(a);
			  }
			  System.out.println();
		  }
		  break;
		  
		  case 5: {
			  int id = view.getAppointmentId();
			  Appointment a = model.search(id);
			  if(a!=null) {
				  System.out.println(a);
			  }else {
				  System.out.println("Appointment not Found");
			  }
		  }
		  break;
		  
		  case 6:{
			  model.PatientVisitHistory();
		  }
		  
		  case 7:
			  return;
			 
		  default:
			  System.out.println("Invalid choice");
			  break;
			  
		  }
	  }
}

 

}
