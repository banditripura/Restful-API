package com.springbootjdbc.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootjdbc.model.Student;



@Repository
public class StudentJDBC {

	@Autowired
	private DataSource dataSource;
	List<Student> stu=null;
	Connection con =null;
	Statement stmt=null;
	PreparedStatement pstmt=null;

	public int createUser(Student stu) throws SQLException {
		con =dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into student(studentid,firstname,address) values (?, ?,?)");
		pstmt.setInt(1, stu.getStudentid());
		pstmt.setString(2, stu.getFirstname());
		pstmt.setString(3, stu.getAddress());
		int count =pstmt.executeUpdate();
		con.close();
		return count;
	}
	public List<Student> getStudent() throws SQLException {
		stu=new ArrayList<Student>();
		con =dataSource.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select studentid, firstname, address from student"); 
		while(rs.next()){
			stu.add(new Student( rs.getInt("studentid"),rs.getString("firstname"), rs.getString("address")));
		}
		rs.close();
		con.close();
		return stu;
	}
	public int removestudent(int studentid) throws SQLException {
		con =dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM student where studentid ="+studentid);
		int del = pstmt.executeUpdate();
		con.close();
		return  del;
	}
	public int updatestudent(Student s) throws SQLException 
	{	
		con =dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("UPDATE student SET firstname=? WHERE studentid=?");
		pstmt.setString(1, s.getFirstname());
		pstmt.setInt(2,s.getStudentid());
		int update	=pstmt.executeUpdate();
		con.close();
		return update;
	}

	public Student getStudentbyId(int studentid) throws SQLException {
		con =dataSource.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select studentid, firstname, address from student where studentid="+studentid);
		Student stu = null;
		while(rs.next()) {
			stu=new Student(rs.getInt("studentid"),rs.getString("firstname"),rs.getString("address"));
		}
		rs.close();
		con.close();
		return stu;

	}

}
