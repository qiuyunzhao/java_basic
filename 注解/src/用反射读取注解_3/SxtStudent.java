package 用反射读取注解_3;

@SxtTable("tb_student")
public class SxtStudent {
	
	@SxtField(columnName = "id", type = "int", length = 10)
	private int id;
	@SxtField(columnName = "sname", type = "varchar", length = 10)
	private String name;
	@SxtField(columnName = "age", type = "int", length = 3)
	private int age;

	public SxtStudent() {
		super();
	}

	public SxtStudent(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
