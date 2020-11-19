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
	
	%>
	<div class="container">
		<jsp:include page="header.jsp" />
		<div class="row justify-content-md-center box">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link page-size" href="User.jsp">User Menu</a></li>
					<li class="page-item"><a class="page-link page-size" href="openProject?projectName=<%=projectName%>">Open bot</a></li>
					<li class="page-item"><a class="page-link page-size" href="Ranking.jsp?projectName=<%=projectName%>">Ranking</a></li>
					<li class="page-item active" aria-current="page"><span
						class="page-link page-size">Report tables<span class="sr-only">(current)</span>
					</span></li>
					<li class="page-item"><a class="page-link page-size" href="ReportDetails.jsp?projectName=<%=projectName%>">Report details</a></li>
				</ul>
			</nav>
		</div>

			<div class="row">
				<div class="tab-content" id="toolsReport">
					<div class="row">
						<div class="col">
						<%
							Map<String, List<AQuestion>> questions_evaluations = conga.getAllQuestions(user, projectName);
								for (String type : questions_evaluations.keySet()) {

									List<AQuestion> questions = questions_evaluations.get(type);
						%>
						<h1><%=type%></h1>
							<div class="table-responsive">
								<table class="table table-hover">
									<thead>
										<tr>
											<th scope="col"></th>
											<%
												int i = 1;
												for (AQuestion ev : questions) {
											%>
											<th scope="col" data-container="body" data-toggle="popover" data-placement="top" data-content="<%=ev.getQuestion().getText()%>"><%=type.substring(0, 1)+i%></th>
											<%
												i++;
												}
											%>
											<th scope="col"></th>
										</tr>
									</thead>
									<tbody>
										<%
											for (String tool : ranking.keySet()) {
										%>
										<tr>
											<th scope="row"><%=tool%></th>
											<%
												for (AQuestion ev : questions) {
												double score = ev.getScore(tool) * 100;
												String level;
												if (score<0){
													level = "alert-secondary";
												}else if (score == 100) {
													level = "alert-success";
												} else if (score >= 50) {
													level = "alert-warning";
												} else {
													level = "alert-danger";
												}
											%>
											<%if (score < 0) {%>
											<td><div class="alert <%=level%>" role="alert">-
												</div></td>
											<%}else{ %>
											<td><div class="alert <%=level%>" role="alert"><%=df2.format(score)%>%
												</div></td>
											<%
											}}
											%>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
							<%} %>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		$(function () {
			  $('[data-toggle="popover"]').popover()
			})
		</script>
</body>
</html>