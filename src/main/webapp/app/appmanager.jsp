<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.AppDTO"%>
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
	<%
		List<AppDTO> list = (List<AppDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Appname</th>
			<th>Apptype</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (AppDTO u : list) {
		%>
		<tr>
			<td><a href=AppServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getAppname()%>
			</a></td>
			<td><%=u.getApptype()%></td>
			<td><a href=AppServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=AppServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="AppServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="app">Appname</label>
    </div>
    <div class="col-75">
      <input type="text" id="app" name="appname" placeholder="inserisci appname">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Apptype</label>
    </div>
	  <div class="col-75">
		  <select id="type" name="apptype">
			  <% for ( AppDTO u : list )
			  {
			  %>
			  <option><%=u.getApptype()%></option>
			  <%
				  }
			  %>
		  </select>
	  </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>