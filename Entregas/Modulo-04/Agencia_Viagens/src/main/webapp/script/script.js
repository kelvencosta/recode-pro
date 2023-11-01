 function getCookie(name) {
			var value = "; " + document.cookie;
			var parts = value.split("; " + name + "=");
			if (parts.length == 2) return parts.pop().split(";").shift();
		}

		var nome = getCookie("nome");
		
		if (nome) {
			var perfilLink = document.getElementById('perfilLink');
			perfilLink.href += nome;
		}