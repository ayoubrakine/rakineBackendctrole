package ayoub.rakine.exam.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ayoub.rakine.exam.entities")
@ComponentScan(basePackages = {"ayoub.rakine.exam.controllers","ayoub.rakine.exam.services"})
@EnableJpaRepositories(basePackages = "ayoub.rakine.exam.repository")
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

}
