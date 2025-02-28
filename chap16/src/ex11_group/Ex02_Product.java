package ex11_group;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import chap16.Car;
public class Ex02_Product {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("product.txt"));
		// 월별 판매 현황을 Map 객체로 생성하기
		// br.lines() : 라인별 문자열 Stream 으로생성
		Map<Integer, Long> map = br.lines()
				.map(s->{ // Stream<String> => Stream<car>
					//s : String. product.txt 파일의 한줄
					String[] str = s.split(",");
							 String temp ="";
							 try {
								 temp=str[4]; // 상태3(반품)인 경우 반품 사유
							 }catch(ArrayIndexOutOfBoundsException e) {
								 temp="";
							 }
							 return new Car(Integer.parseInt(str[0]) 	// 월
									 ,Integer.parseInt(str[1]),			// 상태 1: 생산 2: 판매 3: 반품
									 str[2], 							// 자동차명
									 Integer.parseInt(str[3]),			// 수량
									 temp); 							//  반품사유
				}) // 결과 Stream<Car>
				.filter(s->s.getCon()==2) // s.Car 객체 판매수량. Con멤버 값이 2 인경우가 판매.
				.collect(Collectors.groupingBy(Car::getMonth,// key 값
						Collectors.summingLong(Car::getQty))); //Qty 의 합
		System.out.println(map);
		map.entrySet().stream().map(s->{
			String temp = s.getKey() + "";
			if(s.getKey() <10) temp ="0"+temp;
			return (temp+"월 판매 수량 :"+s.getValue());
		}).sorted().forEach(s->System.out.println(s));
	}
	
}
