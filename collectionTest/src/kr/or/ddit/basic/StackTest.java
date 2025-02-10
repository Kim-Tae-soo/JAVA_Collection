package kr.or.ddit.basic;

import java.util.Iterator;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser b = new Browser();
		
		b.history();
		
		b.goURL("1.naver");
		b.history();
		b.goURL("2.yahoo");
		b.history();
		b.goURL("3.Google");
		b.goURL("4.daum");
		b.history();
		System.out.println("back page");
		b.goBack();
		b.history();

		System.out.println("back page");
		b.goBack();
		b.history();
		
		System.out.println("go page");
		b.goForward();
		b.history();
		
		System.out.println("새로운 사이트 방문하기");
		b.goURL("5.네이트");
		b.history();
	
	}

}


//웹 브라우저의 앞으로가기, 뒤로 가기 기능 구현 (스택 이용)
class Browser{
	private Stack<String> back;		//이전 방문 내역이 저장될 스택
	private Stack<String> forward;	//다음 방문 내역이 저장될 스택
	private String currentURL;		//현재 페이지
	
	//생성자
	public Browser() {
		back = new Stack<String>();
		forward = new Stack<String>();
		currentURL = "";
		
	}
	
	//매겨변수로 방문할 URL을 받아서 해당 페이지를 방문하는 메서드
	public void goURL(String url) {
		System.out.println(url + "사이트에 방문합니다...");
		
		if(currentURL!=null&&!"".equals(currentURL)) { //현재 페이지가 있으면
			back.push(currentURL); //현재 페이지에를 back스택에 추가한다.
		}
		currentURL = url;		// 현재 페이지를 매개변수로 받은 방문할 URL로 변경한다.
		forward.clear();		// forward 를 클리어함
	}
	
	// 뒤로 가기 기능의 메서드
	public void goBack() {
		//List객체.isEmpty() ==> List가 비어있으면 true, 그렇지 않으면 false를 반환한다.
		if(!back.isEmpty()) { // back스택에 데이터가 있으면..
			forward.push(currentURL); 	// 현재 페이지를 forward 스택에 추가
			currentURL = back.pop();	// back 스택에서 1개의 데이터를 꺼내와 현재 페이지로 한다.
			
		}
	}
	
	// 앞으로 가기 기능의 메서드
	public void goForward() {
		if(!forward.isEmpty()) { // forward 스택이 비어있지 않으면...
			back.push(currentURL); //현재 페이지를 back 스택에 추가한다.
			currentURL = forward.pop(); // forward 스택에서 1개의 데이터를 꺼내와 현재 페이지로 한다.
		}
	}
	
	//방문 기록을 확인하기 위한 메서드
	public void history() {
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("		방문기록			");
		System.out.println("------------------------------------");
		
		System.out.println("back ==> " + back);
		System.out.println("현재 페이지 ==> " + currentURL);
		System.out.println("forward ==> " + forward);
		System.out.println("------------------------------------");
		System.out.println();
	}
	
}
