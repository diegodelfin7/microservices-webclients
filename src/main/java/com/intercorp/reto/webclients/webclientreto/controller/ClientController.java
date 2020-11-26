package com.intercorp.reto.webclients.webclientreto.controller;

import java.util.List;

import com.intercorp.reto.webclients.webclientreto.services.ClientService;
import com.intercorp.reto.webclients.webclientreto.model.Client;
import com.intercorp.reto.webclients.webclientreto.model.KpiClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class ClientController{


    @Autowired
    private ClientService clientService;

    @GetMapping("/healthy")
    public String healthy(){
        return "healthy";
    }

    @PostMapping("/creacliente")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/listclientes")
    public List<Client> listCustomers() {
        return clientService.listClients();
    }

    @GetMapping("/kpideclientes")
    public KpiClients getKpiClients(){
        return clientService.getKpiClients();
    }
}