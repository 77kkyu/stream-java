package com.company.stream.advanced.executionOrder;

import java.util.stream.Stream;

/**
 * Stream API의 실행 순서
 */
public class ExecutionOrder {
	public static void main(String[] args) {

		/**
		 * filter먼저 실행하고 반복문이 실행 될 것 같지만,
		 * 각각의 데이터에 대해 filter와 forEach가 먼저 수행하는 수직적 구조로 순회한다
		 * filter 한번 -> forEach한번
		 */
		Stream.of("a", "b", "c", "d", "e")
				.filter(s -> {
					System.out.println("filter = " + s);
					return true;
				})
				.forEach(s -> System.out.println("forEach = " + s));

		System.out.println("=============================================");


		/**
		 * 대문자로 다 치환하고 B를 찾을것 같지만
		 * 하나 치환하고 B를 찾는 구조이다 위에 코드랑 동일
		 * 치환을 다섯번 하고 나서 B를 찾는 것 보다 연산을 줄일 수 있다
		 */
		Stream.of("a", "b", "c", "d", "e")
				.map(s -> {
					System.out.println("map = " + s);
					return s.toUpperCase();
				})
				.anyMatch(s -> {
					System.out.println("anyMatch = " + s);
					return s.startsWith("B");
				});

		System.out.println("=============================================");


		/**
		 * map filter의 순서에 따라 연산이 다르다.
		 */
		Stream.of("a", "b", "c", "d", "e")
				.map(s -> {
					System.out.println("map = " + s);
					return s.toUpperCase();
				})
				.filter(s -> {
					System.out.println("filter = " + s);
					return s.startsWith("A");
				})
				.forEach(s -> System.out.println("forEach = " + s));


		System.out.println("=============================================");

		/**
		 * map filter의 순서에 따라 연산이 다르다.
		 */
		Stream.of("a", "b", "c", "d", "e")
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("a");
				})
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.forEach(s -> System.out.println("forEach: " + s));

	}
}
