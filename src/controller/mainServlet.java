package controller;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



import bean.Bill;
import bean.Category;
import bean.Company;
import bean.Customer;
import bean.Product;
import bean.Stok;
import bean.User;
import model.DbUtils;


@WebServlet("/mainServlet")
public class mainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DbUtils dbu;
	
    @Resource(name="jdbc/example")
    private DataSource datasource;
    
    public mainServlet() {
        super();
        
    }
    

	
	@Override
	public void init() throws ServletException {
		try {
			dbu=new DbUtils(datasource);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		super.init();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
	      
    	if(action == null) {
			action = "LISTSTOC";
		}
    	try {
    		switch(action) {
    		
			case "LISTSTOC":
				listStock(request,response);
				
				break;
			case "LISTCUST":
				listCustomer(request,response);
				
				break;
			case "LISTBIL":
				listBill(request,response);
				
				break;
			case "LISTPRO":
				listProduct(request,response);
				
				break;
				
			case "LISTCOMP":
				listCompany(request,response);
				
				break;
			case "ADDSTOC":
				addStock(request,response);
				
				break;
				
			case "ADDCUST":
				addCustomer(request,response);
				
				break;
			case "LISTCAT":
				listCategory(request,response);
				
				break;
			case "ADDCAT":
				addCategory(request,response);
				
				break;
			case "LISTUSER":
				listUser(request,response);
				
				break;
				
				
			case "ADDUSER":
				addUser(request,response);
				
				break;
					
			case "LOAD":
				loadUser(request,response);
				
				
				break;
			case "UPDATE":
				updateUser(request,response);
				
				
				break;
			case "DELUSER":
				deleteUser(request,response);
			
				
				break;
			case "DELCAT":
				deleteCategory(request,response);
				
				
				break;
				
			case "ADDBILL":
				addBill(request,response);
				
				
				break;
			case "ADDPRO":
				addProduct(request,response);
				
				
				break;
			case "LOADCAT":
				loadCategory(request,response);
				
				
				break;
	
			case "UPDATECAT":
				updateCategory(request,response);
				
				
				break;
			case "ADDCOMP":
				addCompany(request,response);
				
				
				break;
			case "DELSTOK":
				deleteStok(request,response);
				
				
				break;
			case "DELCUST":
				deleteCustomer(request,response);
				
				
				break;
			case "DELCOMP":
				deleteCompany(request,response);

				break;
				
			case "DELBILL":
				deleteBill(request,response);

				break;
			case "DELPRO":
				deleteProduct(request,response);

				break;
			default:
				
				break;
				
		}	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		

	}
	

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String name=request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		Category category=new Category(name,id);
		DbUtils.updatecategory(category);
		listCategory(request,response);
		
	}



	private void loadCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("id"));
		Category category=DbUtils.getcategory(id);
		request.setAttribute("category", category);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/update-category.jsp");
		dispatcher.forward(request,response);
		
	}



	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id= Integer.parseInt(request.getParameter("id"));
		DbUtils.deleteProduct(id);
		listProduct(request,response);
		
	}



	private void deleteBill(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id= Integer.parseInt(request.getParameter("id"));
		DbUtils.deleteBill(id);
		listBill(request,response);
		
	}



	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id= Integer.parseInt(request.getParameter("id"));
		DbUtils.deleteCustomer(id);
		listCustomer(request,response);
		
	}



	private void deleteStok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id= Integer.parseInt(request.getParameter("id"));
		DbUtils.deleteStock(id);
		listStock(request,response);
		
	}



	private void deleteCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id= Integer.parseInt(request.getParameter("id"));
		DbUtils.deleteCompany(id);
		listCompany(request,response);
		
	}

	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id= Integer.parseInt(request.getParameter("id"));
		DbUtils.deleteCategory(id);
		listCategory(request,response);
		
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String username=request.getParameter("username");
		String password=request.getParameter("pass");
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
		String role=request.getParameter("role");
		String mail=request.getParameter("mail");
		User user=new User(username, password, name, surname, role, mail);
		DbUtils.updateuser(user);
		listUser(request,response);
		
	}
	
	private void loadUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username=request.getParameter("username");
		User user=DbUtils.getUser(username);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/update-user.jsp");
		dispatcher.forward(request,response);
		
	}
	
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String username= request.getParameter("username");
			DbUtils.deleteUser(username);
			listUser(request,response);
		}
	
	
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
		String role=request.getParameter("role");
		String mail=request.getParameter("mail");
		User user=new User(username, password, name, surname, role, mail);
		DbUtils.adduser(user);
		listUser(request,response);
		
	}



private void addCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
	String name=request.getParameter("name");
	int id=Integer.parseInt(request.getParameter("id"));
	Category category=new Category(name,id);
	DbUtils.addcategory(category);
	listCategory(request,response);
		
	}




	private void addCompany(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		String type=request.getParameter("type");
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		Company company=new Company( id, name, type, tel);
		DbUtils.addcompany(company);
		listCompany(request,response);
		
	}



	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("id"));
		int idcategory=Integer.parseInt (request.getParameter("idcategory"));
		int idcompany=Integer.parseInt (request.getParameter("idcompany"));
		String name=request.getParameter("name");
		Product product=new Product(id,name, idcategory, idcompany);
		DbUtils.addproduct(product);
		listProduct(request,response);
		
	}



	private void addBill(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("id"));
		int idproduct=Integer.parseInt (request.getParameter("idproduct"));
		int idcompany=Integer.parseInt (request.getParameter("idcompany"));
		int idcustomer=Integer.parseInt(request.getParameter("idcustomer"));
		int miktar=Integer.parseInt (request.getParameter("amount"));
		String datemm=request.getParameter("datemm");
		String datedd=request.getParameter("datedd");
		String type=request.getParameter("type");
		String date= datedd+"-"+datemm+"-"+2021;
		System.out.print(date);
		Bill bill=new Bill(id,type,date,idcompany, idcustomer,idproduct);
		DbUtils.addbill(bill);
		listBill(request,response);
		
	}


	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("id"));
		String tel=request.getParameter("tel");
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
		String mail=request.getParameter("mail");
		Customer customer=new Customer( id,name, surname, tel, mail);
		DbUtils.addcustomer(customer);
		listCustomer(request,response);
		
	}



	private void addStock(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int amount=Integer.parseInt(request.getParameter("amount"));
		int purchPrice=Integer.parseInt(request.getParameter("purchPrice"));
		int salePrice=Integer.parseInt(request.getParameter("salePrice"));
		int id=Integer.parseInt(request.getParameter("id"));
		int proid=Integer.parseInt(request.getParameter("proid"));
		Stok stok=new Stok(id, amount, purchPrice, salePrice, proid);
		DbUtils.addStock(stok);
		listStock(request,response);
		
	}
	
	
	private void listCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Category> categories=DbUtils.listcategory();
		request.setAttribute("categoryList", categories);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/categoryOp.jsp");
		dispatcher.forward(request,response);
		
	}



	private void listCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int maxid=DbUtils.idcompany();
		maxid++;
		request.setAttribute("companyid", maxid);
		List<Company> companys=DbUtils.listcompany();
		request.setAttribute("companyList", companys);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/companyOp.jsp");
		dispatcher.forward(request,response);
		
	}



	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int maxid=DbUtils.idproduct();
		maxid++;
		request.setAttribute("productid", maxid);
		List<Company> companys=DbUtils.listcompany();
		request.setAttribute("companyList", companys);
		List<Category> categories=DbUtils.listcategory();
		request.setAttribute("categoryList", categories);
		List<Product> products=DbUtils.listproduct();
		request.setAttribute("productList", products);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/productOp.jsp");
		dispatcher.forward(request,response);
		
	}



	private void listBill(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int maxid=DbUtils.idbill();
		maxid++;
		request.setAttribute("billid", maxid);
		List<Company> companys=DbUtils.listcompany();
		request.setAttribute("companyList", companys);
		List<Product> products=DbUtils.listproduct();
		request.setAttribute("productList", products);
		List<Customer> customers=DbUtils.listcustomer();
		request.setAttribute("custList", customers);
		List<Bill> bills=DbUtils.listbill();
		request.setAttribute("billList", bills);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/billOp.jsp");
		dispatcher.forward(request,response);
		
	}



	private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int maxid=DbUtils.idcustomer();
		maxid++;
		request.setAttribute("customerid", maxid);
		List<Customer> customers=DbUtils.listcustomer();
		request.setAttribute("custList", customers);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/customerOp.jsp");
		dispatcher.forward(request,response);
		
	}



	private void listStock(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int maxid=DbUtils.idstock();
		maxid++;
		request.setAttribute("stokid", maxid);
		List<Product> products=DbUtils.listproduct();
		request.setAttribute("productList", products);
		List<Stok> stoks=DbUtils.liststok();
		request.setAttribute("stokList", stoks);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/stokOp.jsp");
		dispatcher.forward(request,response);
		
	}



	private void listUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<User> users=DbUtils.listuser();
		request.setAttribute("userList", users);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/userOp.jsp");
		dispatcher.forward(request,response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
