package es.upm.isst.grupo07.diy4rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
@OpenAPIDefinition(info = @Info(
        title = "Diy4rent API",
        version = "1.0",
        description = "API to track and load parcels' tracking information"
))
public class Diy4rentApplication {

	public static void main(String[] args) {
		SpringApplication.run(Diy4rentApplication.class, args);
	}

}
