<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Roboto:100,400,700&amp;subset=cyrillic-ext" rel="stylesheet">
</head>
<body>
<form  action="<%=request.getContextPath()%>/mainServlet" method="get">
<input type="hidden" name="action" value="ADDUSER">
<label for="ad" >
<span class="content-name">Ad</span>
</label>
<input type="text" name="name">
<label for="ad" >
<span class="content-name">Soyad</span>
</label>
<input type="text" name="surname">
<label for="ad" >
<span class="content-name">Kullanıcı Adı</span>
</label>
<input type="text" name="uname">
<label for="ad" >
<span class="content-name">Şifre</span>
</label>
<input type="text" name="pass">
<label for="ad" >
<span class="content-name">Yetki</span>
</label>
<select id="role" name="role">
    <option value="yönetici">yönetici</option>
    <option value="personel">personel</option>
  </select>
<label for="ad" >
<span class="content-name">Mail</span>
</label>
<input type="text" name="mail">
<input type="submit" id="submit" value="KAYDET">
</form>

<table>
<tr>
<th>Ad</th>
<th>Soyad</th>
<th>Yetki</th>
<th>Mail Adres</th>
<th>Güncelle</th>
<th>Sil</th>

<c:forEach var = "tempuser" items = "${userList}">
	<c:url var="templink" value="mainServlet">
		<c:param name="action" value="LOAD"/>
		<c:param name="username" value="${tempuser.username}"/>
	</c:url>
	
	<c:url var="deletelink" value="mainServlet">
		<c:param name="action" value="DELUSER"/>
		<c:param name="username" value="${tempuser.username}"/>
	</c:url>
            <tr>
               <td><c:out value = "${tempuser.name}"/></td>
               <td><c:out value = "${tempuser.surname}"/></td>
               <td><c:out value = "${tempuser.role}"/></td>
               <td><c:out value = "${tempuser.mail}"/></td>
               <td> <a href="${templink}">update</a> </td>
               <td> <a href="${deletelink}">delete</a> </td>
            </tr> 
 </c:forEach>
</tr>
</table>


</body>
</html>