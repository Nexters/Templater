package com.templater;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
	
//	@Bean(name = "dataSource")
//    public DataSource getDataSource(){
//        DataSource dataSource = createDataSource();
//        DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
//        return dataSource;
//    }
//
//    private DatabasePopulator createDatabasePopulator() {
//        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//        databasePopulator.setContinueOnError(true);
//        databasePopulator.addScript(new ClassPathResource("schema.sql"));
//        return databasePopulator;
//    }
//
//    private SimpleDriverDataSource createDataSource() {
//        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
//        simpleDriverDataSource.setDriverClass(org.h2.Driver.class);
//        simpleDriverDataSource.setUrl("jdbc:h2:target/database/example;AUTO_RECONNECT=TRUE");
//        simpleDriverDataSource.setUsername("");
//        simpleDriverDataSource.setPassword("");
//        return simpleDriverDataSource;      
//    }

}
