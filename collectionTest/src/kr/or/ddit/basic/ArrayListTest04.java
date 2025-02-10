package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제3)
	5명의 별명을 입력 받아 ArrayList에 저장한 후에 이들 중에 별명의 길이가 제일 긴 별명들을 출력하시오.
	(단, 각 별명의 길이는 같을 수 있다.) ==> 클래스명 ArrayListTest04
*/

public class ArrayListTest04 {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> aliasList = new ArrayList<String>();
		
		System.out.println("별명을 입력하세요...");
		
		for(int i=1; i<=5; i++) {
			System.out.println(i + "번째 별명을 입력 >> ");
			String alias = scan.nextLine();
			aliasList.add(alias);
			
		}// 위에가 별명 추가란.
		
		System.out.println();
		
		// 제일 긴 별명의 길이가 저장될 변수 선언하고 List의 첫번째 데이터의 길이로 초기화 한다.
		int maxLength = aliasList.get(0).length();
		
		for(int i = 1; i<aliasList.size(); i++) {
			if(aliasList.get(i).length() == maxLength) {
				System.out.println(aliasList.get(i));
			}
		}
	}

}
