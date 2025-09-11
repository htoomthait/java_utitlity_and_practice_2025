package net.htoomaungthait.junit.practice.controller;


import net.htoomaungthait.junit.practice.respond.FmtResponse;
import net.htoomaungthait.junit.practice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends BaseController{

    @Autowired
    private HomeService homeService;

    @RequestMapping("/home")
    @ResponseStatus(HttpStatus.OK)
    public FmtResponse<String> home(
            @RequestParam(value = "name", defaultValue = "Htoo Maung Thait") String name,
            @RequestParam(value = "email", defaultValue = "htoomaungthait@gmail.com") String email
    ) {
        return FmtResponse.of("HC-001", "success", homeService.getWelcomeMessage(name, email));
    }
}
