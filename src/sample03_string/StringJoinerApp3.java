package sample03_string;

import java.util.StringJoiner;

public class StringJoinerApp3 {

	public static void main(String[] args) {
		
		StringJoiner joiner1 = new StringJoiner(" ");
		
		joiner1.add("홍길동");
		joiner1.add("김유신");
		joiner1.add("깅감찬");
		joiner1.add("이순신");
		joiner1.add("류관순");
		joiner1.add("안중근");
		
		String text = joiner1.toString();
		System.out.println(text);
	}
}
