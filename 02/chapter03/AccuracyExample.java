package chapter03;

public class AccuracyExample {
	public static void main(String[] args) {
		//��Ȯ�� ���� ������ �ʴ´� - float, double�� �ٻ�ġ�� ���� ó�� �ϱ� ����
		/*int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		
		double result = apple - pieceUnit * number;*/
		int apple = 1;
		int totalPieces = apple * 10;
		int number = 7;
		int temp = totalPieces - number;
		
		double result = temp/10.0;

		System.out.println("��� �� ������");
		System.out.println("0.7 ������ ����, ");
		System.out.println(result + " ������ ���´�");
	}
}
