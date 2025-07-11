package com.chatnlt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatnlt.entities.Testimonial;
import com.chatnlt.repository.TestimonialRepository;

@Service
public class TestimonialService {

	
	 @Autowired
	    private TestimonialRepository testimonialRepo;

	    public List<Testimonial> getAllTestimonials() {
	        return testimonialRepo.findAll();
	    }
	
	
	
}
