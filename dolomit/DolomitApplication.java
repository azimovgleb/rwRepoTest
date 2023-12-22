package rw.vtb.dolomit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DolomitApplication {

	public static void main(String[] args) {
		SpringApplication.run(DolomitApplication.class, args);
	}

}
