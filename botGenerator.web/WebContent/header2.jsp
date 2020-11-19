
<%
	boolean hasUser = true;
String congaRef = "User.jsp";
if (session == null) {
	hasUser = false;
	congaRef = "editor.jsp";
} else {
	String username = (String) session.getAttribute("user");
	if (username == null) {
		hasUser = false;
		congaRef = "editor.jsp";
	}
}
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<h1 class="">
		<a class="navbar-brand conga" href="<%=congaRef%>">CONGA</a>
	</h1>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>


	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link " href="#">Docs</a></li>
		</ul>
	</div>
	<%
		if (hasUser) {
	%>
	<a href="User.jsp">
	<span><svg width="1em" height="1em" viewBox="0 0 16 16"
			class="bi bi-person-fill" fill="currentColor"
			xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
				d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
</svg> <%=session.getAttribute("user")%></span> </a>
<a href="logout"
		class="btn btn-light">Sign out</a>
	<%
		} else {
	%>

	<a href="index.jsp" class="btn btn-light">Sign in</a>

	<%
		}
	%>
</nav>