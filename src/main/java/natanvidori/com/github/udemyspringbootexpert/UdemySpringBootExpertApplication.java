package natanvidori.com.github.udemyspringbootexpert;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UdemySpringBootExpertApplication {

    @Value("${aplication.name}")
    private String applicationName;

	@GetMapping("/name")
	public String applicationName() {
		return applicationName;
	}

	public static void main(String[] args) {
		SpringApplication.run(UdemySpringBootExpertApplication.class, args);
	}

}
