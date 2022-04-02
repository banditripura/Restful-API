package com.springbootjdbc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjdbc.exceptions.ExceptionResponse;
import com.springbootjdbc.exceptions.NoContentFoundException;
import com.springbootjdbc.exceptions.StudentNotFoundException;
import com.springbootjdbc.model.Student;
import com.springbootjdbc.service.Studentservice;

@RestController
public class StudentController {

	@Autowired
	private Studentservice  studentservice;

	@GetMapping(value = "byID")
	public ResponseEntity<Student> getUser(@RequestParam int studentid) throws SQLException {
		Student user = studentservice.getStudentbyId(studentid);
		if (user == null) {
			throw new StudentNotFoundException("Student with id " + studentid + " not found", HttpStatus.NOT_FOUND.value());
		}
		return new ResponseEntity<Student>(user,HttpStatus.OK);
	}
	
	@GetMapping("/select")
	public List<Student> getStudent() throws ClassNotFoundException, SQLException {
		List<Student> list=studentservice.getStudent();
		if(list.isEmpty())
			throw new NoContentFoundException("no Students avaliable in Database", HttpStatus.NO_CONTENT.value());
		return list;
	}

	@PostMapping(value = "/insert")
	public ResponseEntity<Student> createUser(@RequestBody Student stu) throws SQLException {
		if(studentservice.getStudentbyId(stu.getStudentid())!=null) {
			return new ResponseEntity("Student with given id is already avaliable in DB",HttpStatus.CONFLICT);
		}
		studentservice.createUser(stu);
		return new ResponseEntity<Student>(HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{studentid}")
	public ResponseEntity<Student> removestudent(@PathVariable("studentid") int studentid) throws ClassNotFoundException, SQLException {
		int count= studentservice.removestudent(studentid);
		if (count == 0) {
			return new ResponseEntity("No student found with studentid::" + studentid ,null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("students deleted successfully",null, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Student> updatestudent(@RequestBody Student stu)throws ClassNotFoundException, SQLException{
		int count= studentservice.updatestudent(stu);
		if (count == 0) {
			return new ResponseEntity("No student found with studentid::" + stu.getStudentid() ,null, HttpStatus.NOT_FOUND);      
		}
		return new ResponseEntity("student updated successfully", HttpStatus.OK);
	}

}
