<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/revisionConvocatoria.css"
	type="text/css">
<link rel="stylesheet" href="CSS/revisionConvocatoria.scss"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
	<div class="cover d-flex align-items-center pt-5 bg-primary" id="cover">
		<div class="container">
			<div class="row">
				<div class="col-md-8 text-md-left align-self-center my-5">
					<h1 class="text-white display-1"></h1>
					<h1 class="text-white text-center display-4">
						REVISION DE <br>CONVOCATORIA
					</h1>
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
					<img class="img-fluid d-block mx-auto" src="images/img1.png">
				</div>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-expand-md navbar-light bg-faded">
	<div class="container">
		<form action="AdminServlet" method="post">
			<button class="btn btn-outline-danger" type="submit">Cancelar</button>
		</form>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
			</ul>
		</div>
		<form action="LoginServlet" method="get">
			<button class="btn btn-outline-primary" type="submit">Cerrar Sesion</button>
		</form>
	</div>
	</nav>
	<div class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<form action="NuevaConvServlet" method="post">
							<div class="card-block" id="form">
								<div class="form-group row">
									<div class="col-md-11">
										<h3>Datos de la convocatoria</h3>
										<div class="hidden bg-warning" id="divDatos"
											style="display: none;">
											<label for="comment" class="ml-1">Comentario:</label>
											<textarea class="form-control" rows="5" id="comment"
												name="objetivoConv"></textarea>
										</div>
										<hr>
									</div>
									<div class="col-md-1">
										<a id="datosComent" class="btn btn-warning text-white"> <i
											class="d-block mx-auto fa fa-1x fa-comments"></i>
										</a> <input type="hidden" name="datosComentario" value="0">
									</div>
								</div>
								<div class="form-group">
									<label for="usr" class="">Titulo de convocatoria:</label> <input
										type="text" class="form-control" id="usr" name="tituloConv">
								</div>
								<div class="form-group">
									<label for="comment" class="">Objetivo de convocatoria:</label>
									<textarea class="form-control" rows="5" id="comment"
										name="objetivoConv"></textarea>
								</div>
								<div class="form-group">
									<label for="comment" class="">Bases de la convocatoria:</label>
									<textarea class="form-control" rows="15" id="comment"
										name="basesConv"></textarea>
								</div>
								<div class="form-group">
									<label for="comment" class="">Requisitos de la
										convocatoria:</label>
									<textarea class="form-control" rows="5" id="comment"
										name="requisitosConv"></textarea>
								</div>
								<div class="form-group">
									<label for="comment" class="">Logotipo de la
										convocatoria (PNG o JPG):</label> <input type="file" id="comment"
										class="form-control-file" name="logotipoConv">
								</div>
								<div class="form-group row">
									<div class="col-md-11">
										<h3>Informes de la convocatoria</h3>
										<div class="hidden bg-warning" id="divInformes"
											style="display: none;">
											<label for="comment" class="ml-1">Comentario:</label>
											<textarea class="form-control" rows="5" id="comment"
												name="objetivoConv"></textarea>
										</div>
										<hr>
									</div>
									<div class="col-md-1">
										<a id="informesComent" class="btn btn-warning text-white">
											<i class="d-block mx-auto fa fa-1x fa-comments"></i>
										</a> <input type="hidden" name="informesComentario" value="0">
									</div>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-md-3">
											<label for="usr" class="">Telefono:</label> <input
												type="text" class="form-control" id="usr"
												name="telefonoConv">
										</div>
										<div class="col-md-4">
											<label for="usr" class="">Correo:</label> <input type="text"
												class="form-control" id="usr" name="correoConv">
										</div>
										<div class="col-md-5">
											<label for="usr" class="">Pagina Web:</label> <input
												type="text" class="form-control" id="usr"
												name="paginawebConv">
										</div>
									</div>
									<div class="row">
										<div class="col-md-7">
											<label for="usr" class="">Direccion:</label> <input
												type="text" class="form-control" id="usr"
												name="direccionConv">
										</div>
										<div class="col-md-5">
											<label for="usr" class="">Responsable:</label> <input
												type="text" class="form-control" id="usr"
												name="responsableConv">
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<label for="usr" class="">Fecha de inicio:</label> <input
												type="date" class="form-control" id="usr"
												name="fechaInicioConv">
										</div>
										<div class="col-md-6">
											<label for="usr" class="">Fecha de cierre:</label> <input
												type="date" class="form-control" id="usr"
												name="fechaFinalConv">
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-11">
										<h3>Redes sociales(Enlaces)</h3>
										<div class="hidden bg-warning" id="divRedes"
											style="display: none;">
											<label for="comment" class="ml-1">Comentario:</label>
											<textarea class="form-control" rows="5" id="comment"
												name="objetivoConv"></textarea>
										</div>
										<hr>
									</div>
									<div class="col-md-1">
										<a id="redesComent" class="btn btn-warning text-white"> <i
											class="d-block mx-auto fa fa-1x fa-comments"></i>
										</a> <input type="hidden" name="redesComentario" value="0">
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label for="usr"><i
											class="fa fa-fw fa-facebook-square text-gray-dark fa-lg"></i>Facebook</label>
										<input type="text" class="form-control" id="usr"
											name="facebookConv">
									</div>
									<div class="col-md-3">
										<label for="usr"><i
											class="fa fa-fw text-gray-dark fa-lg fa-twitter-square"></i>Twitter</label>
										<input type="text" class="form-control" id="usr"
											name="twitterConv">
									</div>
									<div class="col-md-3">
										<label for="usr"><i
											class="fa fa-fw text-gray-dark fa-lg fa-youtube-play"></i>Youtube</label>
										<input type="text" class="form-control" id="usr"
											name="youtubeConv">
									</div>
									<div class="col-md-3">
										<label for="usr"><i
											class="fa fa-fw text-gray-dark fa-lg fa-instagram"></i>Instagram</label>
										<input type="text" class="form-control" id="usr"
											name="instagramConv">
									</div>
								</div>
								<div class="form-group"></div>
								<div class="form-group">
									<div class="row">
										<div class="col-md-5"></div>
										<div class="col-md-4">
											<button type="reset" class="btn btn-outline-danger active"
												href="#">Reiniciar</button>
											<button type="submit" class="btn btn-outline-success active"
												href="#">Finalizar</button>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
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
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
		integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
		crossorigin="anonymous"></script>
</body>
<script type="text/javascript">
	$("#datosComent").click(function() {
		$("#divDatos").toggle(500);
	});
	$("#informesComent").click(function() {
		$("#divInformes").toggle(500);
	});
	$("#redesComent").click(function() {
		$("#divRedes").toggle(500);
	});
</script>
</html>