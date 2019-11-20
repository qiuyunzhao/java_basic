package S策略模式;

/**
 * 策略类接口   有新的侧率只需要添加具体实现类就可以，别的不用动
 */
public interface Strategy {
	
	public double getPrice(double standardPrice);
	
}

/**
 * 实现接口的实体类：新顾客小批量
 */
class NewCustomerFewStrategy implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("不打折，原价");
		return standardPrice;
	}
}

/**
 * 实现接口的实体类：新顾客大批量
 */
class NewCustomerManyStrategy implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("打九折");
		return standardPrice * 0.9;
	}
}

/**
 * 实现接口的实体类：老顾客小批量
 */
class OldCustomerFewStrategy implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("打八五折");
		return standardPrice * 0.85;
	}
}

/**
 * 实现接口的实体类：老顾客大批量
 */
class OldCustomerManyStrategy implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("打八折");
		return standardPrice * 0.8;
	}
}