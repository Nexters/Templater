package com.templater.test;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class TestConfig {
	
	@Value("") //경로설정
	private Resource schemaScript;

	@Value("") 
	private Resource dataScript;

	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
	    final DataSourceInitializer initializer = new DataSourceInitializer();
	    initializer.setDataSource(dataSource);
	    initializer.setDatabasePopulator(databasePopulator());
	    return initializer;
	}

	private DatabasePopulator databasePopulator() {
	    final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	    populator.addScript(schemaScript);
	    populator.addScript(dataScript);
	    return populator;
	}

}
