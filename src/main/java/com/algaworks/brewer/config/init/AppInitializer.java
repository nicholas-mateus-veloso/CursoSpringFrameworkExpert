package com.algaworks.brewer.config.init;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.algaworks.brewer.BrewerApplication;
import com.algaworks.brewer.config.JPAConfig;
import com.algaworks.brewer.config.ServiceConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/*
	 * Faz o gerenciamento dos serviços
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { JPAConfig.class, ServiceConfig.class, BrewerApplication.class };
	}

	/*
	 * Serve para achar as configurações do sistema para os Controllers
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { BrewerApplication.class };
	}

	/*
	 * Serve para achar o caminho dos Controllers definido pelo sistema
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/*
	 * Irá fazer o tratamento de todos os filtros de linguagem para UTF-8
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return new Filter[] { characterEncodingFilter };
	}
	
	/*
	 * Serve para configurar o recebimento de múltiplos arquivos
	 * Ele configura de forma automática o tamanho do arquivo
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}

}
