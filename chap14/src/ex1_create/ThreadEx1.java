package ex1_create;
/*
 Thread 생성
 1. Thread 클래스 상속
 2. run() 메서드 구현 : Thread(스레드) 의 기능	
 */
class Thread1 extends Thread{ // Therad1 클래스는 Thread 객체임.
	Thread1(String name){
		super(name); // Thread 의 이름을 설정
	}
	// Thread 수행 해야할 메서드. start()
	public void run() { 	// Running 상태. run() 메서드 실행 중인 상태
		for(int i = 1; i<=5; i++) {
			//getName() : Thread 의 이름 출력
			System.out.println(i+"="+getName());
			try {
				sleep(1000); // 간격을 주기 위해서. sleep(1000) : 1000밀리초(1초) 대기상태                           
			}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx1 {
	public static void main(String[] args) { // main 시작 main 도 스레드가 됨
		System.out.println("main 스레드 시작");
		Thread t1 =new Thread1("First");  // Thread 생성
		Thread t2 =new Thread1("Second"); // Thread 생성
		t1.start(); // t1 객체의 Runnable 상태
		t2.start(); // t2 객체의 Runnable 상태
		/*
		 * start() : 스레드의 시작. 병렬화 시킴. 멀티스레드 환경
		 * 1. 스택영역을 나누어서 병렬화 시킴
		 * 2. 병렬화 된 스택 영역에 run() 메서드 호출
		 */
		System.out.println("main 스레드 종료");
	}

}
