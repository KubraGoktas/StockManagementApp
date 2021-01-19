<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form  action="<%=request.getContextPath()%>/mainServlet" method="get">
<input type="hidden" name="action" value="UPDATE">
<input type="hidden" name="username" value="${user.username}">
<label for="ad" >
<span class="content-name">Ad</span>
</label>
<input type="text" name="name" value="${user.name}">
<label for="ad" >
<span class="content-name">Soyad</span>
</label>
<input type="text" name="surname" value="${user.surname}">
<label for="ad" >
<span class="content-name">Kullanıcı Adı</span>
</label>
<input type="text" name="uname" value="${user.username}">
<label for="ad" >
<span class="content-name">Şifre</span>
</label>
<input type="text" name="pass" value="${user.password}">
<label for="ad" >
<span class="content-name">Yetki</span>
</label>
<select id="role" name="role">
    <option value="yönetici">yönetici</option>
    <option value="personel">personel</option>
    <option selected="selected">${user.role}</option>
  </select>
<label for="ad" >
<span class="content-name">Mail</span>
</label>
<input type="text" name="mail" value="${user.mail}">
<input type="submit" id="submit" value="KAYDET">
</form>



</body>
</html>