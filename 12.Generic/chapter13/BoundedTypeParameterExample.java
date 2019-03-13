package chapter13;

public class BoundedTypeParameterExample {
	public static void main(String[] args) {
		//String str = Util2.compare("a","b"); (x) //String은 Number 타입이 아님
		
		int result1 = Util2.compare(10, 20);
		System.out.println(result1);
		
		int result2 = Util2.compare(4.5, 3);
		System.out.println(result2);
	}
}
