package sample03_string;

import java.util.StringTokenizer;

public class StringTokenizerApp {

	public static void main(String[] args) {
		
		String text = "하원과 민선은 오늘 즉석떡볶이를 먹고 행복해질 계획이다. 쏘 해피~~! 냠 맛있겠당^^ 떡볶이 조아.";
		
		//StringTokenizer 객체는 전달받은 문자열을 토큰화한다.
		// 구분기호를 지정하지 않으면 공백/탭,개행문자로 문자열을 구분해서 토큰화한다.
		StringTokenizer tokenizer = new StringTokenizer(text);
		
		//토큰화된 문자열 출력하기
		// "떡볶이"라는 글자가 포함된 단어는 몇번이나 나왔나?
		
		int count = 0;
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			System.out.println(token);
			
			if(token.contains("떡볶이")) {
				count++;
			}
		}
		System.out.println("전체 문장에서 \"떡볶이\"라는 단어가 나온 횟수 : "+count);
		
	}
}
