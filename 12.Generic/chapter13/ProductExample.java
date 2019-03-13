package chapter13;

public class ProductExample {
	public static void main(String[] args) {
		Product<Tv, String> product1 = new Product<Tv, String>();
		product1.setKind(new Tv());
		product1.setModel("½º¸¶Æ® TV");
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		Product<Car, String> product2 = new Product<Car, String>();
		product1.setKind(new Car());
		product1.setModel("µðÁ©");
		Car car = product2.getKind();
		String carModel = product2.getModel();
	}
}
