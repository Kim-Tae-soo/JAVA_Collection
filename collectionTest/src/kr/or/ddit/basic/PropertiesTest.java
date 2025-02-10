package kr.or.ddit.basic;

import java.util.Properties;

/*
 	Properties 객체
 		- Properties는 Map보다 축소된 기능의 객체라고 할 수 있다.
 		
 		- Map은 Key값과 value값에 모든 형태의 객체를 저장할 수 있지만
 		  Properties는 key와 vlaue에 String만 사용할 수 있다.
 		
 		- Map은 put(), get() 메서드를 이용하여 데이터를 입출력 하지만
 		  Properties는 setProperty(), getProperty() 메서드를 이용하여 데이터를 입출력한다.
 		  
 		- Properties는 데이터를 파일로 입출력할 수 있다.
 		- Properties는 프로그램 환경 설정에 필요한 데이터를 처리할 때 많이 사용되었다.
 		
 */

public class PropertiesTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		
		// 자료 저장
		int age = 30;
		prop.setProperty("name", "홍길동");
		prop.setProperty("age1", "20");
		prop.setProperty("age2", "" + age);
		prop.setProperty("age3", String.valueOf(age));
		prop.setProperty("tel","010-1234-5678");
		prop.setProperty("addr","Daejeon");
		
		// 자료 읽기
		String name = prop.getProperty("name");
		int age2 = Integer.parseInt(prop.getProperty("age2"));
//		double aaa = Double.parseDouble("3.123");
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age2);
		System.out.println("전화 : " + tel);
		System.out.println("주소 : " + addr);
		
	}

}
