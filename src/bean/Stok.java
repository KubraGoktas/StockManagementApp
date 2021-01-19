package bean;

public class Stok {
	private int id;
    private int amount;
    private int purchPrice;
    private int salePrice;
    private int idProduct;
    
    
    
	public Stok() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stok(int amount) {
		super();
		this.amount = amount;
	}
	public Stok(int id, int amount, int purchPrice, int salePrice, int idProduct) {
		super();
		this.id = id;
		this.amount = amount;
		this.purchPrice = purchPrice;
		this.salePrice = salePrice;
		this.idProduct = idProduct;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	@Override
	public String toString() {
		return "Stok [id=" + id + ", amount=" + amount + ", purchPrice=" + purchPrice
				+ ", salePrice=" + salePrice + "]";
	}
	public Stok(int id, int amount, int purchPrice, int salePrice) {
		super();
		this.id = id;
		this.amount = amount;
		
		this.purchPrice = purchPrice;
		this.salePrice = salePrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPurchPrice() {
		return purchPrice;
	}
	public void setPurchPrice(int purchPrice) {
		this.purchPrice = purchPrice;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	
	
    
    

}
