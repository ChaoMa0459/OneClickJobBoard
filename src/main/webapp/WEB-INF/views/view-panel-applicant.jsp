<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Job Board View Panel</title>
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
		<div class="navbar-side"
			style="width: 200px; position: absolute; left: 25px; top: 10px;">
			<ul class="nav nav-pills nav-stacked" role="tablist"
				style="width: 200px; position: absolute; left: 25px; top: 10px;">
				<li class="active"
					style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="homepanel.htm">Home</a></li>
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="viewresume.htm">View Resumes</a></li>
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="createresume.htm">Create New Resume</a></li>
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="jobs.htm">Apply for Jobs</a></li>
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="login.htm">Logout</a></li>
			</ul>
		</div>

		<div class="resume-form"
			style="position: relative; left: 225px; top: 50px; width: 70%;">

			<div class="row">

				<form:form commandName="resumeChoice" class="form-horizontal">

					<div class="form-group">
						<label for="resumeName" class="col-sm-4 control-label">Please
							Select a Resume: </label>
						<div class="col-sm-8" style="width: 40%">
							<form:select path="resumeName" id="resumeName"
								class="form-control">
								<c:forEach var="resume" items="${requestScope.resumes}">
									<form:option value="${resume.getResumeName()}">${resume.getResumeName()}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<input type="submit" class="btn btn-success" value="Go" />
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</body>

</html>
