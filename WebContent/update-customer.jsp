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
<input type="hidden" name="action" value="UPDATECUST">
<input type="hidden" name="id" value="${customer.id}">
<label for="ad" >
<span class="content-name">Ad</span>
</label>
<input type="text" name="name" value="${customer.name}">

<label for="ad" >
<span class="content-name">Soyad</span>
</label>
<input type="text" name="surname" value="${customer.surname}">

<label for="ad" >
<span class="content-name">Tel No</span>
</label>
<input type="text" name="uname" value="${customer.tel}">

<label for="ad" >
<span class="content-name">Mail Adres</span>
</label>
<input type="text" name="pass" value="${customer.mail}">


<input type="submit" id="submit" value="KAYDET">
</form>


</body>
</html>