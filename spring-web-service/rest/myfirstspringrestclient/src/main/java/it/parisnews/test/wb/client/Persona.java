package it.parisnews.test.wb.client;

public class Persona {

	private int id;
	private String nome;
	private String cognome;
	private int eta;
	
	
	public Persona() {
		
	}
	
	

	public Persona(int id, String nome, String cognome, int eta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public int getEta() {
		return eta;
	}



	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
	public void stampaPersona(){
		System.out.println("=== Stampo Persona ===");
		System.out.println("Id Persona: " + this.id);
		System.out.println("Nome: " + this.nome);
		System.out.println("Cognome: " + this.cognome);
		System.out.println("Eta': " + this.eta);
		System.out.println("=== Fine Stampa Persona ===");
	}
	
}
