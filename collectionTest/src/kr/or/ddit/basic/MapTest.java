package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		/*
			Map ==> key값과 value값을 한 쌍으로 관리하는 객체
				- key값은 중복을 허용하지 않고 순서(index)가 없다. (Set의 특징을 갖는다.)
				- value 값은 중복을 허용한다.
				
		*/
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 자료 추가 ==> put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map ==> " + map);
		System.out.println();
		
		
		// 자료 수정 ==> 데이터를 추가할 때 key값이 같으면 나중에 추가한 값으로 덮어쓴다.
		map.put("addr", "서울");
		System.out.println("map ==> " + map);
		System.out.println();
		
		// 자료 읽기 ==> get(key값)
		//		  ==> 'key'값과 한 쌍이 되는 value값을 반환한다.
		//		  ==> 'key'값이 없으면 null을 반환한다.
		System.out.println("나이 : " + map.get("age"));
		System.out.println("이름 : " + map.get("name"));
		System.out.println();
		
		
		// 자료 삭제 ==> remove(key값)
		//		  ==>'key값'이 같은 자료를 찾아서 삭제한다.
		//		  ==> 반환값 : 삭제된 자료의 value값
//		String removeTel = map.remove("tel");
//		System.out.println("map ==> " + map);
//		System.out.println("삭제된 값 >> " + removeTel);
//		System.out.println();
//		
		// key값이 존재하는지 여부를 나타내는 메서드 : containsKey(key 값)
		//		==> 해당 'key값'이 있으면 true, 없으면 false를 반환한다.
		
		System.out.println("tel 키값의 존재 여부 : " + map.containsKey("tel"));
		System.out.println("age 키값의 존재 여부 : " + map.containsKey("age"));
		System.out.println();
		System.out.println("-------------------------------------------");
		
		/*
			Map에 저장된 모든 데이터를 읽어와 사용하는 방법
		
			1. key값 이용하기.
			
			1-1. keySet()메서드 이용하기
				 keySet()메서드 ==> Map의 모든 key값들을 가져와 Set형으로 반환한다.
		*/
		
		Set<String> keySet = map.keySet();
		
		// 방법1 ==> Iterator 객체 이용하기
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key+" : " + value);
		}
		System.out.println("-------------------------------------------");
		
		// 방법2 ==> 향상된 for문 이용하기
		for(String key : keySet) {
			String value = map.get(key);
			System.out.println(key+" = " + value);
		}
		System.out.println("-------------------------------------------");
		
		/*
		  	2. value값만 읽어와서 처리하기
		  	==> values(메서드 이용)
		 */
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("-------------------------------------------");
		
		/*
		 	3. Entry 내부 객체 이용하기
			 	==> Map에는 Entry라는 내부 class가 만들어져 있다.
			 	이 Entry클래스는 key와 value라는 멤버변수로 구성되어 있다.
			 	Map에서는 이 Entry클래스를 Set형식으로 저장하여 관리한다.
			 	
			- Entry객체 전체를 가져오는 메서드 ==> entrySet()메서드
				==> 가져온 Entry들은 Set형식으로 저장되어 있다.
				
		 */
		// Entry라는 내부 객체 전체 가져오기
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		// 방법1. Iterator
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		while(entryIt.hasNext()) {
			Map.Entry<String,String> entry = entryIt.next();
			System.out.println("key 값 : " + entry.getKey());
			System.out.println("key 값 : " + entry.getValue());
			System.out.println();
		}
		System.out.println("-------------------------------------------");
		
		// 방법2. 향상된 for문
		for(Map.Entry<String,String> entry : mapSet) {
			System.out.println("key 값 ==> " + entry.getKey());
			System.out.println("key 값 ==> " + entry.getValue());
			System.out.println();
			
		}
		System.out.println("-------------------------------------------"); 
		
		
	}
	

}
