package ejb;

import business.SqrtSessionRemote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SqrtSession
 */
@Stateless(mappedName = "SqrtSession")
public class SqrtSession implements SqrtSessionRemote {

    /**
     * Default constructor. 
     */
    public SqrtSession() {
        // TODO Auto-generated constructor stub
    }
    
    public double getSqrt(double numero){
    	return Math.sqrt(numero);
    }

}
