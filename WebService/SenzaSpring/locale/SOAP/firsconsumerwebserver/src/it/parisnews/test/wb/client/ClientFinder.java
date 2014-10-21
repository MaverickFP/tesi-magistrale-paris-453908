package it.parisnews.test.wb.client;

import it.parisnews.test.wb.service.User;
import it.parisnews.test.wb.service.UserRepository;
import it.parisnews.test.wb.service.UserRepositoryService;

public class ClientFinder {

	public static void main(String[] args) {
		
		
		//per creare le classi di supporto direttamente dal wisdl ho usato
		//i seguenti comandi
		// 1 - aprire il terminale
		// 2 - mkdir sei
		// 3 - cd sei
		// 4 - wsimpor	WSDL_URI
		// questo crea delle cartelle e all'interno dei file .class
		// 5 - wsimport -keep -s src WSDL_URI
		// questo crea nella cartella src delle sottocartelle e dei file.jar
		// 6 - creare il package it.paris.test.wb.service ed all'interno copiare i file.jar appena creati
		// nel caso seguente il WSDL_URI e' http://imac-di-francesco.local:8080/firstwebservice/UserRepositoryService?wsdl
		
		
		UserRepositoryService service = new UserRepositoryService();
		UserRepository userRepository = service.getUserRepositoryPort();
		
		ClientUtility cu = new ClientUtility();
		
		System.out.println("Recupero un utente");
		User u1 = userRepository.findUser(1);
		cu.printUser(u1);
		
		System.out.println("Aggiungo un utente");
		User u2 = cu.addUser();
		userRepository.addUser(u2);
		
		System.out.println("Verifico inserimento utente");
		u1 = userRepository.findUser(4);
		cu.printUser(u1);
		
		System.out.println("Cancello un utente");
		int ris = userRepository.delUser(4);
		if(ris == 1)
			System.out.println("Cancellazione ok");
		else
			System.out.println("Errore nella cancellazione");
		
		

	}

}
