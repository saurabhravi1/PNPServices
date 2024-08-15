<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="${contextPath}/css/style.css" />
    <title>${projectName}</title>
  </head>
  <body>
    <!--Navbar Start-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="home">${projectName}</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto text-uppercase">
   
	  <li class="nav-item active">      
    	<input type="search" id="form1" class="form-control" />   

       <%--  <a class="nav-link" href="${contextPath}/user/home">Home <span class="sr-only">(current)</span></a> --%>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${contextPath}/user/home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
      	<a class="nav-link" href="${contextPath}/user/newJob">New Job</a>
      </li>
      <li class="nav-item">
      	<a class="nav-link" href="${contextPath}/user/userAllJobs">My Jobs</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/user/signup">Sign Up</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/user/about">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/logout">Logout</a>
      </li>
      
      
    </ul>
    
  </div>
</nav>
    <!-- Navbar End -->

    