package ex5_other;
/*
 스레드 정리
 1. 스레드의 생성
 	(1)Thread 클래스 상속, run 메서드 오버라이팅하기
 	(2)Runnable 인터페이스 구현. run 메서드 오버라이딩하기. Thread 객체에 주입
 2. 스레드의 상태
 	Thread 생성 상태 : new Thread()
 	Runnable 상태   : start() 메서드 실행 후.
 	Running 상태    : run() 메서드를 실행 중인 상태
 	대기상태 		   : sleep(), 동기화 lock 획득실패. wait(). 대기상태 해제시 Runnable 상태로 변경
 	Dead 상태       : run() 메서드 종료.
 	
 3. 스레드의 중요 메서드
 	(1) start() : 병렬화 기능. run 메서드 호출. new 상태 => Runnable 상태
 	(2) run()   : 스레드의 기능. 스레드가 실행하는 메서드. 
 	(3) sleep(밀리초) : 밀리초 만큼 대기.
 	(4) setDaemon(boolean) : true 인경우 데몬 스레드로 생성. new 상태에서만 설정해야함. 
 	(5) join() : 해당 스레드가 종료시까지 호출한 메서드가 대기
 	(6) setPriority(1~10) : 우선 순위 설정
 	(7) interrupt() : InterruptedException 예외 발생.
 	(8) yield() : Running 상태에서 Runnable 상태로 변경.
 	(9) stop() : 스레드의 상태를 Dead 상태로 강제 변경.사용하지 않도록 권고.
 	
 4. 동기화 : synchronized 예약어 사용
 	동기화 블럭 : lock 설정. 공유 객체로 lock 설정해야함.
 	동기화 메서드 : 공유 객체의 메서드여야함
 5. wait, notify,notifyAll
 	Object 멤버
 	동기화 영역에서만 사용가능
 */
class InterrupTread extends Thread{
	public void run() {
		System.out.println("자고있습니다. 깨우지 마세요");
		try {
			sleep(10000000); // 100000초 대기
		}catch(InterruptedException e) {
			System.out.println("누가 깨우지?");
			e.printStackTrace();
		}
	}
}
public class InterrupEx1 {
	public static void main(String[] args) throws InterruptedException {
		InterrupTread t1 = new InterrupTread();
		t1.start();
		Thread.sleep(2000); // 2초 대기
		t1.interrupt(); // t1 스레드에 InterruptedException 발생
	}

}
