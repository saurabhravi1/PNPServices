<jsp:include page="header.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="banner d-flex justify-content-center align-items-center">

<div class="container">
	<div class="row">
	    
	    <div class="col-md-8 col-md-offset-2">
	        
    		<h1>Create/Update Job</h1>
    		<form:form action="${contextPath}/user/saveJob" modelAttribute="jobModel" method="POST">
    		    <form:hidden path="id"/>
    		    <c:if test="${sessionScope.responseMessage.type=='alert-success'}">
    		    
					<div class="lert alert-success" role="alert">
			  			<c:out value="${sessionScope.responseMessage.message}"></c:out>
					</div>
				</c:if>
				<c:if test="${sessionScope.responseMessage.type=='alert-error'}">
					<div class="alert alert-danger" role="alert">
			  			<c:out value="${sessionScope.responseMessage.message}"></c:out>
					</div>
				</c:if>
    		    
    		    
    		    
    		    <div class="form-group has-error">
    		        <label for="Title">Title <span class="require">*</span> <small>(Enter your job title.)</small></label>
    		        <form:input type="text" path="title"  class="form-control" id="title" />
    		        <form:errors path="title" cssClass="errors"/>
    		    </div>
    		    
    		    <div class="form-group has-error">
    		        <label for="Job Description">Job Description <span class="require">*</span> <small>(Enter your job description.)</small></label>
    		        <form:textarea path="description"  class="form-control" id="description" />
    		        <form:errors path="description" cssClass="errors"/>
    		    </div>
    		    
    		    <div class="form-group has-error">
    		        <label for="Start Date">Job Start Date <span class="require">*</span> <small>(Enter your job start date.)</small></label>
    		        <form:input type="date" path="startdate"  class="form-control" id="startdate" />
    		        <form:errors path="startdate" cssClass="errors"/>
    		    </div>
    		    <div class="form-group has-error">
    		        <label for="end Date">Job End Date <span class="require">*</span> <small>(Enter your job end date.)</small></label>
    		        <form:input type="date" path="endDate"  class="form-control" id="endDate" />
    		        <form:errors path="endDate" cssClass="errors"/>
    		    </div>    		 
    		    
    		    <div class="form-group has-error">
	    			<label for="Required">Required <span class="require">*</span> <small>(Select your requirement.)</small></label>
	    			<form:select path="required" items="${ jobRequiredList}" itemValue="key" itemLabel="value" class="form-control" id="required" aria-describedby="emailHelp" />
	    			<form:errors path="required" cssClass="errors"/>
	  			</div>
	  			<div class="form-group has-error">
	    			<label for="Required">Services <span class="require">*</span> <small>(Select services required/provided.)</small></label>
	    			<form:select path="services"  items="${serviceList}" itemValue="key" itemLabel="value" class="form-control" id="required" aria-describedby="emailHelp" />
	    			<form:errors path="required" cssClass="errors"/>
	  			</div>
    		    <div class="form-group">
    		        <p><span class="require">*</span> - required fields</p>
    		    </div>

				<div class="form-group">
					<button type="submit" class="btn btn-primary">Create</button>
				</div>

				</form:form>
    		
		</div>
		
	</div>
</div>
</div>  
<jsp:include page="footer.jsp" />