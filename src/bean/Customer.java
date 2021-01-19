package bean;

public class Customer {
	private int id;
    private String name;
    private String surname;
    private String tel;
    private String mail;
    
    
    
	public Customer(String name, String surname, String tel, String mail) {
		super();
		this.name = name;
		this.surname = surname;
		this.tel = tel;
		this.mail = mail;
	}
	public Customer(int id, String name, String surname, String tel, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.tel = tel;
		this.mail = mail;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
