package MovieBookingMain;

import java.util.Scanner;

public class SeatDAO {
	Scanner scan;
	Seat[] seatList;
	int max;
	void init() {
		max = 8;
		scan = new Scanner(System.in);
		seatList = new Seat[max];
		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = new Seat();
			seatList[i].number = i + 1;
			seatList[i].userID = "";
			seatList[i].check = false;
		}
	}

	void printSeat() {
		for (int i = 0; i < seatList.length; i++) {
			System.out.print("[" + seatList[i].number + "]");
		}
		System.out.println();

		for (int i = 0; i < seatList.length; i++) {
			if (seatList[i].check == false) {
				System.out.print("[x]");
			} else {
				System.out.print("[o]");
			}
		}
		System.out.println();
	}

	void ticketing(String log) {
		printSeat();
		System.out.println("[예매] 번호를 입력 : ");
		int sel = scan.nextInt();
		if(sel <= 0 || sel > max) {
			return;
		}
		sel -= 1;
		if(seatList[sel].check == false) {
			seatList[sel].userID = log;
			seatList[sel].check = true;
			System.out.println("[예매완료]");
			printSeat();
		}else {
			System.out.println("[예매할수없습니다]");
		}
		
	}

	//예매 취소
	void cancel(String log) {
		printSeat();	// 좌석 출력
		check(log);		// 내 아이디와 일치하는 좌석을 보여준다.
		System.out.println("[취소] 번호를 입력 : ");
		int sel = scan.nextInt();
		if(sel <= 0 || sel > max) {
			System.out.println("[취소할수없습니다]");
			return;
		}
		sel -= 1;	// 인덱스로 변경
		if(seatList[sel].check == true && seatList[sel].userID.equals(log)) {
			seatList[sel].userID = "";
			seatList[sel].check = false;
			System.out.println(( sel + 1 ) + "번 좌석이 [취소완료] 되었습니다. ");
			printSeat();
		}else {
			System.out.println("[취소할수없습니다]");
		}
	}

	//예매 확인
	//내 아이디와 일치하는 이미 예약된 좌석을 보여준다.
	void check(String log) {
		for (int i = 0; i < seatList.length; i++) {
			if(seatList[i].userID.equals(log)) {
				System.out.println(log + "님은 " + (i + 1) + "번 좌석이 예약되어 있습니다.");
			}
		}
	}


	
}
