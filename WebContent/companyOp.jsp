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
<input type="hidden" name="action" value="ADDCOMP">

<label for="ad" >
<span class="content-name">Id</span>
</label>
<input type="text" name="id" value="${companyid}" readonly>

<label for="ad" >
<span class="content-name">Ad</span>
</label>
<input type="text" name="name" required>

<label for="ad" >
<span class="content-name">Tel No</span>
</label>
<input type="text" name="tel" required>

<label for="ad" >
<span class="content-name">Tür</span>
</label>
<input type="text" name="type" required>

<input type="submit" id="submit" value="KAYDET">

</form>

<table>
<tr>
<th>Id</th>
<th>Ad</th>
<th>Tür</th>
<th>Tel No</th>
<th>Sil</th>
<c:forEach var = "tempcom" items = "${companyList}">
<c:url var="deletelink" value="mainServlet">
		<c:param name="action" value="DELCOMP"/>
		<c:param name="id" value="${tempcom.id}"/>
	</c:url>
            <tr>
               <td><c:out value = "${tempcom.id}"/></td>
               <td><c:out value = "${tempcom.name}"/></td>
               <td><c:out value = "${tempcom.type}"/></td>
               <td><c:out value = "${tempcom.tel}"/></td>
               
               <td> <a href="${deletelink}">delete</a> </td>
            </tr>
 </c:forEach>
 </tr>
</table>

</body>
</html>