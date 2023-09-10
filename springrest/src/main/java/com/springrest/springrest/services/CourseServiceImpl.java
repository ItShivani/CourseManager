package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	//List<Courses> list;
	public CourseServiceImpl() {
		/*list = new ArrayList<>();
		list.add(new Courses(101,"Introduction to Java","This course is focussed on teaching the basics of Java programming"));
		list.add(new Courses(576,"Introduction to Machine Learning","This course is focusses on teaching the basics of Machine Learning"));
		*/
	}
	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		return courseDao.findAll();
	}
	@Override
	public Courses getCourse(long courseId) {
		// TODO Auto-generated method stub
		/*Courses c = null;
		for(Courses course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;*/
		return courseDao.getOne(courseId);
	}
	@Override
	public Courses addCourse(Courses course) {
		// TODO Auto-generated method stub
		//list.add(course);
		courseDao.save(course);
		return course;
	}
	@Override
	public Courses updateCourse(Courses course) {
		// TODO Auto-generated method stub
		/*for(Courses c:list) {
			if(course.getId()==c.getId()) {
				c.setId(course.getId());
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
				break;
			}
		}
		return course;*/
		courseDao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		/*for(Courses c:list) {
			if(c.getId()==courseId) {
				list.remove(c);
				break;
			}
		}
		return list;*/
		courseDao.delete(courseDao.getOne(courseId));
		
	}
	
	

}
