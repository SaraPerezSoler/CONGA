<%@page import="recommenderQuestionnaire.Evaluation"%>
<%@page import="recommenderQuestionnaire.Option"%>
<%@page import="congabase.AQuestion"%>
<%@page import="congabase.UserAnswer"%>
<%@page import="congabase.main.CongaData"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bot tool recommendation</title>
<link href='https://fonts.googleapis.com/css?family=Atma'
	rel='stylesheet'>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		String projectName = request.getParameter("projectName");
	String user = (String) session.getAttribute("user");
	CongaData conga = CongaData.getCongaData(getServletContext());

	Map<String, Double> ranking = conga.getRanking(user, projectName);
	DecimalFormat df2 = new DecimalFormat("#.##");
	boolean first = true;
	String active = "active";
	%>
	<div class="container">
		<jsp:include page="header.jsp" />
		<div class="row justify-content-md-center box">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link page-size" href="User.jsp">User Menu</a></li>
					<li class="page-item"><a class="page-link page-size" href="openProject?projectName=<%=projectName%>">Open bot</a></li>
					<li class="page-item"><a class="page-link page-size" href="Ranking.jsp?projectName=<%=projectName%>">Ranking</a></li>
					<li class="page-item"><a class="page-link page-size" href="ReportTables.jsp?projectName=<%=projectName%>">Report tables</a></li>
					<li class="page-item active" aria-current="page"><span
						class="page-link page-size">Report details<span class="sr-only">(current)</span>
					</span></li>
				</ul>
			</nav>
		</div>
	
		<div class="row justify-content-md-center box">
			<div class="col-md-4">

				<div class="nav flex-column nav-pills" id="tools" role="tablist"
					aria-orientation="vertical">
					<h1>Ranking</h1>
					<%
						for (String tool : ranking.keySet()) {
							String toolId = tool.replace(" ", "_").replace(".", "");
					%>
					<div class="row">

						<div class="col">
							<a class="nav-link" id="<%=toolId%>" data-toggle="pill"
								href="#<%=toolId%>-pane" role="tab"
								aria-controls="<%=toolId%>-pane" aria-selected="<%=first%>"><%=tool%></a>
						</div>
						<div class="col"><%=df2.format(ranking.get(tool) * 100)%>%
						</div>
					</div>
					<%
							first = false;
						}
					%>
				</div>
			</div>
			<div class="col-md-8">

				<div class="tab-content" id="toolsReport">
					<%
						active = "active";
						for (String tool : ranking.keySet()) {
							String toolId = tool.replace(" ", "_").replace(".", "");
					%>
					<div class="tab-pane fade show <%=active%>" id="<%=toolId%>-pane"
						role="tabpanel" aria-labelledby="<%=toolId%>">

						<h1 class="text-center"><%=tool%></h1>
						<%
							Map<String, List<AQuestion>> questions_evaluations = conga.getAllQuestions(user, projectName);
								for (String type : questions_evaluations.keySet()) {

									List<AQuestion> questions = questions_evaluations.get(type);
						%>
						<h2><%=type%></h2>
						<%
							for (AQuestion question : questions) {
										boolean isMulti = question.getQuestion().isMultiresponse();
										String name = question.getQuestion().getName();
						%>
						<div class="row">
							<div class="col box">
								<div class="row ">
									<div class="col-md-9">
										<%=question.getQuestion().getText()%>
										<%
											if (isMulti) {
										%>(Multi-response)<%
											}
										%>
									</div>
									<div class="col-md-2">
										<%=question.getRelevance()%>
									</div>
									<div class="col-md-1">
										<%
											double score = question.getScore(tool);
														if (score == -1) {
										%>
										-
										<%
											} else {
										%>
										<%=df2.format(score * 100)%>%
										<%
											}
										%>
									</div>
								</div>
								<div class="row justify-content-md-center">
									<div class="col-md-10">

										<ul class="list-group">
											<%
														for (Option option : question.getSelecteds()) {
																if (option.isAccepted(tool)) {
											%>
											<li class="list-group-item list-group-item-success"><%=option.getText()%>
												(Accepted)</li>
											<%
												} else if (option.isRefused(tool)) {
											%>
											<li class="list-group-item list-group-item-danger"><%=option.getText()%>
												(Refused)</li>
											<%
												} else {
											%>
											<li class="list-group-item list-group-item-warning"><%=option.getText()%>
												(Unknown)</li>
											<%
												}
															}
											%>
										</ul>

									</div>
								</div>
							</div>
						</div>
						<%
							}
								}
						%>
					</div>
					<%
						active = "";

						}
					%>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			e.target // newly activated tab
			e.relatedTarget // previous active tab
		})
	</script>
</body>
</html>