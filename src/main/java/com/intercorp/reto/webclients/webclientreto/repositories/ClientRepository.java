package com.intercorp.reto.webclients.webclientreto.repositories;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intercorp.reto.webclients.webclientreto.model.Client;
import com.intercorp.reto.webclients.webclientreto.utils.Utils;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
@Repository
public class ClientRepository{


    private static final Logger LOOGGER = LoggerFactory.getLogger(ClientRepository.class);

    @Resource(name="dynamoDBMapper")
    DynamoDBMapper dbMapper;
    
    /*
    @Autowired
    private DynamoDBMapper mapper;
    */

    public Client save( Client client) {
        client.setSuggestionDof(Utils.calculate(client.getAge()));
        dbMapper.save(client);
        return client;
    }

    public List<Client> getAllClients(){
        List<Client> result = new ArrayList<Client>();
        try {
            result = dbMapper.scan(Client.class, new DynamoDBScanExpression());
        } catch(final Exception e) {
            LOOGGER.error(e.getMessage());
        }
        return result;
    }
    
}