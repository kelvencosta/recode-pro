<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="imagens/pro_agency_k5D_icon.ico"
	type="image/x-icon">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/cadastro-editar.css">
<link rel="stylesheet" href="css/bootstrap.css">
<title>cadastro</title>
</head>
<body class="body">
	<div class="registration-form">
		<form action="CriarController" method="post">
			<div class="form-icon">
				<span><i class="icon icon-user"></i></span>
			</div>
			<div class="form-group">
				<input class="form-control item" type="text" id="nome" name="nome"
					placeholder="Nome" required>
			</div>
			<div class="form-group">
				<input class="form-control item" type="text" id="cpf" name="cpf"
					placeholder="CPF" required>
			</div>
			<div class="form-group">
				<input class="form-control item" type="text" id="rg" name="rg"
					placeholder="RG" required>
			</div>
			<div class="form-group">
				<input class="form-control item" type="tel" id="tel" name="tel"
					placeholder="Telefone" required>
			</div>
			<div class="form-group">
				<input class="form-control item" type="email" id="email"
					name="email" placeholder="Email" required>
			</div>
			<div class="form-group">
				<input class="form-control item" type="password" id="senha"
					name="senha" placeholder="Senha" required>

			</div>
			<div class="form-group div-buttons">
				<input onClick="salvaNome()" type="submit" value="Cadastrar Cliente"
					class="btn btn-block create-account"> <a href="home.html"
					class="btn btn-block create-account"> Voltar</a>
			</div>
		</form>
	</div>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>


	<script>
		$(document).ready(function() {
			$('#cpf').mask('000.000.000-00');
			$('#tel').mask('(00)0000-0000');
		})

		function salvaNome() {
			var nome = document.getElementById("nome").value;
			document.cookie = "nome=" + nome;
		}
	</script>
</body>
</html>