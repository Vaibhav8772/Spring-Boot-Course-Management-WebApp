package com.chatnlt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatnlt.entities.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
