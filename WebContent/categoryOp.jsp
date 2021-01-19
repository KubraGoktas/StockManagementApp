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
<input type="hidden" name="action" value="ADDCAT">

<label for="ad" >
<span class="content-name">Id</span>
</label>
<input type="text" name="id" required>

<label for="ad" >
<span class="content-name">Ad</span>
</label>
<input type="text" name="name" required>

<input type="submit" id="submit" value="KAYDET">

</form>
  
<table>
<tr>
<th>id</th>
<th>Ad</th>
<th>Güncelle</th>
<th>Sil</th>
<c:forEach var = "tempcat" items = "${categoryList}">
<c:url var="templink" value="mainServlet">
		<c:param name="action" value="LOADCAT"/>
		<c:param name="id" value="${tempcat.id}"/>
	</c:url>
	<c:url var="deletelink" value="mainServlet">
		<c:param name="action" value="DELCAT"/>
		<c:param name="id" value="${tempcat.id}"/>
	</c:url>
            <tr>
               <td><c:out value = "${tempcat.id}"/></td>
               <td><c:out value = "${tempcat.name}"/></td>
               <td> <a href="${templink}">update</a> </td>
               <td> <a href="${deletelink}">delete</a> </td>
            </tr>
 </c:forEach>
</tr>
</table>
</body>
</html>