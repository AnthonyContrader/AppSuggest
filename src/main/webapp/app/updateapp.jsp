<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.AppDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>App Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="AppServlet?mode=applist">Apps</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%AppDTO u = (AppDTO) request.getAttribute("dto");%>


	<form id="floatleft" action="AppServlet?mode=update&id=<%=u.getId()%>" method="post">
		<div class="row">
			<div class="col-25">
				<label for="app">Appname</label>
			</div>
			<div class="col-75">
				<input type="text" id="app" name="appname" value=<%=u.getAppname()%>>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="type">type</label>
			</div>
			<div class="col-75">
				<input type="text" id="type" name="apptype" value=<%=u.getApptype()%>>
			</div>
		</div>
		<button type="submit" >Edit</button>
	</form>


</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>