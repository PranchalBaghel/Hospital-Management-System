package hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import hms.model.Bill;

public class BillDao {
	//insert
    public int insert(Bill p1) {
    	int i =0;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("insert into bill(patient_id , appointment_id , amount , is_paid) values (?,?,?,?)");
			pst.setInt(1, p1.getPatient_id());
			pst.setInt(2, p1.getApt_id());
			pst.setDouble(3, p1.getAmount());
			pst.setBoolean(4, p1.isIs_paid());
			
			i = pst.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return i;
    }
    
  //update 
    public int update(Bill p1) {
    	int i =0;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("update bill set patient_id = ? , appointment_id = ? , amount = ? , is_paid = ? where id=?");
			pst.setInt(1, p1.getPatient_id());
			pst.setInt(2, p1.getApt_id());
			pst.setDouble(3, p1.getAmount());
			pst.setBoolean(4, p1.isIs_paid());
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
			PreparedStatement pst = con.prepareStatement("delete from bill where id = ?");
			pst.setInt(1, id);
			
			i = pst.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return i;
    }
    
  //read
    public List<Bill> read(){
    	List<Bill> list = new LinkedList<Bill>();
    	
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from bill");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Bill(rs.getInt("id") , rs.getInt("patient_id"), rs.getInt("appointment_id") ,rs.getBoolean("is_paid") ,rs.getDouble("amount")));
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return list;
    }
    
  //search 
    public Bill search(int id) {
    	Bill b = null;
    	try {
    		Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from bill where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				//b = new Bill()
				b = new Bill(rs.getInt("id") , rs.getInt("patient_id"), rs.getInt("appointment_id") ,rs.getBoolean("is_paid") ,rs.getDouble("amount"));
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	return b;
    }


}
