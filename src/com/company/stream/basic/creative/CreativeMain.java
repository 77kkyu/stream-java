package com.company.stream.basic.creative;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class CreativeMain {
	public static void main(String[] args) {

		/**
		 * Collection Stream 생성
		 */
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> listStream = list.stream();
		//listStream.forEach(System.out::println);
		System.out.println("Collection Stream");
		listStream.forEach(e -> System.out.print(e + " "));
		System.out.println(" ");
		System.out.println("======================================");
		System.out.println(" ");

		/**
		 * 배열의 Stream 생성
		 */
		Stream<String> stream = Stream.of("a", "b", "c"); // 가변인자
		Stream<String> stream1 = Stream.of(new String[]{"a", "b", "c"});
		Stream<String> stream2 = Arrays.stream(new String[]{"a", "b", "c"});
		Stream<String> stream3 = Arrays.stream(new String[]{"a", "b", "c"}, 0,2); // end 범위를 보함하지 않는다
		System.out.println("배열의 Stream");
		stream3.forEach(e -> System.out.print(e + " "));
		System.out.println(" ");
		System.out.println("======================================");
		System.out.println(" ");

		/**
		 * 원시 Stream 생성
		 */
		IntStream intStream = IntStream.range(4,10); // range()함수를 사용하여 기존의 for문을 대체할 수 있다
		LongStream longStream = LongStream.range(1,3);
		DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3);
		System.out.println("원시 Stream");
		doubleStream.forEach(e -> System.out.print(e + " "));




	}
}
