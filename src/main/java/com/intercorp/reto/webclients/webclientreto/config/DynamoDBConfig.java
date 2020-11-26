package com.intercorp.reto.webclients.webclientreto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;


@Configuration
public class DynamoDBConfig {
		
	private static final DynamoDBMapperConfig.TableNameResolver TABLE_NAME_RESOLVER = (className, config) -> "clients";
	ClientConfiguration getClientConfiguration() {
		ClientConfiguration cfg = new ClientConfiguration();
		cfg.setProtocol(Protocol.HTTPS);
		//cfg.setProxyHost(proxyHost);
		cfg.setProxyPort(8099);
		return cfg;
	}


	@Bean(name="dynamoDBMapper")
	public DynamoDBMapper dynamoDBMapperLocal() {
		Regions region = Regions.US_EAST_1;
		DynamoDBMapperConfig dbMapperConfig = new DynamoDBMapperConfig.Builder().withTableNameResolver(TABLE_NAME_RESOLVER).build();
		AmazonDynamoDBClient dynamoClient = getAmazonDynamoDBLocalClient(region);
		return new DynamoDBMapper(dynamoClient,dbMapperConfig);
	}

	private AmazonDynamoDBClient getAmazonDynamoDBLocalClient(Regions region) {
		return (AmazonDynamoDBClient) AmazonDynamoDBClientBuilder.standard()
			.withRegion(region).build();
	}

	
	private AmazonDynamoDBClient getAmazonDynamoDBClient(Regions region) {
		return (AmazonDynamoDBClient) AmazonDynamoDBClientBuilder.standard()
		.withCredentials(new DefaultAWSCredentialsProviderChain())
		.withClientConfiguration(getClientConfiguration()).withRegion(region).build();
	}

}