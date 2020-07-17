package com.sba.pm.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="task")
public class TaskEntity {

		@Id
		@Column(name="task_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY )
		private Integer id;
		
		@Column(name="task")
		private String task;
		
		@Column(name ="start_dt")
		private Date startDate;
		
		@Column(name="end_dt")
		private Date endDate;
		
		@Column(name="priority")
		private Integer priority;
		
		@Column(name="status")
		private Integer status;
		
		@OneToOne(mappedBy = "taskData")
		@JsonIgnoreProperties(value = { "projectData", "taskData" }, allowSetters = true)
		private UserEntity userData;

		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="parent_id")
		private ParentTaskEntity parentTask;
		
		@ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
		@JoinColumn(name="project_id")
		@JsonIgnoreProperties(value = { "user", "task" }, allowSetters = true)
		private ProjectEntity projectEntity;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public ParentTaskEntity getParentTask() {
			return parentTask;
		}

		public void setParentTask(ParentTaskEntity parentTask) {
			this.parentTask = parentTask;
		}

		public String getTask() {
			return task;
		}

		public void setTask(String task) {
			this.task = task;
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

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public UserEntity getUserData() {
			return userData;
		}

		public void setUserData(UserEntity userData) {
			this.userData = userData;
		}

		public ProjectEntity getProjectEntity() {
			return projectEntity;
		}

		public void setProjectEntity(ProjectEntity projectEntity) {
			this.projectEntity = projectEntity;
		}

}
