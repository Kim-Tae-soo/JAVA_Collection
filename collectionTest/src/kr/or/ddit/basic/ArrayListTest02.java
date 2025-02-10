package kr.or.ddit.basic;
import java.util.*;

import org.w3c.dom.NameList;
/*
  문제)
   5명의 사람 이름을 입력 받아 ArrayList에 저장한 후 ArrayList에 저장된 데이터 중에서 '김'씨 성을 가진 이름을 모두 출력하시오.
   
  문제2)
  	5명의 별명을 입력 받아 ArrayList에 저장한 후에 이들 중에 별명의 길이가 제일 긴 별명을 출력하시오
  	(단, 각 별명의 길이는 모두 다르게 입력한다.) ==> 클래스명 ArrayListTest03
 
  문제3)
  	5명의 별명을 입력 받아 ArrayList에 저장한 후에 이들 중에 별명의 길이가 제일 긴 별명들을 출력하시오.
  	(단, 각 별명의 길이는 같을 수 있다.) ==> 클래스명 ArrayListTest04
 */

public class ArrayListTest02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();

		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 사람 이름 입력>>");
			String name = scan.next();
			nameList.add(name);

		}
		System.out.println();
		
		System.out.println("김씨 성을 가진 사람들...");
		for (int i = 0; i < nameList.size(); i++) {
//			if (nameList.get(i).substring(0, 1).equals("김")) {
//				System.out.println(nameList.get(i));
//			}
			if(nameList.get(i).charAt(0)=='김') {
				System.out.println(nameList.get(i));
			}
//			if(nameList.get(i).indexOf("김")==0) {
//				System.out.println(nameList.get(i));
//			}
//			if(nameList.get(i).startsWith("김")) {
//				System.out.println(nameList.get(i));
//			}
		}
	}
}
