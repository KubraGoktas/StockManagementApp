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
<input type="hidden" name="action" value="UPDATECAT">
<input type="hidden" name="id" value="${category.id}">

<label for="ad" >
<span class="content-name">İd</span>
</label>
<input type="text" name="id" value="${category.id}">

<label for="ad" >
<span class="content-name">Ad</span>
</label>
<input type="text" name="name" value="${category.name}">


<input type="submit" id="submit" value="KAYDET">
</form>



</body>
</html>