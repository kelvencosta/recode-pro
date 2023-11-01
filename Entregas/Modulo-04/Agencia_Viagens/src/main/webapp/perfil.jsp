<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="imagens/pro_agency_k5D_icon.ico" type="image/x-icon">
<title>Perfil</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/perfil.css">
</head>
<body>
	<c:if test="${not empty cliente}"></c:if>

	<header>
		<nav class="nav">
			<div class="div-img">
				<img src="imagens/perfil.svg" class="img-perfil">
				<h2 class="h3 text-white">${cliente.nome}</h2>
				<a href="home.html" class="btn btn-block voltar"> Voltar</a>
			</div>

			<div>
				<a href="EditarController?nome=${cliente.nome}"
					class="btn btn-info text-white">Editar</a> <a
					href="ExluirController?cod=${cliente.cod}"
					onclick="return confirm('Deseja Excluir?')" class="btn btn-danger">Excluir</a>
			</div>
		</nav>
	</header>

	<main>
		<section>
			<aside class="container-aside">
				<div class="col-lg-6">
					<div class="card mb-4">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-6">
									<p class="mb-5 h5">CPF</p>
								</div>
								<div class="col-sm-6">
									<p class="text-muted mb-5 h6">${cliente.cpf}</p>
								</div>
							</div>
							<hr class="border border-info">
							<div class="row">
								<div class="col-sm-6">
									<p class="mb-5 h5">RG</p>
								</div>
								<div class="col-sm-6">
									<p class="text-muted mb-5 h6">${cliente.rg}</p>
								</div>
							</div>
							<hr class="border border-info">
							<div class="row">
								<div class="col-sm-6">
									<p class="mb-5 h5">Telefone</p>
								</div>
								<div class="col-sm-6">
									<p class="text-muted mb-5 h6">${cliente.tel}</p>
								</div>
							</div>
							<hr class="border border-info">
							<div class="row">
								<div class="col-sm-6">
									<p class="mb-5 h5">Email</p>
								</div>
								<div class="col-sm-6">
									<p class="text-muted mb-5 h6">${cliente.email}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</aside>
		</section>
	</main>

</body>
</html>