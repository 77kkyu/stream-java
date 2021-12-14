package com.company.stream.advanced.parallelStream;

import java.util.Arrays;

/**
 * 병렬 스트림의 정렬
 */
public class ParallelStream {
	public static void main(String[] args) {

		/**
		 * Parallel Stream에 따라 출력 결과가 항상 바뀌어야 한다.
		 * 다른 출력 결과는 항상 바뀌지만 sort는 main Thread에서 순차적으로 실행되는 것을 확인할 수 있다.
		 * 이러한 이유는 Parallel Stream에서의 sort가 내부적으로 Java8의 새로운 메소드인 Arrays.parallelSort()를 사용하기 때문이다
		 */
		Arrays.asList("a", "b", "c", "d", "e")
				.parallelStream()
				.filter(s -> {
					System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
					return true;
				})
				.map(s -> {
					System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
					return s.toUpperCase();
				})
				.sorted((s1, s2) -> {
					System.out.format("sort: %s <> %s [%s]\n", s1, s2, Thread.currentThread().getName());
					return s1.compareTo(s2);
				})
				.forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));

	}
}
