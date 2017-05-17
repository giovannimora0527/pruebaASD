<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="bootstrap-3.3.7/dist/css/bootstrap.min.css"> -->
<!-- <link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" -->
<!-- 	rel="stylesheet"></link> -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<title>Activos Fijos</title>
</head>
<body>
	<br>
	<div class="container">
		<div class="row">
			<h1>M�dulo de creaci�n de activos</h1>
			<label>Ingrese los datos a continuaci�n</label>
		</div>
	</div>

	<div class="container">
		<c:url var="addAction" value="/activo/add"></c:url>
		<form:form action="${addAction}" modelAttribute="activo">
			<table class="table table-bordered table-condensed table-stripped">
				<c:if test="${activo.id == 0}">
					<tr>
						<td><b>* NOMBRE</b></td>
						<td><form:input path="activo" cssClass="form-control"
								required="true" />
						<td><b>DESCRIPCION</b></td>
						<td><form:textarea path="descripcion" rows="5" cols="30"
								cssClass="form-control" style="overflow: auto; resize: none" />
						</td>
						<td><b>* TIPO DE ACTIVO</b></td>
						<td><form:select path="tipo" cssClass="form-control"
								id="tiposelect">
								<form:option value="NONE" label="--- Seleccione una opci�n ---" />
								<form:options items="${activoTipo}" />
							</form:select></td>
					</tr>
					<tr>
						<td><b>* SERIAL</b></td>
						<td colspan="3"><form:input path="serial"
								cssClass="form-control" required="true" />
						<td><b>* NUMERO DE INVENTARIO</b></td>
						<td colspan="3"><form:input path="numInventario"
								cssClass="form-control" required="true" />
					</tr>
					<tr>
						<td><b>PESO</b></td>
						<td><form:input path="peso" cssClass="form-control" />
						<td><b>ALTO</b></td>
						<td><form:input path="alto" cssClass="form-control" />
						<td><b>ANCHO</b></td>
						<td><form:input path="ancho" cssClass="form-control" />
					</tr>
					<tr>
						<td><b>LARGO</b></td>
						<td><form:input path="largo" cssClass="form-control" />
						<td><b>* FECHA DE COMPRA</b></td>
						<td><form:input path="fechaCompra" type="date"
								cssClass="form-control" required="true" /></td>
						<td><b>FECHA DE BAJA</b></td>
						<td><form:input path="fechaBaja" type="date"
								cssClass="form-control" /></td>
					</tr>
				</c:if>
			</table>
			<c:if test="${(activo.id == 0)}">
				<input type="submit" class="btn btn-primary"
					value="<spring:message text="Guardar"/>" />
			</c:if>
		</form:form>
		<c:url var="editarAction" value="/activo/edit"></c:url>
		<form:form action="${editarAction}" modelAttribute="activo">
			<c:if test="${!(activo.id == 0)}">
				<table class="table table-striped table-condensed table-bordered">
					<tr>
						<td><label>Id: </label></td>
						<td><form:input path="id" readonly="true" disabled="true"
								cssClass="form-control" /></td>
						<td><label>Serial: </label></td>
						<td><form:input path="serial" cssClass="form-control" /> <form:hidden
								path="id" /></td>
						<td><label>Id: </label></td>
						<td><b>FECHA DE BAJA</b></td>
						<td><form:input path="fechaBaja" type="date"
								cssClass="form-control" /> 
						</td>
					</tr>
				</table>
				<c:if test="${!(activo.id == 0)}">
					<input type="submit" class="btn btn-primary"
						value="<spring:message text="Editar Activo"/>" />
				</c:if>
			</c:if>
		</form:form>




		<br> <br>
		<h3>Lista de Activos</h3>
		<table class="table table-bordered table-striped table-condensed">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Serial</th>
					<th>N�m. Inventario</th>
					<th>Fecha de Compra</th>
					<th>Fecha de Baja</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listActivos}" var="activo">
					<tr>
						<td><c:out value="${activo.activo}" escapeXml="false" /></td>
						<td><c:out value="${activo.serial}" escapeXml="false" /></td>
						<td><c:out value="${activo.numInventario}" escapeXml="false" /></td>
						<td><c:out value="${activo.fechaCompra}" escapeXml="false" /></td>
						<td><c:out value="${activo.fechaBaja}" escapeXml="false" /></td>
						<td align="center"><a
							href="<c:url value='/edit/${activo.id}' />"> <span
								class="glyphicon glyphicon-edit"></span>
						</a> <a href="<c:url value='/remove/${activo.id}' />"> <span
								class="glyphicon glyphicon-remove"></span>
						</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript" src="jquery/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src='bootstrap-3.3.7/dist/js/bootstrap.min.js'></script>
<script src="webjars/jquery/3.2.0/jquery.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</html>