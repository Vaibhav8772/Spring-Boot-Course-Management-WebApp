package com.chatnlt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatnlt.entities.Testimonial;


@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

}
