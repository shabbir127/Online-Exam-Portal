package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;
import com.google.protobuf.Empty;

public class StudentDao {
	
	//connection object...
	private Connection conn;
	
	//constructor for initializing connection object.... 
	public StudentDao(Connection conn)
	{
		this.conn=conn;
	}
	
	
	
	
	//it will register Student
	public boolean registerStudent(Student  student)
	{
		boolean f=false;
		try {
			String sql="insert into student(sid, name, email, pass, dob, gender, address, contact) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,student.getSid());
			ps.setString(2,student.getName());
			ps.setString(3,student.getEmail());
			ps.setString(4,student.getPass());
			ps.setString(5,student.getDob());
			ps.setString(6,student.getGender());
			ps.setString(7,student.getAddress());
			ps.setString(8,student.getContact());
			int i=ps.executeUpdate();
			if (i==1) {
				f=true;
			}
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
		return f;
	}

	
	
	
	
	
	//login student by using sid or password...
	public Student studentlogin(String sid,String name,String pass)
	{
		
		Student s=null;
		try {
			String sql = "SELECT * FROM student WHERE sid=? AND name=? AND pass=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, sid);
			ps.setString(2, name);
			ps.setString(3, pass);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				s=new Student();
				s.setSid(rs.getString("sid"));
				s.setName(rs.getString("name"));
				
			}
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
		
		return s;
	}
	
	
	
	
	
	// Get All Student list that are present in database.....
	public List<Student> AllStudent()
	{
		List<Student>list=new ArrayList<Student>();
		Student student=null;
		try {
			String sql="select * from student ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				student=new Student();
				student.setSid(rs.getString(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setDob(rs.getString(5));
				student.setGender(rs.getString(6));
				student.setAddress(rs.getString(7));
				student.setContact(rs.getString(8));
				list.add(student);
			}
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
		
		
		return list;
	}
	
	
	
	
	
	//this will get student By  sid
	public Student getStudentBySid(String sid)
	{
		Student s=null;
		try {
			String sql="select * from Student where sid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,sid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Student();
				s.setSid(rs.getString(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setDob(rs.getString(5));
				s.setGender(rs.getString(6));
				s.setAddress(rs.getString(7));
				s.setContact(rs.getString(8));
				
			}
			
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
		
		return s;
	}
	
	
	
	
	
	//this will  Update existing Student from database....
	public boolean  UpdateStudent(Student student)
	{
		boolean f=false;
		try {
			String sql="update  student set  name=?, email=?,dob=?, gender=?, address=?, contact=?  where sid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getDob());
			ps.setString(4, student.getGender());
			ps.setString(5, student.getAddress());
			ps.setString(6, student.getContact());
			ps.setString(7, student.getSid());
			int i=ps.executeUpdate();
			if (i==1) {
				
				f=true;
			}
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
		
		return f;
	}
	
	
	
	
	
	//delete student by sid
	public boolean deleteStudent(String sid)
	{
		boolean f=false;
		try {
			String sql="delete from student where sid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, sid);
			int i=ps.executeUpdate();
			
			if (i==1) 
			{
				f=true;
			}
			
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
		
		return f;
	}
	
}
