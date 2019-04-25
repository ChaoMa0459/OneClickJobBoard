<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Job Board Registration</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
</head>

<body
	style="background: url(${pageContext.request.contextPath}/resources/images/Job-Search.jpg);
background-repeat: no-repeat;
background-position: bottom center;
background-size: 50%;">
	<div class="container">

		<div class="alert alert-info" role="alert">
			<h4 class="text-center">
				<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
				User Registration
			</h4>
		</div>

		<div class="row">

			<form:form commandName="user" class="form-horizontal">

				<div class="form-group">
					<label for="username" class="col-sm-4 control-label">Username:</label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control" id="username"
							path="username" placeholder="Username" required="required" />
					</div>
				</div>
				<c:if test="${requestScope.errorDupUsername != null}">
					<div class="alert alert-warning" style="margin-left: 30%;">
						<p style="margin-left: 5%;">
							<strong>Sorry!</strong> ${requestScope.errorDupUsername}
						</p>
					</div>
				</c:if>

				<div class="form-group">
					<label for="password" class="col-sm-4 control-label">Password:</label>
					<div class="col-sm-8">
						<form:input type="password" class="form-control" id="password"
							path="password" placeholder="Password" required="required" />
					</div>
				</div>

				<div class="form-group">
					<label for="password" class="col-sm-4 control-label">Confirm
						Password: </label>
					<div class="col-sm-8">
						<form:input type="password" class="form-control" id="password"
							path="confirmPassword" placeholder="Confirm Password"
							required="required" />
					</div>
				</div>
				<c:if test="${requestScope.errorConfirmPassword != null}">
					<div class="alert alert-warning" style="margin-left: 30%;">
						<p style="margin-left: 5%;">
							<strong>Sorry!</strong> ${requestScope.errorConfirmPassword}
						</p>
					</div>
				</c:if>

				<div class="form-group">
					<label for="email" class="col-sm-4 control-label">Email: </label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control" id="email"
							path="email" placeholder="email" required="required" />
					</div>
				</div>

				<div class="form-group">
					<label for="type" class="col-sm-4 control-label">Type: </label>
					<div class="col-sm-8">
						<form:select path="type" id="type" class="form-control">
							<form:option value="Applicant">Applicant</form:option>
							<form:option value="Company">Company</form:option>
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<input type="submit" class="btn btn-success" value="Register" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<a href="login.htm"><input class="btn btn-success"
							value="Click here to login"></a>
					</div>
				</div>

			</form:form>
		</div>
	</div>

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"></script>
</body>
</html>