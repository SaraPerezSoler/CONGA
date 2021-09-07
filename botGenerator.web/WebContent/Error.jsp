<%@page import="generator.Language"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>CONGA</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="bootstrap\css\bootstrap.min.css" />
<link href='https://fonts.googleapis.com/css?family=Atma'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="css/index.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="bootstrap\js\bootstrap.min.js"></script>
<script src="js/login.js"></script>
</head>
<body>
	<%
	String username = (String) session.getAttribute("user");
	if (username == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	%>
	<div class="container">
		<jsp:include page="header.jsp" />
		<div class="row formcenter">
			<div class="col-12">
				<div class="row">
					<div class="col">
						<%
						if (getServletContext().getAttribute("msg") != null) {
						%>
						<div class="alert alert-danger"><%=getServletContext().getAttribute("msg")%></div>
						<%
						getServletContext().setAttribute("msg", null);
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>