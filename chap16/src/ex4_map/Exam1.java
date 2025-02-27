package ex4_map;

import java.util.Arrays;
import java.util.List;

class Student{
	String name;
	int eng;
	int math;
	public Student(String name, int eng, int math) {
		super();
		this.name = name;
		this.eng = eng;
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
}
public class Exam1 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("홍길동",90,80),
										   new Student("김삿갓",95,80),
										   new Student("이몽룡",95,80));
		// Stream 을 이용하여 영어 점수 합, 수학점수합, 전체 점수합 출력하기
		// s : Student 형 객체 
		System.out.println("영어 점수 합 : "+list.stream().mapToInt(s->s.eng).sum());
		System.out.println("수학 점수 합 : "+list.stream().mapToInt(s->s.math).sum());
		System.out.println("전체 점수 합 : "+list.stream().mapToInt(s->s.math+s.eng).sum());
		System.out.println("메서드 참조 방식");
		System.out.print("영어 점수 합 :");
		System.out.println(list.stream().mapToInt(Student :: getEng).sum());
		System.out.print("수학 점수 합 :");
		System.out.println(list.stream().mapToInt(Student :: getMath).sum());
		System.out.print("영어 점수 평균 :");
		System.out.println(list.stream().mapToInt(Student :: getEng).average().getAsDouble());
		System.out.print("수학 점수 평균 :");
		System.out.println(list.stream().mapToInt(Student :: getMath).average().getAsDouble());
		System.out.println("영어 점수 평균 : "+list.stream().mapToInt(s->s.eng).average().getAsDouble());
		System.out.println("수학 점수 평균 : "+list.stream().mapToInt(s->s.math).average().getAsDouble());
	}
}
