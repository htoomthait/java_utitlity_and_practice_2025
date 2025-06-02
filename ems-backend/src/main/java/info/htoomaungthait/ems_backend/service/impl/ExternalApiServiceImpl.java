package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.RandomJokeDto;
import info.htoomaungthait.ems_backend.dto.SampleProductDataDto;
import info.htoomaungthait.ems_backend.dto.SampleProductDto;
import info.htoomaungthait.ems_backend.service.ExternalApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
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

    public boolean postAProduct(){
        SampleProductDataDto sampleProductDataDto = new SampleProductDataDto();

        sampleProductDataDto.setCpuModel("M4 Pro");
        sampleProductDataDto.setPrice(2750.5);
        sampleProductDataDto.setHardDiskSize("512 GB");
        sampleProductDataDto.setYear(2024);

        SampleProductDto sampleProductDto = new SampleProductDto();
        sampleProductDto.setName("Macbook pro M4 2024");
        sampleProductDto.setData(sampleProductDataDto);

        try{
            String response = webClient
                    .post()
                    .uri("https://api.restful-api.dev/objects")
                    .bodyValue(sampleProductDto)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(3)) // set timeout here
                    .block();
            System.out.println("Response: " + response);
            return true;
        }catch(WebClientResponseException ex){
            System.err.println("HTTP error: " + ex.getStatusCode() + " - " + ex.getResponseBodyAsString());
        }catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }

        return false;

    }

}
