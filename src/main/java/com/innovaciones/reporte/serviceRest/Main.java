/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.Cliente;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author pisama
 */
public class Main {

    public static final String REST_SERVICE_URI = "http://localhost:8080/connector-1.0/rest";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers() {
        System.out.println("Testing listAllUsers API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI + "/reporteService/jasper/5", List.class);

        if (usersMap != null) {
            for (LinkedHashMap<String, Object> map : usersMap) {
              //  System.out.println("User : id=" + map.get("id") + ", Name=" + map.get("factura"));;
            }
        } else {
            System.out.println("No user exist----------");
        }
    }

    /* POST */
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setCliente("Patricio Isama from CLIENTE");
        cliente.setEstado(1);

        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/reporteService/user/", cliente, Cliente.class);
        System.out.println("Location : " + uri.toASCIIString());
    }

    public static void main(String args[]) {
          listAllUsers();
      //  createUser();
        //rogue111@mail.com
    }

}
