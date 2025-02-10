package kr.or.ddit.basic;

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

public class LottoStore {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("┌=========================================┐");
			System.out.println("│	      	LOTTO 프로그램	          │");
			System.out.println("│-----------------------------------------│");
			System.out.println("│	  1. Lotto 구입            	  │");
			System.out.println("│	  2. Lotto 종료			  │");
			System.out.println("└=========================================┘");
			System.out.print("메뉴 선택 : ");
			int num = scan.nextInt();
			if (num == 1) {
				System.out.println("로또 구입 시작");
				System.out.println("- 로또 한장당 가격은 1,000원 입니다.");
				System.out.println("금액 입력 : ");
				System.out.println();
				int buymoney = scan.nextInt();
				int money = 1000;
				if (buymoney / money >= 1) {
					System.out.println("입력 금액은 : " + buymoney + "원 입니다.");
					System.out.println("거스름 돈 : " + buymoney % money + "원 입니다.");
					System.out.println("행운의 로또 번호는 아래와 같습니다.");
					System.out.println();

					int[] lotto = new int[45];
					for (int i = 0; i < lotto.length; i++) {
						lotto[i] = i + 1;
					}

					for (int i = 0; i < 100; i++) {
						int index = (int) (Math.random() * (lotto.length - 1) + 1);

						int temp = lotto[0];
						lotto[0] = lotto[index];
						lotto[index] = temp;
					}

					System.out.print("행운의 번호 : ");
					for (int i = 0; i < 6; i++) {
						System.out.print(lotto[i] + ",");

					}
					System.out.println();
					System.out.println();
					continue;

					// Lotto 구입 금액 시 1000원보다 작거나 최대 구매 금액인 100,000원 보다 클 경우 처리

				} else if (buymoney < 1000) {
					System.out.println("입력된 금액이 너무 작습니다. \n최소 금액은 로또 한장(1,000원)입니다.");
					System.out.println();
					continue;
				} else if (buymoney > 100000) {
					System.out.println("입력된 금액이 너무 많습니다. \n1인당 Lotto 구매 최대 금액은 100,000원 입니다.");
					System.out.println();
					continue;

				}
				break;

				// 2번과 2번 외의 숫자를 입력 했을 시.
			} else if (num == 2) {
				System.out.println();
				System.out.println("프로그램이 종료되었습니다. \n감사합니다.");

				break;
			} else {
				System.out.println();
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
	}

}
