package model;

import java.io.IOException;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.sql.DataSource;

import bean.User;

public class LoginDao {
	private static DataSource datasource;

	public LoginDao(DataSource datasource) {
		super();
		this.datasource = datasource;
	}
	
public static String authenticateUser(User userlog) throws IOException {
     	
     	String userName = userlog.getUsername();
        String password = userlog.getPassword();
      
         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
         
      
         String userNameDB = "";
         String passwordDB = "";
         String roleDB = "";
         String NameDB="";
         String SurnameDB="";
         try
         {
             con = datasource.getConnection();
             statement = con.createStatement();
             resultSet = statement.executeQuery("select kullaniciAdi,sifre,yetki,ad,soyad from kullanici");
             
             while(resultSet.next())
             {
                 userNameDB = resultSet.getString("kullaniciAdi");
                 passwordDB = resultSet.getString("sifre");
                 roleDB = resultSet.getString("yetki");
                 NameDB=resultSet.getString("ad");
                 SurnameDB=resultSet.getString("soyad");
                 
      
                 if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("yönetici")) {
                 	userlog.setName(NameDB);
                 	userlog.setSurname(SurnameDB);
                     return "Admin_Role";
                 }else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("personel")) {
                	 userlog.setName(NameDB);
                	 userlog.setSurname(SurnameDB);
                 	return "Personel_Role";
                 }
               
             }
         }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
         
         
     	 return "KULLANICI BULUNAMADI!";
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


}
