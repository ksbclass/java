package chap5;

import java.util.Scanner;

/*
 * 10 진수를 입력 받아서 2진수로 변경하기
 */
public class ArrayEx04 {
	public static void main(String[] args) {
		int[] binary = new int[32];
		System.out.println("2진수로 변환할 10진수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int divnum = num;
		int index = 0;
		while (divnum >0) {
			binary[index++] = divnum%2;
			divnum /=2;
		}
		System.out.print(num + "의 2진수 :");
		for(int i = index-1; i>=0; i--) {
			System.out.print(binary[i]);
		}
		System.out.println();
		System.out.println(Integer.toBinaryString(num));
	}

}
