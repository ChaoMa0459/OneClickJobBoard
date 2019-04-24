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
<body>
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
					href="logout.htm">Logout</a></li>
			</ul>
		</div>

		<div class="resume-form"
			style="position: relative; left: 225px; top: 10px; width: 70%;">

			<div class="alert alert-info" role="alert">
				<h4 class="text-center">
					<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
					New Resume Form
				</h4>
			</div>

			<div class="row">

				<form:form commandName="resume" class="form-horizontal">

					<div class="form-group">
						<label for="resumeName" class="col-sm-4 control-label">Resume
							Name:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="resumeName"
								path="resumeName" placeholder="Resume Name" required="required" />
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
						<p class="text-center">Personal Information:</p>
					</div>

					<!-- // basic information
						private String resumeName;
						private String first;
						private String last;
						private String email;
						private String phoneNumber;
						private String skills;
						private String website;
						 -->
					<div class="form-group">
						<label for="first" class="col-sm-4 control-label">First
							Name:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="first"
								path="first" placeholder="First Name" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="last" class="col-sm-4 control-label">Last
							Name:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="last"
								path="last" placeholder="Last Name" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="col-sm-4 control-label">Email:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="email"
								path="email" placeholder="Email" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="phoneNumber" class="col-sm-4 control-label">Phone
							Number:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="phoneNumber"
								path="phoneNumber" placeholder="xxx-xxx-xxxx"
								required="required" />
						</div>
					</div>

					<!-- 	
					// address
					private String addressLine1;
					private String addressLine2;
					private String city;
					private String state;
					private String zipcode;
					 -->

					<div class="form-group">
						<label for="addressLine1" class="col-sm-4 control-label">Address
							Line 1:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="addressLine1"
								path="addressLine1" placeholder="Line 1" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="addressLine2" class="col-sm-4 control-label">Address
							Line 2:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="addressLine2"
								path="addressLine2" placeholder="Line 2" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="city" class="col-sm-4 control-label">City:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="city"
								path="city" placeholder="City" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="state" class="col-sm-4 control-label">State:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="state"
								path="state" placeholder="State" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="zipcode" class="col-sm-4 control-label">Zip
							Code:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="zipcode"
								path="zipcode" placeholder="00000" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="skills" class="col-sm-4 control-label">Skills:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="skills"
								path="skills" placeholder="separated by comma"
								required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="website" class="col-sm-4 control-label">Website:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="website"
								path="website" placeholder="Website" required="required" />
						</div>
					</div>


					<!-- 
	private boolean authorized;
	private boolean needSponsorship;
 -->

					<div class="form-group">
						<label for="authorized" class="col-sm-4 control-label">Are
							you authorized to work in the U.S.? </label>
						<div class="col-sm-8">
							<form:select path="authorized" id="authorized"
								class="form-control">
								<form:option value="yes">Yes</form:option>
								<form:option value="no">No</form:option>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label for="needSponsorship" class="col-sm-4 control-label">Do
							you need sponsorship to work in the U.S. (now or in the future)?
						</label>
						<div class="col-sm-8">
							<form:select path="needSponsorship" id="needSponsorship"
								class="form-control">
								<form:option value="yes">Yes</form:option>
								<form:option value="no">No</form:option>
							</form:select>
						</div>
					</div>

					<!-- 	// education
	private String degree;
	private String university;
	private String major;
	private float gpa; -->

					<div class="alert alert-info">
						<p class="text-center">Education Background:</p>
					</div>

					<div class="form-group">
						<label for="degree" class="col-sm-4 control-label">Highest
							Degree: </label>
						<div class="col-sm-8">
							<form:select path="degree" id="degree" class="form-control">
								<form:option value="Bachelor">Bachelor</form:option>
								<form:option value="Master">Master</form:option>
								<form:option value="PhD">PhD</form:option>
								<form:option value="Other">Other</form:option>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label for="university" class="col-sm-4 control-label">University:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="last"
								path="university" placeholder="university" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="major" class="col-sm-4 control-label">Major:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="major"
								path="major" placeholder="Major" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="gpa" class="col-sm-4 control-label">GPA(out of
							4.0):</label>
						<div class="col-sm-8">
							<form:input type="number" class="form-control" id="gpa" min="0.0"
								max="4.0" step="0.1" path="gpa" placeholder="example: 3.5"
								required="required" />

						</div>
					</div>

					<!-- 	// work experience
	private String title;
	private String company;
	private String workCity;
	private String workDescription;
	private String workLength;
	 -->

					<div class="alert alert-info">
						<p class="text-center">Work Experience:</p>
					</div>

					<div class="form-group">
						<label for="title" class="col-sm-4 control-label">Title:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="title"
								path="title" placeholder="Title" required="required" />
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
						<label for="workCity" class="col-sm-4 control-label">Work
							City:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="workCity"
								path="workCity" placeholder="City" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="workDescription" class="col-sm-4 control-label">Work
							Description:</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" id="workDescription"
								path="workDescription" placeholder="Description"
								required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="workLength" class="col-sm-4 control-label">How long is this work?
						</label>
						<div class="col-sm-8">
							<form:select path="workLength" id="workLength" class="form-control">
								<form:option value="0-1 Year">0-1 Year</form:option>
								<form:option value="1-3 Years">1-3 Years</form:option>
								<form:option value="More Than 3 Years">More Than 3 Years</form:option>
							</form:select>
						</div>
					</div>


					<!-- // self identify
	private String gender;
	private String ifVeteran;
	private String hispanicOrLatino;
	private String race;
	private String ifDisabled;
	 -->

					<div class="alert alert-info">
						<p class="text-center">Self Identify:</p>
					</div>

					<div class="form-group">
						<label for="gender" class="col-sm-4 control-label">Gender:
						</label>
						<div class="col-sm-8">
							<form:select path="gender" id="gender" class="form-control">
								<form:option value="male">Male</form:option>
								<form:option value="female">Female</form:option>
								<form:option value="other">Other</form:option>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label for="ifVeteran" class="col-sm-4 control-label">Are
							you a protected veteran? </label>
						<div class="col-sm-8">
							<form:select path="ifVeteran" id="ifVeteran" class="form-control">
								<form:option value="Yes">Yes</form:option>
								<form:option value="No">No</form:option>
								<form:option value="I don't wish to answer">I don't wish to answer</form:option>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label for="hispanicOrLatino" class="col-sm-4 control-label">Are
							you Hispanic or Latino? </label>
						<div class="col-sm-8">
							<form:select path="hispanicOrLatino" id="hispanicOrLatino"
								class="form-control">
								<form:option value="Yes">Yes</form:option>
								<form:option value="No">No</form:option>
								<form:option value="I don't wish to answer">I don't wish to answer</form:option>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label for="ifDisabled" class="col-sm-4 control-label">Do
							you have disability? </label>
						<div class="col-sm-8">
							<form:select path="ifDisabled" id="ifDisabled"
								class="form-control">
								<form:option value="Yes">Yes</form:option>
								<form:option value="No">No</form:option>
								<form:option value="I don't wish to answer">I don't wish to answer</form:option>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label for="race" class="col-sm-4 control-label">Identify
							your race: </label>
						<div class="col-sm-8">
							<form:select path="race" id="race" class="form-control">
								<form:option value="American Indian or Alaska Native">American Indian or Alaska Native</form:option>
								<form:option value="Asian">Asian</form:option>
								<form:option value="Black or African American">Black or African American</form:option>
								<form:option value="Hispanic or Latino">Hispanic or Latino</form:option>
								<form:option value="White">White</form:option>
								<form:option value="Native Hawaiian or Other Pacific Islander">Native Hawaiian or Other Pacific Islander</form:option>
								<form:option value="Two or More Races">Two or More Races</form:option>
								<form:option value="I don't wish to answer">I don't wish to answer</form:option>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<input type="submit" class="btn btn-success" value="Create" />
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</body>

</html>
