package com.ptsc.tcms;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class TCMSServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TCMSApplicationStarter.class);
	}

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		super.onStartup(container);
	}
	
}
