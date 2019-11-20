package S策略模式;

public class Client {

	public static void main(String[] args) {

		double price = getPrice("老客户小批量", 100);
		System.out.println("您该报价：" + price);

		System.out.println("------------------------");

		Strategy s1 = new OldCustomerFewStrategy();
		Context ctx = new Context(s1);

		ctx.pringPrice(100);
	}

	/**
	 * 不采用策略模式：
	 * 
	 * 实现起来比较容易，符合一般开发人员的思路 假如，类型特别多，算法比较复杂时，整个条件语句的代码就变得很长，难于维护。
	 * 如果有新增类型，就需要频繁的修改此处的代码！ 不符合开闭原则！
	 */
	public static double getPrice(String type, double price) {
		if (type.equals("普通客户小批量")) {
			System.out.println("不打折,原价");
			return price;
		} else if (type.equals("普通客户大批量")) {
			System.out.println("打九折");
			return price * 0.9;
		} else if (type.equals("老客户小批量")) {
			System.out.println("打八五折");
			return price * 0.85;
		} else if (type.equals("老客户大批量")) {
			System.out.println("打八折");
			return price * 0.8;
		}
		return price;
	}

}
