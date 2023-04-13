package sample03_string;

public class StringBuilderApp {

	public static void main(String[] args) {
		
		// StringBuilder와 StringBuffer
		//  - 문자열의 변경이 빈번할 때 사용하는 객체다.
		
		// 아래의 코드를 실행하면, String객체는 매번 새로운 객체가 생성되기 때문에 
		// hashCode값이 각각 다르게 출력된다.
		System.out.println("### String 객체에 문자열 추가하기");
		String string = "hello";
		System.out.println("String 객체의 hashCode값 -> "+ string.hashCode()); //99162322
		string += " 홍길동";
		System.out.println("String 객체의 hashCode값 -> "+ string.hashCode()); //-738614884
		string += "님 반갑습니다.";
		System.out.println("String 객체의 hashCode값 -> "+ string.hashCode()); //-831588838
		System.out.println(string.toString());
		
		System.out.println();
		
		// StringBuilder는 문자열을 추가해도 객체가 새로 생성되지 않기 때문에 추가한 후에도 hashCode값이 같다.
		System.out.println("### StringBuilder 객체에 문자열 추가하기.");
		StringBuilder sb = new StringBuilder("hello");
		System.out.println("StringBuilder 객체의 hashCode값 -> "+ sb.hashCode()); // 2104457164
		sb.append(" 홍길동");
		System.out.println("StringBuilder 객체의 hashCode값 -> "+ sb.hashCode()); // 2104457164
		sb.append("님 반갑습니다.");
		System.out.println("StringBuilder 객체의 hashCode값 -> "+ sb.hashCode()); // 2104457164
		System.out.println(sb.toString());		
	}
}
