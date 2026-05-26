package hms.controller;

import java.util.List;

import hms.dao.PatientDao;
import hms.model.Patient;
import hms.view.PatientView;

public class PatientController {
	
  private PatientView view;
  private PatientDao model;
  
  public PatientController(PatientView view, PatientDao model) {
	super();
	this.view = view;
	this.model = model;
  }
  
  public void run() {
	  while(true) {
		  int choice = view.menu();
		  switch(choice) {
		  case 1 :{
			  String name = view.getPatientName();
			  int age = view.getPatientAge();
			  String disease = view.getPatientDisease();
			  Patient p1 = new Patient(name , age, disease);
			  int i = model.insert(p1);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 2:{
			  String name = view.getPatientName();
			  int age = view.getPatientAge();
			  String disease = view.getPatientDisease();
			  int id = view.getPatientId();
			  Patient p1 = new Patient(id, name , age, disease );
			  int i = model.update(p1);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 3:{
			  int id = view.getPatientId();
			  int i = model.delete(id);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 4:{
			  List<Patient> list = model.read();
			  for(Patient p : list) {
				  System.out.println(p);
			  }
			  System.out.println();
		  }
		  break;
		  
		  case 5: {
			  int id = view.getPatientId();
			  Patient p = model.search(id);
			  if(p!=null) {
				  System.out.println(p);
			  }else {
				  System.out.println("Patient not Found");
			  }
		  }
		  break;
		  
		  case 6:
			  return;
			 
		  default:
			  System.out.println("Invalid choice");
			  break;
			  
		  }
	  }
  }
  
}
