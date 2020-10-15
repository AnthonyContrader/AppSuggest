<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.ApptypeDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Apptype Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="ApptypeServlet?mode=apptypelist">Apptypes</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%ApptypeDTO u = (ApptypeDTO) request.getAttribute("dto");%>


	<form id="floatleft" action="ApptypeServlet?mode=update&id=<%=u.getId()%>" method="post">
		<div class="row">
			<div class="col-25">
				<label for="apptype">Tag</label>
			</div>
			<div class="col-75">
				<input type="text" id="apptype" name="tag" value=<%=u.getTag()%>>
			</div>
		</div>
		<button type="submit" >Edit</button>
	</form>


</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>