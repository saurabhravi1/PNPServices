<jsp:include page="header.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="banner d-flex justify-content-center align-items-center">

	
</div>
<div class="container">
		<div class="row">

			<div class="col-md-8 col-md-offset-2">

				<h1>View All Jobs</h1>
				<c:if test="${sessionScope.responseMessage.type=='alert-success'}">
    		    
					<div class="alert alert-success" role="alert">
			  			<c:out value="${sessionScope.responseMessage.message}"></c:out>
					</div>
				</c:if>
				<c:if test="${sessionScope.responseMessage.type=='alert-error'}">
					<div class="alert alert-danger" role="alert">
			  			<c:out value="${sessionScope.responseMessage.message}"></c:out>
					</div>
				</c:if>
				<table class="table table-striped table-dark">
					<thead>
						<tr>
							<th scope="col">#Id</th>
							<th scope="col">Title</th>
							<th scope="col">Description</th>
							<th scope="col">Status</th>
							<th scope="col">Required</th>
							<th scope="col">Services</th>
							<th scope="col">Created Date</th>
							<th scope="col">User id</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allJobList}" var="job">
							<tr>
								
								<th scope="row">${job.id }</th>
								<td>${job.title }</td>
								<td>${job.description }</td>
								<td>${job.status }</td>
								<td>${job.required }</td>
								<td>
									<c:forEach var="temp" items="${job.services}">
								       ${temp},
								    </c:forEach>
								</td>
								<td>${job.createdDate }</td>
								<td>${job.user_id }</td>
								<td><a href="${contextPath}/user/update/${job.id }">Update</a></td>
								<td><a href="${contextPath}/user/delete/${job.id }">Delete</a></td>
								<td><a href="${contextPath}/user/clone/${job.id }">Copy</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

		</div>
	</div>
<jsp:include page="footer.jsp" />