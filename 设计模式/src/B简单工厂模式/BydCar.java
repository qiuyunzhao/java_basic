package B简单工厂模式;


//实现类Byd
public class BydCar implements Car {

	@Override
	public void run() {
		System.out.println("比亚迪在跑！");
	}
}