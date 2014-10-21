package it.uniroma3.dia.asw.rmi.service;

public class SqrtServiceException extends Exception{	
	private static final long serialVersionUID = 1L;
	
	private String info;
	
	public SqrtServiceException(String message) {
		//super(message)
		this.info = message;
		System.out.println(message);
	}
	
	public String getInfo(){
		return info;
	}
}
