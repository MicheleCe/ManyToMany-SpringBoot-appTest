package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer courseId;

	private String title;

	private String description;

	@JsonIgnore
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();

	public Course(String title, String description) {
		this.title = title;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", description=" + description + "]";
	}

}
