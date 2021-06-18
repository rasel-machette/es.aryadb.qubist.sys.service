package com.arya.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subtasks")
public class Subtasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "Component")
	private String component;
	
	private String idstory;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;

	@Column(name = "Assigned")
	private String assigned;

    
	public Subtasks() {
		super();
	}


	public Subtasks(String id, String component, String idstory, String name, String description, String assigned) {
		super();
		this.id = id;
		this.component = component;
		this.idstory = idstory;
		this.name = name;
		this.description = description;
		this.assigned = assigned;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getComponent() {
		return component;
	}


	public void setComponent(String component) {
		this.component = component;
	}


	public String getIdstory() {
		return idstory;
	}


	public void setIdstory(String idstory) {
		this.idstory = idstory;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAssigned() {
		return assigned;
	}


	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}


	@Override
	public String toString() {
		return "Subtasks [id=" + id + ", component=" + component + ", idstory=" + idstory + ", name=" + name
				+ ", description=" + description + ", assigned=" + assigned + "]";
	}

	
}

