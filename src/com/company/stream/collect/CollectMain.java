package com.company.stream.collect;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * collect() = 스트림의 최종연산, 매개변수로 Collector를 필요로 한다
 * Collector = 인터페이스, collect의 ㅏ라미터는 이 인터페이스를 구현해야 한다
 * Collectors = 클래스, static 함수로 미리 작성된 컬렉터를 제공한다
 */
public class CollectMain {
	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(
				new Person("해쉬", 30)
				, new Person("에이든", 30)
				, new Person("마크", 33)
				, new Person("앨런", 36)
				, new Person("프로도", 33)
		);

		/**
		 * Collectors.toList()
		 * Stream에서 작업한 결과를 List로 반환받을 수 있다
		 * Person의 이름으로 변환하여 결과 반환
		 */
		List<String> nameList = personList.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
		System.out.print("Collectors.toList() = ");
		nameList.forEach(e -> System.out.print(e + " "));
		System.out.println(" ");


		/**
		 * Collectors.joining()
		 * Stream에서 작업한 결과를 1개의 String으로 이어붙이기
		 * delimiter : 각 요소 중간에 들어가 요소를 구분시켜주는 구분자
		 * prefix : 결과 맨 앞에 붙는 문자
		 * suffix : 결과 맨 뒤에 붙는 문자
		 */
		String listToString = personList.stream()
				.map(Person::getName)
				.collect(Collectors.joining(",", "<", ">"));
		System.out.println(listToString);


		/**
		 * Collectors.averagingInt(), Collectors.summingInt(), Collectors.summarizingInt()
		 * 평균값이나 총합을 구할 수 있다
		 * Collectors.summarizingInt() = getCount(), getSum(), getAverage(), getMin(), getMax()
		 */
		Double averageAge = personList.stream()
				.collect(Collectors.averagingInt(Person::getAge));
		System.out.println("averageAge = " + averageAge);

		Integer summingAge = personList.stream()
				.collect(Collectors.summingInt(Person::getAge));
		System.out.println("summingAge = " + summingAge);

		Integer summingAgeMapToInt = personList.stream()
				.mapToInt(Person::getAge)
				.sum();
		System.out.println("summingAgeMapToInt = " + summingAgeMapToInt);

		IntSummaryStatistics statistics = personList.stream()
				.collect(Collectors.summarizingInt(Person::getAge));
		System.out.println("summarizingInt = " + statistics); // getMax, getAverage, getCount 등 가능


		/**
		 * Collectors.groupingBy()
		 * Stream에서 작업한 결과를 특정 그룹을 묶을 수 있고, 결과를 Map으로 반환 받는다
		 *
		 */
		Map<Integer, List<Person>> collectorMapOfLists = personList.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Collectors.groupingBy() = " + collectorMapOfLists.toString());


		/**
		 * Collectors.partitioningBy()
		 * partitioningBy()는 함수형 인터페이스 Predicate를 받아 Boolean을 Key값으로 분할한다
		 * e.getAge()가 30보다 큰 경우랑 아닌 경우로 나눠준다
		 */
		Map<Boolean, List<Person>> mapPartitioned = personList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 30));
		System.out.println("Collectors.partitioningBy() = " + mapPartitioned);


	}
}
