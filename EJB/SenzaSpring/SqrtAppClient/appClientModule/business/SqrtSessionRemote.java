package business;

import javax.ejb.Remote;

@Remote
public interface SqrtSessionRemote {

	double getSqrt(double numero);
	
}
