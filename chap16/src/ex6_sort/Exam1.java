package ex6_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import chap16.Student;

/*
 * SortedEx3.java 소스의 내용을 반별, 총점 순으로 정렬하기
 */
public class Exam1 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("김삿갓",1,85,88,80),
				new Student("김길동",1,89,56,66),
				new Student("김삿갓",1,80,88,80),
				new Student("김삿갓",1,90,88,66),
				new Student("이몽룡",2,90,78,95),
				new Student("임꺽정",3,60,56,88),
				new Student("임꺽정",1,90,72,72));
		//반별총점순으로 내림 정렬하기
		System.out.println("반별 총점순으로 정렬하기");
		list.stream().sorted(
		Comparator.comparing(Student::getBan)
		.thenComparing(s->(s.getEng()+s.getMath()+s.getKor()))) // 총점순 2차 정렬
		.forEach(System.out::println);
		//영어점수의 내림정렬하기
		System.out.println("반별 영어점수의 내림 정렬하기 =====");
        list.stream().sorted(
                Comparator.comparing(Student::getBan)
                .thenComparing(s -> s.getEng()) 
        ).forEach(System.out::println);
		//수학점수의 내림정렬하기
        System.out.println("반별 수학점수의 내림 정렬하기 =====");
        list.stream().sorted(
                Comparator.comparing(Student::getBan)
                        .thenComparing(s -> s.getMath()) // 수학점수 내림차순
        ).forEach(System.out::println);
		//국어점수의 내림정렬하기
        System.out.println("반별 국어점수의 내림 정렬하기 =====");
        list.stream().sorted(
                Comparator.comparing(Student::getBan)
               .thenComparing(s -> s.getKor()) // 국어점수 내림차순
        ).forEach(System.out::println);

	}
}
