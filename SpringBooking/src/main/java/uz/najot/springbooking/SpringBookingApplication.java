package uz.najot.springbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBookingApplication.class, args);
    }

}
