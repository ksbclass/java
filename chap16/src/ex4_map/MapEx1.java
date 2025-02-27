package ex4_map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
  map : 스트림의 요소를 다른 요소로  변경 할 수 있는 함수
   		mapXXXX
  mapToInt : IntStream 형 <- Stream 형 함수
  
  메서드 종류
  Stream<R> map(Function<T,R>) : T 형을 입력받아 R 리턴하여 R형 Stream 생성
  Stream<R> mapToObj(DoubleFunction<R>) : double 형을 입력받아 R 리턴하여 R형 Stream 생성
  Stream<R> mapToObj(IntFunction<R>) : int 형을 입력받아 R 리턴하여 R형 Stream 생성
  Stream<R> mapToObj(LongFunction<R>) : long 형을 입력받아 R 리턴하여 R형 Stream 생성
  
  IntStream mapToInt(ToIntFunction<T>) : T형을 입력받아서 int 형을 리턴해주는 IntStream 생성
  IntStream map(IntUnaryOperator) : int 형을 입력받아서 int 형을 리턴해주는 IntStream 생성
  LongStream mapToLong(ToLongFunction<T>) : T 형을 입력받아서 long 형을 리턴해주는 LongStream 생성
  DoubleStream mapToDouble(ToDoubleFunction<T>) : T 형을 입력받아서 double 형을 리턴해주는 DoubleStream 생성
  
 */
public class MapEx1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동전","김삿갓","구운몽","전우치전","사씨남정기");
		System.out.println();
		/*
		  	글자의 크기로 새로운 IntStream으로 생성하기
			Stream<String> list.stream() 
			IntStream isr = list.stream().mapToInt(String::length); //객체 참조
			스트림은 1회성이기때문에 한번에 진행을 하면 다시 처음으로 못돌아간다.
		 */
		IntStream isr = list.stream().mapToInt(s->s.length()); 
		isr.forEach(System.out::println);
		System.out.println("전체 문자열 크기 : "+list.stream().mapToInt(s->s.length()).sum());
		System.out.println("전체 문자열 객수 : "+list.stream().count());
		//1 ~ 100까지의 합을 출력하자
		System.out.println("1~100까지의 합 :" +IntStream.range(1,101).sum());
		
		//list 를 이름으로 가진 학생 객체를 출력하기
		Stream<Student> sts = list.stream().map(s-> new Student(s,0,0));
		sts.forEach(System.out::println);
	}
}
