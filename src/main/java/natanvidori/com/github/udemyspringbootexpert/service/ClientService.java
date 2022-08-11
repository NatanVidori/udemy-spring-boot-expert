package natanvidori.com.github.udemyspringbootexpert.service;

import org.springframework.stereotype.Service;

import natanvidori.com.github.udemyspringbootexpert.model.ClientModel;
import natanvidori.com.github.udemyspringbootexpert.repository.ClientRepository;

@Service
public class ClientService {
    
    private ClientRepository repository; 

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void SalvarClient(ClientModel client) {
        ValidateClient(client);
        this.repository.persist(client);
    }

    public void ValidateClient(ClientModel client) {

    }

    

}