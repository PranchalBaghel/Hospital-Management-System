package hms.controller;

import java.util.List;

import hms.dao.BillDao;
import hms.model.Bill;
import hms.view.BillView;

public class BillController {
	
private BillView view;
private BillDao model;

public BillController(BillView view, BillDao model) {
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
			  int apt_id = view.getAppointmentId();
			  double amount = view.getAmount();
			  boolean is_paid = view.getisPaid();
			  Bill b1 = new Bill(patient_id , apt_id, is_paid,amount);
			  int i = model.insert(b1);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 2:{
			  int patient_id = view.getPatientId();
			  int apt_id = view.getAppointmentId();
			  double amount = view.getAmount();
			  boolean is_paid = view.getisPaid();
			  int id = view.getBillId();
			  Bill b1 = new Bill(id , patient_id , apt_id, is_paid,amount);
			  int i = model.update(b1);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 3:{
			  int id = view.getBillId();
			  int i = model.delete(id);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 4:{
			  List<Bill> list = model.read();
			  for(Bill p : list) {
				  System.out.println(p);
			  }
			  System.out.println();
		  }
		  break;
		  
		  case 5: {
			  int id = view.getBillId();
			  Bill b = model.search(id);
			  if(b!=null) {
				  System.out.println(b);
			  }else {
				  System.out.println("Bill not Found");
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
