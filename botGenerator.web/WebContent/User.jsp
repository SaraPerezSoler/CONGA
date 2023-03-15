<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="congabase.Project"%>
<%@page import="java.util.List"%>
<%@page import="congabase.main.CongaData"%>
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
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<%
		String prev = (String) getServletContext().getAttribute("Prev");
		String ordPrev = (String) getServletContext().getAttribute("ord");
		String orderBy = request.getParameter("orderBy");
		String ordAux = "asc";
		if (prev != null && orderBy != null) {
			if (prev.equals(orderBy) && ordAux.equals(ordPrev)) {
				ordAux = "desc";
			}
		}
		String ord = ordAux;
		getServletContext().setAttribute("Prev", orderBy);
		getServletContext().setAttribute("ord", ord);
		
		String username = (String) session.getAttribute("user");
		if (username == null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		CongaData conga = CongaData.getCongaData(getServletContext());
		List<Project> projects = new ArrayList<Project>(); 
		projects.addAll(conga.getProjects(username));
		
		if (!projects.isEmpty()) {
			if (orderBy != null) {
				Collections.sort(projects, new Comparator<Project>() {
					@Override
					public int compare(Project o1, Project o2) {
						String s1 = "";
						String s2 = "";
						if (orderBy.equals("Name")){
							s1 = o1.getName();
							s2 = o2.getName();
						}else if (orderBy.equals("Creation")){
							s1 = o1.getCreationDateString();
							s2 = o2.getCreationDateString();
						}else if (orderBy.equals("Modification")){
							s1 = o1.getModificationDateString();
							s2 = o2.getModificationDateString();
						}else if (orderBy.equals("RTool")){
							s1 = conga.getWinner(o1);
							s2 = conga.getWinner(o2);
						}else if (orderBy.equals("RDate")){
							s1 = o1.getQuestionnaireDateString();
							s2 = o2.getQuestionnaireDateString();
						}
						
						if (ord.equals("asc")) {
							return s1.compareTo(s2);
						} else {
							return s2.compareTo(s1);
						}
					}
						});
			}
		%>
		<div class="row">
			<div class="col">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col"><a href="User.jsp?orderBy=Name"
									style="color: black;">Project Name</a></th>
								<th scope="col"><a href="User.jsp?orderBy=Creation"
									style="color: black;">Creation</a></th>
								<th scope="col"><a href="User.jsp?orderBy=Modification"
									style="color: black;">Last modification</a></th>
								<th scope="col"><a href="User.jsp?orderBy=RTool"
									style="color: black;">Recommended tool</a></th>
								<th scope="col"><a href="User.jsp?orderBy=RDate"
									style="color: black;">Recommended date</a></th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Project project : projects) {
							%>
							<tr>
								<th scope="row"><a href="openProject?projectName=<%=project.getName()%>"><%=project.getName()%></a></th>
								<td><%=project.getCreationDateString()%></td>
								<td><%=project.getModificationDateString()%></td>
								<td><%=conga.getWinner(project)%></td>
								<td><%=project.getQuestionnaireDateString()%></td>
							
								<td>
									<a href="deleteProject?projectName=<%=project.getName()%>">
										<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  											<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
 											<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
										</svg>
									</a>
									<a href="questionnaire1.jsp?projectName=<%=project.getName()%>">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-question-circle-fill" viewBox="0 0 16 16">
 											 <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.496 6.033h.825c.138 0 .248-.113.266-.25.09-.656.54-1.134 1.342-1.134.686 0 1.314.343 1.314 1.168 0 .635-.374.927-.965 1.371-.673.489-1.206 1.06-1.168 1.987l.003.217a.25.25 0 0 0 .25.246h.811a.25.25 0 0 0 .25-.25v-.105c0-.718.273-.927 1.01-1.486.609-.463 1.244-.977 1.244-2.056 0-1.511-1.276-2.241-2.673-2.241-1.267 0-2.655.59-2.75 2.286a.237.237 0 0 0 .241.247zm2.325 6.443c.61 0 1.029-.394 1.029-.927 0-.552-.42-.94-1.029-.94-.584 0-1.009.388-1.009.94 0 .533.425.927 1.01.927z"/>
										</svg>
									</a>
									<%
									if (project.getQuestionnaire() != null && project.getQuestionnaire().getDate() != null) {
								%>
									<a href="Ranking.jsp?projectName=<%=project.getName()%>">
										<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-eye" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
 											<path fill-rule="evenodd" d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.134 13.134 0 0 0 1.66 2.043C4.12 11.332 5.88 12.5 8 12.5c2.12 0 3.879-1.168 5.168-2.457A13.134 13.134 0 0 0 14.828 8a13.133 13.133 0 0 0-1.66-2.043C11.879 4.668 10.119 3.5 8 3.5c-2.12 0-3.879 1.168-5.168 2.457A13.133 13.133 0 0 0 1.172 8z"/>
  											<path fill-rule="evenodd" d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
										</svg>
									</a>
									<%
									}else{
								%>
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-eye-slash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
									  <path d="M13.359 11.238C15.06 9.72 16 8 16 8s-3-5.5-8-5.5a7.028 7.028 0 0 0-2.79.588l.77.771A5.944 5.944 0 0 1 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.134 13.134 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755-.165.165-.337.328-.517.486l.708.709z"/>
									  <path d="M11.297 9.176a3.5 3.5 0 0 0-4.474-4.474l.823.823a2.5 2.5 0 0 1 2.829 2.829l.822.822zm-2.943 1.299l.822.822a3.5 3.5 0 0 1-4.474-4.474l.823.823a2.5 2.5 0 0 0 2.829 2.829z"/>
									  <path d="M3.35 5.47c-.18.16-.353.322-.518.487A13.134 13.134 0 0 0 1.172 8l.195.288c.335.48.83 1.12 1.465 1.755C4.121 11.332 5.881 12.5 8 12.5c.716 0 1.39-.133 2.02-.36l.77.772A7.029 7.029 0 0 1 8 13.5C3 13.5 0 8 0 8s.939-1.721 2.641-3.238l.708.709z"/>
									  <path fill-rule="evenodd" d="M13.646 14.354l-12-12 .708-.708 12 12-.708.708z"/>
								</svg>
								<%
									}
								%>
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
		<div class="row justify-content-end">
			<div class="col-8">
			</div>
			<div class="col-2">
				<a href="newproject.jsp" class="btn btn-secondary">Create
					project</a>
			</div>
			<div class="col-2">
				<a href="loadproject.jsp" class="btn btn-secondary">Load
					project</a>
			</div>
		</div>
		<%
			} else {
		%>
		<div class="row tablecenter">
			<div class="col">
				<a href="newproject.jsp" class="btn btn-secondary center-buttons">Create
					project</a>
			</div>
			<div class="col">
				<a href="loadproject.jsp" class="btn btn-secondary center-buttons">Load
					project</a>
			</div>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>