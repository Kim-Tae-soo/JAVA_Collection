package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqulasHashCodeTest {

	public static void main(String[] args) {

		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");

		Person p2 = new Person();
		p2.setNum(2);
		p2.setName("이신순");
//		p2.setNum(1);
//		p2.setName("홍길동");

		Person p3 = p1;
		
		System.out.println(p1==p2);
		System.out.println(p1==p3);
		System.out.println();
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println();
		
		Set<Person> testSet = new HashSet<Person>();
		testSet.add(p1);
		testSet.add(p2);
		System.out.println("Set의 개수 : " + testSet.size());
		System.out.println();
		
		
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 : " + p3.hashCode());

	}
	


}


/*
 
 	- equals()메서드 		==> 두 객체의 내용이 같은지 비교하는 메서드	- 동등성
 	- hashCode()메서드 	==> 두 객체가 같은 객체인지를 비교하는 메서드	- 동일성
 	
 	- HashSet, HashMap, Hashtable과 같이 Hash로 시작하는 컬렉션 객체들은
 	  객체의 의미상의 동일성 비교를 위해 hashCode()메서드를 호출하여 비교한다.
 	  그러므로, 객체가 같은지 여부를 결정하려면 equals()메서드와 hashCode()메서드를 같이 재정의해야 한다.
 	
 	- hashCode()메서드에서 사용되는 '해싱 알고리즘'은 서로 다른 객체들의 대해 같은 hashCode 값을
 	  만들어 낼 수 있다.
 	  
 */

class Person {
	private int num;
	private String name;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && num == other.num;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if(this==obj)return true;
//		if(obj==null)return false;
//		if(this.getClass() != obj.getClass()) return false;
//		
//		Person that = (Person)obj; // 매개변수의 객체를 현재의 객체 유형으로 형변환 
//		
//		return this.num==that.num && Objects.equals(this.name, that.name);
//	}
}