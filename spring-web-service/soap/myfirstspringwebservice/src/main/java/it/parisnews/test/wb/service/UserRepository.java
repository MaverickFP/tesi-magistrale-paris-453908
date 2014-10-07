package it.parisnews.test.wb.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import it.parisnews.serviceschema.*;

@Component
public class UserRepository {
	private static final List<User> utenti = new ArrayList<User>();
	
	@PostConstruct
	public void initData(){
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
	
	
	public User findUser(int i){
		Assert.notNull(i);
		User result = null;
		
		for(User user : utenti){
			if(i== user.getUserid()){
				result = user;
			}
		}/*fine for*/
		
		
		
		return result;
		
	}
	
	
	
	public User addUser(User p){
		Assert.notNull(p);
		User newUser = new User();
		newUser.setUserid(p.getUserid());
		newUser.setName(p.getName());
		newUser.setSurname(p.getSurname());
		newUser.setAge(p.getAge());
		newUser.setCity(p.getCity());
		utenti.add(newUser);
		return newUser;
	}/*fine addUser*/
	
	
	
	public int delUser(int i){
		int ris = 0;
		Assert.notNull(i);
		
		for(Iterator<User> iterator = utenti.iterator(); iterator.hasNext();){
			User p = iterator.next();
			if(i == p.getUserid()){
				iterator.remove();
				ris = 1;
			}/*fine if*/
			
		}/*fine for*/
		
		return ris;
	}/*fine metodo delUser*/
	
	
	
	

}
