package chap4;
/*
 * 중첩 반복문 : 반복문 내에 반복문이 존재
 */
public class LoopEx02 {
	public static void main(String[] args) {
		for(int i=2;i<=9;i++) { //i:3
			System.out.println("\n"+i+"단"); 
			for(int j=2;j<=9;j++) { //j:2
				System.out.println(i+"*"+j+"="+(i*j));   //2*9=18
			}
		} //외부 반복문의 끝
	}
}
