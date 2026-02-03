package com.example;

import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;


@RestController
public class ClientController {


      WebClient client;
      ReactiveCircuitBreaker circuitBreaker;
      ReactiveResilience4JCircuitBreakerFactory factory;

      
    public ClientController(WebClient client,
                             ReactiveResilience4JCircuitBreakerFactory factory) {
        this.client = client;
        this.factory = factory;

        this.circuitBreaker = factory.create("sample");
    }

    @GetMapping(path = "/client/retry")
    public Mono<String> getMessageByRetry(){

    	return client.get()
    	    .uri("http://localhost:9090/api/v1/info/SBC")
    	    .retrieve()
    	    .bodyToMono(String.class)
    	    .retryWhen(Retry.max(6)
    	        .doBeforeRetry(retrySignal -> {
    	            System.out.println("Retry attempt #" + (retrySignal.totalRetries() + 1));
    	        })
    	    );

    }



    @GetMapping(path = "/client/info")
    public Mono<String> getMessage(){
    	
    	

        return this.circuitBreaker.run(

                client.get().uri("http://localhost:9090/api/v1/flights/SBC")
                        .retrieve()
                                .bodyToMono(String.class).log(),
                                throwable -> Mono.just("Fall back")



        );


    }




}
