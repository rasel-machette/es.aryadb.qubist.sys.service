package com.arya.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.arya.entities.Story;
import com.arya.exception.ResourceNotFoundException;
import com.arya.service.StoryService;

@RestController
@RequestMapping("/arya/v1.0")
public class StoryController {
	@Autowired
	private StoryService storyService;
	
	
		 @GetMapping(
		   	        value = "/story",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Story> getAllStory(){
			 return this.storyService.getAllStory();
			
		}	
		
	    @GetMapping(
		   	        value = "/story", params = "id",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Story> getStoryById(@RequestParam(value = "id") Long storyId)
				throws ResourceNotFoundException {
			 
			 return storyService.getStoryById(storyId);
		}
			
		 @GetMapping(
				    value = "/story", params = "name",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		 public ResponseEntity<List<Story>> getStoryByName(@RequestParam(value = "name") String storyName)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryByName(storyName);
		}
		
		
		 @GetMapping(
				    value = "/story", params = "summary",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		 public ResponseEntity<List<Story>> getStoryBySummary(@RequestParam(value = "summary") String storySummary)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryBySummary(storySummary);
		}	 
		
	
		 @GetMapping(
				    value = "/story", params = "description",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Story>> getStoryByDescription(@RequestParam(value = "description") String storyDescription)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryByDescription(storyDescription);
		} 
		 
		 
		
		 @GetMapping(
				    value = "/story", params = "owner",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Story>> getStoryByOwner(@RequestParam(value = "owner") String storyOwner)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryByOwner(storyOwner);
		} 
		 	 
	
		 @GetMapping(
				    value = "/story", params = "priority",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Story>> getStoryByPriority(@RequestParam(value = "priority") String storyPriority)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryByPriority(storyPriority);
		} 	 
		 
	
		 @GetMapping(
				    value = "/story", params = "assigned",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Story>> getStoryByAssigned(@RequestParam(value = "assigned") String storyAssigned)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryByAssigned(storyAssigned);
		} 	 
		  
	  
		 @PostMapping(
	 	        value = "/story",
	 	        consumes = MediaType.APPLICATION_JSON_VALUE)
		public Story insertStory(@Validated @RequestBody Story story) {
			 
			return storyService.insertStory(story);
		}
		

		 @PutMapping(
				    value = "/story", params = "id",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Story> updateStory(@RequestParam(value = "id") Long storyId,
				@Validated @RequestBody Story storyDetails) throws ResourceNotFoundException {
			
			return storyService.updateStory(storyId, storyDetails);
			
		}
		
		@DeleteMapping(
				value = "/story", params = "id",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
		public Map<String, Boolean> deleteStory(@RequestParam(value = "id") Long storyId)
				throws ResourceNotFoundException {
			
			return storyService.deleteStory(storyId);
  }
	
	}
