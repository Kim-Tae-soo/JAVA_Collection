package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class phoneTest {

    private Scanner scan = new Scanner(System.in);
    private HashMap<String, Contact> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        new phoneTest().phoneMenu();
    }

    public void phoneMenu() {
        while (true) {
            System.out.println();
            System.out.println("┌=========================================┐");
    		System.out.println("│	    Phone Book		          │");
    		System.out.println("│-----------------------------------------│");
    		System.out.println("│	  1.전화번호 등록            	  │");
    		System.out.println("│	  2.전화번호 수정   		      	  │");
    		System.out.println("│	  3.전화번호 삭제            	  │");
    		System.out.println("│	  4.전화번호 검색            	  │");
    		System.out.println("│	  5.전화번호 전체 출력            	  │");
    		System.out.println("│	  0.프로그램 종료            	  │");
    		System.out.println("└=========================================┘");
            System.out.print("번호 입력 >> ");
            int choice = scan.nextInt();
            scan.nextLine();  // 엔터키 제거

            switch (choice) {
                case 1:
                    phoneAdd();
                    break;
                case 2:
                    phoneMod();
                    break;
                case 3:
                    phoneDel();
                    break;
                case 4:
                    phoneSer();
                    break;
                case 5:
                    phoneAll();
                    break;
                case 0:
                    System.out.println("프로그램이 종료됩니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void phoneAdd() {
        System.out.println("새롭게 등록할 전화번호 정보를 입력하세요...");
        
        System.out.print("이름을 입력하세요 >> ");
        String name = scan.nextLine();
        if (phoneBook.containsKey(name)) {
            System.out.println("'" + name + "'은 이미 등록된 사람입니다.");
            return;
        }
        
        System.out.print("전화번호를 입력하세요 >> ");
        String tel = scan.nextLine();
        
        System.out.print("주소를 입력하세요 >> ");
        String addr = scan.nextLine();
        
        phoneBook.put(name, new Contact(name, addr, tel));
        System.out.println("'" + name + "' 전화번호 정보 등록 완료!!");
    }

    public void phoneMod() {
        System.out.print("수정할 사람의 이름을 입력하세요 >> ");
        String name = scan.nextLine();
        if (!phoneBook.containsKey(name)) {
            System.out.println("'" + name + "'은 등록되지 않은 사람입니다.");
            return;
        }

        System.out.print("새로운 전화번호를 입력하세요 >> ");
        String tel = scan.nextLine();

        System.out.print("새로운 주소를 입력하세요 >> ");
        String addr = scan.nextLine();

        phoneBook.put(name, new Contact(name, addr, tel));
        System.out.println("'" + name + "' 전화번호 정보 수정 완료!!");
    }

    public void phoneDel() {
        System.out.print("삭제할 사람의 이름을 입력하세요 >> ");
        String name = scan.nextLine();
        if (!phoneBook.containsKey(name)) {
            System.out.println("'" + name + "'은 등록되지 않은 사람입니다.");
            return;
        }

        phoneBook.remove(name);
        System.out.println("'" + name + "' 전화번호 정보 삭제 완료!!");
    }

    public void phoneSer() {
        System.out.print("검색할 사람의 이름을 입력하세요 >> ");
        String name = scan.nextLine();
        if (!phoneBook.containsKey(name)) {
            System.out.println("'" + name + "'은 등록되지 않은 사람입니다.");
            return;
        }

        Contact p = phoneBook.get(name);
        System.out.println("이름: " + p.getName());
        System.out.println("전화번호: " + p.getTel());
        System.out.println("주소: " + p.getAddr());
    }

    public void phoneAll() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("번호\t\t이름\t\t전화번호\t\t\t\t주소");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        int index = 1;
        for (Contact p : phoneBook.values()) {
            System.out.println(index + "\t\t" + p.getName() + "\t\t" + p.getTel() + "\t\t" + p.getAddr());
            index++;
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("출력 완료.");
    }
}

class Contact {
    private String name;
    private String addr;
    private String tel;

    public Contact(String name, String addr, String tel) {
        this.name = name;
        this.addr = addr;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public String getTel() {
        return tel;
    }
}
