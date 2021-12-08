package com.company.stream.basic.mapTo;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToMain {
	public static void main(String[] args) {

		/**
		 * 원시 Stream <-> Stream
		 */
		IntStream.range(1, 4)
				.mapToObj(i -> "o" + i)
				.forEach(e -> System.out.print(e + " "));

		System.out.println();

		Stream.of(1.0, 2.0, 3.0, 4.0)
				.mapToInt(Double::intValue)
				.mapToObj(i -> "o" + i)
				.forEach(e -> System.out.print(e + " "));

	}
}
