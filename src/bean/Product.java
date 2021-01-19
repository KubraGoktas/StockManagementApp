package bean;



public class Product {
	private int id;
	private String name;
	private int idcategory;
	private int idcompany;
	
	
	
	
	public Product(int id, String name, int idcategory, int idcompany) {
		super();
		this.id = id;
		this.name = name;
		this.idcategory = idcategory;
		this.idcompany = idcompany;
	}
	public int getIdcategory() {
		return idcategory;
	}
	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
	}
	public int getIdcompany() {
		return idcompany;
	}
	public void setIdcompany(int idcompany) {
		this.idcompany = idcompany;
	}
	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
