<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/home.css" type="text/css">
<link rel="stylesheet" href="CSS/home.scss" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Home</title>
</head>
<%
	String msjErrorUser = (String) request.getAttribute("msjErrorUser");
	String msjErrorPass = (String) request.getAttribute("msjErrorPass");
%>
<input type="hidden" id="msjErrorUser" value="<%=msjErrorUser%>">
<input type="hidden" id="msjErrorPass" value="<%=msjErrorPass%>">
<body class="">
	<div class="modal" id="login-modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h4 class="modal-title" id="centrar">Iniciar Sesion</h4>
					<button class="close" data-dismiss="modal" type="button">×</button>
				</div>
				<form class="" method="post" action="LoginServlet">
					<div class="modal-body">

						<div class="form-group text-left" id="userDiv">
							<label class="">Usuario</label> <input id="user" type="text"
								class="form-control" placeholder="Ingresa tu usuario"
								name="usuario">
						</div>
						<div class="form-group text-left" id="passDiv">
							<label>Contraseña</label> <input id="pass" type="password"
								class="form-control" placeholder="Ingresa tu contraseña"
								name="password">
						</div>

					</div>
					<div class="modal-footer bg-faded">
						<a class="btn btn-default active" data-dismiss="modal">Cancelar</a>
						<button class="btn btn-primary btn-send text-white" type="submit">Iniciar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal" id="send-modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h4 class="modal-title" id="centrar">Enviar Convocatoria</h4>
					<button class="close" data-dismiss="modal" type="button">×</button>
				</div>
				<form class="" method="post" action="EmailServlet">
					<div class="modal-body">

						<div class="form-group text-left" id="userDiv">
							<label class="">E-mail</label> <input id="user" type="text"
								class="form-control" placeholder="Ingresa tu E-mail"
								name="email">
							<input type="hidden" name="idConvocatoria" id="idConvocatoria">
						</div>

					</div>
					<div class="modal-footer bg-faded">
						<a class="btn btn-default active" data-dismiss="modal">Cancelar</a>
						<button class="btn btn-primary btn-send text-white" type="submit">Enviar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="cover d-flex align-items-center pt-5 bg-primary" id="cover">
		<div class="container">
			<div class="row">
				<div class="col-md-8 text-md-left align-self-center my-5">
					<h1 class="text-white display-1"></h1>
					<h1 class="text-white text-center display-3">CONVOCATORIAS</h1>
					<p class="lead text-white text-center">Encuentra la
						convocatoria que tanto estas buscando</p>
					<div class="row mt-5">
						<div class="col-md-5 col-6">
							<a href="#download"></a>
						</div>
						<div class="col-md-5 col-6">
							<a href="#download"></a>
						</div>
					</div>
				</div>
				<div class="col-md-4 ">
					<img class="img-fluid d-block mx-auto" src="images/img1.png" />
				</div>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-expand-md navbar-light bg-faded">
	<div class="container">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<form class="form-inline my-lg-0">
				<input class="form-control mr-sm-2" type="text"
					placeholder="Buscar Convocatoria">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
			</form>
			<ul class="navbar-nav mr-auto">
			</ul>
		</div>
		<a href="#" class="btn btn-outline-primary center-block"
			data-target="#login-modal" data-toggle="modal">Iniciar sesion</a>
	</div>
	</nav>
	<div class="py-5  section">
		<div class="container">
			<c:forEach items="${convocatorias}" var="convocatoria">
				<c:if test="${convocatoria.estado == 'Autorizada'}">
					<div class="row">
						<div class="col-md-2">
							<img
								src="http://cie.up.edu.mx/sites/default/files/tipo-recurso-documento.png"
								class="img-fluid mx-auto rounded-circle">
						</div>
						<div class="col-md-7">
							<h1 class="text-primary">
								<c:out value="${convocatoria.titulo}" />
							</h1>
							<p class="lead">
								<c:out value="${fn:substring(convocatoria.objetivo, 0, 280)}" />
							</p>
						</div>
						<div class="col-md-2 text-center" id="centrar">
							<a href="#" onclick="sendMail(${convocatoria.idConvocatoria})" class="btn btn-outline-primary center-block"
								data-target="#send-modal" data-toggle="modal">Enviar
								Convocatoria</a>
						</div>
					</div>
					<hr>
				</c:if>
			</c:forEach>
			<div class="row">
				<div class="col-md-1 text-center" id="centrar">
					<ul class="pagination pagination-sm text-center">
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Previous"> <span aria-hidden="true">«</span> <span
								class="sr-only">Previous</span>
						</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Next"> <span aria-hidden="true">»</span> <span
								class="sr-only">Next</span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="py-5 section bg-faded text-center" id="download">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<img class="img-fluid d-block mx-auto"
						src="http://servicios.ucuauhtemoc.edu.mx/site/images/logos_descargas/logo_nuevo_uca.jpg">
				</div>
				<div class="col-md-6">
					<h1 class="">"ENCUENTRA LA MEJOR CONVOCATORIA"</h1>
					<a target="blank"><i
						class="fa fa-fw fa-check-square-o text-primary fa-3x"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="bg-info py-4" id="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<p class="text-left lead">¿Quieres estar al tanto de las nuevas
						convocatorias? Suscribete y te mantendremos informado.</p>
					<form class="form-inline">
						<div class="form-group">
							<input type="email" class="form-control"
								placeholder="Tu e-mail aqui">
						</div>
						<button type="submit" class="btn btn-primary">Suscribete</button>
					</form>
				</div>
				<div class="col-4 col-md-1 align-self-center">
					<a href="https://github.com/JMGama" target="blank"><i
						class="fa fa-fw fa-3x text-white fa-github"></i></a>
				</div>
				<div class="col-4 col-md-1 align-self-center">
					<a
						href="https://www.linkedin.com/in/jos%C3%A9-manuel-gama-estrada-97b4b6125/"
						target="blank"><i
						class="fa fa-fw fa-3x text-white fa-linkedin-square"></i></a>
				</div>
				<div class="col-4 col-md-1 align-self-center">
					<a href="https://twitter.com/JoseGama196" target="blank"><i
						class="fa fa-fw text-white fa-3x fa-twitter"></i></a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 my-3">
					<p>© Copyright 2017 José Manuel Gama Estrada - All rights
						reserved.</p>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
	<script
		src="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-alpha.6.min.js"></script>
	<script src="https://pingendo.com/assets/scripts/smooth-scroll.js"></script>

	<script type="text/javascript">
		if ($('#msjErrorUser').val() == "1") {
			$('#login-modal').modal();
			$('#user').attr('class', 'form-control form-control-danger');
			$('#userDiv').attr('class', 'form-group text-left has-danger');
		} else if ($('#msjErrorUser').val() != "") {
			$('#login-modal').modal();
			$('#user').val($('#msjErrorUser').val());
			$('#user').attr('class', 'form-control form-control-success');
			$('#userDiv').attr('class', 'form-group text-left has-success');
		}

		if ($('#msjErrorPass').val() == "1") {
			$('#login-modal').modal();
			$('#pass').attr('class', 'form-control form-control-danger');
			$('#passDiv').attr('class', 'form-group text-left has-danger');
		}
		
		function sendMail(id) {
		    $('#idConvocatoria').val(id);
		}
		
	</script>
</body>

</html>