<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ônibus - BusEye</title>
<link rel="shortcut icon" href="./fav.ico?" type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet" href="./css/form.css">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
(function($) {
  $.fn.inputFilter = function(inputFilter) {
    return this.on("input keydown keyup mousedown mouseup select contextmenu drop", function() {
      if (inputFilter(this.value)) {
        this.oldValue = this.value;
        this.oldSelectionStart = this.selectionStart;
        this.oldSelectionEnd = this.selectionEnd;
      } else if (this.hasOwnProperty("oldValue")) {
        this.value = this.oldValue;
        this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
      } else {
        this.value = "";
      }
    });
  };
}(jQuery));

$(document).ready(function() {
  $("#localizacao").inputFilter(function(value) {
	return /^[a-z, ç, á, à, ã, â, é, è, ê, í, ì, î, õ, ó, ò, ô, ú, ù, û, 0-9, ,, ., -]*$/i.test(value);
  });
});
</script>
</head>
<body>
  <header class="py-3">
    <div class="d-flex justify-content-between px-3">
      <a href="/Sprint4-POO/home" class="me-3">
        <img class="img-fluid navbar-brand" alt="BusEye logo" src="./fav.ico" width="125">
      </a>
      <ul class="my-auto p-0 d-flex flex-wrap justify-content-end">
        <li class="nav-item">
          <a class="nav-link p-1" href="https://facebook.com" target="_blank" title="Facebook">
            <span class="redes-sociais fab fa-facebook"></span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link p-1" href="https://instagram.com" target="_blank" title="Instagram">
            <span class="redes-sociais fab fa-instagram"></span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link p-1" href="https://youtube.com" target="_blank" title="YouTube">
            <span class="redes-sociais fab fa-youtube"></span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link p-1" href="https://reddit.com" target="_blank" title="Reddit">
            <span class="redes-sociais fab fa-reddit"></span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link p-1" href="https://twitter.com" target="_blank" title="Twitter">
            <span class="redes-sociais fab fa-twitter"></span>
          </a>
        </li>
      </ul>
    </div>
  </header>
  
  <nav class="text-center py-2">
    <div class="container">
      <h4>Menu</h4>
      <div>
    	<div class="btn-group mb-2">
    	  <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      		Funcionário
    	  </button>
    	  <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      		<li><a class="dropdown-item" href="/Sprint4-POO/formFuncionario">Formulário</a></li>
      		<li><a class="dropdown-item" href="/Sprint4-POO/listaFuncionarios">Lista</a></li>
    	  </ul>
  		</div>
    	<div class="btn-group mb-2">
    	  <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      		Usuário
    	  </button>
    	  <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      		<li><a class="dropdown-item" href="/Sprint4-POO/formUsuario">Formulário</a></li>
      		<li><a class="dropdown-item" href="/Sprint4-POO/listaUsuarios">Lista</a></li>
    	  </ul>
  		</div>
    	<div class="btn-group mb-2">
    	  <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      		Linha
    	  </button>
    	  <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      		<li><a class="dropdown-item" href="/Sprint4-POO/formLinha">Formulário</a></li>
      		<li><a class="dropdown-item" href="/Sprint4-POO/listaLinhas">Lista</a></li>
    	  </ul>
  		</div>
    	<div class="btn-group mb-2">
    	  <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      		Ônibus
    	  </button>
    	  <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      		<li><a class="dropdown-item" href="/Sprint4-POO/formOnibus">Formulário</a></li>
      		<li><a class="dropdown-item" href="/Sprint4-POO/listaOnibus">Lista</a></li>
    	  </ul>
  		</div>
    	<div class="btn-group mb-2">
    	  <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      		Lista de favoritos
    	  </button>
    	  <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      		<li><a class="dropdown-item" href="/Sprint4-POO/formListaFavoritos">Formulário</a></li>
      		<li><a class="dropdown-item" href="/Sprint4-POO/listaListaFavoritos">Lista</a></li>
    	  </ul>
  		</div>
      </div>
	</div>
  </nav>

  <main class="py-3">
  <div class="container">
  	<h5 class="ps-3 mb-2">Registrar ônibus</h5>

	<c:if test="${registrado == true}">
	  <div class="d-flex justify-content-center mb-2">
		<p class="fs-5 bg-success p-2 m-0 rounded branco">Ônibus registrado</p>
	  </div>
	</c:if>

	<c:if test="${repetido == true}">
	  <div class="d-flex justify-content-center mb-2">
		<p class="fs-5 bg-danger p-2 m-0 rounded branco">Ônibus já existente</p>
	  </div>
	</c:if>

    <form class="p-3 rounded" action="/Sprint4-POO/registrarOnibus" method="post">
      <div id="form" class="mb-5">
          <div class="mb-3">
            <label class="form-label" for="localizacao">Localização</label>

			<c:if test="${localizacaoInvalida == true}">
              <div class="fw-bold" style="color: red">Localização inválida</div>
          	</c:if>

            <input id="localizacao" class="form-control" type="text" name="localizacao" value="${localizacao}" maxlength="30" autofocus required>
          </div>

          <div class="mb-3">
            <label class="form-label" for="idFuncionario">ID do funcionário</label>

			<c:choose>
			  <c:when test="${idInvalidaF == true}">
              	<div class="fw-bold" style="color: red">ID inválida</div>
			  </c:when>
			  <c:when test="${naoEncontradoF == true}">
              	<div class="fw-bold" style="color: red">Funcionário não encontrado</div>
			  </c:when>
			</c:choose>

            <input id="idFuncionario" class="int form-control" type="number" name="idFuncionario" value="${idFuncionario}" min="1" required>
          </div>

          <div class="mb-3">
            <label class="form-label" for="idLinha">ID da linha</label>

			<c:choose>
			  <c:when test="${idInvalidaL == true}">
              	<div class="fw-bold" style="color: red">ID inválida</div>
			  </c:when>
			  <c:when test="${naoEncontradaL == true}">
              	<div class="fw-bold" style="color: red">Linha não encontrada</div>
			  </c:when>
			</c:choose>

            <input id="idLinha" class="int form-control" type="number" name="idLinha" value="${idLinha}" min="1" required>
          </div>

          <div>
            <label class="form-label" for="capacidade">Capacidade</label>

			<c:if test="${capacidadeInvalida == true}">
			  <div class="fw-bold" style="color: red">Capacidade inválida</div>
			</c:if>

            <input id="capacidade" class="int form-control" type="number" name="capacidade" value="${capacidade}" min="1" max="100" required>
          </div>
      </div>
      
      <div class="d-flex flex-wrap justify-content-between text-center botoes">
        <div>
          <button id="limpar" class="btn btn-primary" type="reset">Limpar formulário</button>
        </div>
        <div>
          <button class="btn btn-primary" type="submit">Registrar</button>
          <a href="/Sprint4-POO/listaOnibus" class="btn btn-primary">Lista</a>
        </div>
      </div>
    </form>
  </div>
  </main>
  
  <footer class="py-3">
    <p class="text-center mb-0 branco">Equipe Ctrl+Alt+Del © 2021.</p>
  </footer>
</body>
</html>