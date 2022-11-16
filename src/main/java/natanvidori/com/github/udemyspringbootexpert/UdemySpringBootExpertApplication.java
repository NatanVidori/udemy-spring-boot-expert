package natanvidori.com.github.udemyspringbootexpert;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import natanvidori.com.github.udemyspringbootexpert.Configuration.Animal.Animal;
import natanvidori.com.github.udemyspringbootexpert.Configuration.Animal.Cat;

@SpringBootApplication
@RestController
public class UdemySpringBootExpertApplication {

    @Value("${aplication.name}")
    private String applicationName;

	@Cat
	private Animal animal;

	@Bean(name = "executarAnimal")
	public CommandLineRunner executar() {
		return args -> {
			this.animal.makeNoise();
		};
	}

	@GetMapping("/name")
	public String applicationName() {
		return applicationName;
	}

	public static void main(String[] args) {
		SpringApplication.run(UdemySpringBootExpertApplication.class, args);
	}

}
