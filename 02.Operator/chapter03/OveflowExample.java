package chapter03;

public class OveflowExample {
	public static void main(String[] args) {
		int x = 1000000;
		int y = 1000000;
		int z = x * y;
		System.out.println(z); // ��°�� : -727379968 <-�����Ⱚ
		// int ��� long���� �ٲٸ� �ذ� ����
	}
}
