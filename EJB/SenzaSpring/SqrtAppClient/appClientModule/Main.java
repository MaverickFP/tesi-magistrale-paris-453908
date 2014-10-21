import java.util.Properties;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import business.SqrtSessionRemote;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//LOCALE
			//InitialContext ic = new InitialContext();
			//SqrtSessionRemote service = (SqrtSessionRemote) ic.lookup("SqrtSession");
			//========
			
			
			//REMOTO
			
			Properties p = new Properties();
			p.setProperty("java.naming.factory.initial", 
                    "com.sun.enterprise.naming.SerialInitContextFactory");

			p.setProperty("java.naming.factory.url.pkgs", 
                    "com.sun.enterprise.naming");

			p.setProperty("java.naming.factory.state",
                    "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
			
			//p.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");			
			p.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.1.3");
			
			p.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
			InitialContext ic = new InitialContext(p);
			String jndiName = "java:global/EntSqrtEJB/SqrtSession!business.SqrtSessionRemote"; 
			//SqrtSessionRemote service = (SqrtSessionRemote) ic.lookup("SqrtSession");
			SqrtSessionRemote service = (SqrtSessionRemote) ic.lookup(jndiName);
			
			
			System.out.println("Inserire un numero");
			Scanner in = new Scanner(System.in);
			double numero = in.nextDouble();
					
			double ris = service.getSqrt(numero);
			System.out.println("La radice quadrata di " + numero + " e' " + ris);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}