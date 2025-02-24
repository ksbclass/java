package chap4;
/*
 * 반복문 : 조건식의 결과가 참인 동안 문장 실행
 * 
 * === for 문 ===
 * for(초기값:조건문;증감식) {
 *    조건문의 결과가 참인 동안 실행되는 문장들
 * }
 * 조건문의 결과가 거짓이면 반복문 종료
 * 
 * === while 문 ===
 * while(조건문) {
 *    조건문의 결과가 참인 동안 실행되는 문장들
 * }
 * 조건문의 결과가 거짓이면 반복문 종료
 * 처음부터 조건문의 결과가 거짓이면 문장 실행 안함
 * 
 * === do while 문 ===
 * do {
 *    조건문의 결과가 참인 동안 실행되는 문장들. 한번은 실행 됨.
 * } while(조건문);
 * 조건문의 결과가 거짓이면 반복문 종료
 * 조건문과 상관 없이 한번은 문장 실행
 */
public class LoopEx01 {
	public static void main(String[] args) {
		System.out.println("반복문 없이 1 ~ 5까지 출력하기");
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
		System.out.print(4);
		System.out.println(5);
		System.out.println("for문을 이용하여 1 ~ 5까지 출력하기");
		for(int i=1;i<=5;i++)  //i변수 : for 구문 내에서만 사용가능한 지역변수  
			System.out.print(i);
		System.out.println();
		/* 12345
		 * 1) int i = 1
		 * 2) i<=5 : true  <--------| 거짓인 경우 반복문 종료
		 * 3) System.out.print(i);  |  반복
		 * 4) i++; //6     ---------|  
		 */
		System.out.println("while문을 이용하여 1 ~ 5까지 출력하기");
		int i = 1; //지역변수
		while(i<=5) { //6
			System.out.print(i); //12345
			i++;
		}
		System.out.println();
		System.out.println("while 구문 밖의 i:"+ i); //6
		System.out.println("do while문을 이용하여 1 ~ 5까지 출력하기");
		i = 1; //지역변수
		do { 
			System.out.print(i); //12345
			i++; //6
		}while(i<=5);
		System.out.println();
		System.out.println("do while 구문 밖의 i:"+ i); //6
	}
}
