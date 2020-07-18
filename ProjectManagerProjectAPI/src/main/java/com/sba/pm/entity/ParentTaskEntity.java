package com.sba.pm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="parent_task")
@JsonIgnoreProperties(value = { "taskEntity"}, allowSetters = true)
public class ParentTaskEntity {
	@Id
	@Column(name="parent_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="parent_task")
	private String parentTask;
	
	@OneToMany(mappedBy="parentTask",  cascade = CascadeType.ALL)
	private List<TaskEntity> taskEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public List<TaskEntity> getTaskEntity() {
		return taskEntity;
	}

	public void setTaskEntity(List<TaskEntity> taskEntity) {
		this.taskEntity = taskEntity;
	}

}
