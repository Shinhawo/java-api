package sample05_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateApp2 {

	public static void main(String[] args) {
	
		//시스템의 현재 날짜와 시간정보를 표현하는 Date 객체 생성하기
		Date now = new Date();
		System.out.println("포맷팅 하기 전 -> "+now);
		
		// 날짜와 시간 패턴 지정하기
		String pattern = "yyyy-MM-dd HH:mm:ss";
		String pattern2 = "yyyy년 M월 d일 EEEE a h시 m분 s초 HH:mm:ss";
		
		// 패턴정보를 전달받아서 SimpeDateFormat객체를 생성하고 초기화하기.
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		// Date객체(날짜와 시간정보)를 지정된 패턴형식의 문자열로 변환하기
		String text = sdf.format(now);
		System.out.println("포멧팅된 날짜와 시간정보 -> "+text);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat(pattern2);
		
		String text2 = sdf2.format(now);
		System.out.println("포멧팅된 날짜와 시간정보 -> "+text2);
		
	}
}
