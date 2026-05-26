package hms;

import hms.controller.AppointmentController;
import hms.controller.BillController;
import hms.controller.DepartmentController;
import hms.controller.DoctorController;
import hms.controller.HospitalController;
import hms.controller.PatientController;

import hms.dao.AppointmentDao;
import hms.dao.BillDao;
import hms.dao.DepartmentDao;
import hms.dao.DoctorDao;
import hms.dao.PatientDao;

import hms.view.AppointmentView;
import hms.view.BillView;
import hms.view.DepartmentView;
import hms.view.DoctorView;
import hms.view.HospitalView;
import hms.view.PatientView;

public class Main {
	public static void main(String[] args) {
		
		//patient module
		
		PatientView pv = new PatientView();
		PatientDao pm = new PatientDao();
		PatientController pc = new PatientController(pv,pm);
		
		//doctor module
		
		DoctorView dv = new DoctorView();
		DoctorDao dm = new DoctorDao();
		DoctorController dc = new DoctorController(dv,dm);
		
		//department module
		
		DepartmentView dv1 = new DepartmentView();
		DepartmentDao dm1 = new DepartmentDao();
		DepartmentController dc1 = new DepartmentController(dv1,dm1);
		
		//bill module 
		
		BillView bv = new BillView();
		BillDao bm = new BillDao();
		BillController bc = new BillController(bv,bm);
		
		//appointment module
		
		AppointmentView av = new AppointmentView();
		AppointmentDao am = new AppointmentDao();
		AppointmentController ac = new AppointmentController(av,am);
		
		//	hospital view
		
		HospitalView hospitalviews = new HospitalView();
		
		//hospital controller
		
		HospitalController hospitalControllers = new HospitalController(hospitalviews,pc ,dc , dc1 ,bc , ac);
		hospitalControllers.start();
	}

}
