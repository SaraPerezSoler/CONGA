<%@page import="congabase.RelevanceLevel"%>
<%@page import="congabase.AQuestion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="congabase.main.CongaData"%>
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
		<div class="row justify-content-md-center">
			<div class="col">
				<h1 class="text-center box">Chatbot tool recommender</h1>
				<!--<p class="text-justify">Welcome to the tool recommender for creating chatbots. On
					this first page you must select the model of the chatbot. I will
					use this model to evaluate different characteristics of the chatbot
					(listed below) to obtain better precision when recommending a tool.
					Then you can select the level of relevance you want to give to each
					characteristic. The characteristics have four levels of relevance:
					relevant, doble relevance, critical. In the relevant and double
					relevant cases, if the tool cannot satisfy the characteristics of
					the chatbot, the tool will score less in the ranking, but in
					critical cases if the tool cannot satisfy the needs of the chatbot,
					that tool will be discarded. The multi-response characteristics
					have critical relevance divided into two:</p>
				<ul>
					<li>at least one option: the tool must satisfy at least one of
						the options that the chatbot has, but the more options it
						satisfies, the higher it will score in the ranking</li>
					<li>all options: if the tool does not satisfy all the options
						that the chatbot has, it will be discarded.</li>
				</ul>
				<p class="text-justify">For example, if you select a level of relevance "not
					relevant" to the chatbot language feature, it implies that when
					recommending a tool I will not take into account the language of
					the bot, however, if the selected tool does not support said
					language at best you have to make modifications in the chatbot to
					be able to use the tool.</p>-->
			</div>
		</div>
		
		<%String projectName = request.getParameter("projectName"); %>
		
		<div class="row">
			<div class="col">
				<form class="login-form" method="post" action="startQuestionnaire?projectName=<%=projectName%>">
					<div class="row">
						<div class="col">
							<div class="row justify-content-md-center">
								<div class="col-lg-9">
									<%
										String user = (String)session.getAttribute("user");
										CongaData conga= CongaData
												.getCongaData(pageContext.getServletContext());
										List<AQuestion> evaluators = conga.getEvaluations(user, projectName);
										for (AQuestion ev : evaluators) {
									%>
									<div class="row">
										<div class="col-md-9">
											<%=ev.getQuestion().getText()%>
										</div>
										<div class="col-md">
											<select name ="<%=ev.getQuestion().getName()%>" class="form-control form-control-sm">
												<%
													for (String level : RelevanceLevel.getLevelsString(ev.getQuestion().isMultiresponse())) {
												%>
												<%if (ev.getRelevance().getLiteral().equals(level)) {%>
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

									<%
										}
									%>
								</div>
							</div>
							<div class="row justify-content-md-center box">
								<div class="col">
									<button type="submit"
										class="row-lg btn btn-secondary btn-lg btn-block">Start
										Questionnaire</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>