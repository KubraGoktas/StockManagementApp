package bean;



public class Company {
	private int id;
    private String name;
    private String type;
    private String tel;
    
    
	public Company(int id, String name, String type, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.tel = tel;
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
	public void setName(String ad) {
		this.name = ad;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
    
    

}
