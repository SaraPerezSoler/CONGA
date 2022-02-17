<%@page import="congabase.RecommenderOption"%>
<%@page import="recommenderQuestionnaire.Question"%>
<%@page import="recommenderQuestionnaire.Tool"%>
<%@page import="recommenderQuestionnaire.Option"%>
<%@page import="congabase.RelevanceLevel"%>
<%@page import="congabase.AQuestion"%>
<%@page import="congabase.main.CongaData"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bot tool recommendation</title>
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
	<div class="container">
		<jsp:include page="header.jsp" />
		<%
		String projectName = request.getParameter("projectName");
		String user = (String) session.getAttribute("user");
		String serviceId = request.getParameter("serviceId");
		CongaData conga = CongaData.getCongaData(pageContext.getServletContext());
		List<Question> questions = conga.getRecommenderQuestions();
		RecommenderOption ro = conga.getRecommenderOption(user, serviceId);
		
		%>
		<form class="login-form" method="post" action="saveOptions?serviceId=<%=ro.getServiceId()%>">
			<div class="row justify-content-md-center">
				<div class="col-lg-9">
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
					<div class="row">
						<div class="col-6">
							<div class="form-group">
								<label>Tool</label> <select name="tool"
									class="form-control form-control-sm">
									<%
									for (Tool tool : conga.getAllTools()) {
										String selected ="";
										if (tool.equals(ro.getTool())){
											selected = "selected";
										}
									%>
									<option <%=selected%>><%=tool.getName()%></option>
									<%
									}
									%>
								</select>
							</div>
						</div>
						<div class="col-6">
							<div class="form-group">
								<label>Version</label> <input type="text" class="form-control"
									id="version" name="version" aria-describedby="toolservice" value="<%=ro.getVersion()%>">
							</div>
						</div>
					</div>

					<%
					for (Question question : questions) {
						boolean isMulti = question.isMultiresponse();
						String name = question.getName();
					%>
					<div class="row">
						<div class="col box">
							<div class="row ">
								<div class="col-md-9 question-size">
									<%=question.getText()%>
									<%
									if (isMulti) {
									%>(Multi-response)<%
									}
									%>
								</div>
							</div>
							<div class="row justify-content-md-center">
								<div class="col-md-10">
									<div class="form-check">
										<%
										for (Option option : question.getOptions()) {
											String avSelected ="";
											String unavSelected ="";
											String poSelected ="";
											String unkSelected ="";
											if (ro.isAvailable(option)){
												avSelected = "selected";
											}else if (ro.isUnavailable(option)){
												unavSelected = "selected";
											}else if (ro.isPossible(option)){
												poSelected = "selected";
											}else{
												unkSelected="selected";
											}
										%>
										<div class="row">
											<div class="col-6">
												<%=option.getText()%>
											</div>

											<div class="col-3">
												<select name="<%=question.getName()%>_<%=option.getText()%>"
													class="form-control form-control-sm">
													<option value="Available" <%=avSelected%>>Available</option>
													<option value="Unavailable" <%=unavSelected%>>Unavailable</option>
													<option value="Possible" <%=poSelected%>>Possible</option>
													<option value="Unknown" <%=unkSelected%>>Unknown</option>
												</select>
											</div>
										</div>


										<%
										}
										%>
									</div>
								</div>
							</div>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
			<div class="row justify-content-md-center box">
				<div class="col">
					<button type="submit"
						class="row-lg btn btn-secondary btn-lg btn-block">Save
						Options</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>