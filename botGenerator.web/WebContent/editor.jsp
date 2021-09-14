<%@page import="congabase.Service"%>
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
	var fileIndex = baseUrl.indexOf("editor.jsp");
	var fileIndex1 = baseUrl.indexOf("generator");
	var fileIndex2 = baseUrl.indexOf("createProject");
	var fileIndex3 = baseUrl.indexOf("openProject");
	var fileIndex4 = baseUrl.indexOf("loadBot");
	if (fileIndex > 0)
		baseUrl = baseUrl.slice(0, fileIndex);
	if (fileIndex1 > 0)
		baseUrl = baseUrl.slice(0, fileIndex1);
	if (fileIndex2 > 0)
		baseUrl = baseUrl.slice(0, fileIndex2);
	if (fileIndex3 > 0)
		baseUrl = baseUrl.slice(0, fileIndex3);
	if (fileIndex4 > 0)
		baseUrl = baseUrl.slice(0, fileIndex4);
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
							
							function validate(){
								jQuery
								.get(
										'http://'
												+ location.host
												+ '/botGenerator.web/validate',
										function(result) {
// 													console.log(result);
													const rest = JSON.parse(result);
													console.log(rest);
													var issues = rest.issues;
													console.log(issues);
													if (issues.length == 0){
														document.getElementById("general-error").innerHTML = "Validation completed successfully";
														document.getElementById("counter").innerHTML = '(0 errors, 0 warnings)';
													}else{
														var table = '<div class="table-responsive"> <table class="table table-hover"> <tbody>';
														var warnings = '';
														var errors = '';
														var wcount = 0;
														var ecount = 0;
														for (var i = 0; i < issues.length; i++) {
															var issue = issues[i];
															if (issue.severity == "warning"){
																wcount++;
																//F5B301
																warnings += '<tr style="color:#D79D00;"><td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-exclamation-triangle-fill" viewBox="0 0 16 16"><path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/></svg></td><td> Line '+issue.line+': '+issue.description+'</td></tr>';
															}else if (issue.severity == "error"){
																ecount++;
																errors += '<tr style="color:red;"><td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-octagon-fill" viewBox="0 0 16 16"> <path d="M11.46.146A.5.5 0 0 0 11.107 0H4.893a.5.5 0 0 0-.353.146L.146 4.54A.5.5 0 0 0 0 4.893v6.214a.5.5 0 0 0 .146.353l4.394 4.394a.5.5 0 0 0 .353.146h6.214a.5.5 0 0 0 .353-.146l4.394-4.394a.5.5 0 0 0 .146-.353V4.893a.5.5 0 0 0-.146-.353L11.46.146zm-6.106 4.5L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/> </svg></td><td>Line '+issue.line+': '+issue.description+'</td></tr>';
															}
														}
														table += errors;
														table += warnings;
														table += '</tbody> </table> </div>';
														document.getElementById("general-error").innerHTML = table;
														document.getElementById("counter").innerHTML = '('+ecount+' errors, '+wcount+' warnings)';
													}
													
										});
							}
							function save() {
								documents = editor.xtextServices
										.saveResource();
								validate();
								location.reload()
								
							}
							validate();

							$("#save-button").click(function () {save();});
						
// 							 $('body').on("keydown", function(e) { 
// 						            if (e.ctrlKey && e.shiftKey  && e.which === 83) {
// 						            	console.log("pressed");
// 						            	save();
// 						            }
// 						        });
							$("#format-button").click(function() {
								documents = editor.xtextServices.format();
							});

							$("#validate-button")
									.click(
											function() {
												validate();
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

	// 	$(document).ready(function() {
	// 		$('.dropdown-submenu a').on("click", function(e) {
	// 			$(this).parents('ul').find('.dropdown-submenu ul').hide();
	// 			$(this).parents('ul').parents('ul').find('.dropdown-submenu ul').hide();
	// 			$(this).next('ul').toggle();
	// 			e.stopPropagation();
	// 			e.preventDefault();
	// 			var ref = $(this).attr('href');
	// 			if (ref.localeCompare('#')!=0){
	// 				window.open(
	// 						'http://'
	// 						+ location.host +'/botGenerator.web/'+ref ,
	// 						function(result) {
	// 						});
	// 				setTimeout(function () {
	// 					location.reload();
	// 			    }, 500);

	// 			}
	// 		});
	// 	});
	
	$(document).ready(function() {
		$('.dropdown-submenu a').on("mouseover", function(e) {
			$(this).next('ul').toggle();
			e.stopPropagation();
			e.preventDefault();
		});
		$('#collapseOne').on('hidden.bs.collapse', function () {
			document.getElementById("arrow").innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16"> <path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/></svg>';
			});
		$('#collapseOne').on('shown.bs.collapse', function () {
			document.getElementById("arrow").innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down" viewBox="0 0 16 16"> <path d="M3.204 5h9.592L8 10.481 3.204 5zm-.753.659 4.796 5.48a1 1 0 0 0 1.506 0l4.796-5.48c.566-.647.106-1.659-.753-1.659H3.204a1 1 0 0 0-.753 1.659z"/></svg>';
			});
	});
	
	
</script>
</head>

<body>
	<%
	Project project = (Project) getServletContext().getAttribute("project");
	CongaData conga = CongaData.getCongaData(getServletContext());
	getServletContext().setAttribute("jsp", "editor.jsp");
	%>
	<div class="container">
		<jsp:include page="header.jsp" />
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
						class="dropdown-item" href="loadproject.jsp">Load from files</a>
				</div>
				<button id="format-button"
					class="btn btn-outline-secondary  button-nav-size button-nav-margin button-nav-height">
					Format</button>
				<button id="validate-button"
					class="btn btn-outline-secondary  button-nav-size button-nav-margin button-nav-height">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
					  <path
							d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
					  <path
							d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z" />
					</svg>
				</button>
				<div class="dropdown button-nav-margin">
					<button
						class="btn btn-outline-secondary dropdown-toggle button-nav-height"
						type="button" id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<svg width="1em" height="1em" viewBox="0 0 16 16"
							class="bi bi-download" fill="currentColor"
							xmlns="http://www.w3.org/2000/svg">
			  				<path fill-rule="evenodd"
								d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z" />
			  				<path fill-rule="evenodd"
								d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z" />
						</svg>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<%
						for (String tool : conga.supportedGeneratorTools().keySet()) {
						%>
						<li class="dropdown-submenu"><a class="dropdown-item"
							href="#"><%=tool%></a>
							<ul class="dropdown-menu">
								<%
								for (Service s : conga.supportedGeneratorTools().get(tool)) {
								%>
								<li><a class="dropdown-item"
									href="generator?serviceId=<%=s.getServiceId()%>&projectName=<%=project.getName()%>"><%=s.getUser().getNick()%>/<%=s.getVersion()%></a></li>
								<%
								}
								%>
							</ul></li>
						<%
						}
						%>
					</ul>
				</div>

				<a href="questionnaire1.jsp?projectName=<%=project.getName()%>"
					id=""
					class="btn btn-outline-secondary button-nav-size button-nav-margin button-nav-height">
					Questionnaire <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-question-circle-fill" viewBox="0 0 16 16">
  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.496 6.033h.825c.138 0 .248-.113.266-.25.09-.656.54-1.134 1.342-1.134.686 0 1.314.343 1.314 1.168 0 .635-.374.927-.965 1.371-.673.489-1.206 1.06-1.168 1.987l.003.217a.25.25 0 0 0 .25.246h.811a.25.25 0 0 0 .25-.25v-.105c0-.718.273-.927 1.01-1.486.609-.463 1.244-.977 1.244-2.056 0-1.511-1.276-2.241-2.673-2.241-1.267 0-2.655.59-2.75 2.286a.237.237 0 0 0 .241.247zm2.325 6.443c.61 0 1.029-.394 1.029-.927 0-.552-.42-.94-1.029-.94-.584 0-1.009.388-1.009.94 0 .533.425.927 1.01.927z"/>
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

			<div class="col-5 max-height-large">
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

		<div class="row justify-content-md-center">
			<div class="col" id="console-div">
				<h5 class="card-title">Problems</h5>
				<div class="card scroll" id="console-card">
					<div class="card-body">
						<h6 class="card-subtitle mb-2 text-muted">
							<button class="btn btn-link" data-toggle="collapse"
								data-target="#collapseOne" aria-expanded="true"
								aria-controls="collapseOne" >
								<span id="arrow"> <svg xmlns="http://www.w3.org/2000/svg"
										width="16" height="16" fill="currentColor"
										class="bi bi-caret-down" viewBox="0 0 16 16">
  <path
											d="M3.204 5h9.592L8 10.481 3.204 5zm-.753.659 4.796 5.48a1 1 0 0 0 1.506 0l4.796-5.48c.566-.647.106-1.659-.753-1.659H3.204a1 1 0 0 0-.753 1.659z" />
</svg></span>
							</button>
							<span> General Problems <span id="counter"></span></span>
						</h6>
						<div id="collapseOne" class="collapse show"
							aria-labelledby="headingOne" data-parent="#console-div">
							<span id ="general-error">  </span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>
