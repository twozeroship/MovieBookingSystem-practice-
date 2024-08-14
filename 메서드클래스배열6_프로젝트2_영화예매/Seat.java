package 메서드클래스배열6_프로젝트2_영화예매;

// 좌석 정보를 저장하는 클래스
public class Seat {
	String userID;
	int number;
	boolean check;
	
	void showNum() {
		System.out.print(number + " ");
	}
	void showData() {
		
		if(check == true) {
			System.out.print("■ ");
		}
		else {
			System.out.print("□ ");
		}
	}	
}
