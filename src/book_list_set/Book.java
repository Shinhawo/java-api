package book_list_set;

import java.util.Objects;

public class Book implements Comparable<Book>{

		private int no;
		private String title;
		private String writerString;
		private int price;
		
		public Book(int no, String title, String writerString, int price) {
		
			this.no = no;
			this.title = title;
			this.writerString = writerString;
			this.price = price;
		}
		public int getNo() {
			return no;
		}
		
		public String getTitle() {
			return title;
		}
		
		public String getWriterString() {
			return writerString;
		}
	
		public int getPrice() {
			return price;
		}
		@Override
		public int hashCode() {
			return Objects.hash(no);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			return no == other.no;
		}
		
//		@Override
//		public int compareTo(Book other) {
//		
//		// 책 번호를 기준으로 정의
//		// 정수, 실수 비교일 때는 빼기
//		return no - other.no;
//		}
		
		// 이름순 정렬 
		// 문자열은 Comparable 구현 객체 
		public int compareTo(Book other) {
			
		return title.compareTo(other.title);
		}
		
		// 출판일 비교 >> 유닉스타입 이용 (.getTime)
		// Date는 Comparable 구현 객체
		// return pubDate.compareTo(other.pubDate)
}
