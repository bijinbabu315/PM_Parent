package com.sba.pm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="project")
@JsonIgnoreProperties(value = { "task" }, allowSetters = true)
public class ProjectEntity {
	
	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="project")
	private String project;
	
	@Column(name ="start_dt")
	private Date startDate;
	
	@Column(name="end_dt")
	private Date endDate;
	
	@Column(name="priority")
	private Integer priority;

	@Transient
	private Integer userId;

	@OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "userData", "projectEntity" }, allowSetters = true)
	private List<TaskEntity> task;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<TaskEntity> getTask() {
		return task;
	}

	public void setTask(List<TaskEntity> task) {
		this.task = task;
	}
	
}
