<!DOCTYPE html>
<html>
<head>
<title>Login page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="bootstrap\css\bootstrap.min.css" />
<link href='https://fonts.googleapis.com/css?family=Atma'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="js/login.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-md-center loginbox">
			<div class="col">
				<div class="text-center shadow-none bg-light rounded">
					<h1 class="display-4 congaBig">CONGA</h1>
				</div>
				<!--  <div class="text-center"><h2 class="display-4">Login</h2></div>-->
				<div class="row">
					<div class="col">
						<%
							if (getServletContext().getAttribute("msg") != null) {
						%>
						<div class="alert alert-danger"><%=getServletContext().getAttribute("msg")%></div>
						<%
							}
						%>
					</div>
				</div>
				<form class="login-form" method="post" action="login">
					<div>
						<div class="form-group">
							<label for="lg_username" class="sr-only">username</label> <input
								type="text" class="form-control" id="lg_username"
								name="lg_username" placeholder="username"
								onblur="validateUserName()">
							<div id="error_username"></div>
						</div>
						<div class="form-group">
							<label for="lg_password" class="sr-only">password</label> <input
								type="password" class="form-control" id="lg_password"
								name="lg_password" placeholder="password"
								onblur="validateLgPassword()">
							<div id="error_password"></div>
						</div>
						<!--
                    <div class="form-group login-group-checkbox">
                        <input type="checkbox" id="lg_remember" name="lg_remember">
                        <label for="lg_remember">recordarme</label>
                    </div>
                    -->
					</div>
					<button type="submit"
						class="row-lg btn btn-secondary btn-lg btn-block">Sign in</button>
					<div class="etc-login-form">
						<p>
							New to CONGA? <a href=""> Create an account.</a>
						</p>
						<p>
							You can also <a href="editor.jsp">try</a> CONGA without account.
						</p>
					</div>
				</form>
			</div>
		</div>

		<!-- 		<div class="row" style="margin-top: 260px; margin-left: 905px"> -->
		<!-- 			<div class = "col"> -->
		<!-- 			</div> -->
		<!-- 			<div class = "col"> -->
		<!-- 			<iframe allow="microphone;" width="350" height="430" -->
		<!-- 				src="https://console.dialogflow.com/api-client/demo/embedded/0439012a-5ee3-4384-96bc-e5d389c8ee55"> -->
		<!-- 			</iframe> -->
		<!-- 			</div> -->
		<!-- 		</div> -->


		<!-- 		<script -->
		<!-- 			src="https://www.gstatic.com/dialogflow-console/fast/messenger/bootstrap.js?v=1"></script> -->
		<!-- 		<df-messenger chat-title="Test" -->
		<!-- 			agent-id="0439012a-5ee3-4384-96bc-e5d389c8ee55" language-code="en"></df-messenger> -->


	</div>

</body>
</html>