package com.ptsc.tcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = { "com.ptsc.tcms" }, 
		exclude = { org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class TCMSApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(TCMSApplicationStarter.class, args);
	}

}