package com.service;

import java.util.List;

import com.entity.Course;
import com.vo.CourseStudentVO;

public interface CourseService {

	public void save(Course course);

	public List<Course> findAll();

	public void deleteById(Integer courseId);

	public List<CourseStudentVO> findCourseStudent();

	public List<CourseStudentVO> findCourseStudentByStudentId(Integer studentId);

}
