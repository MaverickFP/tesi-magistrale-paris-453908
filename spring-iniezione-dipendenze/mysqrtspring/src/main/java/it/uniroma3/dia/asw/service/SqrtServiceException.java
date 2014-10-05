package it.uniroma3.dia.asw.service;

public class SqrtServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String info;
	
	public SqrtServiceException(String message){
		this.info = message;
		System.out.println(message);
	}
	
	public String getInfo(){
		return info;
	}

	
}
