package com.chatnlt.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.chatnlt.entities.Incident;



public interface IncidentRepository extends JpaRepository<Incident, Integer> {

}

