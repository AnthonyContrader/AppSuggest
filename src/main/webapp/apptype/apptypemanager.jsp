<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ApptypeDTO"%>
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
  <a class="active" href="ApptypeServlet?mode=applist">Apptypes</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ApptypeDTO> list = (List<ApptypeDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Tag</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ApptypeDTO u : list) {
		%>
		<tr>
			<td><a href=ApptypeServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getTag()%>
			</a></td>
			<td><a href=ApptypeServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=ApptypeServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ApptypeServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="apptype">Tag</label>
    </div>
    <div class="col-75">
      <input type="text" id="apptype" name="tag" placeholder="inserisci tag">
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>