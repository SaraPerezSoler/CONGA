<%@page import="congabase.main.CongaData"%>
<%@page import="congabase.Project"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="en-us">
<title>CONGA Web Editor</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap\css\bootstrap.min.css" />
<link href='https://fonts.googleapis.com/css?family=Atma'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="bootstrap\js\bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="xtext/2.23.0/xtext-ace.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="webjars/requirejs/2.3.6/require.min.js"></script>
<script type="text/javascript">
	var baseUrl = window.location.pathname;
	console.log(baseUrl)
	var fileIndex = baseUrl.indexOf("editor.html");
	var fileIndex2 = baseUrl.indexOf("createProject");
	var fileIndex3 = baseUrl.indexOf("openProject");
	if (fileIndex > 0)
		baseUrl = baseUrl.slice(0, fileIndex);
	if (fileIndex2 > 0)
		baseUrl = baseUrl.slice(0, fileIndex2);
	if (fileIndex3 > 0)
		baseUrl = baseUrl.slice(0, fileIndex3);
	require
			.config({
				baseUrl : baseUrl,
				paths : {
					"jquery" : "webjars/jquery/3.4.1/jquery.min",
					"ace/ext/language_tools" : "webjars/ace/1.3.3/src/ext-language_tools",
					"xtext/xtext-ace" : "xtext/2.23.0/xtext-ace"
				}
			});
	require(
			[ "webjars/ace/1.3.3/src/ace" ],
			function() {
				require(
						[ "xtext/xtext-ace" ],
						function(xtext) {
							var editor = xtext
									.createEditor({
										baseUrl : baseUrl,
										syntaxDefinition : "xtext-resources/generated/mode-bot"
									});

							$("#save-button").click(
									function() {
										documents = editor.xtextServices
												.saveResource();
										location.reload()
									});
							$("#format-button").click(function() {
								documents = editor.xtextServices.format();
							});

							$("#change-resource")
									.change(
											function() {
												var resourceId = $(
														"#change-resource option:selected")
														.attr("value");
												editor.xtextServices.serviceBuilder
														.changeResource(resourceId);
											});

							$("#get-button")
									.click(
											function() {
												var e = document
														.getElementById("tool");
												var tool = e.options[e.selectedIndex].value;
												jQuery
														.get(
																'http://'
																		+ location.host
																		+ '/botGenerator.web/xtext-service/generate?resource='
																		+ editor.xtextServices.options.resourceId
																		+ '&allArtifacts=true',
																function(result) {
																});
												window
														.open('http://'
																+ location.host
																+ '/botGenerator.web/getfiles?resource='
																+ editor.xtextServices.options.resourceId
																+ '&tool='
																+ tool)
											});

							$("#recomender")
									.click(
											function() {
												jQuery
														.get(
																'http://'
																		+ location.host
																		+ '/botGenerator.web/goRecommender?resource='
																		+ editor.xtextServices.options.resourceId,
																function(result) {
																});
											});

						});
			});
</script>
</head>

<body>
	<%
		Project project = (Project) getServletContext().getAttribute("project");
	CongaData conga = CongaData.getCongaData(getServletContext());
	%>
	<div class="container">
		<jsp:include page="header2.jsp" />
		<nav class="navbar navbar-light" style="background-color: #FFFFFF;">
			<div class="form-inline" style="width: 100%">
				<button id="save-button"
					class="btn btn-outline-secondary button-nav-size button-nav-margin button-nav-height">
					<i class="fa fa-save" style="font-size: 20px"></i>
				</button>
				<a
					class="btn btn-outline-secondary button-nav-size button-nav-margin button-nav-height dropdown-toggle"
					data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
					aria-expanded="false">New</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="newproject.jsp">Empty project</a> <a
						class="dropdown-item" href="loadproject.jsp">Load from
						Dialogflow files</a>
				</div>
				<button id="format-button"
					class="btn btn-outline-secondary  button-nav-size button-nav-margin button-nav-height">
					Format</button>
				<div class="form-group button-nav-margin">
					<select name="tool" id="tool"
						class="form-control button-nav-size button-nav-height"
						style="width: 125px;">
						<%
							for (String tool : CongaData.supportedTools()) {
						%>
						<option value="<%=tool%>"><%=tool%></option>
						<%
							}
						%>
					</select>
					<button id="get-button"
						class="btn btn-outline-secondary button-nav-size button-nav-height">
						<svg width="1em" height="1em" viewBox="0 0 16 16"
							class="bi bi-download" fill="currentColor"
							xmlns="http://www.w3.org/2000/svg">
		  				<path fill-rule="evenodd"
								d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z" />
		  				<path fill-rule="evenodd"
								d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z" />
					</svg>
					</button>
				</div>
				<a href="questionnaire1.jsp?projectName=<%=project.getName()%>"
					id=""
					class="btn btn-outline-secondary button-nav-size button-nav-margin button-nav-height">
					Questionnaire <svg width="1em" height="1em" viewBox="0 0 16 16"
						class="bi bi-question-octagon-fill" fill="currentColor"
						xmlns="http://www.w3.org/2000/svg">
  					<path fill-rule="evenodd"
							d="M11.46.146A.5.5 0 0 0 11.107 0H4.893a.5.5 0 0 0-.353.146L.146 4.54A.5.5 0 0 0 0 4.893v6.214a.5.5 0 0 0 .146.353l4.394 4.394a.5.5 0 0 0 .353.146h6.214a.5.5 0 0 0 .353-.146l4.394-4.394a.5.5 0 0 0 .146-.353V4.893a.5.5 0 0 0-.146-.353L11.46.146zM5.496 6.033a.237.237 0 0 1-.24-.247C5.35 4.091 6.737 3.5 8.005 3.5c1.396 0 2.672.73 2.672 2.24 0 1.08-.635 1.594-1.244 2.057-.737.559-1.01.768-1.01 1.486v.105a.25.25 0 0 1-.25.25h-.81a.25.25 0 0 1-.25-.246l-.004-.217c-.038-.927.495-1.498 1.168-1.987.59-.444.965-.736.965-1.371 0-.825-.628-1.168-1.314-1.168-.803 0-1.253.478-1.342 1.134-.018.137-.128.25-.266.25h-.825zm2.325 6.443c-.584 0-1.009-.394-1.009-.927 0-.552.425-.94 1.01-.94.609 0 1.028.388 1.028.94 0 .533-.42.927-1.029.927z" />
				</svg>
				</a>
				<%
					if (project.getQuestionnaire() != null && project.getQuestionnaire().getDate() != null) {
				%>
				<a href="Ranking.jsp?projectName=<%=project.getName()%>"
					class="btn btn-outline-secondary button-nav-size button-nav-margin button-nav-height">
					Recommender <svg width="1em" height="1em" viewBox="0 0 16 16"
						class="bi bi-eye" fill="currentColor"
						xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd"
							d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.134 13.134 0 0 0 1.66 2.043C4.12 11.332 5.88 12.5 8 12.5c2.12 0 3.879-1.168 5.168-2.457A13.134 13.134 0 0 0 14.828 8a13.133 13.133 0 0 0-1.66-2.043C11.879 4.668 10.119 3.5 8 3.5c-2.12 0-3.879 1.168-5.168 2.457A13.133 13.133 0 0 0 1.172 8z" />
						<path fill-rule="evenodd"
							d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z" />
					</svg>
				</a>
				<%
					} else {
				%>
				<button
					class="btn btn-outline-secondary button-nav-size button-nav-margin button-nav-height"
					disabled="disabled">
					Recommender
					<svg width="1em" height="1em" viewBox="0 0 16 16"
						class="bi bi-eye-slash" fill="currentColor"
						xmlns="http://www.w3.org/2000/svg">
					  <path
							d="M13.359 11.238C15.06 9.72 16 8 16 8s-3-5.5-8-5.5a7.028 7.028 0 0 0-2.79.588l.77.771A5.944 5.944 0 0 1 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.134 13.134 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755-.165.165-.337.328-.517.486l.708.709z" />
					  <path
							d="M11.297 9.176a3.5 3.5 0 0 0-4.474-4.474l.823.823a2.5 2.5 0 0 1 2.829 2.829l.822.822zm-2.943 1.299l.822.822a3.5 3.5 0 0 1-4.474-4.474l.823.823a2.5 2.5 0 0 0 2.829 2.829z" />
					  <path
							d="M3.35 5.47c-.18.16-.353.322-.518.487A13.134 13.134 0 0 0 1.172 8l.195.288c.335.48.83 1.12 1.465 1.755C4.121 11.332 5.881 12.5 8 12.5c.716 0 1.39-.133 2.02-.36l.77.772A7.029 7.029 0 0 1 8 13.5C3 13.5 0 8 0 8s.939-1.721 2.641-3.238l.708.709z" />
					  <path fill-rule="evenodd"
							d="M13.646 14.354l-12-12 .708-.708 12 12-.708.708z" />
				</svg>
				</button>
				<%
					}
				%>
			</div>
		</nav>

		<div class="row justify-content-md-center">
			<div class="col-7">
				<div class="row">
					<div class="col">
						<div id="xtext-editor" data-editor-xtext-lang="bot"
							data-editor-resource-id="<%=project.getOwner().getNick() + "/" + project.getName()%>.bot"
							data-editor-dirty-element="dirty-indicator"
							data-editor-enable-save-action="true"
							data-editor-enable-formatting-action="true"
							data-editor-show-error-dialogs="true"></div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div id="dirty-indicator">modified</div>
						<div id="status">
							Welcome to <a href="User.jsp">CONGA</a> editor
						</div>
					</div>
				</div>
			</div>

			<div class="col-5">
				<!-- <div class="col-5 align-self-center">  -->
				<div class="row justify-content-end">
					<img alt="Flow legend" class="align-self-end legend"
						src="img/legend.png">
				</div>
				<div class="row justify-content-md-center">

					<h5>
						Flow Diagram
						<svg width="1em" height="1em" viewBox="0 0 16 16"
							class="bi bi-diagram-3" fill="currentColor"
							xmlns="http://www.w3.org/2000/svg">
	  				<path fill-rule="evenodd"
								d="M6 3.5A1.5 1.5 0 0 1 7.5 2h1A1.5 1.5 0 0 1 10 3.5v1A1.5 1.5 0 0 1 8.5 6v1H14a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-1 0V8h-5v.5a.5.5 0 0 1-1 0V8h-5v.5a.5.5 0 0 1-1 0v-1A.5.5 0 0 1 2 7h5.5V6A1.5 1.5 0 0 1 6 4.5v-1zM8.5 5a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1zM0 11.5A1.5 1.5 0 0 1 1.5 10h1A1.5 1.5 0 0 1 4 11.5v1A1.5 1.5 0 0 1 2.5 14h-1A1.5 1.5 0 0 1 0 12.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1zm4.5.5A1.5 1.5 0 0 1 7.5 10h1a1.5 1.5 0 0 1 1.5 1.5v1A1.5 1.5 0 0 1 8.5 14h-1A1.5 1.5 0 0 1 6 12.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1zm4.5.5a1.5 1.5 0 0 1 1.5-1.5h1a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1-1.5 1.5h-1a1.5 1.5 0 0 1-1.5-1.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1z" />
				</svg>
					</h5>
				</div>
				<div class="row justify-content-md-center">
					<img alt="Flow image" class="align-self-center image"
						src="FileServlet?projectName=<%=project.getName()%>">
				</div>
			</div>
		</div>
	</div>




</body>
</html>
