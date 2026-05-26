package hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import hms.model.Patient;

public class PatientDao {
    //insert
    public int insert(Patient p1) {
    	int i =0;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("insert into patient(name,age,disease) values (?,?,?)");
			pst.setString(1, p1.getName());
			pst.setInt(2, p1.getAge());
			pst.setString(3, p1.getDisease());
			
			i = pst.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return i;
    }
    
    //update 
    public int update(Patient p1) {
    	int i =0;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("update patient set name = ? ,age = ? ,disease = ? where id=?");
			pst.setString(1, p1.getName());
			pst.setInt(2, p1.getAge());
			pst.setString(3, p1.getDisease());
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
			PreparedStatement pst = con.prepareStatement("delete from patient where id = ?");
			pst.setInt(1, id);
			
			i = pst.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return i;
    }
    
    
    //read
    public List<Patient> read(){
    	List<Patient> list = new LinkedList<Patient>();
    	
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from patient");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Patient(rs.getInt("id") , rs.getString("name") , rs.getInt("age"), rs.getString("disease")));
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return list;
    }
    
    //search 
    public Patient search(int id) {
    	Patient p = null;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from patient where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				//p = new Patient()
				p = new Patient(rs.getInt("id") , rs.getString("name") , rs.getInt("age"), rs.getString("disease"));
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return p;
    }
}
