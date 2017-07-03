package com.microservice.exceptions;

public class DataLayerException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String str1;
	public DataLayerException(String str2) {
       str1=str2;
    }
    public String toString(){ 
       return ("DataLayer Exception "+str1) ;
    }
}
