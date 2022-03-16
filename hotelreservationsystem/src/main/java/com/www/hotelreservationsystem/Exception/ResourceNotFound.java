package com.www.hotelreservationsystem.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	
	public ResourceNotFound(String resourceName, String fieldName, long id) {
		
		super(String.format("%s not fount with %s : %s, resourceName,fieldName, fieldValue"));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = id;
		
	}



	public String getResourceName() {
		return resourceName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public Object getFieldValue() {
		return fieldValue;
	}
	
	
	
}