package sample03_string;

import java.util.StringTokenizer;

public class StringTokenizerApp2 {

	public static void main(String[] args) {
		
		// split()메서드와 StringTokenizer의 차이점
		
		String text1 = "김유신,영업2팀,과장,010-1111-1111";
		String text2 = "강감찬,,인턴,010-2222-2222";
		
		// split()
		System.out.println("### split메서드로 문자열 자르기.");
		String[] value1 = text1.split(",");
		String[] value2 = text2.split(",");
		System.out.println("첫번째 문자열의 텍스트 갯수 -> "+ value1.length); //4
		System.out.println("두번째 문자열의 텍스트 갯수 -> "+ value2.length); //4
		System.out.println();
		
		//StringTokenizer
		System.out.println("### StringTokenizer로 문자열 토큰화하기.");
		StringTokenizer tokenizer = new StringTokenizer(text1,","); 
		StringTokenizer tokenizer2 = new StringTokenizer(text2,","); 
		System.out.println("첫번째 문자열의 토큰 갯수 -> " + tokenizer.countTokens());  //4
		System.out.println("두번째 문자열의 토큰 갯수 -> " + tokenizer2.countTokens()); //3
	}
}
