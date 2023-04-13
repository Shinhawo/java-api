package sample03_string;

import java.util.StringJoiner;

public class StringJoinerApp2 {

	public static void main(String[] args) {
		String[] names = {"김유신","강감찬","이순신"};
		
		String textString ="";
		
		for(String x : names) {
			textString += x;
			textString += ",";
		}
		textString= textString.substring(0,textString.length()-1);
		System.out.println(textString);
		
		
		StringJoiner joiner = new StringJoiner(",");
		for(String x : names) {
			joiner.add(x);
		}

		System.out.println(textString);
		
	}
}
