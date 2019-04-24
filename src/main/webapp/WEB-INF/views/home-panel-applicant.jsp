<html>
<head>
<title>Job Board Home</title>
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
<body style="background: url(${pageContext.request.contextPath}/resources/images/Job-Search.jpg);
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
					href="logout.htm">Logout</a></li>
			</ul>
		</div>
		<div class="welcome" style="position: relative; left: 225px; top: 10px; width: 70%;">
			<h1>Welcome to the Quick Apply! <br></h1>
			<h3>Source Code:<br>
			<a href="https://github.com/SwagMC/OneClickJobBoard">https://github.com/SwagMC/OneClickJobBoard</a></h3>
		</div>
	</div>
</body>

</html>
