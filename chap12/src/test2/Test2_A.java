package test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
1.궁합음식의 키를 입력받아 해당되는 음식을 출력하기. 
  종료가 입력될때 까지 계속 출력하기
2.종료 입력시 등록된 내용 출력하기
  등록된음식 :
    떡볶이 : 오뎅
    짜장면 : 단무지
3. 등록이 안된경우 
   등록여부를 입력받아, 등록하는 경우 궁합음식을 입력받기  
   등록하시겠습니까(y)? 
     y입력 : foods객체에 추가.
            궁합음식 입력받아서 foods에 추가함
     y가아닌경우 :
            음식을 다시 입력하기   

[결과]
음식명을 입력하세요(종료:종료)
떡볶이
떡볶이의 궁합음식:오뎅
음식명을 입력하세요(종료:종료)
치킨
치킨의 궁합음식이 등록되어 있지 않습니다.등록하시겠습니까?
y
치킨의 궁합음식을 등록하세요
맥주
음식명을 입력하세요(종료:종료)
종료
{치킨=맥주, 떡볶이=오뎅, 라면=김치}
*/
public class Test2_A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String,String> foods = new HashMap<>();
		foods.put("떡볶이", "오뎅");
		foods.put("라면", "김치");
		while(true) {
			System.out.println("음식명을 입력하세요(종료:종료)");
			String food = scan.next();
			if(food.equals("종료")) break;
			String pairFood = foods.get(food);
			if(pairFood == null) {
				System.out.println(food + "의 궁합음식이 등록되어 있지 않습니다.등록하시겠습니까(Y)?");
				String yn = scan.next();
				if(yn.equalsIgnoreCase("Y")) {
					System.out.println(food + "의 궁합음식을 등록하세요");
					pairFood = scan.next();
					foods.put(food, pairFood);
				} else continue;
			} else {
				System.out.println(food + "의 궁합음식 : " + pairFood);
			}
		}
		System.out.println("프로그램 종료");
		System.out.println(foods);
		
	}
}

