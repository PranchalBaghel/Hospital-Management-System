package hms.model;

public class Doctor {
private int id;
private String name;
private String Specialist;
private int dept_id;


public Doctor() {
	super();
}


public Doctor(int id, String name, String specialist, int dept_id) {
	super();
	this.id = id;
	this.name = name;
	Specialist = specialist;
	this.dept_id = dept_id;
}


public Doctor(String name, String specialist, int dept_id) {
	super();
	this.name = name;
	Specialist = specialist;
	this.dept_id = dept_id;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getSpecialist() {
	return Specialist;
}


public void setSpecialist(String specialist) {
	Specialist = specialist;
}


public int getDept_id() {
	return dept_id;
}


public void setDept_id(int dept_id) {
	this.dept_id = dept_id;
}


@Override
public String toString() {
	return "Doctor [id=" + id + ", name=" + name + ", Specialist=" + Specialist + ", dept_id=" + dept_id + "]";
}



}
