package ex8_pararllel;

import java.util.Arrays;
import java.util.List;

public class SequenciaVsparallelEx2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		long start =System.nanoTime();//1970년 이후 부터 현재시간 까지 시간을 나노초 리턴
		list.stream().forEach((a)->System.out.println(Thread.currentThread()+":"+a));
		//Thread.currentThread() : 현재 실행중인 Thread 객체 
		long end = System.nanoTime();
		System.out.println("순서처리 시간 : " + (end-start));
		start =System.nanoTime();
		//parallelStream : 병렬로 데이터를 처리하는 스트림.
		list.parallelStream().filter(a->a%2==1)
			.forEach((a)->System.out.println(Thread.currentThread()+":"+a));
		end =System.nanoTime();
		System.out.println("병렬처리 시간 : " +(end-start));
	}

}
