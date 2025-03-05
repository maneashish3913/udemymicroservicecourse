package com.eazybytes.loans.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s not found with the given data %s: %s",resourceName,fieldName,fieldValue));
    }
}
