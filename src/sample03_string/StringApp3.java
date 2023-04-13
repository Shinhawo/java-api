package sample03_string;

public class StringApp3 {

	public static void main(String[] args) {
		
		// 기본자료형을 문자열로 변환하기
		/// valueOf 중복정의가 되어있어 불린, 정수, 실수, 객체, 문자, 문자배열을 String으로 변환해서 반환한다.
		// static String valueOf(boolean value) 
		// static String vlaueOF(char c)
		// static String vlaueOF(char[] arr, int offset, int length)
		// static String vlaueOF(double d)
		// static String vlaueOF(int i)
		// static String vlaueOF(long l)
		// static String vlaueOF(Object obj)
		
		String text = String.valueOf(true);
		String text1 = String.valueOf('a');
		String text2 = String.valueOf(3.14);
		String text3 = String.valueOf(10000);
		String text4 = String.valueOf(10000000000000L);
		char [] arr = {'안','녕','하','세','요'}; 
		
		String text5 = String.copyValueOf(arr);
		System.out.println(text.toString());
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);
		System.out.println(text4);
		System.out.println(text5); // 안녕하세요
		
		//문자열을 기본자료형으로 변환하기.
		boolean result = Boolean.parseBoolean("true");
		char result2 = "ABC".charAt(0); // >> 문자열 "ABC" 중 0번째 것을 문자로 바꾼다.
		int result3 = Integer.parseInt("10000");
		double result4 = Double.parseDouble("3.14");
		long result5 = Long.parseLong("10000000000000");
		
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		
		// 값을 가공할 때는 문자열이 가장 쉽다.
		// 임의의 정수에 대하여 정수의 각 자리값을 더한 결과를 출력하기.
		// 정수 : 110293
		// 출력값 : 16

		int number = 110293;
		String text6 = String.valueOf(number); // 문자열은 split 메서드를 사용할 수 있음
		String[] values = text6.split("");
		int total = 0;
	
		for (String value : values) {
			int num = Integer.parseInt(value);
			total += num;
		}
		System.out.println(total);
		
	}
}
