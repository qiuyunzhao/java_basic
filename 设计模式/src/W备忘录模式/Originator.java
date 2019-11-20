package W备忘录模式;

/**
 * 源发器类
 */
public class Originator {

	private String ename;
	private int age;
	private double salary;


	//进行备忘存储操作，并返回备忘录对象
	public Memento  saveToMemento(){
	return new Memento(this);
	}

	// 进行数据恢复，恢复成制定备忘录对象的值
	public void recoverFromMemento(Memento mmt) {
		this.ename = mmt.getEname();
		this.age = mmt.getAge();
		this.salary = mmt.getSalary();
	}

	public Originator(String ename, int age, double salary) {
		super();
		this.ename = ename;
		this.age = age;
		this.salary = salary;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}