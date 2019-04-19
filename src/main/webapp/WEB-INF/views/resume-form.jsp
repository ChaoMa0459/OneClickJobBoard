<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Job Board Resume Form</title>
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
			style="width: 200px; height: auto; position: absolute; left: 25px; top: 10px;">
			<ul class="nav nav-pills nav-stacked" role="tablist"
				style="width: 200px; position: absolute; left: 25px; top: 10px;">
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="homepanel.htm">Home</a></li>
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="viewresume.htm">View Resumes</a></li>
				<li class="active"
					style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="createresume.htm">Create New Resume</a></li>
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="jobs.htm">Apply for Jobs</a></li>
				<li style="border: 1px solid #337ab7; border-radius: 6px;"><a
					href="login.htm">Logout</a></li>
			</ul>
		</div>

		<div class="resume-form" style="position: relative; left: 225px; top: 10px; width: 70%;">

			<div class="alert alert-info" role="alert">
				<h4 class="text-center">
					<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
					New Resume Form
				</h4>
			</div>

			<div class="row">

				<form:form commandName="resume" class="form-horizontal">

					<div class="form-group">
						<label for="resumeName" class="col-sm-4 control-label">Resume Name:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="resumeName"
								path="resumeName" placeholder="Resume Name" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="first" class="col-sm-4 control-label">First Name:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="first"
								path="first" placeholder="First Name" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="gender" class="col-sm-4 control-label">Gender: </label>
						<div class="col-sm-8">
							<form:select path="gender" id="gender" class="form-control">
								<form:option value="male">Male</form:option>
								<form:option value="female">Female</form:option>
								<form:option value="other">Other</form:option>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<input type="submit" class="btn btn-success" value="Create" />
						</div>
					</div>
<!-- 
	// basic information
	@Column
	private String resumeName;
	@Column
	private String first;
	@Column
	private String last;
	@Column
	private String email;
	@Column
	private String phoneNumber;
	@Column
	private String skills;
	@Column
	private String website;
	@Column
	private boolean authorized;
	@Column
	private boolean needSponsorship;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	// address
	@Column
	private String addressLine1;
	@Column
	private String addressLine2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zipcode;
	
	// education
	@Column
	private String degree;
	@Column
	private String university;
	@Column
	private String major;
	@Column
	private float gpa;
	
	// work experience
	@Column
	private String title;
	@Column
	private String company;
	@Column(name = "work_city")
	private String workCity;
	@Column(name = "work_description")
	private String workDescription;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	
	// self identify
	@Column
	private String gender;
	@Column
	private boolean ifVeteran;
	@Column
	private boolean hispanicOrLatino;
	@Column
	private String race;
	@Column
	private boolean ifDisabled;
 -->
				</form:form>
			</div>
		</div>
	</div>
</body>

</html>
