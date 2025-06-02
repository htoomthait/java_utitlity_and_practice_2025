package info.htoomaungthait.ems_backend.controller;


import info.htoomaungthait.ems_backend.dto.ApiResponse;
import info.htoomaungthait.ems_backend.dto.RandomJokeDto;
import info.htoomaungthait.ems_backend.service.impl.ExternalApiServiceImpl;
import info.htoomaungthait.ems_backend.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/fetch-an-api")
public class SampleFetchApiController {

    private final ExternalApiServiceImpl externalApiService;

    public SampleFetchApiController(ExternalApiServiceImpl externalApiService) {
        this.externalApiService = externalApiService;
    }


    @GetMapping("random-joke")
    public ResponseEntity<ApiResponse<RandomJokeDto>> getAJokeFromWebService(){

        RandomJokeDto randomJokeDto =  this.externalApiService.fetchJoke();

        return ResponseUtil.success(randomJokeDto);
    }

    @PostMapping("sample-post-product")
    public ResponseEntity<ApiResponse<Boolean>> makePostSampleProduct(){
        Boolean response = this.externalApiService.postAProduct();

        return ResponseUtil.success(response);
    }
;}
