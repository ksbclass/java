package ex5_predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
 Predicate 인터페이스
 	boolean test(T) : 매개변수 존재, 리턴타입은 boolean
 	
 	Predicate<T>: boolean test(T)
 	IntPredicate<T>: boolean test(int)
 	LongPredicate<T>: boolean test(long)
 	DoublePredicate<T>: boolean test(double)
 */
class Student{
	private String name;
	private String gender;
	private int eng;
	private int math;
	public Student(String name, String gender, int eng, int math) {
		super();
		this.name = name;
		this.gender = gender;
		this.eng = eng;
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", gender=" + gender + ", eng=" + eng + ", math=" + math + "]";
	}
}
public class PredicateEx1 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("홍길동","남자",70,85),
										  new Student("성충향","여자",75,100),
										  new Student("이몽룡","남자",55,95),
										  new Student("향단이","여자",80,95));
		System.out.println("영어 점수가 60이상인 학생의 영어 평균 :" + avg(list,s->s.getEng() >=60));
		//s: Student 형
		System.out.println("영어 점수가 60이상인 학생의 영어 평균 :" + avg(list,s->{
			return s.getEng()>=60;
		}));
		System.out.println("여학생의 영어 평균 :" + avg(list,s->s.getGender().equals("여자")));
		System.out.println("남학생의 영어 평균 :" + avg(list,s->s.getGender().equals("남자")));
	}
	//Predicate<Student>f ->s.getEng()
	private static Double avg(List<Student> list, Predicate<Student> f ) {
		int sum=0, cnt =0;
		for(Student s : list) {
			// f.test(s) : 
			if(f.test(s)) {
				sum += s.getEng();
				cnt++;
			}
		}
		return (double)sum/cnt;
	}
}
