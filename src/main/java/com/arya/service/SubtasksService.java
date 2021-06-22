package com.arya.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arya.controller.ProposalController;
import com.arya.entities.Proposal;
import com.arya.entities.Subtasks;
import com.arya.exception.ResourceNotFoundException;
import com.arya.repository.SubtasksRepository;

@Service
public class SubtasksService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProposalController.class);
	@Autowired
	private  SubtasksRepository subtasksRepository;
	
	
	
	
	public List<Subtasks> getAllSubtasks(){
		LOGGER.info("Start process");
		  return this.subtasksRepository.findAll();
		
	}

	public ResponseEntity<List<Subtasks>> getSubtasksByIdstory(String subtasksIdstory)
			throws ResourceNotFoundException {
		
		LOGGER.info("Start process");
		    List<Subtasks> subtasks = subtasksRepository.findByIdstory(subtasksIdstory);
				return ResponseEntity.ok().body(subtasks);
	}
	
	
	

	public ResponseEntity<List<Subtasks>> getSubtasksByAssigned(String subtasksAssigned)
			throws ResourceNotFoundException {
		
		LOGGER.info("Start process");
		    List<Subtasks> subtasks = subtasksRepository.findByAssigned(subtasksAssigned);
				return ResponseEntity.ok().body(subtasks);
	}
	public Subtasks insertSubtasks(Subtasks subtasks) {
		LOGGER.info("Start process");
		   return subtasksRepository.save(subtasks);
	}
	

}