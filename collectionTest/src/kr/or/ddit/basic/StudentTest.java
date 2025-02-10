package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
  문제 ) 학번(int), 이름, 국어점수, 영어점수 수학점수, 총점, 등수를 멤버로 갖는
  		Student 클래스를 작성한다
  		이 Student 클래스의 생성자에는 학번, 이름, 국어점수, 영어점수, 수학점수만
  		매개변수로 받아서 초기화 처리를 한다. 이 때 총점은 세 과목의 점수를 이용해서 초기화 한다.
  		
  		이 Student 객체는 Lists에 저장하여 관리한다.
  		List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
  		총점의 역순(내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는
  		외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오.
  		(외부 정렬 기준 클래스명 : SortByTotal)
  		
  		(등수는 List에 전체 데이터가 모두 추가된 후에 구하도록 한다.)
 */

public class StudentTest {

	private Scanner scan = new Scanner(System.in);
	private ArrayList<Student> stdList = new ArrayList<Student>();

	public static void main(String[] args) {
		new StudentTest().stdStart();

	}

	// 등수 구하는 메서드
	public void createRank() {
		for (Student std1 : stdList) { // 기준 데이터를 구하기 위한 반목문
			int rank = 1; // 처음에는 1등으로 초기화해 놓고 시작한다.
			for (Student std2 : stdList) { // 비교대상을 나타내는 반복문

				// 기준보다 큰 값을 만나면 rank값을 증가시킨다.
				if (std1.getTot() < std2.getTot()) {
					rank++;
				}
			}

			std1.setRank(rank); // 구해진 등수를 Student 객체의 rank 변수에 저장한다.

		}

	}

	// 시작 메서드
	public void stdStart() {
		System.out.println("	학생 성적을 입력하세요..");
		System.out.println("------------------------------");
		int cnt = 0;
/*		
		while (true) {
			cnt++;
			System.out.println(cnt + "번째 학생 성적 입력...");

			System.out.print("학번 >> ");
			int num = scan.nextInt();

			System.out.print("이름 >> ");
			String name = scan.next();

			System.out.print("국어 >> ");
			int kor = scan.nextInt();

			System.out.print("영어 >> ");
			int eng = scan.nextInt();

			System.out.print("수학 >> ");
			int mat = scan.nextInt();

			stdList.add(new Student(num, name, kor, eng, mat));

			System.out.println();
			System.err.println("성적 입력을 계쏙 하시겠습니까? (Y/N)");
			String again = scan.next();

			if (again.equalsIgnoreCase("N")) {
				break;
			}

		}
*/
		
		stdList.add(new Student(2, "홍길동", 90, 50, 40));
		stdList.add(new Student(1, "성춘향", 10, 30, 50));
		stdList.add(new Student(4, "권성운", 70, 40, 30));
		stdList.add(new Student(3, "김철민", 100, 100, 30));
		stdList.add(new Student(5, "이학범", 60, 100, 100));
		stdList.add(new Student(7, "김태수", 100, 20, 10));
		stdList.add(new Student(6, "이성화", 40, 100, 30));
		stdList.add(new Student(8, "조현준", 5, 0, 100));

		// 등수를 구하는 메서드
		createRank();

		System.out.println("정렬전");
		for (Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("--------------------------------------------------------------------------------");
		Collections.sort(stdList);
		System.out.println("학번의 오름차순 정렬 후 ");
		for (Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("--------------------------------------------------------------------------------");
		Collections.sort(stdList,new SortBytotal());
		System.out.println("총점의 내림차순 정렬 후 ");
		for (Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("--------------------------------------------------------------------------------");
		
	}

	class Student implements Comparable<Student> {
		private int num;
		private String name;
		private int kor;
		private int eng;
		private int mat;
		private int tot;
		private int rank;

		public Student(int num, String name, int kor, int eng, int mat) {
			super();
			this.num = num;
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
			tot = mat + kor + eng;

		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getKor() {
			return kor;
		}

		public void setKor(int kor) {
			this.kor = kor;
		}

		public int getEng() {
			return eng;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		public int getMat() {
			return mat;
		}

		public void setMat(int mat) {
			this.mat = mat;
		}

		public int getTot() {
			return tot;
		}

		public void setTot(int tot) {
			this.tot = tot;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		@Override
		public String toString() {
			return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat
					+ ", tot=" + tot + ", rank=" + rank + "]";
		}

		// 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현
		@Override
		public int compareTo(Student std) {
			// TODO Auto-generated method stub
			return Integer.compare(this.num, std.num);
		}
	}
	// 총점의 역순(내림차순)
	class SortBytotal implements Comparator<Student>{

		@Override
		public int compare(Student std1, Student std2) {
			if(std1.getTot()== std2.getTot()) {
				return std1.getName().compareTo(std2.getName());
				
			}else {
				return Integer.compare(std1.getTot(), std2.getTot());
			}
		}
		
	}
}
