package ex6_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//sorted() : 요소의 설정된 기본 정렬방식으로 정렬
//sorted(Comparator.reverseOrder()) :  기본 정렬방식의 역순으로 정렬

public class SortedEx1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","김삿갓","이몽룡","임꺽정");
		list.stream().forEach(System.out::println);
		System.out.println();
		System.out.println("기본정렬");
		list.stream().sorted().forEach(System.out::println);
		System.out.println();
		System.out.println("기본의 역순정렬");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);;
	}
}
