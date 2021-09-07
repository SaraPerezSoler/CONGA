<%@page import="recommenderQuestionnaire.Tool"%>
<%@page import="congabase.main.CongaData"%>
<%@page import="congabase.ServiceType"%>
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
<script>
	a = 0;
	function addHeader() {
		a++;

		var div = document.createElement('div');
		div.setAttribute('class', 'row');
		div.innerHTML = '<div class="col-6"><input type="text" class="form-control" id="key_'+a+'" name="key_'+a+'"type="text" placeholder="Enter key"/></div><div class="col-6"><input type="text" class="form-control" id="value_'+a+'" name="value_'+a+'" placeholder="Enter value"/></div>';
		document.getElementById('headers').appendChild(div);
		document.getElementById('headers').appendChild(div);
	}
</script>
</head>
<body>
	<%
	String username = (String) session.getAttribute("user");
	if (username == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	CongaData conga = CongaData.getCongaData(getServletContext());
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
				<form method="post" action="addService">
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label>Tool</label> <select name="tool"
									class="form-control form-control-sm">
									<%
									for (Tool tool : conga.getAllTools()) {
									%>
									<option><%=tool.getName()%></option>
									<%
									}
									%>
								</select>
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label>Version</label> <input type="text" class="form-control"
									id="version" name="version" aria-describedby="toolservice">
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label>Type</label> <select name="type"
									class="form-control form-control-sm">
									<%
									for (ServiceType type : ServiceType.values()) {
									%>
									<option><%=type.getLiteral().toLowerCase()%></option>
									<%
									}
									%>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<div class="form-group">
								<label>URL</label> <input type="text" class="form-control"
									id="url" name="url" aria-describedby="serviceUrl"
									onblur="validateUrl()">
								<div id="error_url"></div>
							</div>

						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<div class="form-group">
								<label>BASIC AUTH</label>

								<div class="row">
									<div class="col-6">
										<input type="text" class="form-control" id="auth_key" name="auth_key"
											aria-describedby="serviceUrl" placeholder="Enter username">
									</div>
									<div class="col-6">
										<input type="text" class="form-control" id="auth_value" name="auth_value"
											aria-describedby="serviceUrl" placeholder="Enter password">
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-12">
							<div class="form-group" id="headers">
								<label>Headers &nbsp;&nbsp;&nbsp;&nbsp;</label> <input
									type="button" class="btn btn btn-outline-secondary"
									id="add_cancion()" onClick="addHeader()" value="+  Add header">
								<div class="row">
									<div class="col-6">
										<input type="text" class="form-control" id="key_0"
											name="key_0" placeholder="Enter key">
									</div>
									<div class="col-6">
										<input type="text" class="form-control" id="value_0"
											name="value_0" placeholder="Enter value">
									</div>
								</div>
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