package sample06_math;

/*
 * 정적 import 구문
 *   - static 변수, static 메서드, static 내부 클래스를 import시킨다.
 *   - java5 부터 지원한다.
 *   - static import 구문으로 포함시킨 변수, 메서드, 내부클래스는 클래스이름 없이 사용할 수 있다.
 *   - 예시
 *       * Math 클래스의 정적메서드 abs를 import한다.
 *       import static java.lang.Math.abs;
 *       수행문에서 사용하기
 *       		int 절대값 = abs(-100);
 *       
 *       * Math 클래스의 모든 정적 구성요소를 import한다.
 *       		import static java.lang.Math.*;
 */			

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.round;
import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.random;

public class MathApp1 {

	public static void main(String[] args) {
	
		// 절대값 구하기
		int value1 = abs(100);
		int value2 = abs(-100);
		double value3 = abs(3.14);
		double value4 = abs(-3.14);
		System.out.println("절대값1 -> "+ value1);
		System.out.println("절대값2 -> "+ value2);
		System.out.println("절대값3 -> "+ value3);
		System.out.println("절대값4 -> "+ value4);
		
		// 큰 값 구하기
		int value5 = max(100, 20);
		double value6 = max(2.145, 10.4);
		double value7 = max(100, 23.45);
		System.out.println("큰 값1 ->" + value5);
		System.out.println("큰 값2 ->" + value6);
		System.out.println("큰 값3 ->" + value7);
		
		// 작은 값 구하기
		int value8 = min(100, 20);
		double value9 = min(2.145, 10.4);
		double value10 = min(100, 23.45);
		System.out.println("작은 값1 ->" + value8);
		System.out.println("작은 값2 ->" + value9);
		System.out.println("작은 값3 ->" + value10);
		
		// 반올림
		long value11 =  round(3.14);
		long value12 =  round(3.5);
		long value13 =  round(3.6);
		System.out.println("반올림 값1 ->" + value11);
		System.out.println("반올림 값2 ->" + value12);
		System.out.println("반올림 값3 ->" + value13);
		
		// 천정값
		double value14 = ceil(3.0);
		double value15 = ceil(3.1);
		double value16 = ceil(3.4);
		double value17 = ceil(3.8);
		double value18 = ceil(4.0);
		System.out.println("ceil값1 ->"+value14);
		System.out.println("ceil값2 ->"+value15);
		System.out.println("ceil값3 ->"+value16);
		System.out.println("ceil값4 ->"+value17);
		System.out.println("ceil값5 ->"+value18);
		
		// 바닥값
		double value19 = floor(3.0);
		double value20 = floor(3.1);
		double value21 = floor(3.4);
		double value22 = floor(3.8);
		double value23 = floor(4.0);
		System.out.println("floor값1 ->"+value19);
		System.out.println("floor값2 ->"+value20);
		System.out.println("floor값3 ->"+value21);
		System.out.println("floor값4 ->"+value22);
		System.out.println("floor값5 ->"+value23);
		
		// (0보다 크거나 같고 1보다 작은) 난수를 반환하는 메서드 0 <= num < 1
		// (int)(random()*N) : 0보다 크거나 같고 N보다 작은 정수를 반환한다.
		// (int)(random()*N) +1 : 1보다 크거나 같고 N보다 작거나 같은 정수를 반환한다.
		System.out.println("난수 -> "+(int)(random()*10+1));
		System.out.println("난수 -> "+(int)(random()*100+1));
		System.out.println("난수 -> "+(int)(random()*1000+1));
		System.out.println("난수 -> "+random());
		System.out.println("난수 -> "+random());
		
	}
}
