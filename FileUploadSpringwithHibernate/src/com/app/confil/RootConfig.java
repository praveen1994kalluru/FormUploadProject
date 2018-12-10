package com.app.confil;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RootConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {
				ApplicationConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{
				ApplicationConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"*.htm"};
	}

}
