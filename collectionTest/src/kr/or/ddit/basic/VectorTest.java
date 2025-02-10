package kr.or.ddit.basic;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;
import java.util.Vector;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class VectorTest {

	public static void main(String[] args) {
		// Collection에는 객체만 저장이 가능함.

		// 객체 생성
		// import + shirt + o ==> import 설정 굳이.. 안외워도 되긴함
		Vector v1 = new Vector();
		// 자바 초창기때부터 지원하고 동기화 처리가 되어있는 객체 ==> Vector ( 약간 무거움 ) 동기화처리시 사용하는데 많이 사용하지는 않음.

		System.out.println("처음 크기 : " + v1.size());

		// 데이터 추가하기1 : add(추가할 데이터);
		// ===> 반환값이 존재하며, 추가가 성공 시 true , 실패 시 false
		// add라는 메소드는 set에서도 사용을 한다. vector나 list에는 거의 true이지만 set에서는 false가 나올 수 있다 이유는 중첩이 되지 않기 때문
		v1.add("aaaa");
		//v1.add(new Integer(111));	//JDK 1.9 미만에서는 사용가능
									// Wrapper 객체를 만들떄 new명령어로 만들면 지원을 하지 않기에 (예전 방식) 사용하지 말아야 한다.
		// 위 방법 말고 다른 사용방법
		v1.add(Integer.valueOf(111)); // JDK 1.9이상에서 권장하는 방법이다.
		v1.add(123);	// 객체가 아닌데 저장이 되는 이유 : 알아서 객체화가 된다 즉 오토박싱, 오토 언박싱이 지원되기 때문
		v1.add('a');
		v1.add(true);
		boolean r = v1.add(3.14);
		
		System.out.println("현재 크기 : " + v1.size());
		System.out.println("반환 값 : " + r);
		System.out.println("v1 : " + v1.toString()); //println에서 출력시 toString 생략 가능.
		System.out.println();
		
		//데이터 추가하기2 : addElement (추가할 데이터)
		//	==> 이전 버전의 프로그램과 호환성을 위해서 남아있는 메서드
		v1.addElement("CCC");
		System.out.println("v1 : " + v1);
		
		//데이터 추가하기3 : add(index, 데이터)
		//		==> 'index'번쨰에 '데이터를'끼워넣기한다.
		//		==> 'index'는 0부터 시작한다.
		//		==> 반환값은 없다.
		
		v1.add(1, "KKK");
		System.out.println("v1 : " + v1);
		System.out.println();
		
		//데이터 꺼내오기 : get(index);
		//		==> 'index'번째 데이터를 꺼내서 반환한다.
		System.out.println("1번째 데이터 : " +  v1.get(1));
//		Integer iTemp =(Integer)v1.get(2);
//		Object iTemp = v1.get(2);
		int iTemp = (int)v1.get(2);		// 오토 언박싱
		System.out.println(iTemp);
		System.out.println();
		
		//데이터 수정하기 : set(index, 새로운 데이터)
		//	==> 'index'번째 데이터를 '새로운 데이터'로 변경한다.
		//	==> 반환값 : 원래의 데이터가 반환값이 된다.
//		Object sTemp = v1.set(0, "zzzz"); -- 왜 이걸 안쓰지 ? Object 데이터 타입
		String sTemp = (String)v1.set(0, "zzzz");
		System.out.println("변경 후 : " + v1);
		System.out.println("반환값(원래의 데이터) : " + sTemp);
		System.out.println();
		
		//데이터 삭제하기1 : remove(index);
		//		==> 'index'번째 데이터를 삭제한다
		//		==> 반환값 : 삭제된 데이터
		v1.remove(0);
		System.out.println("삭제한 후 v1 : " + v1);
		
		sTemp = (String)v1.remove(0);
		System.out.println("삭제한 후 v1 : " + v1);
		System.out.println("삭제된 데이터 : " + sTemp);
		
		//데이터 삭제하기2 : remove(삭제할 데이터 직접 지정);
		//		==> '삭제할데이터'를 찾아서 삭제한다.
		//		==> '삭제할데이터'가 여러개이면 이 중 첫번째 자료가 삭제된다.
		//		==> 반환값 : 삭제 성공(true) 삭제 실패시 (false)
		//		==> 삭제할 데이터가 '정수형'이거나 'char형'일 경우에는 반드시 Wrapper 객체로 변환하여 사용한다.
		v1.remove("CCC");
		System.out.println("삭제한 후 : " + v1);
		
		
		//오버라이딩 : 재정의
	
		// v1.remove(123); //123번째 인덱스를 지우라고 이해해서 오류가 발생함 아래와 같이 수정
		v1.remove(Integer.valueOf(123));
		System.out.println("삭제한 후 : " + v1);
		
		//v1.remove('a');
//		v1.remove(new Character('a'));
		v1.remove(Character.valueOf('a'));
		System.out.println("a 삭제한 후 : " + v1);
		
		v1.remove(true);
		System.out.println("true 삭제한 후 v1 : " + v1);
		
		v1.remove(3.14);
		System.out.println("3.14 삭제한 후 v1 : " + v1);
		
		//전체 데이터 삭제하기 : clear();
		
		v1.clear();
		System.out.println("남아 있는 데이터 : " + v1);
		
		System.out.println("-----------------------------------------------");
		
		/*
		 	- 제네릭타입 (Generic Type) ==> 클래스 내부에서 사용할 데이터의 타입을 객체를 생성할 떄
		 			외부에서 지정해주는 기법으로 객체를 선언할때 괄호 '<>' 안에 그 갹체의 내부에서 
		 			사용할 데이터의 타입을 지정해주는 것을 말한다.
		 			
		 			- 이렇게 선언하게 되면 지정한 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다.
		 			- 이 떄 제네릭으로 선언 될 수 있는 데이터 타입은 '클래스'형이어야 한다.
		 				그래서 int는 Interger , boolean은 Boolean, char는 Charcater 등으로 대체해서 지정해야 한다.
		 			- 제네릭 타입을 지정해서 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요가 없다.
		 */
		
		Vector<Integer> v2 = new Vector<Integer>();	// <>안에 있는 자료형만 저장이 가능함.
		Vector<String> v3 = new Vector<String>();
		
		v2.add(1);
		v3.add("배고파");
		v3.add("뭐먹을까");
//		v3.add(100); //오류 발생 string에 int가 들어감
		
		String sTemp2 = v3.get(0);	// 형변환 없이 사용할 수 있다.
		
		Vector<Vector> vv = new Vector<Vector>();	// 배열로 치면 2차원배열 모양
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();	// 배열로 치면 3차원배열 모양
		
		System.out.println("--------------------------------------------------------");
		
		v3.clear();
		System.out.println("v3 : " + v3.size());
		
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v3 => " + v3);
		System.out.println("v4 => " + v4);
		
		//데이터 삭제하기3 : removeall(Collection 객체)
		//		==> Vector에 저장된 데이터들 중에서 'Collection 객체'가 가지고 있는 모든 데이터를 삭제한다.
		//		==> 반환값 : 성공 시 true , 실패 시 false
		
		v3.removeAll(v4); // v3이 가지고 있는 데이터 중에서 v4가 가지고있는 데이터들을 모두 지워라
		System.out.println("결과 : " + v3);
		
		// Vector의 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용하면 된다.
		// 주로 for문을 사용한다.
		v3.clear();
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		for (int i = 0; i < v3.size(); i++) {
			System.out.println(i+"번째 자료 : " + v3.get(i));
		}
		System.out.println("----------------------------------------");
		
		// 향상된 for 문 사용
		for (String str : v3) {
			System.out.println(str);
		}
	}

}
