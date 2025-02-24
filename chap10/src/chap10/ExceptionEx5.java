package chap10;
/*
 * throws : 예외처리. 
 * throw : 예외 발생. 없는 예외를 강제로 발생
 */
public class ExceptionEx5 {
	public static void main(String[] args) {
		try {
		   first();
		} catch(Exception e) {
			System.out.println("main 메서드에서 예외 처리");
			e.printStackTrace();
		}
	}
	private static void first() {
		System.out.println("first 메서드");
		second();
	}
	private static void second() {
		System.out.println("second 메서드");
		try {
			System.out.println(Integer.parseInt("abc"));
		} catch(Exception e) {
			//e 참조변수 : NumberFormatException 예외객체 참조
			System.out.println("second 메서드에서 예외 처리");
			System.out.println(e.getMessage()); //For input string: "abc"
			throw e; //다시 예외로 발생
		}
	}
}
