package ex5_flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

/*
 * IntStream flatMapToInt() : Stream 을 IntStream 으로 변경 
 */
public class FlatMapEx2 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("10,20,30","40,50,60");
		//list을 IntStream 으로 변경
		IntStream isr =list.stream() // Stream<String>
				//Stream<String>=> IntStream 오로 변환시 flatMapToInt(data
					   		.flatMapToInt(data->{
						   String[] strArr=data.split(",");
						   int[] intArr = new int[strArr.length];
						   for(int i=0;i<strArr.length;i++) {
							   intArr[i]= Integer.parseInt(strArr[i].trim());
						   }
						   return Arrays.stream(intArr);
					   });
		isr.forEach(System.out::println);
		Function<String, IntStream> f=data->{
			   String[] strArr=data.split(",");
			   int[] intArr = new int[strArr.length];
			   for(int i=0;i<strArr.length;i++) {
				   intArr[i]= Integer.parseInt(strArr[i].trim());
			   }
			   return Arrays.stream(intArr);
		   };
		//숫자들의 갯수,합과,평균 출력하기
		System.out.print("숫자들의 갯수 : "); 
		System.out.println(list.stream().flatMapToInt(f).count());
		System.out.print("숫자들의 합 : ");
		System.out.println(list.stream().flatMapToInt(f).sum());
		System.out.print("숫자들의 평균 : ");
		System.out.println(list.stream().flatMapToInt(f).average().getAsDouble());
	}

}
