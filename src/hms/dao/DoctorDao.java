package hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import hms.model.Doctor;
import hms.model.Patient;

public class DoctorDao {
	//insert
    public int insert(Doctor p1) {
    	int i =0;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("insert into doctor(name,specialist,dept_id) values (?,?,?)");
			pst.setString(1, p1.getName());
			pst.setString(2, p1.getSpecialist());
			pst.setInt(3, p1.getDept_id());
			
			i = pst.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return i;
    }
    
  //update 
    public int update(Doctor p1) {
    	int i =0;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("update doctor set name = ? ,specialist = ? ,dept_id = ? where id=?");
			pst.setString(1, p1.getName());
			pst.setString(2, p1.getSpecialist());
			pst.setInt(3, p1.getDept_id());
			pst.setInt(4, p1.getId());
			
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
			PreparedStatement pst = con.prepareStatement("delete from doctor where id = ?");
			pst.setInt(1, id);
			
			i = pst.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return i;
    }
    
   //read
    public List<Doctor> read(){
    	List<Doctor> list = new LinkedList<Doctor>();
    	
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from doctor");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Doctor(rs.getInt("id") , rs.getString("name") , rs.getString("specialist"), rs.getInt("dept_id")));
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return list;
    }
  
  //search 
    public Doctor search(int id) {
    	Doctor d = null;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from doctor where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				//d = new Doctor()
				d = new Doctor(rs.getInt("id") , rs.getString("name") ,rs.getString("specialist"), rs.getInt("dept_id"));
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return d;
    }
    
  //doctor workload report
    public void doctorworkloadreport() {
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select d.id, d.name , d.specialist , count(a.id) as total_appointments " + 
    		"from doctor d " + 
			"left join appointment a " + 
    		"on d.id = a.doctor_id " + 
			"group by d.id, d.name , d.specialist");
			
			ResultSet rs = pst.executeQuery();
			System.out.println("====  Doctor Workload History  ====");
			System.out.println();
			while(rs.next()) {
				System.out.println("Doctor Id : " + rs.getInt("id") + " | Name : " + rs.getString("name") + " | Specialist " + rs.getString("specialist") +" | Total Appointment : "+rs.getInt("total_appointments"));
			}
			System.out.println();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    }
    
    
}
