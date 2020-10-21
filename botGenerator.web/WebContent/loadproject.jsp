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
</head>
<body>
	<%
	String username = (String) session.getAttribute("user");
	if (username == null){
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	%>
	<div class="container">
		<jsp:include page="header.jsp" />
		<div class="row formcenter">
			<div class="col-12">
				<form method="post" action="createProject">
					<div class="row">
						<div class="col-6">
							<div class="form-group">
								<label>Project Name</label> <input type="text"
									class="form-control" id="projectName" name="projectName"
									aria-describedby="emailHelp">
							</div>
						</div>
						<div class="col-6">
							<div class="form-group">
								<label>Language</label> <select name="language"
									class="form-control form-control-sm">
									<%
										for (Language lan : Language.VALUES) {
									%>
									<option><%=lan.getLiteral().toLowerCase()%></option>
									<%
										}
									%>
								</select>
							</div>
						</div>
					</div>
					<div class="row ">
						<div class="col justify-content-end">
							<div class="form-group">
								  <button type="submit" class="row-lg btn btn-secondary btn-lg">Create</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>