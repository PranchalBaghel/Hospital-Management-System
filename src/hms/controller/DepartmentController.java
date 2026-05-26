package hms.controller;

import java.util.List;

import hms.dao.DepartmentDao;
import hms.model.Department;
import hms.view.DepartmentView;

public class DepartmentController {
	
private DepartmentView view;
private DepartmentDao model;

public DepartmentController(DepartmentView view, DepartmentDao model) {
	super();
	this.view = view;
	this.model = model;
}

public void run() {
	  while(true) {
		  int choice = view.menu();
		  switch(choice) {
		  case 1 :{
			  String name = view.getDepartmentName();
			  Department d1 = new Department(name);
			  int i = model.insert(d1);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 2:{
			  String name = view.getDepartmentName();
			  int id = view.getDepartmentId();
			  Department d1 = new Department(id, name);
			  int i = model.update(d1);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 3:{
			  int id = view.getDepartmentId();
			  int i = model.delete(id);
			  System.out.println(i!=0 ? "Success" : "Something went wrong");
		  }
		  break;
		  
		  case 4:{
			  List<Department> list = model.read();
			  for(Department d : list) {
				  System.out.println(d);
			  }
			  System.out.println();
		  }
		  break;
		  
		  case 5: {
			  int id = view.getDepartmentId();
			  Department d = model.search(id);
			  if(d!=null) {
				  System.out.println(d);
			  }else {
				  System.out.println("Department not Found");
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
