<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form  action="<%=request.getContextPath()%>/mainServlet" method="get">
<input type="hidden" name="action" value="ADDCUST">

<label for="ad" >
<span class="content-name">Id</span>
</label>
<input type="text" name="id" value="${customerid}" readonly>

<label for="ad" >
<span class="content-name">Ad</span>
</label>
<input type="text" name="name" required>

<label for="ad" >
<span class="content-name">Soyad</span>
</label>
<input type="text" name="surname" required>

<label for="ad" >
<span class="content-name">Tel No</span>
</label>
<input type="text" name="tel">

<label for="ad" >
<span class="content-name">Mail Adres</span>
</label>
<input type="text" name="mail" required>

<input type="submit" id="submit" value="KAYDET">
</form>


<table>
<tr>
<th>Id</th>
<th>Ad</th>
<th>Soyad</th>
<th>Tel No</th>
<th>Mail</th>
<th>Sil</th>
<c:forEach var = "tempcust" items = "${custList}">
<c:url var="deletelink" value="mainServlet">
		<c:param name="action" value="DELCUST"/>
		<c:param name="id" value="${tempcust.id}"/>
	</c:url>

            <tr>
               <td><c:out value = "${tempcust.id}"/></td>
               <td><c:out value = "${tempcust.name}"/></td>
               <td><c:out value = "${tempcust.surname}"/> </td>
               <td><c:out value = "${tempcust.tel}"/> </td>
               <td><c:out value = "${tempcust.mail}"/> </td>
               
               <td> <a href="${deletelink}">delete</a> </td>
            </tr>
 </c:forEach>
</tr>
</table>
</body>
</html>