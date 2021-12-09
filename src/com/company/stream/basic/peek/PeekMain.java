package com.company.stream.basic.peek;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PeekMain {
	public static void main(String[] args) {

		/**
		 * Stream에 영향을 주지 않고 특정 연산을 수행하기 위한 peek함수가 존재한다
		 * peek 함수는 파라미터로 함수형 인터페이스 Consumer를 인자로 받는다
		 */
		int intStream = IntStream.of(1, 2, 3)
				.peek(System.out::println)
				.sum();
		System.out.println("sum = " + intStream);

	}
}
