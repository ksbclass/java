package ex10_collect;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 *  Box : 기본자료형 => 객체화
 *  asDoubleStream() : IntStream=> DoubleStream
 *  boxed() : IntStream => Stream<Intrger>.
 */
public class Ex01_Boxed {
	static int sum=0;
	public static void main(String[] args) {
		int[] intArray = {1,2,3,4,5}; //배열생성
		IntStream intStream= Arrays.stream(intArray);
		//IntSteram : 요소의 자료형 int 형인 Stream
		//DoubleSteram : 요소의 자료형 double 형인 Stream	
		//asDoubleStream() : IntSteream => DoubleStream
		//asLongStream() : IntSteream => LongStream
		intStream.asDoubleStream().forEach(d->System.out.println(d));//IntStream-> DoubleStream 바꿈.
		System.out.println();
		/*
		 * boxed() : Wrapper 클래스로 요소 변경.
		 */
		intStream =Arrays.stream(intArray); //배열에서 스트림으로 변경.
		Stream<Integer> is = intStream.boxed();
		// obj.getClass() : 
		is.forEach(obj->System.out.println(obj.getClass()));
		Arrays.stream(intArray).boxed().forEach(i->System.out.println(i.intValue()));
	}
}
