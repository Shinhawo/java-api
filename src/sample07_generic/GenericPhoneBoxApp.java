package sample07_generic;

public class GenericPhoneBoxApp {

	public static void main(String[] args) {
		
		GenericPhoneBox<Phone> box1 = new GenericPhoneBox<>();
		GenericPhoneBox<FeaturePhone> box2 = new GenericPhoneBox<>();
		GenericPhoneBox<SmartPhone> box3 = new GenericPhoneBox<>();

		// Phone류의 객체만 GenericPhoneBox에 담을 수 있다.
		/*
		 * class GenericPhoneBox<T extends Phone>{
		 * 		T item;
		 * }
		 * 
		 * <T extends Phone>은 파라미터 T의 타입으로 Phone및 그 하위 타입만 가능하다.
		 */
//		GenericPhoneBox<String> box4 = new GenericPhoneBox<>();

	}
}
