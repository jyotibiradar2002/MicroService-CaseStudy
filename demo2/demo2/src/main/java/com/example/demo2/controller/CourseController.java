package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.intercomm.StudentClient;
import com.example.demo2.model.Course;
import com.example.demo2.model.Student;
import com.example.demo2.repository.CourseRepository;



@RestController
@RequestMapping("/course")
public class CourseController {
	public String sayHi() {
		return "Hello from spring boot!";
	}
	
	@Autowired
	CourseRepository respository;
	
	@Autowired
	StudentClient studClient;
	
	@GetMapping("/view")
	public List<Course> getCourses(){
		return respository.findAll();
	}
	
	@GetMapping("/service/stud/{studId}")
	public Student getstud(@PathVariable int studId) {
		return studClient.getStudent(studId);
	}
	
	/*@GetMapping("/get")
	public List<Course>getCourse()
	{
		System.out.println("get Course");
		List<Course> courseList = respository.findAll();
		return courseList;
	}
	*/
	
		/*@GetMapping("/course/find")
	 public Student getStudentById(@RequestParam("id") int id) {
		 Optional<Student> stud=respository.findById(id);
		 if(stud.isPresent()) {
			 return stud.get();
		 }
		 else {
			 return null;
		 }
		 
	 }*/
	//http://localhost:8082/home/student/find?id=105
	
	/*
	@GetMapping("/course/find/{id}")
	 public Course getStudentById(@PathVariable("id") int id) {
		 Optional<Course> course=respository.findById(id);
		 if(course.isPresent()) {
			 return course.get();
		 }
		 else {
			 return null;
		 }
		 
	 }
	//http://localhost:8082/home/student/find/104 
	*/
}
