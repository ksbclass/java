package ex1_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
 * Vector 클래스
 *  - Collection 프레임워크 이전의 클래스
 *  - List의 구현클래스
 *  - 이전의 메서드와 혼합되어 있음
 */
public class ListEx2 {
	public static void main(String[] args) {
		Vector <Double> list = new Vector<>();
//		List <Double> list = new Vector<>();
		list.add(0.3);
		list.add(Math.PI);
		list.addElement(5.0); //구버전 메서드. add()와 동일
		System.out.println(list);
		//요소의 위치 찾기
		int index = list.indexOf(5.0);
		System.out.println("5.0의 위치:"+ index);
		System.out.println("3.0의 위치:"+ list.indexOf(3.0));
		//요소가 존재?
		if(list.contains(5.0)) {
			System.out.println("5.0은 list의 요소 입니다.");
		} else {
			System.out.println("5.0은 list의 요소가 아닙니다.");
		}
		//요소를 제거하기
		System.out.println("list의 크기 :" + list.size());
//		list.remove(0); //remove(int n) : n번 인덱스의 요소를 제거 
		list.remove(0.3); //remove(Object o) : o 객체를 제거
 		System.out.println("list의 목록 :" + list);
 		List<Integer> list2 = new ArrayList<>();
 		for(int i=0;i<10;i++) list2.add(i+1);
 		System.out.println(list2);
// 		int num = 1; //1번 인덱스
 		Integer num = 1; //1 요소
 		list2.remove(num);
 		System.out.println(list2);
 		
	}
}
