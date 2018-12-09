package com.example.samplevavr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.vavr.control.Try;

@SpringBootApplication
public class SampleVavrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleVavrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Try<Integer> t = divide(10, 0);
		System.out.println(t);
	}

	private Try<Integer> divide(Integer dividend, Integer divisor) {
		return Try.of(() -> dividend / divisor);
	}
}
