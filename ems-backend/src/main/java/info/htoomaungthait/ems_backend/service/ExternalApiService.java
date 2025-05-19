package info.htoomaungthait.ems_backend.service;

import info.htoomaungthait.ems_backend.dto.RandomJokeDto;

public interface ExternalApiService {

    public RandomJokeDto fetchJoke();
}
