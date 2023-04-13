package sample07_generic;

public class GenericWildCardApp {
	public static void main(String[] args) {
		
		test1(new GenericBox<Phone>());
		test1(new GenericBox<SmartPhone>());
		test1(new GenericBox<FeaturePhone>());
		test1(new GenericBox<String>());
		test1(new GenericBox<Integer>());
		
		test2(new GenericBox<Phone>());
		test2(new GenericBox<SmartPhone>());
		test2(new GenericBox<FeaturePhone>());
		

		test3(new GenericBox<Integer>());
		test3(new GenericBox<Long>());

		test4(new GenericBox<FeaturePhone>());
		test4(new GenericBox<Phone>());
	}
	
	public static void test1(GenericBox<?> box) {
		System.out.println("제한없음.");
	}
	
	public static void test2(GenericBox<? extends Phone> box) {
		System.out.println("상한제한중 : Phone과 그 자식들만 작동 가능.");
	}
	
	public static void test3(GenericBox<? extends Number> box) {
		System.out.println("상한제한중 : Number와 그 자식들만 작동 가능");
	}
	
	public static void test4(GenericBox<? super FeaturePhone> box) {
		System.out.println("하한제한중 : FeaturePhone과 그 조상만 작동 가능");
	}
}
