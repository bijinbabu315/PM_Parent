package com.sba.pm.request;

public class ProjectUpdateRequest {

	Integer projectID;
	
	Integer taskID;
	
	Integer isManager;
	
	Integer userID;
	
	boolean isDelete;

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public Integer getTaskID() {
		return taskID;
	}

	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}

	public Integer getIsManager() {
		return isManager;
	}

	public void setIsManager(Integer isManager) {
		this.isManager = isManager;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
