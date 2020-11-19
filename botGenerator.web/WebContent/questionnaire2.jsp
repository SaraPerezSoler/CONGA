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
		<%String projectName = request.getParameter("projectName"); %>
		<form class="login-form" method="post" action="endQuestionnaire?projectName=<%=projectName%>">
			<div class="row justify-content-md-center">
				<div class="col-lg-9">
					<%
					String user = (String)session.getAttribute("user");
					CongaData conga= CongaData
							.getCongaData(pageContext.getServletContext());
					List<AQuestion> questions = conga.getNOTEvaluations(user, projectName);
						for (AQuestion question : questions) {
							boolean isMulti = question.getQuestion().isMultiresponse();
							String name = question.getQuestion().getName();
					%>
					<div class="row">
						<div class="col box">
							<div class="row ">
								<div class="col-md-9 question-size">
									<%=question.getQuestion().getText()%>
									<%
										if (isMulti) {
									%>(Multi-response)<%
										}
									%>
								</div>
								<div class="col-md">
									<select name="<%=name%>-Relevant"
										class="form-control form-control-sm">
										<%
													for (String level : RelevanceLevel.getLevelsString(isMulti)) {
												%>
												<%if (question.getRelevance().getLiteral().equals(level)) {%>
												<option value ="<%=level%>" selected><%=level%></option>
												<%}else{%>
												<option value ="<%=level%>"><%=level%></option>
												<%} %>
												<%
													}
												%>
									</select>
								</div>
							</div>
							<div class="row justify-content-md-center">
								<div class="col-md-10">
									<div class="form-check">
										<%
											int i = 0;
											int n_cols = 3;
												for (Option option : question.getQuestion().getOptions()) {
													String checked = "";
													if (question.getSelecteds().contains(option)){
														checked = "checked";
													}
										%>
										<%
											if (i % n_cols == 0) {
										%>
										<div class="row">
											<%
												}
											%>
											<div class="col">
												<%
													if (isMulti) {
												%>
												<input class="form-check-input" name="<%=name%>-Answer"
													id="<%=option%>" type="checkbox" value="<%=option.getText()%>" <%=checked%>>
												<%
													} else {
												%>
												<input class="form-check-input" type="radio"
													name="<%=name%>-Answer" id="<%=name%>-Answer"
													value="<%=option.getText()%>" <%=checked%>>
												<%
													}
												%>
												<label class="form-check-label question-size" for="<%=option.getText()%>"> <%=option.getText()%></label>

											</div>
											<%
												if (i % n_cols == n_cols-1 || question.getQuestion().getOptions().size()-1==i) {
											%>
										</div>
										<%
											}
													i += 1;
										%>
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
						class="row-lg btn btn-secondary btn-lg btn-block">Send
						Questionnaire</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>