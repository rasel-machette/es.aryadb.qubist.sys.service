package com.arya.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.arya.entities.Proposal;
import com.arya.entities.Subtasks;
import com.arya.exception.ResourceNotFoundException;
import com.arya.service.ProposalService;


@RestController
@RequestMapping("/arya/v1.0")
public class ProposalController {
	
	@Autowired
	private ProposalService proposalService;
	
	 @GetMapping(
	   	        value = "/proposal",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<Proposal> getAllProposal(){
		 return this.proposalService.getAllProposal();
		
	}	
	
	 @GetMapping(
	   	        value = "/proposal", params = "id",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Proposal> getProposalById(@RequestParam(value = "id") Long proposalId)
			throws ResourceNotFoundException {
		 return proposalService.getProposalById(proposalId);
	}
	
	
	 @GetMapping(
			 value = "/proposal", params = "name",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proposal>> getProposalByName(@RequestParam(value = "name") String proposalName)
			throws ResourceNotFoundException {
		 return proposalService.getProposalByName(proposalName);
	}
	
	
	 @GetMapping(
			 value = "/proposal", params = "summary",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Proposal>> getProposalBySummary(@RequestParam(value = "summary") String proposalSummary)
			throws ResourceNotFoundException {
		 return proposalService.getProposalBySummary(proposalSummary);
	}	 
	 	 
	 
	 @GetMapping(
			    value = "/proposal", params = "description",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proposal>> getProposalByDescription(@RequestParam(value = "description") String proposalDescription)
			throws ResourceNotFoundException {
		 return proposalService.getProposalByDescription(proposalDescription);
	}	 
	
	 @GetMapping(
			    value = "/proposal", params = "owner",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proposal>> getProposalByOwner(@RequestParam(value = "owner") String proposalOwner)
			throws ResourceNotFoundException {
		 return proposalService.getProposalByOwner(proposalOwner);
	}
	 

	 @GetMapping(
			    value = "/proposal", params = "priority",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proposal>> getProposalByPriority(@RequestParam(value = "priority") String proposalPriority)
			throws ResourceNotFoundException {
		 return proposalService.getProposalByPriority(proposalPriority);
	}
	 
 
	 @PostMapping(
 	        value = "/proposal",
 	        consumes = MediaType.APPLICATION_JSON_VALUE)
    public Proposal insertProposal(@Validated @RequestBody Proposal proposal) {
		 return proposalService.insertProposal(proposal);
	}
	
	 @PutMapping(
	 	        value = "/proposal", params = "id",
	 	        consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Proposal> updateProposal(@RequestParam(value = "id") Long proposalId,
			@Validated @RequestBody Proposal proposalDetails) throws ResourceNotFoundException {
		return proposalService.updateProposal(proposalId, proposalDetails);
		
	}
	
	@DeleteMapping(value = "/proposal", params = "id",
 	        consumes = MediaType.APPLICATION_JSON_VALUE)
	  public Map<String, Boolean> deleteProposalById(@RequestParam(value = "id") Long proposalId)
			throws ResourceNotFoundException {
		return proposalService.deleteProposalById(proposalId);
 }
	
}
