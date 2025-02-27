package ex5_flatmap;


import java.util.Arrays;
import java.util.stream.Stream;

public class Exam2 {
	public static void main(String[] args) {
		//Stream.of(...) => 내용으로 Stream 으로 생성
		Stream<String[]> strArrStrm = Stream.of(
			new String[]{"abc","def","jkl"},
			new String[]{"ABC","DEF","JKL"}
				);
		//Stream<String[]> => Stream<String> 변경 필요
//		strArrStrm.flatMap(Arrays::stream).forEach(s->System.out.println(s));
		strArrStrm.flatMap(arr->Arrays.stream(arr)).forEach(s->System.out.println(s));
	}

}
