<jsp:include page="headerGlobal.jsp" />  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex justify-content-center align-items-center">
	
	
	<form:form modelAttribute="userModel" action="doSignup" method="POST" >
	  <h2>Register Here</h2>
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
	  <form:hidden path="action"/>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Username</label>	    
	    <form:input type="text" path="username" class="form-control" id="username"  placeholder="Enter Username" />
	  	<form:errors path="username" cssClass="errors"/>
	  </div>
	  
	  <div class="form-group">
	    <label for="exampleInputEmail1">Password</label>
	    <form:input type="passowrd" path="password" class="form-control" id="password" aria-describedby="password" placeholder="Enter password" />
	  	<form:errors path="email" cssClass="errors"/>
	  </div>
	  
	  <div class="form-group">
	    <label for="exampleInputEmail1">Your Full name</label>
	    <form:input type="text" path="name" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter your fullname" />
	    <form:errors path="name" cssClass="errors"/>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email</label>
	    <form:input type="text" path="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter your email" />
	    <form:errors path="email" cssClass="errors"/>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Role</label>
	    <form:select path="role" class="form-control" id="role" aria-describedby="emailHelp">
	    	<option selected>Open this select menu</option>
			<option value="ROLE_ADMIN">Admin</option>
			<option value="ROLE_USER">User</option>
	    </form:select>
	    <form:errors path="role" cssClass="errors"/>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Date of Birth</label>
	    <form:input type="date" id="dateOfBirth" name="dateOfBirth" path="dateOfBirth" />
	    <form:errors path="name" cssClass="errors"/>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Address</label>
	    <form:input type="text" path="address" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter your address" />
	    <form:errors path="address" cssClass="errors"/>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Country</label>
	    <form:select path="country" items="${ countryList}" onchange="populateStateList()" itemValue="key" itemLabel="value" class="form-control" id="country" aria-describedby="emailHelp" placeholder="Enter your country" />
	    <form:errors path="country" cssClass="errors"/>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">State</label>
	    <form:select path="state" items="${ stateList}"  onchange="populateCityList()" itemValue="key" itemLabel="value"  class="form-control" id="state" aria-describedby="emailHelp" placeholder="Enter your state" />
	    <form:errors path="state" cssClass="errors"/>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">City</label>
	    <form:select path="city" items="${ cityList}" onchange="populateZipcodeList()" itemValue="key" itemLabel="value"  class="form-control" id="city" aria-describedby="emailHelp" placeholder="Enter your state" />
	    <form:errors path="city" cssClass="errors"/>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Zipcode</label>
	     <form:select path="zipcode" items="${ zipcodeList}" onchange="populateAreaList()" itemValue="key" itemLabel="value"  class="form-control" id="zipcode" aria-describedby="emailHelp" placeholder="Enter your email" />
	    <form:errors path="zipcode" cssClass="errors"/>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Area</label>
	     <form:select path="area" items="${ areaList}" itemValue="key" itemLabel="value" class="form-control" id="area" aria-describedby="emailHelp" placeholder="Enter your email" />
	    <form:errors path="area" cssClass="errors"/>
	  </div>
	  
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
<script type="text/javascript">

function populateStateList(){
	var countryName = document.getElementById('country').value;
	ajaxCall('http://localhost:1994/PNPServices/master/stateListArray/'+countryName,populateStateListImpl,'array');
}
function populateStateListImpl(response){
	//console.log('populateStateListImpl----> '+response);
	populatePickList(response,'state');		
}

function populateCityList(){
	var stateName = document.getElementById('state').value;
	if(stateName===null || stateName=='' || stateName=='NULL'){
		alert('Please select state first.');
		return;
	}
	ajaxCall('http://localhost:1994/PNPServices/master/cityListArray/'+stateName,populateCityListImpl,'array');
}
function populateCityListImpl(response){
	//console.log('populateCityListImpl----> '+response);
	populatePickList(response,'city');	
}

function populateZipcodeList(){
	var cityName = document.getElementById('city').value;
	if(cityName===null || cityName=='' || cityName=='--NULL--'){
		alert('Please select city first.');
		return;
	}
	ajaxCall('http://localhost:1994/PNPServices/master/zipcodeListArray/'+cityName,populateZipcodeListImpl,'array');
}

function populateZipcodeListImpl(response){
	console.log('zipcodeListArray----> '+response);
	populatePickList(response,'zipcode');	
}

function populateAreaList(){
	var zipcode = document.getElementById('zipcode').value;
	if(zipcode===null || zipcode=='' || zipcode=='NULL'){
		alert('Please select zipcode first.');
		return;
	}
	ajaxCall('http://localhost:1994/PNPServices/master/areaListArray/'+zipcode,populateAreaListImpl,'array');
}

function populateAreaListImpl(response){
	populatePickList(response,'area');	
}

/* if(document.getElementById('state').value!='UTTAR PRADESH')
{document.getElementById('state').value='UTTAR PRADESH';
document.getElementById('action').value='refresh';
document.getElementById('userModel').submit();
} */
</script>
<jsp:include page="footerGlobal.jsp" /> 