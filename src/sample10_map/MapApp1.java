package sample10_map;

import java.util.HashMap;

public class MapApp1 {

	public static void main(String[] args) {
		
		// HashMap 객체로 정보 저장하기
		// key : 사용자아이디, value : 사용자이름
		HashMap<String, String> map = new HashMap<>();
		
		// HasMap객체에 key, value 저장하기
		map.put("hownu080", "신하원");
		map.put("ohgeo12!", "오민선");
		map.put("5ohgeo12!", "오오거");
		map.put("ahn", "안중근");
		map.put("mountainvalleyBoy", "ㅇ수옹");
		
		
		// HashMap 객체에 저장된 정보를 key를 이용해서 조회하기
	    String value1 = map.get("hownu080");
	    System.out.println("조회된 값 -> "+value1);
	    String value2  = map.get("hong");
	    // 존재하지 않는 키로 검색 >> null 반환
	    System.out.println("조회된 값 -> "+value2); 
	    
	    // HashMap객체에 저장된 정보를 key를 이용해서 삭제하기
	    map.remove("ahn");
	    // 존재하지 않는 키로 삭제 >> 아무일도 안일어남
	    map.remove("hong"); 
	}
}
