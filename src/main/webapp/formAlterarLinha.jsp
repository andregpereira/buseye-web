<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Alterar linha - BusEye</title>
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
  $("#nome").inputFilter(function(value) {
	return /^[a-z, �, �, �, �, �, �, �, �, �, �, �, �, �, �, �, �, �, �, 0-9, ,, ., -]*$/i.test(value);
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
      		Funcion�rio
    	  </button>
    	  <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      		<li><a class="dropdown-item" href="/Sprint4-POO/formFuncionario">Formul�rio</a></li>
      		<li><a class="dropdown-item" href="/Sprint4-POO/listaFuncionarios">Lista</a></li>
    	  </ul>
  		</div>
    	<div class="btn-group mb-2">
    	  <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      		Usu�rio
    	  </button>
    	  <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      		<li><a class="dropdown-item" href="/Sprint4-POO/formUsuario">Formul�rio</a></li>
      		<li><a class="dropdown-item" href="/Sprint4-POO/listaUsuarios">Lista</a></li>
    	  </ul>
  		</div>
    	<div class="btn-group mb-2">
    	  <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      		Linha
    	  </button>
    	  <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      		<li><a class="dropdown-item" href="/Sprint4-POO/formLinha">Formul�rio</a></li>
      		<li><a class="dropdown-item" href="/Sprint4-POO/listaLinhas">Lista</a></li>
    	  </ul>
  		</div>
    	<div class="btn-group mb-2">
    	  <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      		�nibus
    	  </button>
    	  <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      		<li><a class="dropdown-item" href="/Sprint4-POO/formOnibus">Formul�rio</a></li>
      		<li><a class="dropdown-item" href="/Sprint4-POO/listaOnibus">Lista</a></li>
    	  </ul>
  		</div>
    	<div class="btn-group mb-2">
    	  <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      		Lista de favoritos
    	  </button>
    	  <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      		<li><a class="dropdown-item" href="/Sprint4-POO/formListaFavoritos">Formul�rio</a></li>
      		<li><a class="dropdown-item" href="/Sprint4-POO/listaListaFavoritos">Lista</a></li>
    	  </ul>
  		</div>
      </div>
	</div>
  </nav>

  <main class="py-3">
  <div class="container">
  	<h5 class="ps-3 mb-2">Alterando linha ${linha.nome}</h5>

	<c:if test="${repetido == true}">
	  <div class="d-flex justify-content-center mb-2">
		<p class="fs-5 bg-danger p-2 m-0 rounded branco">Linha j� existente</p>
	  </div>
	</c:if>

    <form class="p-3 rounded" action="/Sprint4-POO/alterarLinha" method="post">
      <div id="form" class="mb-5">
          <div class="mb-3">
			<input type="hidden" name="id" value="${linha.idLinha}">

            <label class="form-label" for="nome">Nome</label>

			<c:if test="${nomeInvalido == true}">
              <div class="fw-bold" style="color: red">Nome inv�lido</div>
          	</c:if>

            <input id="nome" class="form-control" type="text" name="nome" value="${linha.nome}" autofocus required>
          </div>

          <div class="mb-3">
            <label class="form-label" for="duracaoPercurso">Dura��o do percurso (hh:mm)</label>

          	  <c:if test="${duracaoPercursoInvalida == true}">
              	<div class="fw-bold" style="color: red">Dura��o do percurso inv�lida</div>
          	  </c:if>

            <input id="duracaoPercurso" class="form-control" type="time"name="duracaoPercurso" value="${linha.duracaoPercurso}" min="00:01" max="23:59" required>
          </div>

          <div>
            <label class="form-label" for="idFuncionario">ID do funcion�rio</label>

			<c:choose>
			  <c:when test="${idInvalida == true}">
              	<div class="fw-bold" style="color: red">ID inv�lida</div>
			  </c:when>
			  <c:when test="${naoEncontrado == true}">
              	<div class="fw-bold" style="color: red">Funcion�rio n�o encontrado</div>
			  </c:when>
			</c:choose>

            <input id="idFuncionario" class="int form-control" type="number" name="idFuncionario" value="${linha.idFuncionario}" required>
          </div>
      </div>
      
      <div class="d-flex flex-wrap justify-content-between text-center botoes">
        <div>
          <button id="limpar" class="btn btn-primary" type="reset">Limpar formul�rio</button>
        </div>
        <div>
          <button class="btn btn-primary" type="submit">Alterar</button>
          <a href="/Sprint4-POO/listaLinhas" class="btn btn-primary">Voltar</a>
        </div>
      </div>
    </form>
  </div>
  </main>
  
  <footer class="py-3">
    <p class="text-center mb-0 branco">Equipe Ctrl+Alt+Del � 2021.</p>
  </footer>
</body>
</html>