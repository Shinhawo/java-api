package sample11_bank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingRepository {
	
	/*
	 * Map<Integer, Account>는 계좌정보를 저장하는 객체다.
	 *  key는 계좌번호(Integer)
	 *  value는 계좌정보(Account) 
	 */
	
	private Map<Integer,Account> map = new HashMap<>();
	
	public BankingRepository() {
		map.put(100, new Account(100, 1234, "김유신", 50000));
		map.put(200, new Account(200, 1234, "김유신", 5000000));
		map.put(300, new Account(300, 1234, "강감찬", 350000));
		map.put(400, new Account(400, 1234, "강감찬", 1050000));
		map.put(500, new Account(500, 1234, "이순신", 20050000));
	}
	
	// 저장기능
	/* 계좌정보객체를 전달받아서 Map객체에 저장한다.
	 * 반환타입 : void
	 * 메서드명 : insertAccount
	 * 매개변수 : Account account
	 */
	public void insertAccount(Account account) {
		map.put(account.getNo(), account); // 관리가 편해진다.
	}
	
	// 조회기능
	/* 서비스계층에서 비밀번호 확인하고 보내준 계좌번호로 정보를 반환할 뿐.
	 * 계좌번호를 전달받아서 계좌번호에 해당하는 계좌정보를 반환한다.
	 * 반환타입 : Account
	 * 메서드명 : getAccountByNo
	 * 매개변수 : int accNo
	 */
	public Account getAccountByNo(int accNo) {
		
		return map.get(accNo); // 계좌번호인 키로 계좌정보를 반환. 없으면 null이 반환됨.
	}
	
	// 조회기능
	/*
	 * 예금주 이름을 전달받아서 해당 예금주 이름으로 개설된 모든 계좌정보를 반환한다.
	 * 반환타입 : List<Account> 
	 * 메서드명 : getAccountsByName
	 * 매개변수 : String name
	 */
	public List<Account> getAccountsByName(String name){
		List<Account> accounts = new ArrayList<>();
		
		Collection<Account> values = map.values(); // map의 값들만 얻어진다~~~이말이야
		
		for (Account account : values) {
			if(name.equals(account.getOwner())) {
				// values에 있는 것을 accounts로 옮기기
				accounts.add(account); 
				}
		}
		
		return accounts;
	}
	
	// 변경기능
	/* 서비스계층에서 비밀번호 확인하고 보내준 계좌번호를 적용시킬 뿐.
	 * 변경된 정보가 반영된 계좌정보를 전달받아서 Map객체에 적용시킨다.
	 * 반환타입 : void
	 * 메서드명 : updateAccount
	 * 매개변수 : Account account
	 */
	 public void updateAccount (Account account) {
		 
	 } 
	
	// 삭제기능
	/* 서비스계층에서 비밀번호 확인하고 보내준 계좌번호로 정보를 삭제할 뿐.
	 * 계좌번호를 전달받아서 계좌번호와 일치하는 계좌정보를 삭제한다.
	 * 반환타입 : void
	 * 메서드명 : 
	 * 매개변수 : int accNo 
	 */
	 public void deleteAccount(int accNo) {
		 map.remove(accNo);
	 }
	
	
}
