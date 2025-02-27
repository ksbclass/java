package ex7_peek;

import java.util.Arrays;
/*
 peek : 중간 처리 반복자
 		중간 단계에서 추가 작업시 사용됨.
 		다음 단계 처리가 없으면 동작이 실행되지않음.
 forEach : 최종 단계 반복자.다음 단계가 없음
 		   
 */
public class PeekvsForEachEx1 {

	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5};
		System.out.println("peek 메서드 연습");
		// peek: 짝수의 합 출력. 중간단게에서 작업 수행
		int tot =
		Arrays.stream(intArr).filter(a->a%2==0) // filter(a->a%2==0) : 짝수들만 가져와
		.peek(n->System.out.print(n+",")).sum(); //중간자
		System.out.println("="+tot);
		System.out.println("ForEach 메서드 연습");
		Arrays.stream(intArr).filter(a->a%2==0)
		.forEach(n->System.out.print(n+",")); // 최종자
	}

}
