package app.university;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "spring.shell.interactive.enabled=false",
    "spring.shell.noninteractive.enabled=false"
})
class UniversityApplicationTests {
    @Test
    void contextLoads() {}
}
