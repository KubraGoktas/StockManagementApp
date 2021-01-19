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
<input type="hidden" name="action" value="ADDBILL">

<label for="ad" >
<span class="content-name">Id</span>
</label>
<input type="text" name="id" value="${billid}" readonly>

<label for="ad" >
<span class="content-name">Miktar</span>
</label>
<input type="text" name="amount" required>

<label for="ad" >
<span class="content-name">Gün</span>
</label>
<select id="datedd" name="datedd">
<c:forEach begin="1" end="31" varStatus="loop">
     <option value="${loop.count}">${loop.count}</option>  
</c:forEach>
</select>

<label for="ad" >
<span class="content-name">Ay</span>
</label>
<select id="datemm" name="datemm">
<c:forEach begin="1" end="12" varStatus="loop">
     <option value="${loop.count}">${loop.count}</option>  
</c:forEach>
</select>

<label for="ad" >
<span class="content-name">Yıl</span>
</label>
<input type="text" name="dateyy" value="2021" readonly>



<label for="ad" >
<span class="content-name">Tür</span>
</label>
<select id="type" name="type">
<option value="Alış ">Alış</option>
<option value="Alış ">Satış</option>
  </select>
  
  <label for="ad" >
<span class="content-name">Ürün İd</span>
</label>
  <select id="idproduct" name="idproduct">
<c:forEach items="${productList}" var="temppro" >
              <option value="${temppro.id}">${temppro.id} ${temppro.name}</option>       
</c:forEach>
  </select>
  
    <label for="ad" >
<span class="content-name">Müşteri İd</span>
</label>
<select id="idcustomer" name="idcustomer">
<c:forEach items="${custList}" var="tempcust" >
              <option value="${tempcust.id}">${tempcust.id} ${tempcust.name}</option>       
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
<th>Tür</th>
<th>Tarih</th>
<th>Sil</th>
<c:forEach var = "tempbill" items = "${billList}">
<c:url var="deletelink" value="mainServlet">
		<c:param name="action" value="DELBILL"/>
		<c:param name="id" value="${tempbill.id}"/>
	</c:url>
            <tr>
               <td><c:out value = "${tempbill.id}"/></td>
               <td><c:out value = "${tempbill.type}"/></td>
               <td><c:out value = "${tempbill.date}"/> </td>
               
               <td> <a href="${deletelink}">delete</a> </td>
            </tr>
 </c:forEach>
</tr>
</table>


</body>
</html>