<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ex_2.model.Pais, java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Lista de Paises</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container principal -->
	<div id="main" class="container">
		<h3 class="page-header">Lista de Paises</h3>
		<div class="table-responsive">
			<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>População</th>
						<th>Area</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="pais" items="${paises}">
						<tr>
							<td>${pais.id }</td>
							<td>${pais.nome }</td>
							<td>${pais.populacao }</td>
							<td>${pais.area }</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="index.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>