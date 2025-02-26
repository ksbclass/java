package chap5;
/*
숫자  	i 행		j 
 1		9		9
 2		8		8
 3		9		8
 4		7		7
 5		8		7
 6		9		7
 7		6		6
 8		7		6
 9		8		6
 10		9		6
 11		5		5
 12		6		5
 13		7		5
 14		8		5
 15		9		5
 */
public class Exam07 {

	public static void main(String[] args) {
		//1. 가변 배열 생성
		int[][] arr = new int[10][];
		//2. 각 행의 1차원 배열의 객체 생성
		for(int i=0; i<arr.length;i++) {
			arr[i]=new int[i+1];
		}
		//3.arr 배열에 숫자값 저장
		int num=0; // 저장할 숫자값.
		for(int j=9;j>=0;j--) {
			for(int i =j; i<=9;i++) {
				arr[i][j]= ++ num; //num 값을 증가시킨후 arr[i][j] 값을 저장
			}
		}
		//4. arr 배열의 값을 출력
		//arr : 2차원배열의 참조 변수
		//	  	2차원 배열의 요소의 자료형 1차원 배열의 참조 변수
		for(int[] ar : arr) {
			for(int a : ar) {
				System.out.printf("%3d",a);
			}
			System.out.println();
		}
		
	}
}
