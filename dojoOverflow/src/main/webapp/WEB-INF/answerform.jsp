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
		<title>Question</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css" />
    	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1><c:out value="${question.text}"></c:out></h1>
		<a href="/">Dashboard</a>
		<div>
			<h2>Tags:</h2>
			<c:forEach var="tag" items="${question.tags}">
				<button><c:out value="${tag.subject}"></c:out></button>
			</c:forEach>
		</div>
		<div class="d-flex justify-content-between">
			<div>
				<h2>Answers:</h2>
				<ul>
					<c:forEach var="answer" items="${question.answers}">
						<li><c:out value="${answer.text}"></c:out></li>
					</c:forEach>
				</ul>
			</div>
			<div>
				<h2>Add your answer:</h2>
				<form:form class="full-form" modelAttribute="newAnswer" method="post" action="/questions/${question.id}/answer" >	
					<input type="hidden" id="question" name="question" value="${question.id}" />
					<span class="text-danger"><form:errors path="text" /></span>
					<div class="d-flex justify-content-between">
						<form:label path="text">Answer: </form:label>
						<textarea id="text" name="text"></textarea>
					</div>
					
					<button class="btn btn-primary float-end" type="submit">Submit</button>
				</form:form>
			</div>
		</div>
	</body>
</html>