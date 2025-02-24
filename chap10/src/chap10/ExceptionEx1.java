package chap10;
/*
 * 예외처리 : 발생된 예외를 정상화 하는 과정
 * 
 * try 구문
 * try {}  => 예외 발생 가능성이 있는 문장. 필수
 * catch(예외타입 참조변수) {} => try 구문에서 예외 발생시 호출되는 블럭,생략가능
 * finally {}  => 정상,예외 꼭 실행하는 블럭,생략가능
 * 
 * throws : 예외처리의 다른방식
 * throw  : 예외발생 
 */
public class ExceptionEx1 {
	public static void main(String[] args) {
		try {
		  System.out.println(args[0]); //홍길동
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("command 라인에 파라미터값을 입력하세요");
		}
	}
}
