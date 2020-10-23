<%@ page import="it.contrader.dto.AppDTO" import="it.contrader.model.Apptype" import="it.contrader.controller.ApptypeController"%>
<%@ page import="java.util.List" %>
<%@ page import="it.contrader.dto.ApptypeDTO" %>
<%@ page import="it.contrader.model.App" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="User Management">
	<meta name="author" content="Vittorio Valent">
	<link href="/css/vittoriostyle.css" rel="stylesheet">
	<title>User Manager</title>

</head>
<body>
<%@ include file="./css/header.jsp"%>

<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<AppDTO> list = (List<AppDTO>) request.getSession().getAttribute("list");
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
				<td><a href="/app/read?id=<%=u.getId()%>"> <%=u.getAppname()%>
				</a></td>
				<td><%=u.getApptype()%></td>
				<td><a href="/app/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/app/delete?id=<%=u.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/app/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="app">Appname</label>
				</div>
				<div class="col-75">
					<input type="text" id="app" name="appname"
						placeholder="inserisci appname">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Apptype</label>
				</div>
				<div class="col-75">
					<select id="type" name="apptype">
						<%
							List<ApptypeDTO> all = (List<ApptypeDTO>) request.getSession().getAttribute("tag");

							for ( ApptypeDTO c :all )
							{
						%>
						<option value="<%=c.getId()%>"><%=c.getTag()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>