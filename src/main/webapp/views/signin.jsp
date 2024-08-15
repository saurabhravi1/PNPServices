<jsp:include page="headerGlobal.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="vh-100">
	<div class="container py-5 h-100">
		<div
			class="row d-flex align-items-center justify-content-center h-100">
			<div class="col-md-8 col-lg-7 col-xl-6">
				<img
					src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
					class="img-fluid" alt="Phone image">
			</div>
			<div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
				<form:form action="signin" method="POST" modelAttribute="userModel">
					<div class="form-outline mb-4">
						<form:input path="username" type="text" id="username"
							class="form-control form-control-lg" />
						<label class="form-label" for="form1Example13">Username</label>
					</div>

					<!-- Password input -->
					<div class="form-outline mb-4">
						<form:input path="password" type="password" id="form1Example23"
							class="form-control form-control-lg" />
						<label class="form-label" for="form1Example23">Password</label>
					</div>
					<%-- <div class="form-group">
						<label for="exampleInputEmail1">Role</label>
						<form:select path="role" class="form-control" id="role"
							aria-describedby="emailHelp">						
							<option value="ADMIN">Admin</option>
							<option selected value="USER">User</option>
						</form:select>
						<form:errors path="role" cssClass="errors" />
					</div> --%>
					<div class="d-flex justify-content-around align-items-center mb-4">
						<!-- Checkbox -->
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value=""
								id="form1Example3" checked /> <label class="form-check-label"
								for="form1Example3"> Remember me </label>
						</div>
						<a href="#!">Forgot password?</a>
					</div>

					<!-- Submit button -->
					<button type="submit" class="btn btn-primary btn-lg btn-block"
						onclick="return loginFunction();">Sign in</button>

					<div class="divider d-flex align-items-center my-4">
						<p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
					</div>

					<a class="btn btn-primary btn-lg btn-block"
						style="background-color: #3b5998" href="#!" role="button"> <i
						class="fab fa-facebook-f me-2"></i>Continue with Facebook
					</a>
					<a class="btn btn-primary btn-lg btn-block"
						style="background-color: #55acee" href="#!" role="button"> <i
						class="fab fa-twitter me-2"></i>Continue with Twitter
					</a>

				</form:form>
			</div>
		</div>
	</div>
</section>
<jsp:include page="footerGlobal.jsp" />
