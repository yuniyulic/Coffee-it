package src.com.coffee.domain.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"src.com.coffee.domain"}) //해당 경로 하위에 있는 jpaRepository를 상속한 repository를 scan
@EntityScan(basePackages= {"src.com.coffee.domain"}) //해당 경로 하위에 있는 @Entity 클래스를 scan
@ComponentScan("src.com.coffee.domain")
public class CoffeeItApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeItApplication.class, args);
	}

}
