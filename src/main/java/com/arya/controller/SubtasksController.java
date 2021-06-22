package com.arya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arya.entities.Proposal;
import com.arya.entities.Subtasks;
import com.arya.exception.ResourceNotFoundException;
import com.arya.service.SubtasksService;

@RestController
@RequestMapping("/arya/v1.0")
public class SubtasksController {
	
	@Autowired
	private SubtasksService subtasksService;
	
	
	 @GetMapping(
	   	        value = "/subtask",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<Subtasks> getAllSubtasks(){
		 return this.subtasksService.getAllSubtasks();
		
	}
	 @GetMapping(
	   	        value = "/subtask", params = "idstory",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Subtasks>> getSubtasksByIdstory(@RequestParam(value = "idstory") String subtasksIdstory)
			throws ResourceNotFoundException {
		 return subtasksService.getSubtasksByIdstory(subtasksIdstory);
	} 
	 
	 

	 @GetMapping(
	   	        value = "/subtask", params = "assigned",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Subtasks>> getSubtasksByAssigned(@RequestParam(value = "assigned") String subtasksAssigned)
			throws ResourceNotFoundException {
		 return subtasksService.getSubtasksByAssigned(subtasksAssigned);
	}
	 
	 @PostMapping(
	 	        value = "/subtask",
	 	        consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Subtasks insertSubtasks(@Validated @RequestBody Subtasks subtasks) {
			 return subtasksService.insertSubtasks(subtasks);
		}  
    
}