package it.uniroma3.dia.asw.rmi.server;


import it.uniroma3.dia.asw.rmi.service.SqrtService;
import it.uniroma3.dia.asw.rmi.service.SqrtServiceException;

public class SqrtServiceImpl implements SqrtService{

	public double getSqrt(Double n) throws SqrtServiceException {
		double ris;
			if(n == null){
				throw new SqrtServiceException("Valore nullo");
			}
			if(Double.isNaN(n)){
				throw new SqrtServiceException("Valore non valido");
			}
			if(n < 0){
				throw new SqrtServiceException("Valore negativo");
			}
			ris = Math.sqrt(n);
		
		System.out.println("Risultato " + ris);		
		return ris;
	}

}
