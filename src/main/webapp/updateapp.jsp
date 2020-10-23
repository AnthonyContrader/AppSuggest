<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AppDTO"%>
<%@ page import="it.contrader.dto.ApptypeDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/app/getall">App</a>
  <a href="/app/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%AppDTO u = (AppDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/app/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="app">App</label>
    </div>
    <div class="col-75">
      <input type="text" id="app" name="appname" value=<%=u.getAppname()%>>
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
    	<input type="hidden" name="id" value =<%=u.getId() %>>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>