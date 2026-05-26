package hms.model;

public class Bill {
private int id;
private int patient_id;
private int apt_id;
private boolean is_paid;
private double amount;

public Bill() {
	super();
}

public Bill(int id, int patient_id, int apt_id, boolean is_paid, double amount) {
	super();
	this.id = id;
	this.patient_id = patient_id;
	this.apt_id = apt_id;
	this.is_paid = is_paid;
	this.amount = amount;
}

public Bill(int patient_id, int apt_id, boolean is_paid, double amount) {
	super();
	this.patient_id = patient_id;
	this.apt_id = apt_id;
	this.is_paid = is_paid;
	this.amount = amount;
}

public int getId() {
	return id;
}

public int getPatient_id() {
	return patient_id;
}

public void setPatient_id(int patient_id) {
	this.patient_id = patient_id;
}

public int getApt_id() {
	return apt_id;
}

public void setApt_id(int apt_id) {
	this.apt_id = apt_id;
}

public boolean isIs_paid() {
	return is_paid;
}

public void setIs_paid(boolean is_paid) {
	this.is_paid = is_paid;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public void setId(int id) {
	this.id = id;
}

@Override
public String toString() {
	return "Bill [id=" + id + ", patient_id=" + patient_id + ", apt_id=" + apt_id + ", is_paid=" + is_paid + ", amount="
			+ amount + "]";
}


}
