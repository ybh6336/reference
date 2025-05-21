package ybh.ai.springai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestContainersConfiguration.class)
@SpringBootTest
class SpringAiApplicationTests {

	@Test
	void contextLoads() {
	}

}
