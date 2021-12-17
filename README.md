# Description
- auth : 77kkyu
- development environment : java
- technology : Stream API

> **_Stream API를 사용하면서 느낀 점_**
> 
> 현업에서도 여러 컬렉션을 Stram API를 사용해서 데이터를 처리합니다
> 
> 제일 큰 장점은 이전에는 for문 if문을 사용하고 재배열해서 데이터를 처리했던 것들이
> 
> Stream API로 인해 코드의 가독성도 좋아졌습니다 그리고 SQL 쿼리 짜는 거랑 비슷하다는 생각이 들었습니다
> 
> 단점은 Stream API를 공부를 안 하고 사용했을 경우 성능이 더 안 좋아질 수 있는 거 같고
> 
> 추상화되어있기 때문에 사용 간에 실수가 일어날 수 있는 것 같습니다

---

# Stream API

java8에서 새롭게 추가된 API입니다 컬렉션을 람다식으로 처리할 수 있도록 하는
함수형 프로그래밍 도구 입니다

- Stream은 Immutable 하다. 다시 말해 원본의 데이터를 변경하지 않습니다
- Stream의 연산은 layz 하다. 즉 필요 할 때만 연산함으로 효율적인 처리가 가능합니다
- Stream은 재사용이 불가능합니다
- Stream API를 사용하면 코드의 가독성이 높아집니다


[Stream API Tutorial](https://www.tutorialspoint.com/java8/java8_streams.htm)

---

# Stream API 구조

Stream API의 구조는 크게 세 가지로 구분 됩니다
- Stream 생성
- 중개 연산
- 최종 연산

``` java
List<String> list = Arrays.asList("A", "B", "C", "D", "E");
Stream<String> stream = list.stream() // 스트림 생성
    .filter(e -> e.contains("A") || e.contains("E")) // 중개 연산
    .collect(Collectors.toList()); // 최종연산
```



