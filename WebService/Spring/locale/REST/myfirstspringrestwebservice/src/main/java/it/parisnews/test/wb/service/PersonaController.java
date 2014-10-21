package it.parisnews.test.wb.service;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	
	private PersonaRepository persone;

	@Autowired
	public PersonaController(PersonaRepository persone) {
		this.persone = persone;	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Persona getPersona(@PathVariable("id")int id){
		
		Persona p = persone.getPersona(id);
		return p;
		
	}
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void putPersona(@PathVariable("id")int id, @RequestBody Persona persona){
		//System.out.println("nome: " + persona.getNome());
		persone.aggiornaPersona(persona);
	}
	
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePersona(@PathVariable("id")int id){
		persone.cancellaPersona(id);
		
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Persona createPersona(@RequestBody Persona persona, BindingResult result, HttpServletResponse response)throws BindException{
		if(result.hasErrors()){
			throw new BindException(result);
		}/*fine if*/
		
		persone.aggiungiPersona(persona);
		
		response.setHeader("Location", "/persona/" + persona.getId());
		return persona;
			
	}/*fine metodo createPersona*/
	
	
	
	
	
	
	
	
	

}
