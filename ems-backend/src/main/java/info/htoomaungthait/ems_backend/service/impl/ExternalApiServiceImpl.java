package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.RandomJokeDto;
import info.htoomaungthait.ems_backend.service.ExternalApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

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
                .timeout(Duration.ofSeconds(3)) // ⏱️ 3-second timeout
                .retryWhen(Retry.backoff(2, Duration.ofMillis(500))) // 🔁 Retry with backoff
                .onErrorResume(ex -> {
                    // Log or handle error
                    return Mono.error(new RuntimeException("API call failed: " + ex.getMessage()));
                }).block();
    }

}
