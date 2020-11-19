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
<script type="text/javascript">

function generate(tool, resourceId) {
	jQuery.get('http://' + location.host + '/botGenerator.web/xtext-service/generate?resource=' +resourceId+'&allArtifacts=true',
			function(result) {
			});
	window.open('http://' + location.host + '/botGenerator.web/getfiles?resource=' + resourceId+'&tool='+tool)
}
</script>
</head>
<body>
	<%
		String projectName = request.getParameter("projectName");
	String user = (String) session.getAttribute("user");
	CongaData conga = CongaData.getCongaData(getServletContext());

	Map<String, Double> ranking = conga.getRanking(user, projectName);
	DecimalFormat df2 = new DecimalFormat("#.##");
	%>
	<div class="container">
		<jsp:include page="header.jsp" />
		<div class="row justify-content-md-center box">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link page-size" href="User.jsp">User Menu</a></li>
					<li class="page-item"><a class="page-link page-size" href="openProject?projectName=<%=projectName%>">Open bot</a></li>
					<li class="page-item active" aria-current="page"><span
						class="page-link page-size"> Ranking <span class="sr-only">(current)</span>
					</span></li>
					<li class="page-item"><a class="page-link page-size"
						href="ReportTables.jsp?projectName=<%=projectName%>">Report
							tables</a></li>
					<li class="page-item"><a class="page-link page-size"
						href="ReportDetails.jsp?projectName=<%=projectName%>">Report
							details</a></li>
				</ul>
			</nav>
		</div>

		<div class="row justify-content-md-center box">
			<div class="col">
				<div class="row justify-content-md-center">
					<div class="col">
						<div class="table-responsive">
							<table class="table table-hover">
								<tbody>
									<%
										for (String tool : ranking.keySet()) {
										String disabled = "disabled";
										if (tool.equalsIgnoreCase("Rasa") || tool.equalsIgnoreCase("Dialogflow")) {
											disabled = "";
										}
									%>
									<tr>
										<th scope="row"><%=tool%></th>
										<td><%=df2.format(ranking.get(tool) * 100)%>%</td>
										<td>
											<button type="button" class="btn btn-outline-primary" onclick="generate('<%=tool%>', '<%=user%>/<%=projectName%>.bot')" 
												<%=disabled%>>
												<svg width="1em" height="1em" viewBox="0 0 16 16"
													class="bi bi-download" fill="currentColor"
													xmlns="http://www.w3.org/2000/svg">
												  <path fill-rule="evenodd"
														d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z" />
												  <path fill-rule="evenodd"
														d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z" />
												</svg>
											</button>
										</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>