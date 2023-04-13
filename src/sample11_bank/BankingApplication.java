package sample11_bank;

import static util.DateUtils.toText; // static
import java.util.List;
import java.util.Map;

// 표현계층 : 고객이 입력한 값을 받고 그 객체를 업무로직을 하는 서비스 계층에 전달하고
//         업무로직을 실행한 결과를 클라이언트에게 보내준다. (like 다리)
//		   클라이언트와 1 : 1 대응. 클라이언트에 따라 다양한 표현계층 존재

import util.KeyboardReader;


public class BankingApplication {
	
	public static void main(String[] args) { // static 메서드는 static만 실행가능. 객체 생성해야 멤버 사용가능
		BankingApplication application = new BankingApplication();
		application.displayMenu();
	}
	
	private KeyboardReader reader = new KeyboardReader();
	private Bankingservice service = new Bankingservice();
	
	public void displayMenu() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1.전계좌 2.계좌상세 3.개설 4.입금 5.출금 6.비번변경 7.해지 0.종료");
		System.out.println("----------------------------------------------------------------------");

		System.out.println("### 메뉴선택 > ");
		int menuNo = reader.readInt();
		System.out.println();
		
		if(menuNo == 1) {
			전계좌조회();
		} else if(menuNo == 2) {
			계좌상세조회();
		} else if(menuNo == 3) {
			신규계좌개설();
		}else if(menuNo == 4) {
			입금();
		}else if(menuNo == 5) {
			출금();
		}else if(menuNo == 6) {
			비밀번호변경();
		}else if(menuNo == 7) {
			계좌해지();
		}else if(menuNo == 0) {
			프로그램종료();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		displayMenu();
	}
	
	private void 전계좌조회() {
		System.out.println("<< 전체 계좌 조회 >>");
		System.out.println("### 예금주를 입력하세요.");
		
		// 계좌정보를 조회할 얘금주명을 입력받는다.
		System.out.println("### 예금주 : ");
		String name = reader.readString();
		
		// BankingService객체의 getMyallAccounts(String name) 메서드로 전달해서 호출한다.
		// 예금주명으로 조회된 계좌정보들을 List<Account> 객체로 반환받는다.
		List<Account> accounts =  service.getMyAllAccounts(name);
		
		if (!accounts.isEmpty()) { // accounts가 바라보고 있는 List객체가 안비어있는지
			System.out.println("### ["+name+"]님의 계좌정보.");
			System.out.println("====================================");
			
			for(Account account : accounts) {
				System.out.println("계좌번호 : "+account.getNo());
				System.out.println("현재잔액 : "+account.getBalance());
				System.out.println("------------------------------------");

			}
		} else { // 비어있는지
			System.out.println("### ["+name+"]님 이름으로 등록된 계좌정보가 존재하지 않습니다.");
		}
		
		
	}
	
	private void 계좌상세조회() {
		System.out.println("<< 계좌정보 상세조회 >>");
		System.out.println("### 계좌번호, 비밀번호를 입력하세요.");
		System.out.println("### 계좌번호 : ");
		int no = reader.readInt();
		System.out.println("### 비밀번호 :");
		int pwd = reader.readInt();
		
		Account account = service.getAccountDetail(no, pwd);
		
		if(account != null) {
			System.out.println("--- 계좌 상세정보 ---");
			System.out.println("### 계좌번호 : "+account.getNo());
			System.out.println("### 예금주 : "+account.getOwner());
			System.out.println("### 현재잔액 : "+account.getBalance());
			System.out.println("### 금리 : "+account.getInterestRate());
			System.out.println("### 상태 : "+account.getStatus());
			System.out.println("### 개설일자 : "+ toText(account.getCreatedDate()));
		} else {
			System.out.println("### 계좌정보 조회 중 오류가 발생하였습니다.");
		}
	}
	
	private void 신규계좌개설() {
		System.out.println("<< 신규 계좌 개설 >>");
		System.out.println("### 신규 계좌 개설에 필요한 정보를 입력하세요.");
		
		// 입력값을 읽어와서 변수에 저장한다.
		System.out.println("### 계좌번호 : ");
		int no = reader.readInt();
		System.out.println("### 비밀번호 : ");
		int password = reader.readInt();
		System.out.println("### 예금주명 : ");
		String name = reader.readString();
		System.out.println("### 입금금액 : ");
		long amount = reader.readLong();
		System.out.println("### 약정금리 : ");
		double interestRate = reader.readDouble();
		
		// Account객체를 생성해서 입력한 계좌정보를 저장한다.
		Account account = new Account();
		account.setNo(no);
		account.setPassword(password);
		account.setOwner(name);
		account.setBalance(amount);
		account.setInterestRate(interestRate);
		
		// BankingService객체의 createAccount(Account account)메서드를 호출해서
		// 신규계좌개설을 요청한다.
		Account savedAccount = service.createAccount(account);
		
		// 신규로 개설된 계좌정보를 화면에 출력한다.
		System.out.println();
		System.out.println("### 신규 개설 계좌정보");
		System.out.println("계좌번호 : "+savedAccount.getNo());
		System.out.println("예금주명 : "+savedAccount.getOwner());
		System.out.println("약정금리 : "+savedAccount.getInterestRate());
		System.out.println("현재잔액 : "+savedAccount.getBalance());
		System.out.println("계좌상태 : "+savedAccount.getStatus());
		System.out.println("개설일시 : "+toText(savedAccount.getCreatedDate()));
		
		System.out.println("### 신규 계좌개설이 완료되었습니다.");
		
	}
	
	private void 입금() {
		System.out.println("<< 입금하기 >>");
		System.out.println("### 계좌번호와 입금액을 입력하세요.");
		System.out.println("### 계좌번호 : ");
		int no = reader.readInt();
		System.out.println("### 입금액 : ");
		long amount = reader.readLong();
		
		// 출금같이 성공/실패의 원인이 여러가지일 경우에는 '예외'를 사용한다.
		boolean isSuccess = service.deposit(no, amount);
		
		if(isSuccess == false) {
			System.out.println("입력하신 계좌번호와 일치하는 계좌정보가 없어 입금이 실패하였습니다.");
		} else {
			System.out.println("### ["+no+"] 계좌에 ["+amount+"] 금액이 입금되었습니다.");
		}
	}
	
	private void 출금() {
		System.out.println("<< 출금하기 >>");
		System.out.println("### 계좌번호와 비밀번호, 출금액을 입력하세요.");
		System.out.println("### 계좌번호 : ");
		int no = reader.readInt();
		System.out.println("### 비밀번호 : ");
		int pwd = reader.readInt();
		System.out.println("### 출금액을 입력하세요.");
		long amount = reader.readLong();
		
		boolean isSuccess = service.withraw(no, pwd, amount);
		
		if(isSuccess == false) {
			System.out.println("### 출금에 실패하였습니다.");	
		}else {
			System.out.println("### ["+no+"] 계좌에서 ["+amount+"]원 출금하였습니다.");
		}
	}
	
	private void 비밀번호변경() {
		System.out.println("<< 비밀번호변경 >>");
		System.out.println("### 계좌번호, 비밀번호, 변경할 번호를 입력하세요.");
		System.out.println("### 계좌번호 :");
		int no = reader.readInt();
		System.out.println("### 비밀번호 :");
		int prePassword = reader.readInt();
		System.out.println("### 변경할 비밀번호 :");
		int password = reader.readInt();
		
		boolean isSuccess = service.changePassword(no, prePassword, password);
		
		if(isSuccess == true) {
			System.out.println("### 비밀번호가 ["+prePassword+"]에서 ["+password+"]로 변경되었습니다.");
		}else {
			System.out.println("### 비밀번호 변경처리 중 오류가 발생하였습니다.");
		}
	}
	
	private void 계좌해지() {
		System.out.println("<< 계좌 해지하기 >>");
		System.out.println("### 계좌번호, 비밀번호를 입력하세요.");
		System.out.println("### 계좌번호 : ");
		int no = reader.readInt();
		System.out.println("### 비밀번호 : ");
		int pwd = reader.readInt();
		
		// Account에 없는 값도 담으려고 Map을 사용했다.
		Map<String, Object> result = service.expireAccount(no, pwd);
		boolean isSuccess = (Boolean)result.get("success");
		
		if(isSuccess) {
			String name = (String)result.get("owner");
			long balance = (Long)result.get("balance");
			int interest = (Integer)result.get("interest");
			long amount = (Long)result.get("amount");
			
			System.out.println("### 계좌해지가 완료되었습니다. 해지 내용을 확인하세요.");
			System.out.println("### 계좌번호 : "+ no);
			System.out.println("### 예금주 : "+ name);
			System.out.println("### 현재잔액 : "+ balance);
			System.out.println("### 이자 : "+ interest);
			System.out.println("### 예상해지금액 : "+ amount);
		}else {
			System.out.println("### 계좌 해지 중 오류가 발생했습니다.");
		}
	}
	
	private void 프로그램종료() {
		System.out.println("<< 프로그램 종료 >>");
		System.exit(0);
	}
}
