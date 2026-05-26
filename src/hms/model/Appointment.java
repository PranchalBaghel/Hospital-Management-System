package hms.model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	
private int id;
private Date apt_date;
private Time apt_time;
private int patient_id;
private int doctor_id;

public Appointment(int id, Date apt_date, Time apt_time, int patient_id, int doctor_id) {
	super();
	this.id = id;
	this.apt_date = apt_date;
	this.apt_time = apt_time;
	this.patient_id = patient_id;
	this.doctor_id = doctor_id;
}

public Appointment(Date apt_date, Time apt_time, int patient_id, int doctor_id) {
	super();
	this.apt_date = apt_date;
	this.apt_time = apt_time;
	this.patient_id = patient_id;
	this.doctor_id = doctor_id;
}

public Appointment() {
	super();
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getApt_date() {
	return apt_date;
}
public void setApt_date(Date apt_date) {
	this.apt_date = apt_date;
}
public Time getApt_time() {
	return apt_time;
}
public void setApt_time(Time apt_time) {
	this.apt_time = apt_time;
}
public int getPatient_id() {
	return patient_id;
}
public void setPatient_id(int patient_id) {
	this.patient_id = patient_id;
}
public int getDoctor_id() {
	return doctor_id;
}
public void setDoctor_id(int doctor_id) {
	this.doctor_id = doctor_id;
}
@Override
public String toString() {
	return "Appointment [id=" + id + ", apt_date=" + apt_date + ", apt_time=" + apt_time + ", patient_id=" + patient_id
			+ ", doctor_id=" + doctor_id + "]";
}


}
