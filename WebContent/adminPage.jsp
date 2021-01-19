<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@ include file="rolePage.css" %></style>
<title>ADMİN PAGE</title>
</head>
<body>
<input type="hidden" name="command" value="LIST">

<div class="navbar">
<nav>
<img class="logo" alt="logo" src="img/logo.png">
<a href="adminPage.jsp" title="">Anasayfa</a>
</nav>
</div>

<div class="leftmenu">
<div class="personelcard">
<span>${name} ${surname} </span>
</div>
<nav>
<ul class="left-nav">
	<li class="left-nav-item">
		<a href="<%=request.getContextPath()%>/mainServlet?action=LISTUSER" title="kullanıcı liste">
			<img alt="stok" src="img/stok.png">
			<span>Kullanıcı İşlemleri</span>
		</a>
	</li>
	<li class="left-nav-item">
		<a href="<%=request.getContextPath()%>/mainServlet?action=LISTCAT" title="kategori liste">
			<img alt="firma" src="img/firma.png">
			<span>Kategori İşlemleri</span>
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