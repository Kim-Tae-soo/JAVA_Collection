package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {

	public static void main(String[] args) {
		/*
		  문제2) 5명의 별명을 입력 받아 ArrayList에 저장한 후에 이들 중에 별명의 길이가 제일 긴 별명을 출력하시오.
		 */
		Scanner scan = new Scanner(System.in);
		ArrayList<String> aliasList = new ArrayList<String>();
		
		System.out.println("서로 다른 길이의 별명을 입력하세요...");
		
		for(int i=1; i<=5; i++) {
			System.out.println(i + "번째 별명을 입력 >> ");
			String alias = scan.nextLine();
			aliasList.add(alias);
			
		}// 위에가 별명 추가란.
		
		System.out.println();
		
		//제일 긴 별명이 저장될 변수를 선언하고 List의 첫번쨰 데이터로 초기화.
		String maxAlias = aliasList.get(0);
		
		for(int i=1; i<aliasList.size(); i++) {
			if(maxAlias.length() < aliasList.get(i).length()) {
				maxAlias = aliasList.get(i);
			}
		}
		
		System.out.println("제일 긴 별명 : " + maxAlias);
	}

}
