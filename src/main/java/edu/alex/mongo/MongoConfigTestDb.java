package edu.alex.mongo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import lombok.Data;

@Configuration
@EnableMongoRepositories(basePackages = "edu.alex.mongo", mongoTemplateRef = "testMongoDb")
@PropertySource("classpath:mongo-${env}.properties")
public class MongoConfigTestDb {
	
	static @Data class MongoProps {
		private String url;
		private String database;
	}
	
	@Bean
	@ConfigurationProperties(prefix="testdb")
	protected MongoProps getProperties() {
		return new MongoProps();
	}
	
	@Bean("testMongoDb")
	public MongoTemplate primaryMongoTemplate() throws Exception {
		final MongoProps props = getProperties();
		final MongoClientURI uri = new MongoClientURI(props.getUrl());
		return new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(uri), props.getDatabase()));
	}
}
