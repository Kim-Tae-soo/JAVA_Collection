package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
로또를 구매하는 프로그램 작성하기

사요자는 로또를 구매할 때 구매할 금액을 입력하고.
입력한 금액에 맞게 로또번호를 출력한다.
(단, 로또 한장의 금액은 1000원이며 최대 100장까지만 구입할 수 있고, 거스름돈도 계산하여 출력한다.)

=========================================
				LOTTO 프로그램
=========================================
1. LOTTO구입
2. 프로그램 종료
=========================================
메뉴 선택 : 1 <-- 입력

Lotto 구입 시작
(1000원에 로또번호 하나입니다.)
금액 입력 : 2500 <-- 입력

행운의 로또번호는 아래와 같습니다.
로또번호1 : 2,3,4,5,6,7
로또번호2 : 20,21,22,23,24,25

받은 금액은 2500원이고 거스름돈은 500원 입니다.

=========================================
				LOTTO 프로그램
=========================================
1. LOTTO구입
2. 프로그램 종료
=========================================
메뉴 선택 : 1 <-- 입력

Lotto 구입시작
(1000원에 로또번호 하나입니다.)
금액 입력 : 900
입력 금액이 너무 적습니다. 로또번호 구입 구매 실패


=========================================
				LOTTO 프로그램
=========================================
1. LOTTO구입
2. 프로그램 종료
=========================================
메뉴 선택 : 1 <-- 입력

Lotto 구입시작
(1000원에 로또번호 하나입니다.)
금액 입력 : 1000000
입력 금액이 너무 많습니다. 로또번호 구입 구매 실패

=========================================
				LOTTO 프로그램
=========================================
1. LOTTO구입
2. 프로그램 종료
=========================================
메뉴 선택 : 2 <-- 입력

감사합니다


*/

public class LottoStore_Teacher_Ver {
	
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		new LottoStore_Teacher_Ver().lottoStart();
		

	}
	
	// 시작 메서드
	public void lottoStart() {
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
			case 1 :	//구입
				buyLotto();
				break;
			case 2 :
				System.out.println(); // 종료
				System.out.println("프로그램이 종료되었습니다. \n감사합니다.");
				return;
			default :
				System.out.println();
				System.out.println("작업 번호를 잘못 입력했습니다. ('1' 또는 '2'를 입력하세요.");
				
			}
			
		}
		
	}
	
	// 로또 구매를 처리하는 메서드
	private void buyLotto() {
		System.out.println();
		System.out.println("로또 구입 시작");
		System.out.println();
		System.out.println("- 로또 한장당 가격은 1,000원 입니다.");
		System.out.print("금액 입력 : ");
		int money = scan.nextInt();
		System.out.println();
		
		if(money<1000) {
			System.out.println("입력된 금액이 너무 작습니다. \n최소 금액은 로또 1,000원(1장)입니다.");
			System.out.println();
			return;
		}
		
		if(money>=101000) {
			System.out.println("입력된 금액이 너무 많습니다. \n1인당 Lotto 구매 최대 금액은 100,000원(100장)입니다.");
			System.out.println();
			return;
		}
		
		HashSet<Integer> lottoSet = new HashSet<Integer>();
		
		int count = money / 1000;		// 구매할 Lotto 매수
		System.out.println("총 " + money/1000 + "장을 구매했습니다.");
		System.out.println("행운의 로또 번호는 아래와 같습니다.");
		for(int i=1; i<=count; i++) {
			while(lottoSet.size()<6) {
				lottoSet.add((int)(Math.random()*45+1));
			}
			
			// Set에 있는 데이터를 List에 넣어준다.
			ArrayList<Integer> lottoList = new ArrayList<Integer>(lottoSet);
			Collections.sort(lottoList);	// lottoList 정렬하기
			
			System.out.println("로또 번호 " + i + "번쨰 : " + lottoList);
			
			lottoSet.clear(); 	// Set 비우기
		}
		System.out.println();
		System.out.println("받은 금액은 : " + money + "원입니다.");
		System.out.println("거스름 돈 : " + money % 1000 + "원입니다.");
		
	}
	
	// 메뉴를 출력하고 사용자로부터 작업 번호를 입력받아 반환
	private int displayMenu() {
		// alt + shift + a ==> shift 누르고 블록 묶고 붙여넣기 ==> alt+shit+a
		System.out.println("┌=========================================┐");
		System.out.println("│	      	LOTTO 프로그램	          │");
		System.out.println("│-----------------------------------------│");
		System.out.println("│	  1. Lotto 구입            	  │");
		System.out.println("│	  2. Lotto 종료			  │");
		System.out.println("└=========================================┘");
		System.out.print("메뉴 선택 : ");
		
		return scan.nextInt();
		
	}

}
