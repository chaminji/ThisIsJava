package chapter06;

public class Car5Example {
	public static void main(String[] args) {
		Car5 myCar = new Car5();
		
		//�߸��� �ӵ� ����
		//myCar.speed(-50);
		
		System.out.println("���� �ӵ� : " + myCar.getSpeed());
		
		//�ùٸ� �ӵ� ����
		myCar.setSpeed(60);
		
		//����
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		
		System.out.println("���� �ӵ� : " + myCar.getSpeed());
	}
}
