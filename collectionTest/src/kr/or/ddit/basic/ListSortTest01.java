package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 	정렬과 관련된 interface는 Comparable, Comparator 이러헥 두 가지가 있다.
 	
 	Comparable 은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때 구현하는 인터페이스이다.
 	(내부 정렬 기준)
 	
 	Comparator 는 외부에 별도로 정렬 기준을 구현하고 싶을 때 구현하는 인터페이스이다. ( 외부 정렬 기준 )
 	
 	Comparable에서는 CompareTo()메서드 재정의하고
 	Comparator에서는 Compare() 메서드를 재정의해야 한다.
 	
 	String 클래스 , Wrapper 클래스 , Data 클래스 , File 클래스에는 내부 정렬 기준이 구현되어 있다.
 	(이 클래스들에 구현된 내부 정렬기준은 오름차순으로 처리되도록 구현되어 있다.)
 	
 	
 	
 */

public class ListSortTest01 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		list.add("김태수");
		list.add("이성화");
		list.add("이학범");
		list.add("김철민");
		list.add("권성운");

		System.out.println("정렬 전 : " + list);

		// 정렬은 Collections.sort() 메서드를 이용하여 정렬한다.
		// Collections.sort() 메서드는 기본적으로 내부 정렬 기준으로 정렬한다.
		Collections.sort(list);

		System.out.println("정렬 후 : " + list);
		Collections.shuffle(list); // 랜덤배치
		System.out.println("자료 섞기 : " + list);

		// 외부 정렬 기준을 적용해서 정렬하기
		// 형식 ) Collections.sort(정렬할List, 외부정렬기준클래스의 instance)
		Collections.sort(list, new Desc());

		System.out.println("내림차순 정렬 후 : " + list);

	}

}

// 정렬 방식을 정해주는 class를 작성한다. (외부 정렬 기준 클래스라고 한다.)
// 이 class는 Comparator 인터페이스를 구현해서 작성한다.
class Desc implements Comparator<String> {

	// compare() 메서드를 이용해서 정렬하고 하는 기준을 정해준다.

	// compare() 메서드의 반환값의 의미
	// 0은 두 값이 같다.
	// 양수는 앞, 뒤의 순서를 바꾼다.
	// 음수는 앞, 뒤의 순서를 바꾸지 않는다.

	// 예) 오름차순 일 경우 ==> 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환하도록 구현하면 된다.
	@Override
	public int compare(String str1, String str2) {
		// 내림차순으로 구현하려고 한다.
//		if (str1.compareTo(str2) > 0) {
//			return -1;
//		} else if (str1.compareTo(str2) < 0) {
//			return 1;
//		} else {
//			return 0;
//		}
		
		return str1.compareTo(str2) * -1;
	}

}
