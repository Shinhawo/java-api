package book_list_set;

import java.util.HashSet;

public class SetBookApp {

	public static void main(String[] args) {
		
		HashSet<Book> books = new HashSet<>();
		
		books.add(new Book(100,"자바의 정석","남궁성",35000));
		books.add(new Book(100,"자바의 정석","남궁성",35000));
		books.add(new Book(100,"자바의 정석","남궁성",35000));
		books.add(new Book(101,"이것이 자바다","신용권",32000));
		books.add(new Book(102,"생각하는 프로그래밍","김창준",29000));
		
		System.out.println("======= 책정보 =======");
		for(Book book : books) {
			System.out.println(book.hashCode());
			System.out.println("번호 : "+book.getNo());
			System.out.println("제목 : "+book.getTitle());
			System.out.println("저자 : "+book.getWriterString());
			System.out.println("가격 : "+book.getPrice());
			System.out.println("--------------------");
		}
	}
}
