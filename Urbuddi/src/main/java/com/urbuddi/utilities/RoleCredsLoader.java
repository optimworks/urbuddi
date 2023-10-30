package com.urbuddi.utilities;

import net.thucydides.core.util.EnvironmentVariables;

public class RoleCredsLoader {

	private final EnvironmentVariables environmentVariables;

	public RoleCredsLoader(EnvironmentVariables environmentVariables) {
	        this.environmentVariables = environmentVariables;
	    }

	public String getUsername(String role) {
		String propertyName = role + ".username";
        String username = environmentVariables.getProperty(propertyName);
        return username;
	}

	public String getPassword(String role) {
		 String propertyName = role + ".password";
	        String password = environmentVariables.getProperty(propertyName);
	        return password;
	}

}
