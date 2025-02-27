package ex4_daemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class DataAddThread extends Thread {
	List<String> words;
	String[] data;
	int interval;
	public DataAddThread(List<String> words,String[] data, int interval) {
		this.words=words;
		this.data= data;
		this.interval =interval;
	}
	public void run() {
		while(true) {
			//리스트에 data 배열 중 한개의 요소를 추가
			words.add(data[(int)(Math.random()*data.length)]); 
			try {
				sleep(interval);
			}catch(InterruptedException e) {}
		}
	}
}
public class DaemonEx2 {
	public static void main(String[] args) {
		List<String> words = new ArrayList<>(); // 삭제 대상이 되는 문자들의 모임
		// data의 배열 중 임의 한개를 interval에 한개씩 스레드가 words 리스트 객체에 추가.
		String[] data = {"태연","유리","윤아","호연","수영","서현","티파니","써니",
				"제시카","뷔","슈가","제이홉","알앰","정국","지민","진"};
		int interval =3 *1000;
		Scanner scan = new Scanner(System.in);
		words.add(data[0]);// 기본 값을 태연 문자열을 추가.
		DataAddThread t1 = new DataAddThread(words,data,interval);
		t1.setDaemon(true);//데몬 스레드로 설정.
		t1.start(); // words 리스트에 3초에 한개씩 데이터 추가 기능
		while(true) {// 키보드에서 입력받아, 리스트의 요소한개씩 삭제
			System.out.println(words);
			System.out.print(">>");
			String input = scan.next().trim(); // 입력된 이름을 words 리스트의 요소에서 제거
			words.remove(input);
			if(words.size()==0) {//words 리스트가 비어있는 상태(리스트에 요소가 없는 상태)
				break;
			}
		}
		System.out.println("프로그램 종료");// main 메서드 종료. 데몬스레드 DataAddThread 객체는 종료
	}
}
