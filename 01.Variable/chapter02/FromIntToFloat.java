package chapter02;

public class FromIntToFloat {
	public static void main(String[] args) {
		int num1 = 1234567890;
		int num2 = 1234567890;
		
		//float num3 = num2;
		double num3 = num2;
		num2 = (int) num3;
		
		int result = num1 - num2;
		System.out.println(result);
		// 결과 : -46
		// 자동변환 하면서 문제 발생
	}
}
