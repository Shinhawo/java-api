package book_list_set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListBookApp2 {

	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		
		books.add(new Book(102, "생각하는 프로그래밍", "김창준", 29000));
		books.add(new Book(105, "모던 자바스크립트", "이웅모", 35000));
		books.add(new Book(100, "자바의 정석", "남궁성", 35000));
		books.add(new Book(104, "혼자 공부하는 파이썬", "윤인성", 35000));
		books.add(new Book(101, "이것이 자바다", "신용권", 32000));
		books.add(new Book(103, "Do it! 점프 투 파이썬", "박응용", 18000));

        // books.sort(null);
		// Collections의 sort는 compareTo 메서드가 재정의 되어 있어야 사용 가능하당깨~!!
		Collections.sort(books);
		
		System.out.println("### 책제목을 기준으로 정렬");
		System.out.println("======= 책정보 =======");
	
		for(Book book : books) {
			System.out.println("번호 : "+book.getNo());
			System.out.println("제목 : "+book.getTitle());
			System.out.println("저자 : "+book.getWriterString());
			System.out.println("가격 : "+book.getPrice());
			System.out.println("--------------------");
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("### 가격을 기준으로 정렬");
		// List객체에 저장된 책정보를 가격을 기준으로 정렬~~!!
		Collections.sort(books,(b1,b2) -> b1.getPrice() - b2.getPrice());
		// List 객체에 저장된 책정보를 가격순을 기준으로 정렬시키고, 가격이 동일하면 제목순으로 정렬시키기.
		// 익명
//		Collections.sort(books, new Comparator<Book>() {
//			public int compare(Book o1, Book o2) {
//				int gap = o1.getPrice() - o2.getPrice();
//				if(gap == 0) {
//					return o1.getTitle().compareTo(o2.getTitle());
//				}
//				return gap;
//			}
//		});
		
		Collections.sort(books,(b1,b2) -> {
			int gap = b1.getPrice() - b2.getPrice();
			if(gap == 0) {
				return b1.getTitle().compareTo(b2.getTitle());
			}
			return gap;
		});
		
		System.out.println("======= 책정보 =======");
	
		for(Book book : books) {
			System.out.println("번호 : "+book.getNo());
			System.out.println("제목 : "+book.getTitle());
			System.out.println("저자 : "+book.getWriterString());
			System.out.println("가격 : "+book.getPrice());
			System.out.println("--------------------");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("### 저자명을 기준으로 정렬");
		Collections.sort(books, (b1,b2) -> b1.getWriterString().compareTo(b2.getWriterString()));
		
		System.out.println("======= 책정보 =======");
		
		for(Book book : books) {
			System.out.println("번호 : "+book.getNo());
			System.out.println("제목 : "+book.getTitle());
			System.out.println("저자 : "+book.getWriterString());
			System.out.println("가격 : "+book.getPrice());
			System.out.println("--------------------");
		}
		
		
	}
}
