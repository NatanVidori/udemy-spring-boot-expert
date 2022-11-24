package natanvidori.com.github.udemyspringbootexpert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import natanvidori.com.github.udemyspringbootexpert.domain.entity.Client;
import natanvidori.com.github.udemyspringbootexpert.domain.repository.Clients;

@SpringBootApplication
@RestController
public class UdemySpringBootExpertApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clients clients) {
		return args -> {
			System.out.println("Buscando clientes");
			clients.save(new Client("Natan Vidori"));
			clients.save(new Client("João da Silva"));

			List<Client> listClient = clients.listAll();
			listClient.forEach(System.out::println); 

			System.out.println("Atualizando clientes");
			listClient.forEach(c -> {
				c.setName(c.getName() + " - Atualizado");
				clients.update(c);
			});

			System.out.println("Buscando clientes");
			clients.findByName("Natan").forEach(System.out::println);

			System.out.println("Deletar clientes");
			clients.listAll().forEach(c -> {
				clients.deletar(c);
			});

			System.out.println("Buscando clientes");
			listClient = clients.listAll();
			
			if (listClient.isEmpty()) {
				System.out.println("Nenhum cliente encontrado");
			} else {
				listClient.forEach(System.out::println);
			}
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(UdemySpringBootExpertApplication.class, args);
	}

}
