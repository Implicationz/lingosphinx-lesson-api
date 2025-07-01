package com.lingosphinx.lesson;

import org.springframework.boot.SpringApplication;

public class TestLessonApplication {

	public static void main(String[] args) {
		SpringApplication.from(LessonApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
