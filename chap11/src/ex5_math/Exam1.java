package ex5_math;
/*
 * round(실수값,자리수) : 실수값을 반올림하여 소숫점이하 자리수로 출력하기
 * - 실수값을 소숫점 이하 자리수까지 출력하기
 */
public class Exam1 {
	public static void main(String[] args) {
		System.out.println(round(3.1215,1)); //3.1
		System.out.println(round(3.1215,2)); //3.12
		System.out.println(round(3.1215,3)); //3.122
		System.out.println(truncate(3.15345,1)); //3.1
		System.out.println(truncate(3.15345,2)); //3.15
		System.out.println(truncate(3.15345,3)); //3.153
	}
	private static double truncate(double d, int i) {
		double num = Math.pow(10, i);
		return (int)(d*num)/num;
	}
	private static double round(double d, int i) {
		//%.1f : 소숫점이하 한자리.
		return Double.parseDouble(String.format("%."+i+"f", d)); 
	}
}
