package net.htoomaungthait.junit.practice;

import net.htoomaungthait.junit.practice.controller.HomeController;
import net.htoomaungthait.junit.practice.respond.FmtResponse;
import net.htoomaungthait.junit.practice.service.HomeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {
    @Mock
    private HomeService homeService;

    @InjectMocks
    private HomeController homeController;

    @Test
    void homeReturnsSuccessResponseWithDefaultName() {
        String defaultName = "Htoo Maung Thait";
        String defaultEmail = "htoomaungthait@gmail.com";
        String expectedMessage = "Hello " + defaultName + ", Welcome to Home Page! Will record with your email: " + defaultEmail;

        // Use lenient() to prevent the strict stubbing issue
        Mockito.lenient().when(homeService.getWelcomeMessage(null, null)).thenReturn(expectedMessage);

        FmtResponse<String> response = homeController.home(null, null);

        assertEquals("HC-001", response.getStatusCode());
        assertEquals("success", response.getMessage());
        assertEquals(expectedMessage, response.getData());
    }

    @Test
    void homeReturnsSuccessResponseWithCustomName() {
        String customName = "John Doe";
        String customEmail = "johndone@test.com";
        String expectedMessage = "Hello " + customName + ", Welcome to Home Page! Will record with your email: " + customEmail;
        Mockito.when(homeService.getWelcomeMessage(customName, customEmail)).thenReturn(expectedMessage);

        FmtResponse<String> response = homeController.home(customName, customEmail);

        assertEquals("HC-001", response.getStatusCode());
        assertEquals("success", response.getMessage());
        assertEquals(expectedMessage, response.getData());
    }

    @Test
    void homeHandlesNullResponseFromService() {
        String name = "Jane Doe";
        String email = "janedoe@test.com";
        Mockito.when(homeService.getWelcomeMessage(name, email)).thenReturn(null);

        FmtResponse<String> response = homeController.home(name, email);

        assertEquals("HC-001", response.getStatusCode());
        assertEquals("success", response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void homeReturnsSuccessResponseWithDefaultNameII() {
        // In Spring controllers, @RequestParam handles null differently than in direct method calls
        // Need to mock what really happens when controller is called with null parameter
        Mockito.when(homeService.getWelcomeMessage(null, null)).thenReturn("Hello Htoo Maung Thait, Welcome to Home Page! Will record with your email: htoomaungthait@gmail.com");

        FmtResponse<String> response = homeController.home(null, null);

        assertEquals("HC-001", response.getStatusCode());
        assertEquals("success", response.getMessage());
        assertEquals("Hello Htoo Maung Thait, Welcome to Home Page! Will record with your email: htoomaungthait@gmail.com", response.getData());
    }
}
