package ex3_map;

import java.util.HashMap;
import java.util.Hashtable;

/*
 * Map 구현 클래스
 * HashMap : (key,value) 쌍인 객체의 모임. 순서를 모른다. 동기화되어 있지 않다. 
 * TreeMap : (key,value) 쌍인 객체의 모임. 키값으로 정렬순서
 * Hashtable : (key,value) 쌍인 객체의 모임. 순서를 모른다. 구버전의 클래스. 메서드가 동기화 되었다.
 *             동기화 : 스레드에 대해서 safe 하다
 */
public class MapEx4 {
	public static void main(String[] args) {
		Hashtable<String,String> map = new Hashtable<>();
		map.put("학생", "student");
		map.put("선생", "teacher");
//		map.put(null, "null"); //Hashtable 객체에서는 null을 key로 사용할 수 없음
		System.out.println(map);
		HashMap<String,String> map2 = new HashMap<>();
		map2.put("학생", "student");
		map2.put("선생", "teacher");
		map2.put(null, "null"); //HashMap 객체에서는 null을 key로 사용할 수 있음
		System.out.println(map2);
	}
}

