package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Course;
import com.vo.CourseStudentVO;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	@Query("SELECT new com.vo.CourseStudentVO(c.courseId, s.studentId, c.title, c.description, s.firstName, s.lastName) FROM Course c JOIN students s")
	public List<CourseStudentVO> findCourseStudent();

	@Query("SELECT new com.vo.CourseStudentVO(c.title, c.description, s.firstName, s.lastName) FROM Course c JOIN students s WHERE s.studentId = :studentId")
	public List<CourseStudentVO> findCourseStudentByStudentId(Integer studentId);

}
