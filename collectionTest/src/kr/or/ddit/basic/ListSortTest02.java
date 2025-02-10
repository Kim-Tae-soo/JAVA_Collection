package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		
		Member mem = new Member(1,"홍길동", "010-5920-1003");
		memList.add(mem);
		memList.add(new Member(5, "이순신", "010-1234-1234"));
		memList.add(new Member(9, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "강감찬", "010-4444-1234"));
		memList.add(new Member(6, "일지매", "010-5555-1234"));
		memList.add(new Member(2, "변학도", "010-7666-1234"));
	
		System.out.println("정렬 전..");
		for(Member mem2 : memList) {
			System.out.println(mem2);
			
		}
	System.out.println("-----------------------------------");
	
	Collections.sort(memList);
	System.out.println("정렬 후");
	
	for(Member mem2 : memList) {
		System.out.println(mem2);
		
	}
	System.out.println("----------------------------------");
	
	// Member클래스의 회원번호(num)를 기준으로 내림차순 정렬하는 외부 정렬 기준 클래스르 작성하여
	// 정렬하시오(클래스명 : SortNumDesc)
	Collections.sort(memList,new SortNumDesc());
	
	System.out.println("회원번호의 내림차순 정렬 후...");
	
	for(Member mem2 : memList) {
		System.out.println(mem2);
		
	}
	System.out.println("----------------------------------");
	
	}

}
// Member클래스의 회원이름을 기준으로 오름차순뙤도록 내부 정렬 기준을 구현하기
//		==> Comparable 인터페이스를 구현해야 한다.

class Member implements Comparable<Member>{
	
	private int num;		//회원번호
	private String name;	//회원이름
	private String tel;		//전화번호
	
	// 생성자
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		
		return "Member [num=" + num + ", name=" + name + ", tel="+ tel + "]";
	}
	
	// compareTo()메서드에서 내부 정렬 기준을 구현한다.
	
	@Override
	public int compareTo(Member mem) {
		//회원 이름의 오른차순 정렬 기준 구현하기
//		/*
//		if(this.name.compareTo(mem.name)>0) {
//			return 1;
//		}else if(this.name.compareTo(mem.name)<0) {
//			return -1;
//		}else {
//			return 0;
//		}
//		*/
		return this.name.compareTo(mem.name);
	}
		
		
		
		
		
	
	
	
	
}
//Member클래스의 회원번호(num)를 기준으로 내림차순 정렬하는 외부 정렬 기준 클래스르 작성
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
/*
		if(mem1.getNum() > mem2.getNum()) {
			return -1;
		}else if(mem1.getNum() < mem2.getNum()) {
			return 1;
		}else {
			return 0;
		}
		*/
		
		// Wrapper 클래스를 이용해서 처리하기
		return Integer.valueOf(mem1.getNum()).compareTo(mem2.getNum());
	}
	
}


