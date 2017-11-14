<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Ученики | Электронная Школа</title>
	
	<!-- /container -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Вы вошли как <b>${pageContext.request.userPrincipal.name}</b> | <a onclick="document.forms['logoutForm'].submit()">Выйти</a></h2>

		<h3>Все ученики: </h3>
		<button type="button" id="#add_pupil_btn"class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal">Добавить ученика</button>

<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Добавить ученика</h4>
        </div>
        
        <div class="modal-body">
	        <form:form method="POST" modelAttribute="pupilForm" class="form-signin">
		        <h2 class="form-heading">Новый ученик:</h2>
		        <spring:bind path="lastName">
		            <div class="form-group ${status.error ? 'has-error' : ''}">
		                <form:input type="text" path="lastName" class="form-control" placeholder="Фамилия"
		                            autofocus="true"></form:input>
		                <form:errors path="lastName"></form:errors>
		            </div>
		        </spring:bind>
		
		        <spring:bind path="firstName">
		            <div class="form-group ${status.error ? 'has-error' : ''}">
		                <form:input type="text" path="firstName" class="form-control" placeholder="Имя"></form:input>
		                <form:errors path="firstName"></form:errors>
		            </div>
		        </spring:bind>
				<div class="modal-footer">
		        	<button class="btn btn-lg btn-primary btn-block" type="submit">Добавить</button>
		        </div>
	        </form:form>
        </div>
        
      </div>
      
    </div>
  </div>

		<table width="100%" class="table table-striped table-bordered" id="pupils_table" cellspacing="0">
			<thead>
	            <tr>
	                <th>Фамилия</th>
	                <th>Имя</th>
	            </tr>
	        </thead>
			<c:forEach items="${pupil_list}" var="item">
 				<tr>
					<td><c:out value="${item.lastName}" /></td>
					<td><c:out value="${item.firstName}" /></td>
 				</tr>
			</c:forEach>
		</table>

    </c:if>

</div>

</body>
</html>
