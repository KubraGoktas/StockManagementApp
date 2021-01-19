package bean;

public class User {
	private String username;
    private String password;
    private String name;
    private String surname;
    private String role;
    private String mail;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String name, String surname, String role, String mail) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.mail = mail;
	}

	public User(String name, String surname, String role, String mail) {
		super();
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
    

	
}
