package bean;



public class Bill {
	private int id;
    private String type;
    private String date;
    private int idcompany;
    private int idcustomer;
    private int idproduct;
    
    
    
    
	public Bill(int id, String type, String date, int idcompany, int idcustomer, int idproduct) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.idcompany = idcompany;
		this.idcustomer = idcustomer;
		this.idproduct = idproduct;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIdcompany() {
		return idcompany;
	}
	public void setIdcompany(int idcompany) {
		this.idcompany = idcompany;
	}
	public int getIdcustomer() {
		return idcustomer;
	}
	public void setIdcustomer(int idcustomer) {
		this.idcustomer = idcustomer;
	}
	public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
    

}
