package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Question;
import com.entity.Result;

public class ExamDao {
	
	//connection object...
	private Connection conn;
	
	//constructor for initializing connection object.... 
	public ExamDao(Connection conn)
	{
		this.conn=conn;
	}

	// adding new Questions...
	public boolean  addQuestion(Question q)
	{
		boolean f=false;
		
		try {
			String sql="insert into question(question, option1, option2, option3, option4, answer, courseName) values(?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,q.getQuestion());
			ps.setString(2,q.getOption1());
			ps.setString(3,q.getOption2());
			ps.setString(4,q.getOption3());
			ps.setString(5,q.getOption4());
			ps.setString(6,q.getCorrectAnwser());
			ps.setString(7,q.getCourseName());
			int Result=ps.executeUpdate();
			
			if (Result == 1) {
                  
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
	
	
	
	// getting all question with respect to course_name... 
	public List<Question> findbyCourse (String course)
	{
		List<Question> list=new ArrayList<Question>();
		Question q=null;
		try {
			String sql="select * from question where courseName=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, course);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				q=new Question();
				q.setQid(rs.getInt(1));
				q.setQuestion(rs.getString(2));
				q.setOption1(rs.getString(3));
				q.setOption2(rs.getString(4));
				q.setOption3(rs.getString(5));
				q.setOption4(rs.getString(6));
				q.setCorrectAnwser(rs.getString(7));
				q.setCourseName(rs.getString(8));
				list.add(q);
				
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
	
	
	
	
	//getting all course name...
	public List<Question> getAllCourses() {
	    List<Question> list = new ArrayList<>();
	    try {
	        String sql = "SELECT distinct courseName FROM question"; // Include qid in the query
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Question q = new Question();
	           
	            q.setCourseName(rs.getString("courseName")); // Set course name
	            list.add(q);
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
	
	
	
	
	
	//getting question by id
	public Question getQuestionById(int id)
	{
		Question q=null;
		try {
			String sql="select * from question where qid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				q=new Question();
				q.setQid(rs.getInt(1));
				q.setQuestion(rs.getString(2));
				q.setOption1(rs.getString(3));
				q.setOption2(rs.getString(4));
				q.setOption3(rs.getString(5));
				q.setOption4(rs.getString(6));
				q.setCorrectAnwser(rs.getString(7));
				q.setCourseName(rs.getString(8));
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
		
		return q;
	}
	
	
	
	
	
	
	//update existing question by Id
	public boolean UpdateQuestion(Question q)
	{
		boolean f=false;
		try {
			String sql="update question set question =?, option1 =?, option2 =?, option3 =?, option4 =?, answer =?, courseName =? where qid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,q.getQuestion());
			ps.setString(2, q.getOption1());
			ps.setString(3, q.getOption2());
			ps.setString(4, q.getOption3());
			ps.setString(5, q.getOption4());
			ps.setString(6, q.getCorrectAnwser());
			ps.setString(7, q.getCourseName());
			ps.setInt(8, q.getQid());
			
			int i=ps.executeUpdate();
			if (i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	
	
	
	
	
	
	//delete question by id....
	public boolean deleteQuestion(int id)
	{
		boolean f=false;
		try {
			String sql="delete from question where qid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			
			if (i==1) 
			{
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	
	
	
	
	
	// this will save student test record.....
	public boolean resultsave(String name,String course,double score,int totalQuestions,int ObtainMark)
	{
		boolean f=false;
		try {
			String sql="insert into result(name, course, score, totalQuestions, ObtainMark) values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
            ps.setString(2, course);
            ps.setDouble(3, score);
            ps.setInt(4, totalQuestions);
            ps.setInt(5, ObtainMark);
            int i=ps.executeUpdate();

			if (i == 1) {
                  
				f=true;
			}
            
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	
	
	
	
	
	
	// get result of all student and after it is validate to give specific user....
	public List<Result> getResult ()
	{
		List<Result>list=new ArrayList<Result>();
		 Result result=null;
		 try {
			 String sql="select * from result";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				result=new Result();

			result.setId(rs.getInt(1));
			result.setName(rs.getString(2));
			result.setCourse(rs.getString(3));
			result.setScore(rs.getDouble(4));
			result.setTotalQuestions(rs.getInt(5));
			result.setObtainMark(rs.getInt(6));
			
			list.add(result);
				
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
	
	
	
	
	
	
	
	// this will check the student had completed exam or not ?....
	public boolean examdone(String name,String course)
	{
		boolean f=false;
		
		try {
			String sql="select * from result where name=? and course=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, course);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
	            f = true;
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} 
	    
		
		return f;
	}
	
}
