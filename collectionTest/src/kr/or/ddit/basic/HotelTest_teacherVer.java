package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HotelTest_teacherVer {

	private Map<Integer, Room> hotelMap;
	private Scanner scan;

	public HotelTest_teacherVer() {
		hotelMap = new HashMap<Integer, Room>();
		scan = new Scanner(System.in);

		// 객실 초기화
		for (int i = 2; i <= 4; i++) {
			String type = null;
			switch (i) {
			case 2:
				type = "싱글룸";
				break;
			case 3:
				type = "더블룸";
				break;
			case 4:
				type = "스위트룸";
				break;
			}

			for (int j = 1; j <= 9; j++) {
				int num = i * 100 + j;
				hotelMap.put(num, new Room(num, type));

			}

		}
	}

	public static void main(String[] args) {
		new HotelTest_teacherVer().hotelStart();
	}

	// 시작메서드
	private void hotelStart() {

		System.out.println();
		System.out.println("┌=========================================┐");
		System.out.println("│	 호텔문을 열었습니다. 			  │");
		System.out.println("│	 어서오십시오. 	          	  │");
		System.out.println("└-----------------------------------------┘");
		System.out.println();

		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1: // 체크인
				checkIn();
				break;
			case 2: // 체크아웃
				checkOut();
				break;
			case 3: // 객실상태
				showRoomState();
				break;
			case 4: // 프로그램 종료
				System.out.println();
				System.out.println("┌=========================================┐");
				System.out.println("│	 호텔문을 닫았습니다. 	          	  │");
				System.out.println("│	 안녕히가세요. 	          	  │");
				System.out.println("└=========================================┘");
				System.out.println();
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}

	}

	// 체크인 메서드
	private void checkIn() {

		System.out.println();
		System.out.println("┌-----------------------------------------┐");
		System.out.println("│	        체크인 작업          	  │");
		System.out.println("├-----------------------------------------┤");
		System.out.println("│	 				  │");
		System.out.println("│	 * 201 ~ 209 : 싱글룸		  │");
		System.out.println("│	 * 301 ~ 309 : 더블룸		  │");
		System.out.println("│	 * 401 ~ 409 : 스위트룸		  │");
		System.out.println("│	 				  │");
		System.out.println("└-----------------------------------------┘");
		System.out.print("체크인 할 방 번호를 입력해주세요. >> ");
		int num = scan.nextInt();

		// 입력한 방 번호가 Map의 key값에 없으면 잘못 입력한 방번호 이다.
		if (!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}

		// 입력한 방 번호에 기존의 손님이 있을경우 처리하는 조건문.
		if (hotelMap.get(num).getGuestName() != null) {
			System.out.println(num + "호 객실은 이미 손님이 있습니다.");
			return;
		}
		System.out.println();
		System.out.print("예약 고객님의 이름을 입력해주세요. >> ");
		String name = scan.next();

		// 입력 받은 이름을 해당 방 번호의 투숙객 이름에 저장 후에 출력한다.
		hotelMap.get(num).setGuestName(name);
		System.out.println("어서오세요 " + name + "님의 " + num + "호 체크인이 정상적으로 완료되었습니다.");

	}

	// 체크아웃 메서드
	private void checkOut() {
		
		System.out.println("┌-----------------------------------------┐");
		System.out.println("│	        체크아웃 작업          	  │");
		System.out.println("├-----------------------------------------┤");
		System.out.println("│	 				  │");
		System.out.println("│	 * 201 ~ 209 : 싱글룸		  │");
		System.out.println("│	 * 301 ~ 309 : 더블룸		  │");
		System.out.println("│	 * 401 ~ 409 : 스위트룸		  │");
		System.out.println("│	 				  │");
		System.out.println("└-----------------------------------------┘");
		System.out.print("체크아웃 할 방 번호 입력해주세요. >> ");
		int num = scan.nextInt();

		// 입력한 방번호가 Map의 key값에 없으면 잘못 입력한 방 번호이다.
		if (!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		
		// 입력한 방 번호에 투숙객이 없는지 검사
		if (hotelMap.get(num).getGuestName() == null) {
			System.out.println(num + "호 객실에는 체크인 한 손님이 없습니다.");
			return;
		}
		
		// 체크 아웃 작업은 해당 방 번호의 투숙객이름을 null로 변경해 주면 된다.
		String name = hotelMap.get(num).getGuestName();
		hotelMap.get(num).setGuestName(null);
		
		System.out.println(num + "호 객실의 " + name + "님 체크아웃을 완료하였습니다.\n이용해주셔서 감사합니다.");
		

	}

	// 객실 상태를 출력하는 메서드
	private void showRoomState() {
		System.out.println();
		System.out.println("┌--------------------------------------------┐");
		System.out.println("│      현재 객실 상태			     │");
		System.out.println("├--------------------------------------------┤");
		System.out.println("│방 번호    방 종류    	투숙객 이름	     	     │");
		System.out.println("├--------------------------------------------┤");

		// 방 번호를 순서대로 나오게 하기 위하여 방 번호(Map의 key값) 만 구해서 List에 넣은 후 정렬하여 사용하는법.
		List<Integer> roomNumList = new ArrayList<Integer>(hotelMap.keySet());
		Collections.sort(roomNumList); // 방 번호를 기준으로 오름차순 정렬

		// List에 저장된 방번호를 차례로 꺼내와 Map에서 방번호에 해당하는 Room 객체를 구해서 출력한다.
		for (int num : roomNumList) {
			Room r = hotelMap.get(num); // Map에서 방번호에 해당하는 Room 객체 구하기
			System.out.println("│" + r.getRoomNum() + "      " + r.getRoomType() + "		"
					+ (r.getGuestName() == null ? "-" : r.getGuestName()) + "	    	     │");
			System.out.println("└--------------------------------------------┘");

		}
		System.out.println();

	}

	// 메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu() {

		System.out.println();

		System.out.println("┌-----------------------------------------┐");
		System.out.println("│	 				  │");
		System.out.println("│	  어떤 업무를 진행하시겠습니까?           	  │");
		System.out.println("│	 				  │");
		System.out.println("├-----------------------------------------┤");
		System.out.println("│	 				  │");
		System.out.println("│	  1.체크인           		  │");
		System.out.println("│	  2.체크아웃   		      	  │");
		System.out.println("│	  3.객실상태         		  │");
		System.out.println("│	  4.프로그램 종료      	     	  │");
		System.out.println("│	 				  │");
		System.out.println("└=========================================┘");
		System.out.print("번호 입력 >> ");

		return scan.nextInt();
	}

}

class Room {

	private int roomNum;
	private String roomType;
	private String guestName;

	// 기본 생성자
	public Room() {
	}

	// 생성자
	public Room(int roomNum, String roomType) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
	}

	// getter setter
	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	@Override
	public String toString() {
		return "Room [roomNum=" + roomNum + ", roomType=" + roomType + ", guestName=" + guestName + "]";
	}
}
