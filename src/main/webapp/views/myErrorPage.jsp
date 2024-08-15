<jsp:include page="headerGlobal.jsp" />  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="banner d-flex justify-content-center align-items-center">
	<div class="text-center">
		<h1  class="font-weight-bold">My ERP</h1>
		<p>Op's you got an exception. Kindly connect with Administrator.<br> 
			Exception Name : ${expName }<br>
			Requested URL : ${reqURL }		
		</p>
	<button class="btn btn-primary btn-lg" >Get Started</button>
	</div>
</div>
<jsp:include page="footerGlobal.jsp" />  