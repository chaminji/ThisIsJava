package chapter13;

public class GBoxExample {
	public static void main(String[] args) {
		GBox<String> box1 = new GBox<String>();
		box1.set("hello");
		String str = box1.get();
		
		GBox<Integer> box2 = new GBox<Integer>();
		box2.set(6);
		int value = box2.get();
	}
}
