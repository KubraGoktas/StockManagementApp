<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>personel page</title>
<style><%@ include file="rolePage.css" %></style>
<link href="https://fonts.googleapis.com/css?family=Roboto:100,400,700&amp;subset=cyrillic-ext" rel="stylesheet">
</head>
<body>
<div class="navbar">
<nav>
<img class="logo" alt="logo" src="img/logo.png">
<a href="personelPage.jsp" title="">Anasayfa</a>
</nav>
</div>

<div class="leftmenu">
<div class="personelcard">
<span>${name} ${surname} </span>
</div>
<nav>
<ul class="left-nav">
	<li class="left-nav-item">
		<a href="${pageContext.request.contextPath}/mainServlet?action=LISTSTOC" title="stoklist">
			<img alt="stok" src="img/stok.png">
			<span>Stok İşlemleri</span>
		</a>
	</li>
	<li class="left-nav-item">
		<a href="${pageContext.request.contextPath}/mainServlet?action=LISTCUST" title="customerlist">
			<img alt="musteri" src="img/musteri.png">
			<span>Müşteri İşlemleri</span>
		</a>
	</li>
	<li class="left-nav-item">
		<a href="${pageContext.request.contextPath}/mainServlet?action=LISTCOMP" title="listcompany">
			<img alt="firma" src="img/firma.png">
			<span>Firma İşlemleri</span>
		</a>
	</li>
	<li class="left-nav-item">
		<a href="${pageContext.request.contextPath}/mainServlet?action=LISTBIL" title="listbill">
			<img alt="fatura" src="img/fatura.png">
			<span>Fatura İşlemleri</span>
		</a>
	</li>
	<li class="left-nav-item">
		<a href="${pageContext.request.contextPath}/mainServlet?action=LISTPRO" title="listproduct">
			<img alt="urun" src="img/urunnn.png">
			<span>Ürün İşlemleri</span>
		</a>
	</li>
</ul>
</nav>
<div class="logout">
<a href="loginPage.jsp" title="">
<span>ÇIKIŞ</span>
<img class="exit" alt="exit" src="img/exit.png">
</a>
</div>
</div>

</body>
</html>