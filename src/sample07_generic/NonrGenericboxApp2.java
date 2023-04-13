package sample07_generic;

public class NonrGenericboxApp2 {

	public static void main(String[] args) {
		
		// 문자열을 저장하는 box객체 생성하기.
		NoneGenericBox box1 = new NoneGenericBox();
		box1.setItem("홍길동");
		// box객체 생성 목적과 맞지 않는 객체가 저장될 수 있다.
		box1.setItem(100);// 정수가 담기는걸 막을 수 없다.
		
		// 문자열을 저장하는 box객체 생성하기
		NoneGenericBox box2 = new NoneGenericBox();
		box2.setItem("오거");
		
		// 빨간줄 안가지만 실행시 에러 발생
		// ClassCastException
		int value = (Integer)box2.getItem();
		System.out.println(value);
	}
}
