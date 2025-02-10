package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Scanner;

public class dsa1 {

	public static void main(String[] args) {

		System.out.println("===============================");
		System.out.println("          Lotto 프로그램          ");
		System.out.println("===============================");

		System.out.println("1.Lotto구입");
		System.out.println("2.프로그램 종료");
		System.out.println("===============================");
		System.out.println(" 메뉴를 선택 하시오. ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		while (num == 1) {
			System.out.println("1000원에 로또게임 한번입니다.");
			System.out.println("금액 입력");
			int tot = scan.nextInt();
			if (tot < 1000) {
				System.out.println("입력금액이 너무 적습니다. 로또번호 구입 실패");
			} else if (100000 <= tot) {
				System.out.println("입력금액이 너무 많습니다. 로또번호 구매 실패");
			} else {
				System.out.println("행운의 로또번호는 아래와 같습니다.");

				int b = tot / 1000;
				int c = tot % 1000;

				for (int i = 1; i <= b; i++) {
					HashSet<Integer> testSet = new HashSet<Integer>();

					while (testSet.size() < 6) {
						testSet.add((int) (Math.random() * 45 + 1));
					}
					System.out.println("로또번호 1 : " + testSet + " ");

					HashSet<Integer> testSet1 = new HashSet<Integer>();

					while (testSet1.size() < 6) {
						testSet1.add((int) (Math.random() * 45 + 1));

					}
					System.out.println("로또번호 2 : " + testSet1 + " ");
				}
				System.out.println();
				System.out.println("거스름돈은 : " + c + "원입니다.");

			}

		}
		if (num == 2) {
			System.out.println("감사합니다.");

		} else {
			System.out.println("번호를 다시 입력하시오.");

		}
	}
}
