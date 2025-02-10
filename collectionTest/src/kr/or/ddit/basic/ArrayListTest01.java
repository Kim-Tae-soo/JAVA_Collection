package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		/*
		 	ArrayList의 기본적인 사용법은 Vector와 같다.
		 	
		 */
		
		// 객채생성
		ArrayList list1 = new ArrayList();
		
		// add() 메서드를 이용하여 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(123.45);
		
		System.out.println("list1 => " + list1.toString());
		System.out.println("list1 => " + list1);
		System.out.println("list1 size => " + list1.size());
		System.out.println();
		
		//get 메서드를 이용하여 데이터를 꺼내온다.
		System.out.println("1번째 자료 : " + list1.get(1));
		System.out.println();
		
		//데이터 끼워넣기
		list1.add(3,"zzz");
		System.out.println("끼워넣기 후 : " + list1);
		System.out.println();
		
		// 데이터 변경하기 (형변환을 해줘야함)
		String sTemp = (String)list1.set(3, "yyy");
		System.out.println("변경 후 : " + list1);
		System.out.println("sTemp : " + sTemp);
		System.out.println();
		
		// 데이터 삭제하기
		list1.remove(3);
		System.out.println("3번째 자리 삭제 후 : " + list1);
		System.out.println();
		
		list1.remove("bbb");
		System.out.println("bbb 삭제 후 : " + list1);
		System.out.println();
		
		//제네릭을 사용할 수 있다. 괄호안의 같은 데이터 타입만 저장이 가능함.
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("AAAA");
//		list2.add(123); // 문자열이 아닌 숫자라서 저장이 불가함.
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		
		for(int i=0; i<list2.size(); i++) {
			System.out.println(i + "번째의 데이터 값 : " + list2.get(i));
		}
		
		System.out.println();
		
		for(String str : list2) { // 향상된 for문
			System.out.println(str);
		}
		System.out.println("------------------------------------------------");
		
		
		// contains (비교 데이터) : 리스트에 저장된 데이터 중에서 '비교데이터'가 있으면 true, 없으면 false 반환
		System.out.println("DDDD값 존재 여부 : " + list2.contains("DDDD"));
		System.out.println("DDDD값 존재 여부 : " + list2.contains("ZZZZ"));
		
		// indexOf (비교데이터), lastIndexOf(비교데이터)
		// 	==> 리스트에 '비교데이터'가 있으면 '비교데이터'가 저장된 index값을 반환하고, 없으면 -1을 반환한다.
		
		//	==> indexOf() 메서드는 검색 방향이 앞쪽에서 뒤쪽방향이다.
		//	==> lastIndexOf() 메서드는 검색 방향이 뒤쪽에서 앞쪽방향이다.
		// '비교데이터'가 여러개이면 첫번째로 찾아진 데이터의 위치값을 반환한다.
		
		
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		System.out.println("list2 => " +list2);
		
		System.out.println("DDDD의 위치 값 : " + list2.indexOf("DDDD")+"번째 값");
		System.out.println("DDDD의 위치 값 : " + list2.lastIndexOf("DDDD")+"번째 값"); 
		System.out.println("ZZZZ의 위치 값 ( 없는 데이터면 -1 출력 ) : " + list2.indexOf("ZZZZ")+"번째 값");
		
		System.out.println("------------------------------------------------------------");
		
		//toArray() : 리스트 안의 데이터를 배열로 변환해서 반환한다.
		//			==> 기본적인 Object형 배열로 반환한다.
		
		Object[] strArr = list2.toArray();
//		String[] strArr2 = (String[])list2.toArray(); // 배열은 형변환이 안되게 되어있기 때문에 사용할 수 없는 방법이다.
		
		// toArray(new <제네릭타입명>[개수]) ==> 제네릭 타입의 배열로 변환해서 반환한다.
		
		
		System.out.println("list의 개수 : " + list2.size());
		System.out.println("배열의 개수 : " + strArr.length);
		
		for(int i=0; i<strArr.length; i++) {
			System.out.println(i+"번째 자료 : "+strArr[i]);
		}
		System.out.println("----------------------------------------------------------------");
		// toArray(new <제네릭타입명>[개수]) ==> 제네릭 타입의 배열로 변환해서 반환한다.
		String[] strArr3 = list2.toArray(new String[0]);
		//제네릭 타입의 배열로 변환하여 반환후 향상된 for문 사용
		for(String s : strArr3) {
				System.out.println(s);
		}
	}

}
