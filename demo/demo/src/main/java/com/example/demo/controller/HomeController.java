package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	public String sayHi() {
		return "Hello from spring boot!";
	}
	
	@Autowired
	StudentRepository respository;
	@GetMapping("/student")
	public List<Student>getStudent()
	{
		List<Student> studList = respository.findAll();
		return studList;
	}
	@PostMapping("/student/find")
	 public Student getStudentById(@RequestBody int id) {
		 Optional<Student> stud=respository.findById(id);
		 if(stud.isPresent()) {
			 return stud.get();
		 }
		 else {
			 return null;
		 }
		 
	 }
	//http://localhost:8082/home/student/find?id=105
	
	/*
	@GetMapping("/student/find/{id}")
	 public Student getStudentById(@PathVariable("id") int id) {
		 Optional<Student> stud=respository.findById(id);
		 if(stud.isPresent()) {
			 return stud.get();
		 }
		 else {
			 return null;
		 }
		 
	 }*/
	//http://localhost:8082/home/student/find/104

}
