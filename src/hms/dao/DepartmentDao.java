package hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import hms.model.Department;

public class DepartmentDao {
	//insert
	 public int insert(Department p1) {
	    	int i =0;
	    	try {
	    		Connection con = DBUtil.makeConnection();
				PreparedStatement pst = con.prepareStatement("insert into department(name) values (?)");
				pst.setString(1, p1.getName());
				
				i = pst.executeUpdate();
			} catch (SQLException e) {
			    e.printStackTrace();
			}
	    	return i;
	    }
	 
	//update 
	    public int update(Department p1) {
	    	int i =0;
	    	try {
	    		Connection con = DBUtil.makeConnection();
				PreparedStatement pst = con.prepareStatement("update department set name = ? where id=?");
				pst.setString(1, p1.getName());
				pst.setInt(2, p1.getId());
				
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
				PreparedStatement pst = con.prepareStatement("delete from department where id = ?");
				pst.setInt(1, id);
				
				i = pst.executeUpdate();
			} catch (SQLException e) {
			    e.printStackTrace();
			}
	    	return i;
	    }
	    
	  //read
	    public List<Department> read(){
	    	List<Department> list = new LinkedList<Department>();
	    	
	    	try {
	    		Connection con = DBUtil.makeConnection();
				PreparedStatement pst = con.prepareStatement("select * from department");
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					list.add(new Department(rs.getInt("id") , rs.getString("name")));
				}
				
			} catch (SQLException e) {
			    e.printStackTrace();
			}
	    	return list;
	    }
	    
	  //search 
	    public Department search(int id) {
	    	Department d = null;
	    	try {
	    		Connection con = DBUtil.makeConnection();
				PreparedStatement pst = con.prepareStatement("select * from department where id = ?");
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					//d = new Department()
					d = new Department(rs.getInt("id") , rs.getString("name"));
				}
				
			} catch (SQLException e) {
			    e.printStackTrace();
			}
	    	return d;
	    }

}
