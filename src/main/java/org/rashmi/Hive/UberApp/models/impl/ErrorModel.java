package org.rashmi.Hive.UberApp.models.impl;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorModel {
	private String errorMessage;
	private Integer errorCode;
	private String documentation;
	
	public ErrorModel(String errorMessage, Integer errorCode, String documentation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	
	public ErrorModel() {
		
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getDocumentation() {
		return documentation;
	}
	
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

}