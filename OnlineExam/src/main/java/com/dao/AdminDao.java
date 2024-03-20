package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.Admin;

public class AdminDao {
	
	//connection object...
	private Connection conn;
	
	//constructor for initializing connection object.... 
	public AdminDao(Connection conn)
	{
		this.conn=conn;
	}
	
	
	//validate admin login... 
	public Admin adminlogin(String adname,String pass)
	{
		Admin ad=null;
		
		try {
			String sql="select * from admin where adname=? and pass=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,adname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ad=new Admin();
				ad.setAdname(rs.getString("adname"));
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
		return ad;
	}


	
	
	
}
