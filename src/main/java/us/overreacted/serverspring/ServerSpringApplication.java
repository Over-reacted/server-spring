package us.overreacted.serverspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */

@SpringBootApplication
@EnableMongoAuditing
public class ServerSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerSpringApplication.class, args);
    }

}
