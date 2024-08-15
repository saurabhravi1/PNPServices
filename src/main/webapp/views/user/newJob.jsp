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
	    <label for="exampleInputEmail1">Address</label>
	    <form:input type="text" path="address" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter your address" />
	    <form:errors path="address" cssClass="errors"/>
	  </div>
	  <div class="form-group has-error">
	    <label for="exampleInputEmail1">Country</label>
	    <form:select path="country" items="${ countryList}" itemValue="key" itemLabel="value" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter your country" />
	    <form:errors path="country" cssClass="errors"/>
	  </div>
	  <div class="form-group has-error">
	    <label for="exampleInputEmail1">State</label>
	    <form:select path="state" items="${ stateList}" itemValue="key" itemLabel="value" onchange="refresh()" class="form-control" id="state" aria-describedby="emailHelp" placeholder="Enter your state" />
	    <form:errors path="state" cssClass="errors"/>
	  </div>
	  <div class="form-group has-error">
	    <label for="exampleInputEmail1">City</label>
	    <form:select path="city" items="${ cityList}" itemValue="key" itemLabel="value" onchange="refresh()" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter your state" />
	    <form:errors path="city" cssClass="errors"/>
	  </div>
	  <div class="form-group has-error">
	    <label for="exampleInputEmail1">Zipcode</label>
	     <form:select path="zipcode" items="${ zipcodeList}" itemValue="key" itemLabel="value" onchange="refresh()" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter your email" />
	    <form:errors path="zipcode" cssClass="errors"/>
	  </div>
	  <div class="form-group has-error">
	    <label for="exampleInputEmail1">Area</label>
	     <form:select path="area" items="${ areaList}" itemValue="key" itemLabel="value" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter your email" />
	    <form:errors path="area" cssClass="errors"/>
	  </div>
				<div class="form-group has-error">
					<button type="submit" class="btn btn-primary">Create</button>
				</div>

				</form:form>
    		
		</div>
		
	</div>
</div>
</div>  

<script type="text/javascript">
function refresh(){
	document.getElementById('action').value='refresh';
	document.getElementById('userModel').submit();
}
if(document.getElementById('state').value!='UTTAR PRADESH')
{document.getElementById('state').value='UTTAR PRADESH';
document.getElementById('action').value='refresh';
document.getElementById('userModel').submit();
}
</script>
<jsp:include page="footer.jsp" />