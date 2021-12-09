package com.company.stream.basic.match;

import java.util.Arrays;
import java.util.List;

public class MatchMain {
	public static void main(String[] args) {

		/**
		 * Stream의 요소들이 특정한 조건을 충족하는지 검사하고 싶은 경우에는 match 함수를 사용한다
		 * match 함수는 함수형 인터페이스 Predicate를 받아서 해당 조건을 만족하는지 검사를 하게 되고, 검사 결과를 boolean으로 반환한다
		 * anyMatch: 1개의 요소라도 해당 조건을 만족하는가
		 * allMatch: 모든 요소가 해당 조건을 만족하는가
		 * nonMatch: 모든 요소가 해당 조건을 만족하지 않는가
		 */
		List<String> names = Arrays.asList("해쉬", "마크", "에이든");
		boolean anyMatch = names.stream()
				.anyMatch(name -> name.contains("해"));
		System.out.println("anyMatch = " + anyMatch);

		boolean allMatch = names.stream()
				.peek(p -> System.out.println(p.length()))
				.allMatch(name -> name.length() > 3);
		System.out.println("allMatch = " + allMatch);

		boolean noneMatch = names.stream()
				.noneMatch(name -> name.endsWith("아"));
		System.out.println("noneMatch = " + noneMatch);

	}
}
