package net.htoomaungthait.junit.practice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class JUnitPracticeApplicationTests {

	@Test
	void contextLoads() {
        assertEquals(true, true);
	}

}
