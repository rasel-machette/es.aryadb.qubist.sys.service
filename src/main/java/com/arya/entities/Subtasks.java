package com.arya.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="subtasks")
public class Subtasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Component")
	private String component;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;

	@Column(name = "Assigned")
	private String assigned;

	private String idstory;
	
	
    Subtasks() {
		super();
	}


	public Subtasks(Long id, String component, String name, String description, String assigned, String idstory) {
		super();
		this.id = id;
		this.component = component;
		this.name = name;
		this.description = description;
		this.assigned = assigned;
		this.idstory = idstory;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getComponent() {
		return component;
	}


	public void setComponent(String component) {
		this.component = component;
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


	public String getIdstory() {
		return idstory;
	}


	public void setIdstory(String idstory) {
		this.idstory = idstory;
	}


	@Override
	public String toString() {
		return "Subtasks [id=" + id + ", component=" + component + ", name=" + name + ", description=" + description
				+ ", assigned=" + assigned + ", idstory=" + idstory + "]";
	}


	
}

