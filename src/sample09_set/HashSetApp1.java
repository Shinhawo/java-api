package sample09_set;

import java.util.HashSet;

public class HashSetApp1 {

	public static void main(String[] args) {
		
		//HashSet의 주요 메서드
		HashSet<String> names = new HashSet();

		//객체생성하기
		names.add("김유신");
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("류관순");
		
		// 저장된 객체의 갯수를 조회하기
		int count = names.size();
		System.out.println("저장된 객체의 갯수 -> "+count); // 4 -> 중복허용안함 
		
		// 향상된for문으로 저장된 객체를 반복처리하기
		for(String name : names) {
			System.out.println("이름 -> : "+ name); // 순서대로 나오지 않는다.
		}
		
		// 저장된 객체 삭제하기
		names.remove("강감찬");
		
		// HashSet객체에 지정된 객체가 존재하는지 조회하기
		boolean isExist = names.contains("이순신");
		System.out.println("이순신이 포함되어 있는가? "+isExist);
		
	
		System.out.println();	
		// 향상된for문으로 저장된 객체를 반복처리하기
		System.out.println("### 삭제 후 저장된 이름 확인하기.");
		for(String name : names) {
			System.out.println("이름 -> : "+ name); // 순서대로 나오지 않는다. 
		}
		
	}
}
