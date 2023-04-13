package book_list_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetBookApp2 {

	public static void main(String[] args) {
		Set<Book> books = new HashSet<>();
		
		books.add(new Book(102, "생각하는 프로그래밍", "김창준", 29000));
		books.add(new Book(105, "모던 자바스크립트", "이웅모", 42000));
		books.add(new Book(100, "자바의 정석", "남궁성", 35000));
		books.add(new Book(104, "혼자 공부하는 파이썬", "윤인성", 21000));
		books.add(new Book(101, "이것이 자바다", "신용권", 32000));
		books.add(new Book(103, "Do it! 점프 투 파이썬", "박응용", 18000));
		
		// 101번 책을 삭제하기
		// ConcurrentModificationException 발생! 
		// >> enhanced for문을 수행하는 도중에 객체를 삭제할 수 없음!
//		for (Book book : books) {
//			System.out.println("책번호 -> "+ book.getNo());
//			if(book.getNo() == 101) {
//				books.remove(book);
//			}
//		}
		
		// iterator(반복자) 사용해서 삭제해야 한다
		// 책번호가 짝수인 책정보 상제하기
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book book = iter.next();
			
			if(book.getNo()%2 == 0) {
				iter.remove();
			}
		}
		
		System.out.println("저장된 객체의 갯수 -> "+ books.size());
		for(Book book : books) {
			System.out.println(book.getNo());
		}
	}
}
