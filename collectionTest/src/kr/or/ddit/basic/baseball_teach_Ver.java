package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class baseball_teach_Ver {
	// 난수가 저장될 List (변수선언만) 객체 생성은 아래에서
	private ArrayList<Integer> numList;
	
	// 사용자가 입력한 값이 저장될 List (변수선언만) 객체 생성은 아래에서
	private ArrayList<Integer> userList;
	
	private Scanner scan = new Scanner(System.in);
	
	// 스트라이크와 볼의 갯수가 저장될 변수
	int strike, ball;
	
	public static void main(String[] args) {
		new baseball_teach_Ver().gameStart();

	}
	
	//시작 메서드
	public void gameStart() {
		System.out.println("┌=========================================┐");
		System.out.println("│	Number Baseball Game Start        │");
		System.out.println("└=========================================┘");
		// 난수를 만드는 메서드 호출
		creatNum();
		
		// 검증용 출력
		System.out.println("Test Computer Num : " + numList);
		
		int cnt = 0; // 정답 입력 시도 횟수를 저장하는 변수
		do {
			cnt++;
			
			// 사용자 입력 메서드 호출
			inputNum();
			
			// 볼카운트 메서드 호출
			ballCount();
			
		}while(strike!=3);
		
		System.out.println();
		System.out.println("GOOD! you got it right in " + "'" + cnt + "'" + "time Clear!!");
		
	}
	
	// 1 ~ 9 사이의 서로 다른 난수 3개를 만들어 List에 저장하는 메서드(Set)을 이용
	private void creatNum() {
		Set<Integer> numSet = new HashSet<Integer>();
		
		
		// Set을 이용하여 3개의 난수 만들기
		while(numSet.size()<3) {
			numSet.add((int) (Math.random() * 9 + 1));
		}
		
		// 만들어진 난수를 List에 저장
		numList = new ArrayList<Integer>(numSet);
		
		// 데이터 섞기
		Collections.shuffle(numList); // 데이터를 섞는 명령어 
		
	}
	
	// 사용자로 부터 3개의 정수를 입력 받아서 List에 저장하는 메서드
	// 입력한 정수들은 서로 중복되지 않는다.
	
	private void inputNum() {
		int n1, n2, n3;
		
		do {
			System.out.print("Enter numbers >> ");
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			n3 = scan.nextInt();
			// 중복 검사
			if (n1 == n2 || n1 == n3 || n2 == n3) {
				System.out.println("You cannot enter a number. \nPlease enter again.");
			}
		} while (n1 == n2 || n1 == n3 || n2 == n3);
		
		// 입력한 값을 List에 추가하기
		userList = new ArrayList<Integer>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
		
	}
	
	// 스트라이크와 볼을 판정 및 출력하는 메서드
	private void ballCount() {
		strike = 0;
		ball = 0;		// 스트라이크와 볼의 갯수를 초기화
		
		for(int i=0; i<numList.size(); i++) {
			for(int j=0; j<userList.size(); j++) {
				if(numList.get(i) == userList.get(j)) {	// 값이 같은지 비교
					if (i == j) { // 위치(index)값을 비교함 같은지 틀린지.
						strike++;
					}else {
						ball++;
					}
				}
			}
		}
		
		// 볼 카운트 결과를 출력한다.
		System.out.println(userList.get(0)+" "+userList.get(1)
					+ userList.get(2) + userList.get(3) + " >> " + strike + "S " + ball + "B");
		
	}
	

}
