package ybh.ai.springai;

import org.springframework.boot.SpringApplication;

public class TestSpringaiApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringAiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
