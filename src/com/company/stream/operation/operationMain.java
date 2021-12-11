package com.company.stream.operation;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class operationMain {
	public static void main(String[] args) {

		OptionalInt min = IntStream.of(1, 2, 3).min();
		System.out.println("min = " + min.getAsInt());
		int max = IntStream.of().max().orElse(0);
		System.out.println("max = " + max);
		IntStream.of(1, 2, 3).average().ifPresent(System.out::println);

		long count = IntStream.of(1, 2, 3, 4, 5).count();
		long sum = LongStream.of(1, 2, 3, 4, 5).sum();
		System.out.println("count = " + count + "   sum = " + sum);

	}
}
