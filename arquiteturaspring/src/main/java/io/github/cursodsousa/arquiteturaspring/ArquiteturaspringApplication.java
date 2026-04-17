package io.github.cursodsousa.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class ArquiteturaspringApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ArquiteturaspringApplication.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(ArquiteturaspringApplication.class);
		builder.run(args);

		// Context started
		builder.bannerMode(Banner.Mode.OFF);
		ConfigurableApplicationContext applicationContext = builder.context();
		// var productRepository = applicationContext.getBean("productRepository");
		builder.profiles("dev");
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println(applicationName);

		ValueExample value = applicationContext.getBean(ValueExample.class);
		value.printValue();

		AppProperties appProperties = applicationContext.getBean(AppProperties.class);
		System.out.println(appProperties.getValue1());
	}

}
