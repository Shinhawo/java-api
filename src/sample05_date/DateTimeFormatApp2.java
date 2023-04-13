package sample05_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormatApp2 {
	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		// 지정된 패턴형식의 문자열을 해석해서 Date객체를 생성하기
		Date date = sdf.parse("1998-06-24"); // 위의 패턴과 같은 형식으로 적어야 함.
		System.out.println(date);
		
		//시스템의 현재 날짜와 시간정보를 표현하는 Date객체를 생성하기
		Date now = new Date();
		
		long nowUnixTime = now.getTime();
		long dateUnixTime = date.getTime();
		
		long days = (nowUnixTime - dateUnixTime)/(60*60*24*1000);
		System.out.println("경과일자 : " +  days);
	}
}
