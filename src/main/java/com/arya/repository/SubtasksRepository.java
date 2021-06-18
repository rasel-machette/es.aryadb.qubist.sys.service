package com.arya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.arya.entities.Subtasks;
@Repository
public interface SubtasksRepository extends JpaRepository<Subtasks, String>{
	 
	
	       public List<Subtasks> findByIdstory(String idstory);
	       public List<Subtasks> findByAssigned(String assigned);
	   

	
	}
