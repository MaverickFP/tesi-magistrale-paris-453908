package it.uniroma3.dia.asw.rmi.client;

import java.security.Permission;

public class MySecurityManager extends SecurityManager {
	 @Override
	    public void checkPermission(Permission perm) {
	        return;
	    }
}
