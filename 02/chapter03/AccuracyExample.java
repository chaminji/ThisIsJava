package chapter03;

public class AccuracyExample {
	public static void main(String[] args) {
		//정확한 값이 나오지 않는다 - float, double은 근사치로 값을 처리 하기 때문
		/*int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		
		double result = apple - pieceUnit * number;*/
		int apple = 1;
		int totalPieces = apple * 10;
		int number = 7;
		int temp = totalPieces - number;
		
		double result = temp/10.0;

		System.out.println("사과 한 개에서");
		System.out.println("0.7 조각을 빼면, ");
		System.out.println(result + " 조각이 남는다");
	}
}
