package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
 	문제) Set과 List를 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 		- 컴퓨터의 숫자는 난수를 이용하여 구한다.
 		(스트라이크는 'S', 볼은 'B'로 나타낸다.)
 	
 	1 2 3
 	2 5 3 
 	
 	ex)
 	
 	컴퓨터의 난수 ==> 9 5 7
 	
 	실행 예시)
 	숫자 입력 >> 3 5 6 
 	3 5 6 => 1S 0B
 	
 	숫자 입력 >> 7 8 9
 	7 8 9 => 0S 2B
 	
 	숫자 입력 >> 9 7 5
 	9 7 5 => 1S 2B
 	
 	숫자 입력 >> 9 5 7
 	9 5 7 => 3S 0B
 	
 	삼진 아웃
 	축하합니다 당신은 n번째 만에 맞췄군요!!
 	
 	난수를 아까로또 꺼 사용 그리고 만든 난수를 리스트에 저장하셈
 	숫자도 입력받아서 리스트에 넣으셈 하나씩 하나씩
 	그래서 난수 리스트랑 내가 입력한 리스트랑 비교해서 S/B 비교
 	S가 3개면 나이스 끝임
 	S : 값과 위치가 같아야한다.
 	LIST에서의 위치는 index 즉 index와 값을 이용하여 작성하시오.
 	
 */

public class BaseBallTest {

	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		new BaseBallTest().gameStart();

	}

	// 게임 시작 메서드
	public void gameStart() {
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1:
				baseballStart();
				break;
			case 2:
				System.out.println();
				System.out.println("Number BaseBall Game OFF");
				return;

			default:
				System.out.println();
				System.out.println("Input number Error! retry please");
				System.out.println();
			}
		}

	}
	
	// 게임 관리 메서드
	public void baseballStart() {
		
		HashSet<Integer> baseballSet = new HashSet<Integer>();
		while(baseballSet.size()<3) {
			baseballSet.add((int) (Math.random() * 9 + 1));
		}
		ArrayList<Integer> baseballList = new ArrayList<Integer>(baseballSet);
		Collections.sort(baseballList);
		System.out.println("Computer > " + baseballSet);
		
		 int attempts = 0;
	        while (true) {
	            attempts++;
	            ArrayList<Integer> playerList = getPlayerInput();
	            int strike = 0;
	            int ball = 0;

	            for (int i = 0; i < baseballList.size(); i++) {
	                if (playerList.get(i).equals(baseballList.get(i))) {
	                    strike++;
	                } else if (baseballList.contains(playerList.get(i))) {
	                    ball++;
	                }	
	            }
	            System.out.println(playerList + " => " + strike + "S " + ball + "B");
	            System.out.println();
	            if (strike == 3) {
	                System.out.println("Strike OUT");
	                System.out.println("GOOD! you got it right in " + "'" + attempts + "'" + "time Clear!!");
	                break;
	            }
	        }
		baseballSet.clear(); // Set 비우기
	}
	
	// 플레이어 입력 창
	 public ArrayList<Integer> getPlayerInput() {
	        ArrayList<Integer> playerList = new ArrayList<Integer>();
	        
	        while (playerList.size() < 3) {
	        	System.out.print("player Input > ");
	            playerList.add(scan.nextInt());
	            System.out.println();
	        }
	        return playerList;
	    }

	public int displayMenu() {
		System.out.println();
		System.out.println("┌=========================================┐");
		System.out.println("│	    Number Baseball Game          │");
		System.out.println("│-----------------------------------------│");
		System.out.println("│	  1.Start	            	  │");
		System.out.println("│	  2.GameOFF			  │");
		System.out.println("└=========================================┘");
		System.out.print("Menu choice >> ");
		System.out.println();

		return scan.nextInt();
	}
}
