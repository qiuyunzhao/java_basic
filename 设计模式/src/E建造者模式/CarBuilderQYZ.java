package E建造者模式;

public class CarBuilderQYZ implements CarBuilder {

	@Override
	public Engine builderEngine() {
		System.out.println("构建QYZ牌发动机！");
		return new Engine("QYZ牌发动机！");	  //可能会结合工厂模式创建对象
	}

	@Override
	public Seat builderSeat() {
		System.out.println("构建QYZ牌座椅！");
		return new Seat("QYZ牌座椅！");
	}

	@Override
	public Tyre builderTyre() {
		System.out.println("构建QYZ牌轮胎！");
		return new Tyre("QYZ牌轮胎！");
	}

}