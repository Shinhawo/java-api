package sample08_list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.ValueExp;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class ArrayListApp2 {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<>();
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("류관순");

		System.out.println("### 콜렉션객체(ArrayList객체)에 저장된 값을 외부반복으로 처리하기.");
		for(String name : names) {
			System.out.println(name);
		}
		
		// 변형,수집
		List<Character> values = new ArrayList<>();
		for(String name : names) {
			values.add(name.charAt(0));
		}
		
		// 소비
		for(char c : values) {
			System.out.println(c);
		}
		
		System.out.println("### 콜렉션객체(ArrayList객체)에 저장된 값을 내부반복으로 처리하기.");
		names.stream().forEach(name -> System.out.println(name));
		// stream()이 하나씩 공급해준 객체를 forEach로 소비하여 name으로 받고 그 name을 출력한다.
		
		names.stream()
		     .map(name -> name.charAt(0))
		     .collect(Collectors.toList())
		     .forEach(value -> System.out.println(value));
	}

}
