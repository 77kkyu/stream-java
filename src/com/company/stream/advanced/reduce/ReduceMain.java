package com.company.stream.advanced.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Reduce는 누산기(Accumulator)와 연산(Operation)으로 컬렉션에 있는 값을 처리하여 더 작은 컬렉션이나
 * 단일 값을 만드는 작업입니다
 */
public class ReduceMain {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int sum = list.stream()
				.reduce(Integer::sum)
				.get();
		System.out.println("sum = " + sum);


		/**
		 * reduce는 최대 3가지의 매개변수를 받울 수 있다
		 * 1 Accumulator: 각 요소를 계산한 중간 결과를 생성하기 위해 사용
		 * 2 Identity: 계산을 처리하기 위한 초기값
		 * 3 Combiner: Parlallel Stream에서 나누어 계산된 결과를 하나로 합치기 위한 로직
		 */
		// reduce(accumulator)
		/**
		 * 1개의 파라미터만을 갖는 reduce함수는 BinaryOperator를 매개변수로 받는다.
		 * BinaryOperator<T>는 같은 타입의 인자 2개를 받아 같은 타입의 결과를 반환하는 함수형 인터페이스이다.
		 * 예를 들어 모든 요소의 값을 더하는 경우에는 두 파라미터를 더한 값을 람다식으로 작성해주어야 하는데, 이에 대한 예제 코드는 아래와 같다.
		 */
		OptionalInt reduced = IntStream.range(1,4) // 1~3
				.reduce((a, b) -> {
					return Integer.sum(a, b);
				});
		System.out.println("reduced = " + reduced);


		// reduce(identity, accumulator)
		/**
		 * 2개의 파라미터를 갖는 reduce함수는 Generic 타입의 identity와 BinaryOperator를 매개변수로 받는다.
		 * 새롭게 추가된 identity는 계산을 처리하기 위한 초기값을 의미한다.
		 * 예를 들어 위의 총합 로직에 10을 초기값으로 두고 싶다면 다음과 같이 코드를 수정할 수 있다.
		 */
		int reduced1 = IntStream.range(1,4) // 1,2,3
				.reduce(10, (a,b) -> { // 초기값 10+1+2+3 = 16
					return Integer.sum(a,b);
				});
		System.out.println("reduced1 = " + reduced1);


		// reduce(identity, accumulator, combiner)
		/**
		 * 새롭게 추가된 combiner는 병렬 처리 시에 각자 쓰레드에서 실행된 결과를 마지막에 합치는 작업을 한다.
		 * 그렇기 때문에 기존의 코드에 combiner 코드를 추가하여도 ParallelStream으로 실행하지 않으면 combiner는 호출되지 않는다.
		 * (IntStream에는 3개의 파라미터를 갖는 reduce가 존재하지 않으므로 Stream.of()로 Stream을 생성해야 한다.)
		 */
		int reduced2 = Stream.of(1,2,3)
				.reduce(10, Integer::sum, (a,b) -> {
					System.out.println("combiner was called"); // parallel Stream이 아니라서 안찍힘
					return a+b;
				});
		System.out.println("reduced2 = " + reduced2);

		int reduced3 = Stream.of(1, 2, 3)
				.parallel()
				.reduce(10, Integer::sum, (a,b) -> {
					System.out.println("combiner was called"); // 두번 호출 된다
					return a+b;
				});
		System.out.println("reduced3 = " + reduced3); // 10+1 10+2 10+3 = 36

		int reduced4 = 10 + Stream.of(1, 2, 3)
				.parallel()
				.reduce(0, Integer::sum, (a, b) -> {
					System.out.println("combiner was called");
					return a + b;
				});
		System.out.println("reduced4 = " + reduced4);



	}
}
