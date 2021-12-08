package com.company.stream.basic.map;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapMain {
	public static void main(String[] args) {

		/**
		 * Map은 기존의 Stream 요소들을 변환하여 새로운 Stream을 형성하는 연산이다
		 * 저장된 값을 변환하는데 주로 사용되며, map 함수의 인자로 함수형 인터페이스 function을 받고있다
		 */
		List<String> list = Arrays.asList("a", "b", "c", "d", "e");
		Stream<String> stream = list.stream()
				.map(e -> e.toUpperCase()); // 모든 요소들 대문자로 변환

		stream.forEach(e -> System.out.print(e + " "));
		System.out.println(" ");

		/**
		 * map함수의 람다식은 메소드 참조를 이용해 변경이 가능하다
		 */
		Stream<File> fileStream = Stream.of(new File("Test1.java"), new File("Test2.java"), new File("Test3.java"));
		//Stream<File> --> Stream<String> 변환
		Stream<String> fileNameStream = fileStream.map(File::getName);
		fileNameStream.forEach(e -> System.out.print(e + " "));



	}
}
