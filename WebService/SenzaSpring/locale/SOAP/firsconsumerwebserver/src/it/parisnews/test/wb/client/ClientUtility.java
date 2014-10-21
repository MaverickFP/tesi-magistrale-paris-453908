package it.parisnews.test.wb.client;

import it.parisnews.test.wb.service.User;

public class ClientUtility {
	
	
	
	public ClientUtility(){
		
	}
	
	
	public void printUser(User u){
		System.out.println("=== Stampa Utente ===");
		System.out.println("User Id " + u.getUserid());
		System.out.println("Nome " + u.getName());
		System.out.println("Cognome " + u.getSurname());
		System.out.println("Eta' " + u.getAge());
		System.out.println("Citta' " + u.getCity());
		System.out.println("=== Fine Stampa Utente ===");
	}
	
	
	public User addUser(){
		User u = new User();
		u.setUserid(4);
		u.setName("Daniel");
		u.setSurname("Ciofani");
		u.setAge(30);
		u.setCity("Frosinone");
		return u;
	}
	
	

}
