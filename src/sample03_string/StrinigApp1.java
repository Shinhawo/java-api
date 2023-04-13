package sample03_string;

public class StrinigApp1 {

	public static void main(String[] args) {
		
		// String 객체 생성하기
		
		// 1. 문자열 리터럴을 이용해서 String객체 생성하고 초기화하기.
		String str1 = "홍길동";
		String str2 = "홍길동";
		// 2. new 키워드를 이용해서 String객체를 생성하고, 생성자 메서드로 초기화하기.
		String str3 = new String("홍길동");
		String str4 = new String("홍길동");
		
		// 생성된 객체의 주소값 비교하기. (==)
		// 동일성비교 - 주소값
		System.out.println(str1 == str2); // true 값이 안바뀌므로 같은 객체를 바라볼 수 있다.
		System.out.println(str3 == str4); // false
		
		// 생성된 객체의 내용 비교하기. (equals)
		// 동등성비교 - 내용
		// String은 Object의 hashCode와 equals를 재정의해서 상속받았다. 
		System.out.println(str1.equals(str2)); //true
		System.out.println(str3.equals(str4)); //true
		
	}
}
