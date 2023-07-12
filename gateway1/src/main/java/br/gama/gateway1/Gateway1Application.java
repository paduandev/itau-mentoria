package br.gama.gateway1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class Gateway1Application {
	public static void main(String[] args) {
		SpringApplication.run(Gateway1Application.class, args);
	}

	@Bean
	RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("variavel", "valor"))
						.uri("http://httpbin.org"))
				.route(p -> p
					.host("*.circuitbreaker.com")
					.filters( f -> f.circuitBreaker( config -> 
						config.setName("myBreaker").setFallbackUri("forward:/fallback")))
					.uri("http://httpbin.org")
				)
				.build();
	}

	@GetMapping("/fallback")
	Mono<String> fallback() {
		return Mono.just("Falha no serviço. Tente novamente mais tarde");
	}
}
