package com.example.demo2.intercomm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo2.model.Student;


@FeignClient("student-service")
public interface StudentClient {
	
	@PostMapping(value="/home/student/find", consumes="application/json")
	Student getStudent(@RequestBody int studId);

}
