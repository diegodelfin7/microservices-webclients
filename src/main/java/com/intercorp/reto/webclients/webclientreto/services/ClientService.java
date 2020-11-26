package com.intercorp.reto.webclients.webclientreto.services;

import java.util.List;

import com.intercorp.reto.webclients.webclientreto.model.Client;
import com.intercorp.reto.webclients.webclientreto.model.KpiClients;
import com.intercorp.reto.webclients.webclientreto.utils.Utils;
import com.intercorp.reto.webclients.webclientreto.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
   
    public List<Client> listClients() {
        return clientRepository.getAllClients();
    }

    
    public KpiClients getKpiClients() {
        
        List<Client> clients = clientRepository.getAllClients();
        int[] ages = new int[clients.size()];
        for(int i= 0; i < clients.size(); i++) {
            ages[i] = clients.get(i).getAge();
        }

        KpiClients kpiClients = new KpiClients();
        kpiClients.setAgeAvarage(Utils.getAverage(ages));
        kpiClients.setStandarDeviation(Utils.process(ages));
        return kpiClients;
        
    }
    
}