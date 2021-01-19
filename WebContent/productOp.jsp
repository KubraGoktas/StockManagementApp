<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form  action="<%=request.getContextPath()%>/mainServlet" method="get">
<input type="hidden" name="action" value="ADDPRO">

<label for="ad" >
<span class="content-name">Id</span>
</label>
<input type="text" name="id"  value="${productid}" readonly>

<label for="ad" >
<span class="content-name">Ürün Ad</span>
</label>
<input type="text" name="name" required>


    <label for="ad" >
<span class="content-name">Kategori İd</span>
</label>
<select id="idcategory" name="idcategory">
<c:forEach items="${categoryList}" var="tempcat" >
              <option value="${tempcat.id}">${tempcat.id} ${tempcat.name}</option>       
</c:forEach>
  </select>
  
    <label for="ad" >
<span class="content-name">Firma İd</span>
</label>
<select id="idcompany" name="idcompany">
<c:forEach items="${companyList}" var="tempcom" >
              <option value="${tempcom.id}">${tempcom.id} ${tempcom.name}</option>       
</c:forEach>
  </select>
  

<input type="submit" id="submit" value="KAYDET">

</form>



<table>
<tr>
<th>Id</th>
<th>Ad</th>
<th>Sil</th>
<c:forEach var = "temppro" items = "${productList}">
<c:url var="deletelink" value="mainServlet">
		<c:param name="action" value="DELPRO"/>
		<c:param name="id" value="${temppro.id}"/>
	</c:url>
            <tr>
               <td><c:out value = "${temppro.id}"/></td>
               <td><c:out value = "${temppro.name}"/></td>
               
               <td> <a href="${deletelink}">delete</a> </td>
            </tr>
 </c:forEach>
 </tr>
</table>

</body>
</html>