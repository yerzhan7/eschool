<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/pupils.js"></script>

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
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h3>
				Вы вошли как <b>${pageContext.request.userPrincipal.name}</b> | <a
					onclick="document.forms['logoutForm'].submit()">Выйти</a>
			</h3>
			<button type="button" class="btn btn-info btn-md" data-toggle="modal"
				data-target="#addPupil" id="add_pupil">Добавить ученика</button>

			<h3>Все ученики:</h3>

			<!-- Add Pupil Modal -->
			<div class="modal fade" id="addPupil" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Добавить ученика</h4>
						</div>

						<div class="modal-body">
							<form:form method="POST" action="/pupils" modelAttribute="pupilForm"
								class="form-signin">
								<h2 class="form-heading">Новый ученик:</h2>
								<spring:bind path="lastName">
									<div class="form-group ${status.error ? 'has-error' : ''}">
										<form:input type="text" path="lastName" class="form-control"
											placeholder="Фамилия" autofocus="true"></form:input>
										<form:errors path="lastName"></form:errors>
									</div>
								</spring:bind>

								<spring:bind path="firstName">
									<div class="form-group ${status.error ? 'has-error' : ''}">
										<form:input type="text" path="firstName" class="form-control"
											placeholder="Имя"></form:input>
										<form:errors path="firstName"></form:errors>
									</div>
								</spring:bind>

								<spring:bind path="schoolClass">
									<div class="form-group ${status.error ? 'has-error' : ''}">
										<form:input type="text" path="schoolClass"
											class="form-control" placeholder="Класс"></form:input>
										<form:errors path="schoolClass"></form:errors>
									</div>
								</spring:bind>

								<div class="modal-footer">
									<button class="btn btn-lg btn-info btn-block" type="submit">Добавить</button>
								</div>
							</form:form>
						</div>

					</div>
				</div>
			</div>

			<!-- Delete Pupil Modal -->
			<div class="modal fade" id="deletePupil" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Удалить ученика?</h4>
						</div>

						<div class="modal-body">
							Вы действительно хотите удалить <span id="modal_pupil_id"
								style="font-weight: bold"></span>?
							<form:form id="delete_form" method="DELETE">

								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Отмена</button>
									<button class="btn btn-danger btn-ok" type="submit">Удалить</button>
								</div>
							</form:form>
						</div>

					</div>
				</div>
			</div>

			<table width="100%" class="table table-striped table-bordered"
				id="pupils_table" cellspacing="0">
				<thead>
					<tr>
						<th>Фамилия</th>
						<th>Имя</th>
						<th>Класс</th>
					</tr>
				</thead>
				<c:forEach items="${pupil_list}" var="item">
					<tr>
						<td><c:out value="${item.lastName}" /></td>
						<td><c:out value="${item.firstName}" /></td>
						<td><c:out value="${item.schoolClass}" /></td>
						<td><button class="btn btn-danger btn-sm delete_pupil"
								data-toggle="modal" data-target="#deletePupil"
								data-id="${item.id}" data-firstname="${item.firstName}"
								data-lastname="${item.lastName}" type="button">Удалить</button></td>
					</tr>
				</c:forEach>
			</table>

		</c:if>

	</div>

	<c:if test="${error == true}">
		<script>
			// Simulate click on button to review errors
			$("#add_pupil").trigger('click');
		</script>
	</c:if>

</body>
</html>
