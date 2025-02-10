package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookTest {

    private Scanner scan = new Scanner(System.in);
    private HashMap<String, Phone> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        new PhoneBookTest().phoneMenu();
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
        
        phoneBook.put(name, new Phone(name, addr, tel));
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
        String newTel = scan.nextLine();

        System.out.print("새로운 주소를 입력하세요 >> ");
        String newAddr = scan.nextLine();
        // 방법1) Map은 같은 key값에 새로운 데이터를 추가하면 나중에 추가한 데이터로 덮어쓴다.
        //phoneBook.put(name, new Phone(name, newTel, newAddr));
        
        // 방법2) key값을 이용하여 value(Phone)을 구해서 변경하기
        Phone p = phoneBook.get(name);
        p.setTel(newTel);
        p.setAddr(newAddr);
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

        Phone p = phoneBook.get(name);
        System.out.println("이름: " + p.getName());
        System.out.println("전화번호: " + p.getTel());
        System.out.println("주소: " + p.getAddr());
    }

    public void phoneAll() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("번호\t\t이름\t\t전화번호\t\t\t\t주소");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        int index = 1;
        for (Phone p : phoneBook.values()) {
            System.out.println(index + "\t\t" + p.getName() + "\t\t" + p.getTel() + "\t\t" + p.getAddr());
            index++;
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("출력 완료.");
    }
}

class Phone {
    private String name;
    private String addr;
    private String tel;

    public Phone(String name, String addr, String tel) {
        this.name = name;
        this.addr = addr;
        this.tel = tel;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
    
    

}
