package sample03_string;

public class StringApp4 {

	public static void main(String[] args) {
		
		// 고객의 이메일주소에서 아이디만 조회해서 출력하기
		String[] emalArr = {"hong@gmail.com","lee-sushin@naver.com","kimys@hanmail.com"};
		
		for(String email : emalArr) {
			System.out.println(email);
			System.out.println(email.indexOf("@"));
			String id = email.substring(0, email.indexOf("@"));
			System.out.println(id);
		}	
		
		System.out.println();
		
		// 고객의 이메일주소에서 도메인네임 출력하기
		for(String email : emalArr) {
			System.out.println(email);
			String domainName = email.substring(email.indexOf("@")+1);
			System.out.println(domainName);
		}	
		
		
	}
}
