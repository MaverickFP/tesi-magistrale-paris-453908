package it.parisnews.test.wb.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;



@WebService
public class UserRepository {	
	
	//vedere se e' idoneo mettere tutta la logica di business in una classe separata
	
	private static final List<User> utenti = new ArrayList<User>();
	
	public UserRepository(){
		User pippo = new User();
		pippo.setUserid(1);
		pippo.setName("Pippo");
		pippo.setSurname("PippoSurname");
		pippo.setAge(18);
		pippo.setCity("Paperopoli");
		
		utenti.add(pippo);
		
		User frank = new User();
		frank.setUserid(2);
		frank.setName("Francesco");
		frank.setSurname("Paris");
		frank.setAge(27);
		frank.setCity("Latina");
		
		utenti.add(frank);
		
		
		User u3 = new User();
		u3.setUserid(3);
		u3.setName("Roberto");
		u3.setSurname("Stellone");
		u3.setAge(40);
		u3.setCity("Frosinone");
		
		utenti.add(u3);
		
	}	
	
	
	@WebMethod
	public int delUser(int i){
		int ris = 0; //0 -> errore			
		for(Iterator<User> iterator = utenti.iterator(); iterator.hasNext();){
			User p = iterator.next();
			if(i == p.getUserid()){
				iterator.remove();
				ris = 1; //1 -> ok
			}/*fine if*/			
		}/*fine for*/		
		return ris;
	}/*fine metodo delUser*/
	
	
	
	@WebMethod
	public User findUser(int i){
		
		User result = null;		
		for(User user : utenti){
			if(i== user.getUserid()){
				result = user;
			}
		}/*fine for*/
		return result;		
	}
	
	
	@WebMethod
	public User addUser(User p){		
		User newUser = new User();
		newUser.setUserid(p.getUserid());
		newUser.setName(p.getName());
		newUser.setSurname(p.getSurname());
		newUser.setAge(p.getAge());
		newUser.setCity(p.getCity());
		utenti.add(newUser);
		return newUser;
	}/*fine addUser*/	
	

}
