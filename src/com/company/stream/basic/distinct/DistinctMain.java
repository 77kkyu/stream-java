package com.company.stream.basic.distinct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DistinctMain {
	public static void main(String[] args) {

		/**
		 * 중복된 데이터 제거
		 * distinct는 중복된 데이터를 검사하기 위해 Object의 equals() 메소드를 사용한다
		 * 객체를 만들어서 중복 제거 할 시 equals hashcode를 오버라이드하여 사용!!!!
		 */
		List<String> list = Arrays.asList("해쉬", "에이든", "마크", "앨런", "해쉬", "에이든");
		Stream<String> stream = list.stream()
				.distinct();
		stream.forEach(e -> System.out.print(e + " "));

	}
}
