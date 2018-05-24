package com.zaicamp.base.project.util.constants;

public enum MachineStatus {
	
	OFF("Off"), ON("On");
	
	private String status;
	
	private MachineStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}

}
