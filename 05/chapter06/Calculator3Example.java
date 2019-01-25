package chapter06;

public class Calculator3Example {
	public static void main(String[] args) {
		Calculator3 myCalc = new Calculator3();
		
		//정사각형의 넓이
		double result1 = myCalc.areaRectangle(10);
		
		//직사각형의 넓이
		double result2 = myCalc.areaRectangle(10, 20);
		
		System.out.println("정사각형의 넓이 : " + result1);
		System.out.println("직사각형의 넓이 : " + result2);ㄴ
	}
}
