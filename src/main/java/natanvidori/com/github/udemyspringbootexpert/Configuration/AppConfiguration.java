package natanvidori.com.github.udemyspringbootexpert.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfiguration {
    
    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sistema Spring Boot Expert";
    }
}
