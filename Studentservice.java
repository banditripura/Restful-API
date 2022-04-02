package com.springbootjdbc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjdbc.model.Student;
import com.springbootjdbc.repositories.StudentJDBC;

@Service
public class Studentservice {
	
	
  @Autowired
  private StudentJDBC  studentJDBC;
  
  public int createUser(Student stu) throws SQLException {
		return studentJDBC.createUser(stu);
	}
  public List<Student> getStudent() throws SQLException {
		return  studentJDBC.getStudent();
	}
  public int removestudent(int studentid) throws SQLException {
		return  studentJDBC.removestudent(studentid);
	}
  public int updatestudent(Student s) throws SQLException {
		return studentJDBC.updatestudent(s);
	}
  public Student getStudentbyId(int studentid) throws SQLException {
		return studentJDBC.getStudentbyId(studentid);
	}

}
  
  

