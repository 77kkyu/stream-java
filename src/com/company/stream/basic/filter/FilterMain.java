package com.company.stream.basic.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterMain {
	public static void main(String[] args) {

		/**
		 * filter는 Stream 요소들을 변환하여 새로은 Stream을 형성하는 연산이다
		 * filter 함수의 인자로 함수형 인터페이스 Predicate를 받고 있기 때문에, Boolean을 반환하는
		 * 람다식을 작성하여 filter함수를 구현할 수 있다
		 */
		List<String> list = Arrays.asList("A", "B", "C", "D", "E");
		Stream<String> stream = list.stream()
				.filter(e -> e.contains("A") || e.contains("E"));

		stream.forEach(e -> System.out.print(e + " "));
	}
}
