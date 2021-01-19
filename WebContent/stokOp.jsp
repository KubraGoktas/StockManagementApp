<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@ include file="rolePage.css" %></style>
</head>
<body>



<form  action="<%=request.getContextPath()%>/mainServlet" method="get">
<input type="hidden" name="action" value="ADDSTOC">

<label for="ad" >
<span class="content-name">Id</span>
</label>
<input type="text" name="id" value="${stokid}" readonly>

<label for="ad" >
<span class="content-name">Miktar</span>
</label>
<input type="text" name="amount" required>

<label for="ad" >
<span class="content-name">Alış Fiyat</span>
</label>
<input type="text" name="purchPrice" required>

<label for="ad" >
<span class="content-name">Satış Fiyat</span>
</label>
<input type="text" name="salePrice" required>

<label for="ad" >
<span class="content-name">Ürün Tür Id</span>
</label>
<select id="role" name="proid">
<c:forEach items="${productList}" var="temppro" >
              <option value="${temppro.id}">${temppro.id} ${temppro.name}</option>       
</c:forEach>
  </select>
  

<input type="submit" id="submit" value="KAYDET">

</form>




<table>
<tr>
<th>Id</th>
<th>Miktar</th>
<th>Alış Fiyat</th>
<th>Satış Fiyat</th>
<th>Sil</th>
<c:forEach var = "tempstok" items = "${stokList}">
<c:url var="deletelink" value="mainServlet">
		<c:param name="action" value="DELSTOK"/>
		<c:param name="id" value="${tempstok.id}"/>
	</c:url>
            <tr>
               <td><c:out value = "${tempstok.id}"/></td>
               <td><c:out value = "${tempstok.amount}"/></td>
               <td><c:out value = "${tempstok.purchPrice}"/> ₺</td>
               <td><c:out value = "${tempstok.salePrice}"/> ₺</td>
               
               <td> <a href="${deletelink}">delete</a> </td>
            </tr>
 </c:forEach>
</tr>
</table>

</body>
</html>