<%@page import="congabase.main.CongaData"%>
<%@page import="congabase.Project"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="en-us">
<title>CONGA Web Editor</title>
<link rel="stylesheet" type="text/css" href="xtext/2.23.0/xtext-ace.css" />
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />

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
	require([ "webjars/ace/1.3.3/src/ace" ], function() {
		require([ "xtext/xtext-ace" ], function(xtext) {
			var editor = xtext.createEditor({
				baseUrl : baseUrl,
				syntaxDefinition : "xtext-resources/generated/mode-bot"
			});

			$("#save-button").click(function() {
				documents = editor.xtextServices.saveResource();
			});
			
			$("#change-resource").change(function() {
				var resourceId = $("#change-resource option:selected").attr("value");
				editor.xtextServices.serviceBuilder.changeResource(resourceId);
			});

			$("#get-button").click(function() {
				var e = document.getElementById("tool");
				var tool = e.options[e.selectedIndex].value;
				jQuery.get('http://' + location.host + '/botGenerator.web/xtext-service/generate?resource=' + editor.xtextServices.options.resourceId+'&allArtifacts=true',
						function(result) {
						});
				window.open('http://' + location.host + '/botGenerator.web/getfiles?resource=' + editor.xtextServices.options.resourceId+'&tool='+tool)
			});
			
			$("#recomender").click(function() {
				jQuery.get('http://' + location.host + '/botGenerator.web/goRecommender?resource=' + editor.xtextServices.options.resourceId,
						function(result) {
						});
			});
			
		});
	});
</script>
</head>

<body>
	<%Project project = (Project) getServletContext().getAttribute("project"); %>
	<div class="container">
		<div id="xtext-editor" data-editor-xtext-lang="bot"
			data-editor-resource-id="<%=project.getOwner().getNick()+"/"+project.getName()%>.bot"
			data-editor-dirty-element="dirty-indicator"
			data-editor-enable-save-action="true"
			data-editor-enable-formatting-action="true"
			data-editor-show-error-dialogs="true"></div>
		<div class="status-wrapper">
			<div id="dirty-indicator">modified</div>
			<div id="status">Welcome to <a href="User.jsp">CONGA</a> editor</div>
		</div>
		<div class="button-wrapper">
			Project selected:
			<select id="change-resource" class="form-control editor-buttons">
				<%for (Project p: project.getOwner().getProjects()){ 
					String selected="";
					if (p.equals(project)){
						selected="selected";
					}else{
						selected="";
					}
				%>
				<option value="<%=p.getOwner().getNick()+"/"+p.getName()%>.bot" <%=selected%>><%=p.getName() %></option>
				<%} %>
			</select>
			<button id="save-button" class="btn btn-secondary editor-buttons">Save</button><br><br>
			<!-- <button id="revert-button">Revert</button> -->
			Tool selected:
			<select name="tool" id="tool" class="form-control editor-buttons">
				<%
				  for (String tool: CongaData.supportedTools()){ 
				%>
				<option value="<%=tool%>" ><%=tool%></option>
				<%} %>
			</select>
			<button id="get-button" class="btn btn-secondary editor-buttons">Generate</button><br><br>
			
			<button id="recomender" class="btn btn-secondary editor-buttons">Recommender</button><br><br>
			
			<a href="User.jsp" class="btn btn-secondary editor-buttons">User Menu</a><br><br>

		</div>
	</div>

</body>
</html>
