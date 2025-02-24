package ex1_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Collection 인터페이스 : 객체를 여러개 저장할 수 있는 객체
 * 
 * List 인터페이스 : Collection 인터페이스의 하위 인터페이스
 *                 객체들을 저장할때 저장된 순서를 유지. => 인덱스(첨자)사용가능
 *                 가변배열 객체라고도 함.
 *        구현클래스 : ArrayList, Vector, LinkedList ... 
 *                   Vector : Collection 프레임워크 이전의 클래스. 
 *                            Collection 프레임워크에서 제공되는 함수와, 기존에 사용했던 함수가 혼합됨        
 * Set 인터페이스 :  Collection 인터페이스의 하위 인터페이스                
 *                 객체들을 중복해서 저장하지 않음
 *        구현클래스 : HashSet, TreeSet, LinkedHashSet         
 */
public class ListEx1 {
	public static void main(String[] args) {
		/*
		 * <Integer> : 제네릭. 요소의 자료형을 미리 설정. 자료형이 틀린경우 컴파일 오류발생
		 */
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(5);
		list.add(4);list.add(3);list.add(0);
		list.add(3);
//		list.add("5"); //list 객체는 Integer 객체만 저장 가능함. 
		System.out.println(list);
		//인덱스 사용가능.
		for(int i=0;i<list.size();i++)
			System.out.println(i+ ":"+list.get(i));
		
		//정렬하기
		//Collection : 인터페이스
		//Collections : 클래스. Collection 객체의 기능을 보조해 주는 기능을 가진 클래스 
		Collections.sort(list);
		System.out.println(list);
		for(int i=0;i<list.size();i++)
			System.out.println(i+ ":"+list.get(i));
		Collections.sort(list,Collections.reverseOrder());  //내림차순 정렬
		System.out.println(list);
		Collections.shuffle(list); //요소들 순서를 섞기
		System.out.println(list);
		System.out.println("1번인덱스 부터 3번 인덱스의 객체 조회:"+list.subList(1, 4));
		List<Integer> list2 = list.subList(1, 4);
		System.out.println(list2);
		list2.add(100);
		System.out.println(list);
		System.out.println(list2);
		list2 = new ArrayList<>(list.subList(1, 4));
		list2.add(200);
		System.out.println(list);
		System.out.println(list2);
		
	}
	
}
