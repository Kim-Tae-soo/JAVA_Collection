package kr.or.ddit.basic;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* 	
		 	Scanner는 기본적으로 '사이띄기', '탭키', '엔터키' 를 기준으로 데이터를 분리해서 읽어 반환한다.
			==> 대표적인 메서드들 (next(), nextInt(), nextDouble() 등등)
		
			scan.nextLine() ==> 사이띄기, 탭문자, 엔터키까지 모두 읽어온 후 '엔터키' 이전까지의 자료를 반환한다.
		*/
		
		
		// 엔터키
		System.out.print("정수 입력 >> ");
		int num = scan.nextInt();
		
		System.out.print("실수 입력 >> ");
		double dNum = scan.nextDouble();
		
		System.out.print("사이띄기 없는 문자열 >> ");
		String str = scan.next();
		
		scan.nextLine(); // 엔터키 제거
		System.out.print("띄어쓰기가 있는 문자열 >> ");
		String temp = scan.nextLine();
		
		System.out.println();
		System.out.println("정수 : " + num);
		System.out.println("실수 : " + dNum);
		System.out.println("문자열str : " + str);
		System.out.println("문자열temp : " + temp);
	}

}
