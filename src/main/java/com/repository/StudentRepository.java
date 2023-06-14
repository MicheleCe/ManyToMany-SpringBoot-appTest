package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// This method executes a native SQL query that inserts a new row into the
	// student_courses table with the specified student_id and course_id. The
	// @Modifying annotation indicates that the method performs a modifying
	// operation, and the @Transactional annotation starts a transaction before the
	// method is executed.

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO student_courses (student_id, course_id) VALUES (:studentId, :courseId)", nativeQuery = true)
	public void addCourseToStudent(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM student_courses WHERE student_Id = :studentId and course_Id = :courseId", nativeQuery = true)
	public void removeCourseStudentRelation(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

	@Query(value = "SELECT s FROM Student s WHERE s.firstName = :studentNameOrLastName or s.lastName = :studentNameOrLastName")
	public List<Student> findByLastNameOrFirstName(@Param("studentNameOrLastName") String studentNameOrLastName);

}
