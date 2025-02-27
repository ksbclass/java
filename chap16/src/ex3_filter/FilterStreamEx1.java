package ex3_filter;

import java.util.Arrays;
import java.util.List;

/*
  filter 함수 이용
  
  distinct() : 중복된 요소 제거
  filter(Predicate) : 조건에 맞는 요소 선택.
  filter(Predicate p) : p 가 true 리턴하는 경우만 계속 실행 가능함.
 */
public class FilterStreamEx1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","김삿갓","홍길동","임꺽정","홍길동");
		list.stream().forEach(s-> System.out.println(s));
		System.out.println("중복제거하여 출력하기");
		// 중복된 내용 제거 출력하기
		list.stream().distinct().forEach(s-> System.out.println(s)); // 순서까지 유지 가능.
		System.out.println("홍으로 시작하는 문자열만 출력하기");
		list.stream().filter(n->n.startsWith("홍")).forEach(s-> System.out.println(s));
		System.out.println("홍으로 시작하는 문자열 중복제거 하여 출력하기");
		list.stream().distinct()
					 .filter(n->n.startsWith("홍")).forEach(s-> System.out.println(s));
		list.stream().filter(n->n.startsWith("홍"))
					 .distinct().forEach(s-> System.out.println(s));
	}
}
