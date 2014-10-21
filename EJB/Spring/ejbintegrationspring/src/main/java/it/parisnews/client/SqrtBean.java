package it.parisnews.client;

import business.SqrtSessionRemote;

public class SqrtBean implements SqrtSessionRemote {
	
	private SqrtSessionRemote service;
	
	public SqrtBean() {
		
	}
		

	public SqrtSessionRemote getService() {
		return service;
	}


	public void setService(SqrtSessionRemote service) {
		this.service = service;
	}


	public double getSqrt(double numero) {
		double ris = service.getSqrt(numero);
		return ris;
	}

}
