package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bean.Bill;
import bean.Company;
import bean.Customer;
import bean.Product;
import bean.Stok;
import bean.User;
import bean.Category;

public class DbUtils {
	private static DataSource datasource;
	private static User user;
	private static Category category;
	private static Customer customer;

	public DbUtils(DataSource datasource) {
		super();
		this.datasource = datasource;
	}
	
	public static List<Stok> liststok() throws Exception{
		List<Stok> stoks=new ArrayList<>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=datasource.getConnection();
			String sql="select * from stok";
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int amount=rs.getInt("miktar");
				int purchPrice=rs.getInt("alisfiyat");
				int salePrice=rs.getInt("satisfiyat");
				int id=rs.getInt("idstok");
				Stok tempstok=new Stok(id, amount, purchPrice, salePrice);
				stoks.add(tempstok);
			}
			return stoks;
		} finally {
			close(con,stmt,rs);
		}
		
	}
	
	public static List<Customer> listcustomer() throws Exception{
		List<Customer> customers=new ArrayList<>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=datasource.getConnection();
			String sql="select * from musteri";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String name=rs.getString("Ad");
				String surname=rs.getString("soyad");
				String tel=rs.getString("telNo");
				int id=rs.getInt("idmusteri");
				String mail=rs.getString("eMail");
				Customer tempcust=new Customer(id,name,surname,tel,mail);
				customers.add(tempcust);
			}
			return customers;
		} finally {
			close(con,stmt,rs);
		}
		
	}
	
	public static List<Bill> listbill() throws Exception{
		List<Bill> bills=new ArrayList<>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		// DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		try {
			con=datasource.getConnection();
			String sql="select * from fatura";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("idfatura");
			    String type=rs.getString("tür");
			    String date=rs.getString("tarih");
			    int idcompany=rs.getInt("idfirma");
			    int idcustomer=rs.getInt("idmusteri");
			    int idproduct=rs.getInt("idurun");
				Bill tempbill=new Bill(id,type, date, idcompany,idcustomer,idproduct);
				bills.add(tempbill);
			}
			return bills;
		} finally {
			close(con,stmt,rs);
		}
		
	}
	
	
	public static List<Product> listproduct() throws Exception {
		List<Product> products=new ArrayList<>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			con=datasource.getConnection();
			String sql="select * from urun";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("idurun");
			    String name=rs.getString("urunAd");
				Product tempproduct=new Product( id,  name);
				products.add(tempproduct);
			}
			
			return products;
		} finally {
			close(con,stmt,rs);
		}
		
	}

	public static List<Company> listcompany() throws Exception {
		List<Company> companys=new ArrayList<>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			con=datasource.getConnection();
			String sql="select * from tedarikci";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("idfirma");
			    String name=rs.getString("firmaAd");
				String type=rs.getString("firmaTür");
				String tel=rs.getString("firmaTel");
				Company tempcompany=new Company(id, name,type,tel) ;
				companys.add(tempcompany);
			}
			return companys;
		} finally {
			close(con,stmt,rs);
		}
	}
	
	
	public static List<Category> listcategory() throws Exception {
		List<Category> categories=new ArrayList<>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			con=datasource.getConnection();
			String sql="select * from kategori";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("idkategori");
			    String name=rs.getString("kategoriAd");
				Category tempcategori=new Category(name,id) ;
				categories.add(tempcategori);
			}
			return categories;
		} finally {
			close(con,stmt,rs);
		}
	}
	
	public static List<User> listuser() throws Exception{
		List<User> users=new ArrayList<>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=datasource.getConnection();
			String sql="select * from kullanici order by ad";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String username=rs.getString("kullaniciAdi");
				String password=rs.getString("sifre");
				String name=rs.getString("ad");
				String surname=rs.getString("soyad");
				String role=rs.getString("yetki");
				String mail=rs.getString("mailadres");
				User tempuser=new User(username,password,name, surname, role, mail);
				users.add(tempuser);
			}
			return users;
		} finally {
			close(con,stmt,rs);
		}
		
	}

	public static void addStock(Stok stok) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=datasource.getConnection();
			String sql="insert into stok"
						+"(idstok,miktar,idurun,alisfiyat,satisfiyat)"
						+"values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, stok.getId());
			pstmt.setInt(2, stok.getAmount());
			pstmt.setInt(3, stok.getIdProduct());
			pstmt.setInt(4, stok.getPurchPrice());
			pstmt.setInt(5, stok.getSalePrice());
			pstmt.execute();
		}finally {
			close(con,pstmt,null);
		}
		
	}

	public static void addcustomer(Customer customer) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=datasource.getConnection();
			String sql="insert into musteri"
						+"(idmusteri,Ad,soyad,telNo,eMail)"
						+"values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, customer.getId());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getSurname());
			pstmt.setString(4, customer.getTel());
			pstmt.setString(5, customer.getMail());
			pstmt.execute();
		}finally {
			close(con,pstmt,null);
		}
		
	}

	

	public static void addcategory(Category category) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=datasource.getConnection();
			String sql="insert into kategori"
						+"(idkategori,kategoriAd)"
						+"values(?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, category.getId());
			pstmt.setString(2, category.getName());
			pstmt.execute();
		}
		catch(Exception e) {
			e.toString();
		}
		finally {
			close(con,pstmt,null);
		}
	}
	
	public static void adduser(User user) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=datasource.getConnection();
			String sql="insert into kullanici"
						+"(kullaniciAdi,sifre,yetki,ad,soyad,mailadres)"
						+"values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRole());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getSurname());
			pstmt.setString(6, user.getMail());
			pstmt.execute();
		}finally {
			close(con,pstmt,null);
		}
		
		
	}
	
	public static User getUser(String username) throws Exception {
		user = null;
		PreparedStatement pstmt=null;
		Connection con=null;
		ResultSet rs=null;
		//String userName ;
		try {
			con=datasource.getConnection();
			String sql="select * from kullanici where kullaniciAdi=?";
			pstmt=con.prepareStatement(sql);		
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString("ad");
				String surname=rs.getString("soyad");
				String role=rs.getString("yetki");
				String mail=rs.getString("mailadres");
				String password=rs.getString("sifre");
				user=new User(username,password,name,surname,role,mail);
				System.out.print(sql);
				
			}else {
				throw new Exception("username bulunamadý"+username);
			}
			return user;
			
		}finally {
			close(con,pstmt,rs);
		}
		
		
	}
	
	public static void updateuser(User user) throws Exception{
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
		con=datasource.getConnection();
		String sql="update kullanici set sifre=?, yetki=?, ad=?, soyad=?, mailadres=? where kullaniciAdi=? ";	
		pstmt=con.prepareStatement(sql);
	
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getRole());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getSurname());
		pstmt.setString(5, user.getMail());
		pstmt.setString(6, user.getUsername());
		pstmt.execute();
	}finally {
		close(con,pstmt,null);
	}
		
	}
	
	
	public static void deleteUser(String username) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = datasource.getConnection();
			String sql = "delete from kullanici where kullaniciAdi=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.execute();
		}
		finally {
			close(con, pstmt, null);
		}
		
	}
	
	
	
	
	
	private static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(stmt != null) {
				stmt.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(con != null) {
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void deleteCategory(int id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = datasource.getConnection();
			String sql = "delete from kategori where idkategori=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		}
		finally {
			close(con, pstmt, null);
		}
		
	}

	public static void addbill(Bill bill) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		System.out.print("merhaaba");
		
		try {
			
			con=datasource.getConnection();
			String sql="insert into fatura"
						+"(idfatura,idfirma,idmusteri,idurun,tür,tarih)"
						+"values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bill.getId());
			pstmt.setInt(2, bill.getIdcompany());
			pstmt.setInt(3, bill.getIdcustomer());
			pstmt.setInt(4, bill.getIdproduct());
			pstmt.setString(5, bill.getType());
			pstmt.setString(6, bill.getDate());
			pstmt.execute();
		}finally {
			close(con,pstmt,null);
		}
		
	}

	public static void addproduct(Product product) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			
			con=datasource.getConnection();
			String sql="insert into urun"
						+"(idurun,idkategori,idfirma,urunAd)"
						+"values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, product.getId());
			pstmt.setInt(2, product.getIdcategory());
			pstmt.setInt(3, product.getIdcompany());
			pstmt.setString(4, product.getName());
			pstmt.execute();
		}finally {
			close(con,pstmt,null);
		}
		
	}

	public static void addcompany(Company company) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			
			con=datasource.getConnection();
			String sql="insert into tedarikci"
						+"(idfirma,firmaAd,firmaTür,firmaTel)"
						+"values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, company.getId());
			pstmt.setString(2, company.getName());
			pstmt.setString(3, company.getType());
			pstmt.setString(4, company.getTel());
			pstmt.execute();
		}finally {
			close(con,pstmt,null);
		}
		
	}
	
	public static int idcompany() throws SQLException {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			
			con=datasource.getConnection();
			stmt=con.createStatement();
			int maxid=0;
			String sql="select MAX(idfirma) from tedarikci";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				maxid=rs.getInt("MAX(idfirma)");
			}
			return maxid;
		}finally {
			close(con,stmt,rs);
		}
	}
	
	public static int idcustomer() throws SQLException {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			
			con=datasource.getConnection();
			stmt=con.createStatement();
			int maxid=0;
			String sql="select MAX(idmusteri) from musteri";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				maxid=rs.getInt("MAX(idmusteri)");
			}
			return maxid;
		}finally {
			close(con,stmt,rs);
		}
	}

	public static void deleteStock(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = datasource.getConnection();
			String sql = "delete from stok where idstok=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		}
		finally {
			close(con, pstmt, null);
		}
		
	}

	public static void deleteCustomer(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = datasource.getConnection();
			String sql = "delete from musteri where idmusteri=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		}catch(Exception e) {
			String errMessage="ürün anahtarý baþka bir tablo tarafýndan kullanýlýyor.";
			System.out.print(errMessage);
		}
		finally {
			close(con, pstmt, null);
		}
		
	}

	public static void deleteCompany(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = datasource.getConnection();
			String sql = "delete from tedarikci where idfirma=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		}
		finally {
			close(con, pstmt, null);
		}
		
		
	}

	public static void deleteBill(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = datasource.getConnection();
			String sql = "delete from fatura where idfatura=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		}
		finally {
			close(con, pstmt, null);
		}
		
	}

	public static void deleteProduct(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = datasource.getConnection();
			String sql = "delete from urun where idurun=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		}
		finally {
			close(con, pstmt, null);
		}
		
	}

	public static Category getcategory(int id) throws Exception {
		category = null;
		PreparedStatement pstmt=null;
		Connection con=null;
		ResultSet rs=null;
		try {
			con=datasource.getConnection();
			String sql="select * from kategori where idkategori=?";
			pstmt=con.prepareStatement(sql);	
			System.out.print(id);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString("kategoriAd");
				id=rs.getInt("idkategori");
				category=new Category(name,id);
				System.out.print(sql);
				
			}else {
				throw new Exception("kategori bulunamadý"+category);
			}
			return category;
			
		}finally {
			close(con,pstmt,rs);
		}
	}

	public static void updatecategory(Category category) throws Exception {
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
		con=datasource.getConnection();
		String sql="update kategori set kategoriAd=? where idkategori=? ";	
		pstmt=con.prepareStatement(sql);
	
		pstmt.setString(1, category.getName());
		pstmt.setInt(2, category.getId());
		pstmt.execute();
	}finally {
		close(con,pstmt,null);
	}
		
	}

	public static int idstock() throws SQLException {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			
			con=datasource.getConnection();
			stmt=con.createStatement();
			int maxid=0;
			String sql="select MAX(idstok) from stok";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				maxid=rs.getInt("MAX(idstok)");
			}
			return maxid;
		}finally {
			close(con,stmt,rs);
		}
	}

	public static int idproduct() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			
			con=datasource.getConnection();
			stmt=con.createStatement();
			int maxid=0;
			String sql="select MAX(idurun) from urun";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				maxid=rs.getInt("MAX(idurun)");
			}
			return maxid;
		}finally {
			close(con,stmt,rs);
		}
	}

	public static int idbill() throws SQLException {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			
			con=datasource.getConnection();
			stmt=con.createStatement();
			int maxid=0;
			String sql="select MAX(idfatura) from fatura";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				maxid=rs.getInt("MAX(idfatura)");
			}
			return maxid;
		}finally {
			close(con,stmt,rs);
		}
	}

	
}
