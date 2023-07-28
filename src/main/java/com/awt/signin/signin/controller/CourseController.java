package com.awt.signin.signin.controller;



import com.awt.signin.signin.entity.Courses;
import com.awt.signin.signin.entity.Section;
import com.awt.signin.signin.entity.SubSection;
import com.awt.signin.signin.repository.CoursesRepository;
import com.awt.signin.signin.repository.SectionRepository;
import com.awt.signin.signin.repository.SubSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CourseController {

	@Autowired
	private CoursesRepository courseRepository;

	@Autowired
	private SectionRepository sectionRepository;

	@Autowired
	private SubSectionRepository subSectionRepository;

	@GetMapping("/courses")
	public List<Courses> getAllCourses() {
		return courseRepository.findAll();
	}

	@GetMapping("/sections")
	public List<Section> getAllSections() {
		return sectionRepository.findAll();
	}

	@GetMapping("/subsections")
	public List<SubSection> getAllSubSections() {
		return subSectionRepository.findAll();
	}


	@PostMapping("/courses")
	public ResponseEntity<String> createCourses(@RequestBody List<Courses> coursesList) {
		List<Courses> savedCourses = new ArrayList<>();
		for (Courses courses : coursesList) {
			Optional<Courses> existingCourse = courseRepository.findByCourseName(courses.getCourseName());

			if (existingCourse.isPresent()) {
				// If the course with the same name already exists, update its details
				Courses existingCourseEntity = existingCourse.get();
				existingCourseEntity.setSections(courses.getSections()); // Reattach existing sections
				courses = existingCourseEntity; // Use the existing course entity
			}

			// Save the course and its associated sections
			List<Section> sections = courses.getSections();
			if (sections != null) {
				for (Section section : sections) {
					Optional<Section> existingSection = sectionRepository.findBySectionName(section.getSectionName());

					if (existingSection.isPresent()) {
						Section existingSectionEntity = existingSection.get();
						existingSectionEntity.setPercentage(section.getPercentage());
						existingSectionEntity.setSubSections(section.getSubSections()); // Reattach existing subsections
						section.setSection_id(existingSectionEntity.getSection_id()); // Set the existing section_id
						section.setCourses(existingSectionEntity.getCourses()); // Set the existing course relationship

					} else {
						// Set the current course as the parent course for the new section
						section.setCourses(courses);
					}

					List<SubSection> subSections = section.getSubSections();
					if (subSections != null) {
						for (SubSection subSection : subSections) {
							Optional<SubSection> existingSubSection = subSectionRepository.findBySubsectionName(subSection.getSubsectionName());

							if (existingSubSection.isPresent()) {
								SubSection existingSubSectionEntity = existingSubSection.get();
								existingSubSectionEntity.setReferenceLink(subSection.getReferenceLink());
								subSection.setSubsection_id(existingSubSectionEntity.getSubsection_id()); // Set the existing subsection_id
								subSection.setSection(existingSubSectionEntity.getSection()); // Set the existing section relationship
								subSection.setCourses(existingSubSectionEntity.getCourses()); // Set the existing course relationship
							} else {
								// Set the current section as the parent section for the new subsection
								subSection.setSection(section);
								// Set the current course as the parent course for the new subsection
								subSection.setCourses(courses);
							}
						}
					}
				}
			}

			savedCourses.add(courses);
		}
		courseRepository.saveAll(savedCourses);

		return ResponseEntity.status(HttpStatus.CREATED).body("Saved Courses Successfully");
	}




	@DeleteMapping("/courses/{course_id}")
	public ResponseEntity<String> deleteCourse(@PathVariable int course_id) {
		Optional<Courses> courseOptional = courseRepository.findById(course_id);
		if (courseOptional.isPresent()) {
			Courses course = courseOptional.get();

			// Delete the course and its associated sections and subsections
			List<Section> sections = course.getSections();
			if (sections != null) {
				for (Section section : sections) {
					// Delete associated subsections
					List<SubSection> subSections = section.getSubSections();
					if (subSections != null) {
						for (SubSection subSection : subSections) {
							subSectionRepository.delete(subSection);
						}
					}
					sectionRepository.delete(section);
				}
			}

			courseRepository.delete(course);
			return ResponseEntity.ok("Course and its associated sections and subsections deleted successfully.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}