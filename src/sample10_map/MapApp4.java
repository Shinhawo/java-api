package sample10_map;

import java.util.HashMap;
import java.util.Map;

public class MapApp4 {
	public static void main(String[] args) {
		// Map객체를 이용해서 변화가 많은 정보를 저장할 수 있다.
		
		// Map객체를 이용해서 다양한 검색조건 정보를 저장할 수 있다.
		Map<String, Object> map = new HashMap<>();
		map.put("sort", "price");   		// 정렬기준
		map.put("row", 20);					// 출력갯수 
		map.put("search-out", "title"); 	// 검색옵션
		map.put("searchKeyword", "토익시험"); 	// 검색키워드
		map.put("maxPrice", 30000);  		// 최소가격
		map.put("minPrice", 15000);  		// 최대가격
		map.put("pageNo", 2);				// 요청페이지번호
		
		
		
	}
}
 