package ORMÓ³Éä;

public class Dept {

	private Integer id;
	private String dname;
	private String address;

	public Dept() {
	}

	public Dept(Integer id, String dname, String address) {
		super();
		this.id = id;
		this.dname = dname;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", dname=" + dname + ", address=" + address + "]";
	}
}
