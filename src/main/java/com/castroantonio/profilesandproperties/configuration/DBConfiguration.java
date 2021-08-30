package com.castroantonio.profilesandproperties.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {
	private String driverClassName;
    private String url;
    private String username;
    private String password;
    
    
    @Profile("dev")
    @Bean //Just to show values when it starts.
    public void developmentDataTableConnection() {
    	showValues();
	}
    
    @Profile("prod")
    @Bean //Just to show values when it starts.
    public void  productionDataTableConnection() {
    	showValues();
	}
    
    private void showValues() {
    	//Just shows the configuration loaded in the console:
    	System.out.println(driverClassName);
    	System.out.println(url);
    	System.out.println(username);
    	System.out.println(password);
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}