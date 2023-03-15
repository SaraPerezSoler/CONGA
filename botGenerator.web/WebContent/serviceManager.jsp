<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="congabase.Utility"%>
<%@page import="congabase.Service"%>
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
		if (username == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		CongaData conga = CongaData.getCongaData(getServletContext());
		List<Utility> services = new ArrayList<Utility>(); 
		services.addAll(conga.getUtilities(username));

		if (!services.isEmpty()) {
			if (orderBy != null) {
				Collections.sort(services, new Comparator<Utility>() {
			@Override
			public int compare(Utility o1, Utility o2) {
				String s1 = "";
				String s2 = "";
				if (orderBy.equals("Type")){
					s1 = o1.getTypeString();
					s2 = o2.getTypeString();
				}else if (orderBy.equals("Tool")){
					s1 = o1.getTool().getName();
					s2 = o2.getTool().getName();
				}else if (orderBy.equals("Version")){
					s1 = o1.getVersion();
					s2 = o2.getVersion();
				}else if (orderBy.equals("URL")){
					s1 = o1.getSortURL();
					s2 = o2.getSortURL();
				}else if (orderBy.equals("Access")){
					s1 = o1.getLastAccessString();
					s2 = o2.getLastAccessString();
				}else if (orderBy.equals("Status")){
					s1 = o1.getStatusString();
					s2 = o2.getStatusString();
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
		<script type="text/javascript">
			window.alert("orderby= <%=orderBy%>, prev= <%=prev%>, ordPrev=<%=ordPrev%>, ord=<%=ord%>
			");
		</script>
		<div class="row">
			<div class="col">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col"><a href="serviceManager.jsp?orderBy=Type"
									style="color: black;">Type</a></th>
								<th scope="col"><a href="serviceManager.jsp?orderBy=Tool"
									style="color: black;">Tool</a></th>
								<th scope="col"><a href="serviceManager.jsp?orderBy=Version"
									style="color: black;">Version</a></th>
								<th scope="col"><a href="serviceManager.jsp?orderBy=URL"
									style="color: black;">URL</a></th>
								<th scope="col"><a href="serviceManager.jsp?orderBy=Access"
									style="color: black;">Last access</a></th>
								<th scope="col"><a href="serviceManager.jsp?orderBy=Status"
									style="color: black;">Status</a></th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Utility utility : services) {
							%>
							<tr>
								<th scope="row"><%=utility.getTypeString()%></th>
								<td><%=utility.getTool().getName()%></td>
								<td><%=utility.getVersion()%></td>
								<td><%=utility.getSortURL()%></td>
								<td><%=utility.getLastAccessString()%></td>
								<td><%=utility.getStatusString()%></td>
								<%
								if (utility instanceof Service) {
									Service service = (Service) utility;
								%>
								<td><a
									href="serviceChange?serviceId=<%=service.getServiceId()%>">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-power" viewBox="0 0 16 16">
										  <path d="M7.5 1v7h1V1h-1z" />
										  <path
												d="M3 8.812a4.999 4.999 0 0 1 2.578-4.375l-.485-.874A6 6 0 1 0 11 3.616l-.501.865A5 5 0 1 1 3 8.812z" />
										</svg>
								</a> <a href="editService.jsp?serviceId=<%=service.getServiceId()%>">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-pencil-square"
											viewBox="0 0 16 16">
										  <path
												d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
										  <path fill-rule="evenodd"
												d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
										</svg>
								</a> <a href="deleteService?serviceId=<%=service.getServiceId()%>">
										<svg width="1em" height="1em" viewBox="0 0 16 16"
											class="bi bi-trash" fill="currentColor"
											xmlns="http://www.w3.org/2000/svg">
  											<path
												d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
 											<path fill-rule="evenodd"
												d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
										</svg>
								</a></td>
							</tr>
							<%
							} else {
							%>

							<td><a
								href="editRecommenderTool.jsp?serviceId=<%=utility.getServiceId()%>">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-pencil-square"
										viewBox="0 0 16 16">
										  <path
											d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
										  <path fill-rule="evenodd"
											d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
										</svg>
							</a> <a href="deleteService?serviceId=<%=utility.getServiceId()%>">
									<svg width="1em" height="1em" viewBox="0 0 16 16"
										class="bi bi-trash" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
  											<path
											d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
 											<path fill-rule="evenodd"
											d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
										</svg>
							</a></td>
							</tr>

							<%
							}
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%
		} else {
		%>
		<div class="row tablecenter">
			<div class="col">
				<a href="NewService.jsp" class="btn btn-secondary center-buttons">Add
					New Service</a>
			</div>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>