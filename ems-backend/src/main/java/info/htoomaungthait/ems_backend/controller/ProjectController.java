package info.htoomaungthait.ems_backend.controller;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/employees")
public class ProjectController {

    public ProjectController(){

    }


    public void getAllProject(){

    }

    public ResponseEntity<ApiResponseV2<String>> getProjectById(){
        ApiResponseV2<String> response = new ApiResponseV2<String>("success", "here is your project", "your project");
        return ResponseEntity.ok().body(response);
    }

    public void createProjectBy(){

    }

    public void updateProjectById(){

    }

    public void deleteProjectById(){

    }
}
