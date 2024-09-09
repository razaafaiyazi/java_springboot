package com.bloggingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private long fieldValue;
    private String resourceName;
    private String fieldName;
    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue){
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.fieldName=fieldName;
        this.resourceName=resourceName;
        this.fieldValue=fieldValue;
    }
    public long getFieldValue(){
        return this.fieldValue;
    }
    public String getResourceName(){
        return this.resourceName;
    }
    public String getFieldName(){
        return this.fieldName;
    }

}
