package com.company.stream.advanced.nullSafeStream;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class NullSafeStream {
	public static void main(String[] args) {

		List<String> nullList = null;
//		nullList.stream()
//				.filter(str -> str.contains("d"))
//				.map(String::length)
//				.forEach(e -> System.out.println("nullList = " + e)); // nullPointerException

		collectionToStream(nullList)
				.filter(str -> str.contains("d"))
				.map(String::length)
				.forEach(e -> System.out.println("nullList = " + e)); // []

	}

	/**
	 * collectionToStream 함수는 매개변수로 받은 Collection 객체를 이용해서 Optional 객체를 만들고 Stream을 생성한 후 반환하도록 하고 있다.
	 * 만약 파라미터로 받은 Collection이 null이라면 빈 Stream을 반환하므로 어떠한 경우에서도 Null이 발생하지 않는다.
	 * @param collection
	 * @param <T>
	 * @return
	 */
	public static <T> Stream<T> collectionToStream(Collection<T> collection) {
		return Optional.ofNullable(collection)
				.map(Collection::stream)
				.orElseGet(Stream::empty);
	}

}


