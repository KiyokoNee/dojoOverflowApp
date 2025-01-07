<!-- Main page body template -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Question</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css" />
    	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1>What is your question?</h1>
		<a href="/">Dashboard</a>
		<form:form class="full-form" modelAttribute="newQuestion" method="post" action="/questions/add" >
			<span class="text-danger"><form:errors path="text" /></span>
			<div class="d-flex justify-content-between">
				<form:label path="text">Question: </form:label>
				<form:input path="text" />
			</div>	
			<span class="text-danger"><form:errors path="tagInput" /></span>
			<div class="d-flex justify-content-between">
				<form:label path="tagInput">Author: </form:label>
				<form:input path="tagInput" />
			</div>
			<button class="btn btn-primary float-end" type="submit">Submit</button>
		</form:form>
	</body>
</html>