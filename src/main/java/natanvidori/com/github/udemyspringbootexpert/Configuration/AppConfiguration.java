package natanvidori.com.github.udemyspringbootexpert.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
@Profile("development")
public class AppConfiguration {
    
    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("Rodando a configuração de desenvolvimento");
        };
    }
}
