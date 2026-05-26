package hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import hms.model.Appointment;
import hms.model.Doctor;

public class AppointmentDao {
	//insert
    public int insert(Appointment p1) {
    	int i =0;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("insert into appointment(appointment_date , appointment_time , patient_id , doctor_id) values (?,?,?,?)");
		    pst.setDate(1, p1.getApt_date());
			pst.setTime(2, p1.getApt_time());
			pst.setInt(3, p1.getPatient_id());
			pst.setInt(4, p1.getDoctor_id());
			
			i = pst.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return i;
    }
    
  //update 
    public int update(Appointment p1) {
    	int i =0;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("update appointment set appointment_date = ? , appointment_time = ? , patient_id = ?, doctor_id = ? where id=?");
			 pst.setDate(1, p1.getApt_date());
			 pst.setTime(2, p1.getApt_time());
			 pst.setInt(3, p1.getPatient_id());
			 pst.setInt(4, p1.getDoctor_id());
			 pst.setInt(5, p1.getId());
			
			i = pst.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return i;
    }
    
  //delete
    public int delete(int id) {
    	int i =0;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("delete from appointment where id = ?");
			pst.setInt(1, id);
			
			i = pst.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return i;
    }
    
  //read
    public List<Appointment> read(){
    	List<Appointment> list = new LinkedList<Appointment>();
    	
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from appointment");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Appointment(rs.getInt("id"), rs.getDate("appointment_date"), rs.getTime("appointment_time") , rs.getInt("patient_id"), rs.getInt("doctor_id")));
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return list;
    }
    
  //search 
    public Appointment search(int id) {
    	Appointment a = null;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from appointment where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				//a = new Appointment()
				a = new Appointment(rs.getInt("id") ,rs.getDate("appointment_date"), rs.getTime("appointment_time") , rs.getInt("patient_id"), rs.getInt("doctor_id"));
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return a;
    }
    
  //patient visit history
    public void PatientVisitHistory() {
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select p.id as Patient_Id ,  p.name as Patient_Name , d.name as Doctor_Name  , a.appointment_date , a.appointment_time from appointment a join patient p on a.patient_id = p.id join doctor d on a.doctor_id = d.id");
			ResultSet rs = pst.executeQuery();
			System.out.println("==== Patient visit history ====");
			System.out.println();
			while(rs.next()) {
			System.out.println( "Patient_id : "+  rs.getInt("Patient_Id")+ " | Patient Name : " + rs.getString("Patient_Name") + " | Doctor Name : " + rs.getString("Doctor_Name") + " | Appointment_Date : " + rs.getDate("Appointment_Date") + " | Appointment_Time : " + rs.getTime("Appointment_Time"));
			
			}
			System.out.println();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    }
}
