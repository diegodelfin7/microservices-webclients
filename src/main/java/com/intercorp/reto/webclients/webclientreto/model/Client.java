package com.intercorp.reto.webclients.webclientreto.model;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;


public class Client implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@DynamoDBHashKey(attributeName = "id")
	@DynamoDBAutoGeneratedKey
	private String id;

	@DynamoDBAttribute(attributeName = "firstName")
	private String firstName;

	@DynamoDBAttribute(attributeName = "lastName")
	private String lastName;

	@DynamoDBAttribute(attributeName = "birthday")
	private String birthday;

	@DynamoDBAttribute(attributeName = "age")
	private int age;

	@DynamoDBAttribute(attributeName = "suggestionDof")
	private String suggestionDof;


	public String getId(){
		return id;
	}
	
	public void setId(final String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(final String birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
        this.age = age;
	}
	
	public String getSuggestionDof() {
		return suggestionDof;
	}

	public void setSuggestionDof(final String suggestionDof) {
        this.suggestionDof = suggestionDof;
	}
	/*
	public String suggestionDOF(String birthday){
		//return Utils.calculate(birthday);
		return birthday;
	}
	*/

}
