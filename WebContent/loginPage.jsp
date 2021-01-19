<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<style><%@ include file="loginPage.css" %></style>

</head>
<body>
<div id="loginbar" >
<div id="login">

GİRİŞ<br>
<form action="<%=request.getContextPath()%>/loginServlet" method="post">
<input type="hidden" name="action" value="AUTH">
<label id="error">${errMessage} </label><br>
<input type="text"  name="kadi" placeholder="kullanıcı adı" required><br>
<input type="password"  name="pass" placeholder="şifre" required><br>
<input type="submit" id="submit" value="giriş"><br>
</form>
<label>ticari kayıtlarınızı tutmanın <br>
 akıllı ve kolay yolu...</label>
</div>
</div>

</body>
</html>