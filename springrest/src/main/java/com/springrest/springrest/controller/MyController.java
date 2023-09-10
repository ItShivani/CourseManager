package com.springrest.springrest.controller;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	@GetMapping("/home")
	public String home() {
		return "Welcome to course manager";
	}
	
	//getting all courses
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping(path="/courses",consumes="application/json") //consumes defines the format of input data
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping(path="/courses")
	public Courses updateCourse(@RequestBody Courses course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping(path="/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
		 this.courseService.deleteCourse(Long.parseLong(courseId));
		 return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
