package sample11_bank;

import java.nio.channels.CancelledKeyException;

//서비스계층 : 구체적 기능, 업무 로직 구현

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Bankingservice {
	
	private BankingRepository repo = new BankingRepository();
	
	// 신규 계좌 개설하기 기능
	/*  사용자가 입력한 신규 계좌정보를 전달받아서 영속화계층에 저장시키고, 개설된 계좌정보를 반환한다.
	 * 	반환타입 : Account
	 *  메서드명 : createAccount
	 *  매개변수 : Account account
	 */
	public Account createAccount(Account account) {
		
		// 전달받은 계좌정보에 계좌상태, 개설일시를 저장한다.
		account.setStatus("사용중");
		account.setCreatedDate(new Date());
		
		// 영속화 계층에 계좌정보를 전달해서 저장시킨다.
		repo.insertAccount(account);
		
		return account;
	}
	
	// 전계좌 조회하기
	/* 예금주명을 전달받아서 해당 예금주명으로 개설된 모든 계좌정보를 조회해서 반환한다.
	 * 반환타입 : List<Account>
	 * 매서드명 : getMyAllAccounts
	 * 매개변수 : String name
	 */
	public List<Account> getMyAllAccounts(String name){
		
		List<Account> accounts = repo.getAccountsByName(name);
		return accounts;
	}
	
	// 계좌상세정보 조회하기
	/*
	 * 계좌번호와 비밀번호를 전달받아서 계좌 상세정보를 반환한다.
	 * 반환타입 : Account
	 * 메서드명 : getAccountDetail
	 * 매개변수 : int accNo, int pwd
	 */
	public Account getAccountDetail(int accNo, int pwd) {
		Account account = repo.getAccountByNo(accNo);
		if(account == null) {
			System.out.println("### 입력하신 계좌번호의 계좌정보가 존재하지 않습니다.");
			return null;
		}
		if (account.getPassword() != pwd) {
			System.out.println("### 비밀번호 틀림!");
			return null;
		}
		
		return account;
	}
	
	// 입금하기
	/*
	 * 계쫘번호와 입금액을 전달받아서 현재 잔액을 증가시킨다.
	 * 반환타입 : boolean
	 * 메서드명 : deposit()
	 * 매개변수 : int no, long amount
	 */
	public boolean deposit(int accNo, long amount) {
		// accNo의 계좌정보 가져오기
		Account account = repo.getAccountByNo(accNo);
		if (account == null) {
			return false;
		} 
		
		long balance = account.getBalance() + amount;
		account.setBalance(balance);
		
		return true;
	}
	
	
	// 출금하기
	public boolean withraw(int accNo, int pwd, long amount) {
		Account account = repo.getAccountByNo(accNo);
		
		if (account == null || account.getPassword() != pwd || account.getBalance() < amount) {
			// else if 쓰지마라... 구하려는 값도...조건도...완전 다르잖냐-!!
			if(account == null) {
				System.out.println("### 어? 그런 계좌번호 없는디요...");
			} 
			
			if(account.getPassword() != pwd) {
				System.out.println("### 헐 비밀번호 틀림");
			}
			
			if(account.getBalance() < amount) {
				System.out.println("### 거지십니다!");
			}
			return false;
		}
		
//		if(account == null) {
//			System.out.println("### 어? 그런 계좌번호 없는디요...");
//			return false;
//		} 
//		
//		if(account.getPassword() != pwd) {
//			System.out.println("### 헐 비밀번호 틀림");
//			return false;
//		}
//		
//		if(account.getBalance() < amount) {
//			System.out.println("### 거지십니다!");
//			return false
//		}
		
		long balnce = account.getBalance() - amount;
		account.setBalance(balnce);
		
		return true;
	}
	
	// 비밀번호 변경하기
	public boolean changePassword(int no, int prePassword, int password) {
		Account account = repo.getAccountByNo(no);
		
		if(account == null) {
			System.out.println("### 입력하신 계좌번호의 계좌정보가 존재하지 않습니다.");
			return false;
		}
		if(account.getPassword() != prePassword) {
			System.out.println("### 비밀번호가 틀렸습니다.");
			return false;
		}
		
		account.setPassword(password);
		return true;
	}
	
	
	// 해지하기 
	public Map<String, Object> expireAccount(int accNo, int pwd) {
		Map<String, Object> result = new HashMap<>();
		
		Account account = repo.getAccountByNo(accNo);
		if(account == null) {
			result.put("success", false);
			System.out.println("### 그런 계좌없음");
			return result;
		}
		if(account.getPassword() != pwd) {
			result.put("success", false);
			System.out.println("### 비번틀림");
			return result;
		}
		
		int interest = (int) (account.getBalance()*account.getInterestRate()*5);
		
		result.put("success", true);
		result.put("no", account.getNo());
		result.put("owner", account.getOwner());
		result.put("balance", account.getBalance());
		result.put("interest", interest);   // 이자
		result.put("amount", account.getBalance()+interest);
		
		repo.deleteAccount(accNo);
		
		return result;
	}
}
