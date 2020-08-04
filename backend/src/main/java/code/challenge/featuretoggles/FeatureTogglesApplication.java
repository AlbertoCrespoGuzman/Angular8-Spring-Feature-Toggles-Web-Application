package code.challenge.featuretoggles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FeatureTogglesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeatureTogglesApplication.class, args);
	}

}
