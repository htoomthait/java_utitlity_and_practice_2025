package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.RandomJokeDto;
import info.htoomaungthait.ems_backend.service.ExternalApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {

    private final WebClient webClient;

    public ExternalApiServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    public RandomJokeDto fetchJoke(){
        return webClient.get()
                .uri("https://official-joke-api.appspot.com/random_joke")
                .retrieve()
                .bodyToMono(RandomJokeDto.class)
                .block(); // For synchronous blocking call
    }
}
