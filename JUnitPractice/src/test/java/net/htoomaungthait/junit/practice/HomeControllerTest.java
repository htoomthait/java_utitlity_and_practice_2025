package net.htoomaungthait.junit.practice;

import net.htoomaungthait.junit.practice.controllers.HomeController;
import net.htoomaungthait.junit.practice.respond.FmtResponse;
import net.htoomaungthait.junit.practice.service.HomeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {
    @Mock
    private HomeService homeService;

    @InjectMocks
    private HomeController homeController;

    @Test
    void homeReturnsSuccessResponseWithDefaultName() {
        String defaultName = "Htoo Maung Thait";
        String expectedMessage = "Hello " + defaultName + ", Welcome to Home Page";

        // Use lenient() to prevent the strict stubbing issue
        Mockito.lenient().when(homeService.getWelcomeMessage(null)).thenReturn(expectedMessage);

        FmtResponse<String> response = homeController.home(null);

        assertEquals("HC-001", response.getStatusCode());
        assertEquals("success", response.getMessage());
        assertEquals(expectedMessage, response.getData());
    }

    @Test
    void homeReturnsSuccessResponseWithCustomName() {
        String customName = "John Doe";
        String expectedMessage = "Hello " + customName + ", Welcome to Home Page";
        Mockito.when(homeService.getWelcomeMessage(customName)).thenReturn(expectedMessage);

        FmtResponse<String> response = homeController.home(customName);

        assertEquals("HC-001", response.getStatusCode());
        assertEquals("success", response.getMessage());
        assertEquals(expectedMessage, response.getData());
    }

    @Test
    void homeHandlesNullResponseFromService() {
        String name = "Jane Doe";
        Mockito.when(homeService.getWelcomeMessage(name)).thenReturn(null);

        FmtResponse<String> response = homeController.home(name);

        assertEquals("HC-001", response.getStatusCode());
        assertEquals("success", response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void homeReturnsSuccessResponseWithDefaultNameII() {
        // In Spring controllers, @RequestParam handles null differently than in direct method calls
        // Need to mock what really happens when controller is called with null parameter
        Mockito.when(homeService.getWelcomeMessage(null)).thenReturn("Hello Htoo Maung Thait, Welcome to Home Page");

        FmtResponse<String> response = homeController.home(null);

        assertEquals("HC-001", response.getStatusCode());
        assertEquals("success", response.getMessage());
        assertEquals("Hello Htoo Maung Thait, Welcome to Home Page", response.getData());
    }
}
