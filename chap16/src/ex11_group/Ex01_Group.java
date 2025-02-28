package ex11_group;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import chap16.Student;
import chap16.Student2;
import chap16.Student2.City;

public class Ex01_Group {

	public static void main(String[] args) {
		List<Student2> list =Arrays.asList(
				new Student2("홍길동",50,Student2.Gender.MALE,City.Seoul),
				new Student2("김길수",70,Student2.Gender.FEMALE,City.Seoul),
				new Student2("박자바",85,Student2.Gender.MALE,City.Pusan),
				new Student2("이순영",75,Student2.Gender.FEMALE,City.Pusan)
				);
		//성별로 평균점수 구하기
		double maleavg = list.stream()
				.filter(s->s.getGernder()==Student2.Gender.MALE)
				.mapToInt(s->s.getScore()).average().getAsDouble();
		double femaleavg = list.stream()
				.filter(s->s.getGernder()==Student2.Gender.FEMALE)
				.mapToInt(s->s.getScore()).average().getAsDouble();
//				.collect(Collectors.averagingDouble(Student2 :: getScore));
		//groupingBy(그룹기준 컬럼, 값)
		//averagingDouble(Student2::getScore) : score 값의 평균
		System.out.println("남학생 평균 : "+maleavg +",여학생 평균 :"+femaleavg);
		Map<Student2.Gender,Double> map1 = list.stream()
				.collect(Collectors.groupingBy(Student2::getGernder, Collectors.averagingDouble(Student2::getScore)
						));
		System.out.println(map1);
		//도시별로 이름 출력
		System.out.print("서울지역 :");
		list.stream().filter(s->s.getCity()==Student2.City.Seoul).map(s->s.getName()).forEach(s->System.out.print(s+","));
		System.out.println();
		System.out.print("부산지역 :");
		list.stream().filter(s->s.getCity()==Student2.City.Pusan).map(s->s.getName()).forEach(s->System.out.print(s+","));
		System.out.println();
		// mapping : (Student2 :: getName 데이터들을 변환하기 위한 함수) => 데이터선택
		// 			Collectors.joining(",","[","]") => 선택된 데이터를 수집 함수
		Map<Student2.City,String> map2 = list.stream()
				.collect(Collectors.groupingBy(Student2::getCity, // 도시가 구분컬럼
						Collectors.mapping(Student2 :: getName, Collectors.joining(",","[","]"))));
		//Student2 :: getName 이름을 joining 연결해줘
		System.out.println(map2);
	}
}
