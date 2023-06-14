package com.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString

public class CourseStudentVO {

	@JsonProperty(value = "courseId")
	private Integer courseId;

	@JsonProperty(value = "studentId")
	private Integer studentId;

	@JsonProperty(value = "title")
	private String title;

	@JsonProperty(value = "description")
	private String description;

	@JsonProperty(value = "firstName")
	private String firstName;

	@JsonProperty(value = "lastName")
	private String lastName;

	public CourseStudentVO(String title, String description, String firstName, String lastName) {
		this.title = title;
		this.description = description;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
