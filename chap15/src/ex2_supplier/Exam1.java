package ex2_supplier;

import java.util.function.BooleanSupplier;

public class Exam1 {
	public static void main(String[] args) {
		// BooleanSupplier를 이용하여 data 배열의 합이 짝수인지 여부를 출력하기
		int[] data = {1,2,5,78,4,6,8,12};
		BooleanSupplier b1 =()->{
			int sum=0;
			for(int d :data) {
				sum+=d;
			}return sum%2==0;
		};
		if(b1.getAsBoolean()) {
			System.out.println("data 배열의 합은 짝수입니다");
		}else {
		System.out.println("data 배열의 합은 짝수입니다");
		}
	}
}
