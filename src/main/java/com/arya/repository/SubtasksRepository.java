package com.arya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.arya.entities.Subtasks;
@Repository
public interface SubtasksRepository extends JpaRepository<Subtasks, Long>{
	 

	       public List<Subtasks> findByAssigned(String assigned);
	       public List<Subtasks> findByIdstory(String idstory);
	   

	
	}
