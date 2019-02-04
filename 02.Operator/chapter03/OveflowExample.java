package chapter03;

public class OveflowExample {
	public static void main(String[] args) {
		int x = 1000000;
		int y = 1000000;
		int z = x * y;
		System.out.println(z); // 출력결과 : -727379968 <-쓰레기값
		// int 대신 long으로 바꾸면 해결 가능
	}
}
