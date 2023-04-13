package sample05_date;

import java.util.Date;

public class DateApp1 {

	public static void main(String[] args) {
	
		
		// 시스템의 현재 날짜와 시간정보를 가진 Date객체를 생성하기.
		// 주로 이 용도로만 사용한다.
		Date now = new Date();
		System.out.println(now);
		
		// 유닉스타임을 전달받아서 해당 날짜와 시간정보를 표현하는 Date객체를 생성하기
		
		Date someDate = new Date(0); // 다른 시스템이나 메서드에서 날짜정보를 long값으로 줄 때 사용하쇼.
		System.out.println(someDate); // Thu Jan 01 09:00:00 KST 1970
		Date someDate2 = new Date();
		System.out.println(someDate2); // 현재 날짜와 시간 
		
	}
}
