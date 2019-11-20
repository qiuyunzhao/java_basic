package W����¼ģʽ;

/**
 * Դ������
 */
public class Originator {

	private String ename;
	private int age;
	private double salary;


	//���б����洢�����������ر���¼����
	public Memento  saveToMemento(){
	return new Memento(this);
	}

	// �������ݻָ����ָ����ƶ�����¼�����ֵ
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