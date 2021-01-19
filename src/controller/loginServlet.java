package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import bean.User;
import model.LoginDao;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private LoginDao ldao;
    @Resource(name="jdbc/example")
    private DataSource datasource;
	
       
	 //program aþladýðýnda int metodu server tarafýndan çaðrýlýr
    @Override
	public void init() throws ServletException {
		try {
			ldao=new LoginDao(datasource);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		super.init();
	}
    
    public loginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			authenticateUser(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void authenticateUser(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("kadi");
	    String password = request.getParameter("pass");
	    User loginBean = new User();
		 
	    loginBean.setUsername(userName);
	    loginBean.setPassword(password);
	    try
	    {
	        String userValidate = LoginDao.authenticateUser(loginBean);
	 
	        if(userValidate.equals("Admin_Role"))
	        {
	            System.out.println("Admin's Home");
	            System.out.print(loginBean.getName());
	            String name=loginBean.getName();
	        	String surname=loginBean.getSurname();
	        	

	            HttpSession session = request.getSession(); //Creating a session
	            session.setAttribute("Admin", userName); //setting session attribute
	            session.setAttribute("name", name);
	            
	            session.setAttribute("surname", surname);
	            request.setAttribute("userName", userName);
	 
	            request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
	        }
	        else if(userValidate.equals("Personel_Role"))
	        {
	            System.out.println("Editor's Home");
	        	String name=loginBean.getName();
	        	String surname=loginBean.getSurname();
	 
	            HttpSession session = request.getSession();
	            session.setAttribute("name", name);
	            session.setAttribute("surname", surname);
	            session.setAttribute("Editor", userName);
	            request.setAttribute("userName", userName);
	 
	            request.getRequestDispatcher("/personelPage.jsp").forward(request, response);
	        }
	        else
	        {
	            System.out.println("Error message = "+userValidate);
	            request.setAttribute("errMessage", userValidate);
	 
	            request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
	        }
	    }
	    catch (IOException e1)
	    {
	        e1.printStackTrace();
	    }
	    catch (Exception e2)
	    {
	        e2.printStackTrace();
	    }
		
	}
}
