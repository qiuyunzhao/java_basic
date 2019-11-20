package W备忘录模式;

public class Client {
	public static void main(String[] args) {
		
		CareTaker taker = new CareTaker();

		Originator emp = new Originator("高淇", 18, 1000);
		System.out.println("第1次存储对象：" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
		taker.add(emp.saveToMemento()); // 备忘1次
		
		emp = new Originator("高淇", 19, 2000);
		System.out.println("第2次存储对象：" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
		taker.add(emp.saveToMemento()); // 备忘2次
		
		emp = new Originator("高淇", 20, 3000);
		System.out.println("第3次存储对象：" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
		taker.add(emp.saveToMemento()); // 备忘3次

		emp.recoverFromMemento(taker.get(1)); // 恢复到备忘录第3次的状态
		System.out.println("恢复第2次存储的对象：" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
		
		emp.recoverFromMemento(taker.get(0)); // 恢复到备忘录第3次的状态
		System.out.println("恢复第1次存储的对象：" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
		
	}
}