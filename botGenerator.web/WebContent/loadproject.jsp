<%@page import="congabase.Service"%>
<%@page import="congabase.main.CongaData"%>
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
<%
String username = (String) session.getAttribute("user");
if (username == null) {
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
CongaData conga = CongaData.getCongaData(getServletContext());
%>
<script>
function selectedChange(){
		var tool = document.getElementById("toolSelect").value;
		if (tool == 'empty'){
			document.getElementById("versionDiv").innerHTML = '<select id="versionSelect" name="versionSelect" class="form-control" disabled="disabled"> <option selected value="-1">Choose the tool version</option> </select>'
		}
		<%for (String tool : conga.supportedParserTools().keySet()) {%>
		else if (tool == "<%=tool%>"){
			var select = '<select id="versionSelect" name="versionSelect" class="form-control"> '
			select+= '<option selected value="-1">Choose the tool version</option> '
			<%for (Service s: conga.supportedParserTools().get(tool)){%>
			select+= '<option value="<%=s.getServiceId()%>"><%=s.getUser().getNick()%>/<%=s.getVersion()%></option> '
			<%}%>
			select+= '</select> '
			document.getElementById("versionDiv").innerHTML = select;
		}
			
		<%}%>
	}

</script>
</head>
<body>

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
				<form method="post" method="post" action="loadBot"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col-6">
							<div class="form-group">
								<select id="toolSelect"
									class="form-control" onchange="selectedChange()">
									<option selected value="empty">Choose the tool</option>
									<%
									for (String tool : conga.supportedParserTools().keySet()) {
									%>
									<option value="<%=tool%>"><%=tool%></option>
									<%
									}
									%>
								</select>
							</div>
						</div>
						<div class="col-6">
							<div class="form-group" id = "versionDiv">
								<select id="versionSelect" name="versionSelect"
									class="form-control" disabled="disabled">
									<option selected value="-1">Choose the tool version</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<div class="form-group">
								<label>Project Name</label> <input type="text"
									class="form-control" id="projectName" name="projectName"
									aria-describedby="emailHelp" onblur="validateProjectName()">
								<div id="error_projectName"></div>
							</div>
						</div>
						<div class="col-6">
							<div class="form-group">
								<label>Select a file zip to load the chatbot</label>
								<div class="custom-file">
									<input type="file" id="model-file" name="model-file"
										class="custom-file-input" /> <label class="custom-file-label"
										for="ecore-file">Choose file</label>
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