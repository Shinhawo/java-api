package sample07_generic;

public class GenericBoxApp {

	public static void main(String[] args) {
		
		GenericBox<String> box1 = new GenericBox<>();
		/*
		 * 소스코드
		 * class Generic<T>{
		 *		T item; 
		 * 		T getItem() { retrun item;}
		 *      void setItem (T item) {this.item = item;}
		 * }
		 * 
		 * 실제 생성한 객체의 코드
		 * class Generic<String>{
		 *		String item; 
		 * 		String getItem() { retrun item;}
		 *      void setItem (T item) {this.item = item;}
		 * }
		 */
		box1.setItemT("귀요미오거");
		
		String value = box1.getItemT(); // 클래스형변환 연산자를 사용할 필요가 없다.
		System.out.println(value);

//		box1.setItemT(1);  !빨간줄!
		
	}
}
