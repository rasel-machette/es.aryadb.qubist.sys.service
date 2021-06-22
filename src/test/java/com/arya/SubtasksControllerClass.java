package com.arya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.arya.controller.SubtasksController;
import com.arya.entities.Story;
import com.arya.entities.Subtasks;
import com.arya.exception.ResourceNotFoundException;
import com.arya.repository.SubtasksRepository;
import com.arya.service.SubtasksService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubtasksControllerClass {
	
	@Autowired
	private SubtasksService subtasksService;
	@MockBean
	private  SubtasksRepository subtasksRepository;
	@InjectMocks
	private SubtasksController subtasksController;
	
	@Test
	public void insertSubtasksTest() {
		Subtasks subtasks = new Subtasks(1L,"Hridoy","fhghg","cdcgf","kjhj","hgf");
		when(subtasksRepository.save(subtasks)).thenReturn(subtasks);
		assertEquals(subtasks, subtasksService.insertSubtasks(subtasks));
	}

	@Test
	public void getAllSubtasksTest() {
		when(subtasksRepository.findAll()).thenReturn(Stream.of(new Subtasks(1L,"Hridoy","fhghg","cdcgf","kjhj","hgf")).collect(Collectors.toList()));
		assertEquals(1, subtasksService.getAllSubtasks().size());
	}
	
	@Test
	public void getSubtasksByIdstoryTest() throws ResourceNotFoundException {
		String subtasksIdstory= "Hridoy";
		when(subtasksRepository.findByIdstory(subtasksIdstory)).thenReturn(Stream.of(new Subtasks(1L,"Hridoy","fhghg","cdcgf","kjhj","hgf")).collect(Collectors.toList()));
		Assert.assertEquals(true, subtasksService.getSubtasksByIdstory(subtasksIdstory).toString().contains("Hridoy"));

   }
	@Test
	public void getSubtasksByAssignedTest() throws ResourceNotFoundException {
		String subtasksAssigned= "ghg";
		when(subtasksRepository.findByAssigned(subtasksAssigned)).thenReturn(Stream.of(new Subtasks(1L,"Hridoy","fhghg","cdcgf","kjhj","hgf")).collect(Collectors.toList()));
		Assert.assertEquals(true, subtasksService.getSubtasksByAssigned(subtasksAssigned).toString().contains("ghg"));

   }
	
}
