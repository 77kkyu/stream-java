package com.company.stream.advanced.flatMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2중 배열 또는 2중 리스트로 되어 있는 데이터를 1차원으로 처리할 때 쓴다
 */
public class FaltMapMain {
	public static void main(String[] args) {

		List<List<String>> list = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
		List<String> flatList = list.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		flatList.forEach(System.out::println);

		System.out.println("======================================");

		Stream<String[]> strStream = Stream.of(
				new String[]{"a", "b", "c"}
				, new String[]{"d","e","f"}
		);
		//Stream<Stream<String>> stream = strStream.map(Arrays::stream); // map을 사용하면 2중 Stream이 반환됨
		Stream<String> stream = strStream.flatMap(Arrays::stream); // flatMap을 사용하면 1중 Stream으로 낮출 수 있음
		stream.forEach(System.out::print);
		System.out.println("");
		System.out.println("======================================");

		List<Student> students = Arrays.asList(
				new Student("해쉬", 60, 80, 30)
				, new Student("에이든", 40, 30, 40)
				, new Student("마크", 70, 40, 50)
				, new Student("앨런", 50, 50, 60)
		);

		students.stream()
				.flatMapToInt(student -> IntStream.of(student.getKor(), student.getEng(), student.getMath()))
				.average()
				.ifPresent(avg -> System.out.println(Math.round(avg * 10) / 10.0));

		System.out.println("======================================");

		/**
		 * NullPointerException 방지
		 */
//		Outer outer = new Outer();
//		String foo = outer.nested.inner.foo;
//		System.out.println(foo);
		Optional.of(new Outer())
				.flatMap(o -> Optional.ofNullable(o.nested))
				.flatMap(n -> Optional.ofNullable(n.inner))
				.flatMap(i -> Optional.ofNullable(i.foo))
				.ifPresent(System.out::println);

	}
}
