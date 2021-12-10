package com.company.stream.basic.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortedMain {
	public static void main(String[] args) {

		/**
		 * 요소들을 정렬하기 위해서는 sorted를 사용하면 된다
		 * 파라미터로 Comparator를 넘길 수도 있다 (오름차준, 내림차순)
		 */
		List<String> list = Arrays.asList("해쉬", "에이든", "마크", "앨런");
		Comparator reverseOrder = Comparator.reverseOrder();
		Stream<String> stream = list.stream()
				.sorted();

		stream.forEach(e -> System.out.print(e + " "));



	}
}
