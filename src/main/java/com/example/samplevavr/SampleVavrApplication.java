package com.example.samplevavr;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.vavr.collection.Queue;
import io.vavr.collection.Stream;
import io.vavr.control.Try;

@SpringBootApplication
public class SampleVavrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleVavrApplication.class, args);
	}

	public void print(Object o) {
		System.out.println(o);
	}

	@Override
	public void run(String... args) throws Exception {

		String s = io.vavr.collection.List.of(args).mkString(", ");
		print(s);
	}

	public void listSample() {
		List<String> list = Collections.unmodifiableList(Collections.emptyList());
		// list.add("why not?");

		io.vavr.collection.List<Integer> list1 = io.vavr.collection.List.of(1, 2, 3);
		print(list1);

		io.vavr.collection.List<Integer> list2 = list1.tail().prepend(0);
		print(list2);
	}

	public void queueSample() {
		Queue<Integer> queue = Queue.of(1, 2, 3).enqueue(4).enqueue(5);
		print("[first]");
		print(queue);
		queue = queue.dequeue()._2().dequeue()._2.dequeue()._2.dequeue()._2.dequeue()._2;
		print(queue.dequeueOption());
		print("[last]");
		print(queue);
	}

	String join(String... words) {
		//@formatter:off
		return io.vavr.collection.List.of(words)
				.intersperse(", ")
				.foldLeft(new StringBuilder(), StringBuilder::append)
				.toString();
		//@formatter:on
	}

	public void sampleList() {
		// io.vavr.collection.Stream
		// java.uti.java.util.stream.Stream
		// vavrはjava8の前に出たものかも、java8のクラスで同じことができる
		List<String> list = Stream.of(1, 2, 3).map(Object::toString).collect(Collectors.toList());
		// list.stream().forEach(c -> print(c));
		list.stream().forEach(this::print);
	}

	private Try<Integer> divide(Integer dividend, Integer divisor) {
		return Try.of(() -> dividend / divisor);
	}

	public void sampleTry() {
		Try<Integer> t = divide(10, 0);
		print(t);
	}
}
