package chap8;
/*
 * 인터페이스 예제
 * 인터페이스
 * 1. 인터페이스의 멤버는 상수,추상메서드,default메서드, static 메서드만 가능
 * 2. 인터페이스의 멤버의 접근제어자는 public. 생략해도 public임 
 *    상수 : [public static final] 자료형 상수명 ;
 *    추상메서드 : [public abstract] 리턴타입 메서드명(매개변수목록);
 *    default메서드 : [public] 구현부 가능한 메서드. 인스턴스메서드 
 *    static 메서드 : [public] 구현부 가능한 메서드. 클래스 메서드  
 * 3. 객체화 불가 => 구현클래스의 객체화를 통해서 객체화 가능   
 * 4. 클래스와 인터페이스는 구현(implements)로 표현함. 다중구현 가능
 * 5. 인터페이스간의 상속(extends)로 표현함. 다중 상속이 가능함
 */
interface Printerable {
	int INK = 100;
	void print();
	default void sort() {
		System.out.println("정렬 페이지를 출력하세요");
	};
}
interface Scannerable {
	void scan();
}
interface Faxable {
	String FAX_NO = "02-1111-2222";
	void send(String no);
	void receive(String no);
}
//인터페이스간의 다중 상속
interface Complexerable extends Printerable,Scannerable,Faxable {}
//구현클래스 : 인터페이스를 구현한 클래스
//class Complexer implements Complexerable,Printerable,Scannerable,Faxable { //다중구현가능
class Complexer implements Complexerable {
	int ink;
	Complexer() {
		this.ink = INK;
	}
	@Override
	public void print() {
		System.out.println("프린트 합니다. 남은 잉크량:"+ --ink);
	}
	@Override
	public void scan() {
		System.out.println("이미지를 스캔합니다.");
	}
	@Override
	public void send(String no) {
		System.out.println(FAX_NO + "에서" + no + "로 FAX를 전송합니다.");
	}
	@Override
	public void receive(String no) {
		System.out.println(no + "에서" + FAX_NO + "로 FAX를 받았습니다.");
	}
	
}
public class InterfaceEx1 {
	public static void main(String[] args) {
//		Printerable.INK=200; //상수
		Complexer c = new Complexer();
		System.out.println(Printerable.INK);
		System.out.println(Complexerable.INK);
		System.out.println(Complexer.INK);
		System.out.println(Faxable.FAX_NO);
		System.out.println(Complexerable.FAX_NO);
		System.out.println(Complexer.FAX_NO);
		c.print();
		c.scan();
		c.receive("02-2222-3333");
		c.send("02-2222-3333");
		System.out.println("복합기 프린트의 남은 잉크량:" + c.ink);
		if(c instanceof Complexerable) {
			System.out.println("c가 참조하고 있는 객체는 Complexerable 객체임");
			Complexerable co = c;
			co.print();
			co.scan();
			co.receive("02-2222-3333");
			co.send("02-2222-3333");
//			System.out.println("복합기 프린트의 남은 잉크량:" + co.ink);
		}
		if(c instanceof Printerable) {
			System.out.println("c가 참조하고 있는 객체는 Printerable 객체임");
			Printerable p = c;
			p.print();
//			p.scan();
//			p.receive("02-2222-3333");
//			p.send("02-2222-3333");
//			System.out.println("복합기 프린트의 남은 잉크량:" + p.ink);
		}
		if(c instanceof Scannerable) {
			System.out.println("c가 참조하고 있는 객체는 Scannerable 객체임");
			Scannerable s = c;
//			s.print();
			s.scan();
//			s.receive("02-2222-3333");
//			s.send("02-2222-3333");
//			System.out.println("복합기 프린트의 남은 잉크량:" + s.ink);
		}
		if(c instanceof Faxable) {
			System.out.println("c가 참조하고 있는 객체는 Faxerable 객체임");
			Faxable f = c;
//			f.print();
//			f.scan();
			f.receive("02-2222-3333");
			f.send("02-2222-3333");
//			System.out.println("복합기 프린트의 남은 잉크량:" + f.ink);
		}
		if(c instanceof Object) {
			System.out.println("c가 참조하고 있는 객체는 Object 객체임");
			Object o = c;
//			o.print();
//			o.scan();
//			o.receive("02-2222-3333");
//			o.send("02-2222-3333");
//			System.out.println("복합기 프린트의 남은 잉크량:" + o.ink);
		}
	}
}
