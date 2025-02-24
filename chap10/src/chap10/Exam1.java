package chap10;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 화면에서 정수형 숫자를 입력받아서 정수형 숫자인 경우 숫자만큼 *를 출력하고
 * 정수형 숫자가 아닌 경우 숫자만 입력하세요 메세지 출력하기
 * 
 * Scanner scan = new Scanner(System.in);
 * int num = scan.nextInt(); <= 정수 입력이 아닌 경우 InputMismatchException 예외 발생함
 */
public class Exam1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		try {
		   int num = scan.nextInt();
		   for(int i=1;i<=num;i++) System.out.print("*");
		   System.out.println();
		} catch(InputMismatchException e) {
			System.out.println("숫자만 입력하세요");
		}

	}
}
