package sample08_list;

import java.util.ArrayList;

public class ArrayListApp1 {

	public static void main(String[] args) {
		
		// 배열과 ArrayList<E>의 비교
		
		// 문자열을 저장할 수 있는 배열객체와 ArrayList객체 생성하기.
		String[] arr = new String[5];
		ArrayList<String> list = new ArrayList<>();

		// 배열객체에 문자열 저장하기 >> index를 알아야지만 정확한 위치에 저장 가능.
		arr[0] = "John";
		arr[1] = "Jane";
		arr[2] = "Alexandra";
		arr[3] = "Jilia";
		arr[4] = "David";

		
		// ArrayList객체에 문자열 저장하기 >> 인덱스를 사용하지 않고 ArrayList객체에 값을 저장할 수 있다.
		list.add("John");
		list.add("Jane");
		list.add("Alexandra");
		list.add("Julia");
		list.add("David");
		list.add("Eddy");
		list.add("Liz");
		
		// 배열에 저장된 값 출력하기
		// enhanced-for문은 배열의 처음부터 끝까지 모든 요소를 반복처리한다.
		System.out.println("### 배열객체에 저장된 값 출력하기.");
		for (String value :arr) {
			if(value == null) {
				break;
			}
			System.out.println(value.toUpperCase()); // 3번까지 저장했지만 출력은 4번까지 된다.(끝까지)
		}                                            // 마지막 값이 null이라서 오류가 생겼다.
		
		// ArrayList에 저장된 값 출력하기
		// enhanced-for문은 ArrayList에 저장된 요소의 갯수만큼만 반복처리한다.
		System.out.println("### ArrayList객체에 저장된 값 출력하기.");
		for(String value :list) {
			System.out.println(value.toUpperCase()); // 저장된 값만 출력된다. (null값 출력 안됨.)
		}
	}
}
