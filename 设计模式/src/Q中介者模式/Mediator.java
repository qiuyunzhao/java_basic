package Q中介者模式;

public interface Mediator {
	/**
	 * 具体类的对象在中介中进行注册
	 * 
	 * @param dname
	 *            部门名称
	 * @param d
	 *            部门对象
	 */
	void register(String dname, Department d);

	/**
	 * 中介与注册部门进行交互
	 * 
	 * @param dname
	 *            部门名称
	 */
	void command(String dname);

}