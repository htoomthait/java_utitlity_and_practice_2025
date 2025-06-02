package info.htoomaungthait.ems_backend.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EndPointListingController {
    private final RequestMappingHandlerMapping handlerMapping;

    public EndPointListingController(@Qualifier("requestMappingHandlerMapping") RequestMappingHandlerMapping handlerMapping){
        this.handlerMapping = handlerMapping;
    }

    @GetMapping("/routes")
    public List<String> listEndPoints() {
        return handlerMapping.getHandlerMethods().keySet().stream()
                .map(RequestMappingInfo::toString)
                .sorted()
                .collect(Collectors.toList());
    }



}
