<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Job Board View Job</title>
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
<body>
	<div class="container">
		<div class="navbar-side"
			style="width: 200px; height: auto; position: absolute; left: 25px; top: 10px;">
			<ul class="nav nav-pills nav-stacked" role="tablist"
				style="width: 200px; position: absolute; left: 25px; top: 10px;">
				<li class="active"
					style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="company-homepanel.htm">Home</a></li>
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="viewjob.htm">View Jobs</a></li>
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="createjob.htm">Create New Job</a></li>
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="logout.htm">Logout</a></li>
			</ul>
		</div>

		<div class="resume-form"
			style="position: relative; left: 225px; top: 10px; width: 70%;">

			<div class="alert alert-info" role="alert">
				<h4 class="text-center">
					<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
					View Job
				</h4>
			</div>

			<div class="row">

				<form:form commandName="job" class="form-horizontal">

					<div class="form-group">
						<label for="jobName" class="col-sm-4 control-label">Job
							Name:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="jobName"
								path="jobName" placeholder="Job Name" required="required" />
						</div>
					</div>

					<c:if test="${requestScope.errorName != null}">
						<div class="alert alert-warning" style="margin-left: 30%;">
							<p style="margin-left: 5%;">
								<strong>Sorry!</strong> ${requestScope.errorName}
							</p>
						</div>
					</c:if>

					<div class="alert alert-info">
						<p class="text-center">Job Description:</p>
					</div>

					<div class="form-group">
						<label for="title" class="col-sm-4 control-label">Job Title:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="title"
								path="title" placeholder="Job Title" required="required" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="company" class="col-sm-4 control-label">Company
							Name:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="company"
								path="company" placeholder="company" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="area" class="col-sm-4 control-label">Area:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="area"
								path="area" placeholder="Area" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="overview" class="col-sm-4 control-label">Overview:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="overview"
								path="overview" placeholder="overview" required="required"  style="height: 60px;"/>
						</div>
					</div>

					<div class="form-group">
						<label for="requirements" class="col-sm-4 control-label">Requirements:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="requirements"
								path="requirements" placeholder="Requirements"
								required="required"  style="height: 200px;"/>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
						<a href="select-resume-company.htm"><input class="btn btn-success" value="View Applications" style="width: 200px"></a>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
						<a href="viewjob.htm"><input class="btn btn-success" value="Back" style="width: 200px"></a>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</body>

</html>
