package hms.controller;

import java.util.List;

import hms.dao.DoctorDao;
import hms.model.Doctor;
import hms.view.DoctorView;

public class DoctorController {
	
private DoctorView view;
private DoctorDao model;

public DoctorController(DoctorView view, DoctorDao model) {
	super();
	this.view = view;
	this.model = model;
}

public void run() {
	  while(true) {
		  int choice = view.menu();
		  switch(choice) {
		  case 1 :{
			  String name = view.getDoctorName();
			  String specialist = view.getDoctorSpecialist();
			  int dept_id = view.getDoctorDeptId();
			  Doctor d1 = new Doctor(name , specialist, dept_id);
			  int i = model.insert(d1);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 2:{
			  String name = view.getDoctorName();
			  String specialist = view.getDoctorSpecialist();
			  int dept_id = view.getDoctorDeptId();
			  int id = view.getDoctorId();
			  Doctor d1 = new Doctor(id, name , specialist, dept_id);
			  int i = model.update(d1);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 3:{
			  int id = view.getDoctorId();
			  int i = model.delete(id);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 4:{
			  List<Doctor> list = model.read();
			  for(Doctor p : list) {
				  System.out.println(p);
			  }
			  System.out.println();
		  }
		  break;
		  
		  case 5: {
			  int id = view.getDoctorId();
			  Doctor d = model.search(id);
			  if(d!=null) {
				  System.out.println(d);
			  }else {
				  System.out.println("Doctor not Found");
			  }
		  }
		  break;
		  
		  case 6 : {
			  model.doctorworkloadreport();
		  }
		  
		  case 7:
			  return;
			 
		  default:
			  System.out.println("Invalid choice ");
			  break;
		  }
	  }
}

}
