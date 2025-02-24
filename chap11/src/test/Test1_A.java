package test;
/*
1부터 100까지 중 임의의 숫자를 컴퓨터가 저장하고, 
값을 입력받아 저장된 값을 맞추는 프로그램을 작성하기

입력 숫자가 1 부터 100까지의 숫자가 아닌 경우 : NumberInputException 예외 발생을 시키고 
                                        1 과 100사이의 숫자만 입력하세요 메세지출력 
입력 값이  숫자가 아닌경우 :  InputMismatchException 예외가 발생 
                        숫자만 입력하세요  메세지 출력
계속 입력을 받는다.
몇번의 입력만에 숫자를 맞추었는지 출력하기.
단 입력 오류된 경우도 입력 건수에 포함된다.

[결과]
1부터 100까지의 숫자를 입력하세요
50
작은수를 입력하세요
1부터 100까지의 숫자를 입력하세요
25
작은수를 입력하세요
1부터 100까지의 숫자를 입력하세요
12
큰수를 입력하세요
1부터 100까지의 숫자를 입력하세요
20
작은수를 입력하세요
1부터 100까지의 숫자를 입력하세요
15
큰수를 입력하세요
1부터 100까지의 숫자를 입력하세요
18
작은수를 입력하세요
1부터 100까지의 숫자를 입력하세요
17
작은수를 입력하세요
1부터 100까지의 숫자를 입력하세요
16
정답입니다. 입력 횟수:8
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test1_A {
	public static void main(String[] args) {
		//1~100 사이의 임의의 수
		int answer = (int)(Math.random() * 100) + 1;
		int cnt = 0;
		System.out.println("1부터 100까지의 숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		while(true) {
			int num = 0;  //while 블럭에서만 사용 가능한 지역변수
			try {
			 num = scan.nextInt();
			 cnt++;
			 if(num < 1 || num > 100) 
				 throw new NumberInputException 
				       ("1부터 100까지의 숫자만 입력하세요");
			} catch(InputMismatchException e) {
				String d = scan.next();
				cnt++;
				System.out.println(d + "는 숫자가 아닙니다.");
				continue;
			} catch(NumberInputException e) {
				System.out.println(e.getMessage());
				continue;
			}
			if(num == answer) break;
			else if(num > answer) 
				System.out.println("작은수를 입력하세요");
			else 
				System.out.println("큰수를 입력하세요");
		}
		System.out.println("정답입니다. 입력 횟수:" + cnt);		
	}
}
