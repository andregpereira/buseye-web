<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Alterar funcionário - BusEye</title>
<link rel="shortcut icon" href="./fav.ico?" type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet" href="./css/form.css">
<link rel="stylesheet" href="./css/form.funcionario.css">
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
  $(".int").inputFilter(function(value) {
	return /^\d*$/.test(value);
  });
});
$(document).ready(function() {
  $("#cargo").inputFilter(function(value) {
	return /^[a-z, ç, á, à, ã, â, é, è, ê, í, ì, î, õ, ó, ò, ô, ú, ù, û]*$/i.test(value);
  });
});
$(document).ready(function() {
  $("#email").inputFilter(function(value) {
	return /^[a-z, 0-9, @, .]*$/i.test(value);
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
    <h5 class="ps-3 mb-2">Alterando funcionário ${funcionario.nome}</h5>

    <form class="p-3 rounded" action="/Sprint4-POO/alterarFuncionario" method="post">
      <div id="form" class="mb-5">
        <div id="col1">
          <div class="mb-3">
          	<input type="hidden" name="id" value="${funcionario.idFuncionario}">
            <label class="form-label" for="nome">Nome</label>

          	<c:if test="${nomeInvalido == true}">
              <div class="fw-bold" style="color: red">Nome inválido</div>
          	</c:if>

            <input id="nome" class="form-control" type="text" name="nome" value="${funcionario.nome}" autofocus required>
          </div>
          <div class="mb-3">
            <label class="form-label" for="cpf">CPF</label>
            
          	<c:choose>
          	  <c:when test="${cpfRepetido == true}">
             	 <div class="fw-bold" style="color: red">CPF já registrado</div>
          	  </c:when>
          	  <c:when test="${cpfInvalido == true}">
              	<div class="fw-bold" style="color: red">CPF inválido</div>
          	  </c:when>
          	</c:choose>

            <input id="cpf" class="int form-control" type="text" name="cpf" value="${funcionario.cpf}" maxlength="11" required>
          </div>
          <div class="mb-3">
            <label class="form-label" for="dataNascimento">Data de nascimento</label>

          	<c:if test="${dataInvalida == true}">
              <div class="fw-bold" style="color: red">Data de nascimento inválida</div>
          	</c:if>

			<input id="dataNascimento" class="form-control" type="date" name="dataNascimento" value="${funcionario.dataNasc}" required>
		  </div>
          <div>
            <label class="form-label" for="email">Email</label>

			<c:choose>
          	  <c:when test="${emailRepetido == true}">
             	 <div class="fw-bold" style="color: red">O email inserido já está em uso</div>
          	  </c:when>
          	  <c:when test="${emailInvalido == true}">
              	<div class="fw-bold" style="color: red">Email inválido</div>
          	  </c:when>
          	</c:choose>
	
            <input id="email" class="form-control" type="email" name="email" value="${funcionario.email}" placeholder="nome@email.com" required>
          </div>
        </div>

        <div id="col2">
          <div class="mb-3">
            <label class="form-label" for="telefone">Telefone</label>

			<c:choose>
          	  <c:when test="${telefoneRepetido == true}">
             	 <div class="fw-bold" style="color: red">O telefone inserido já está em uso</div>
          	  </c:when>
          	  <c:when test="${telefoneInvalido == true}">
              	<div class="fw-bold" style="color: red">Telefone inválido</div>
          	  </c:when>
          	</c:choose>

            <input id="telefone" class="int form-control" type="tel" name="telefone" value="${funcionario.telefone}" maxlength="11" required>
          </div>
          <div class="mb-3">
            <label class="form-label" for="cargo">Cargo</label>

			<c:if test="${cargoInvalido == true}">
              <div class="fw-bold" style="color: red">Cargo inválido</div>
          	</c:if>

            <input id="cargo" class="form-control" type="text" name="cargo" value="${funcionario.cargo}" required>
          </div>
          <div>
            <label class="form-label">Situação</label>

			<c:choose>
          	  <c:when test="${situacaoInvalida == true}">
             	 <div class="fw-bold" style="color: red">Escolha uma situação</div>
          	  </c:when>
          	  <c:when test="${situacaoInvalidaHtml == true}">
              	<div class="fw-bold" style="color: red">Bela tentativa mexer no HTML :P</div>
          	  </c:when>
          	</c:choose>

            <div class="d-flex flex-wrap ps-3">
              <div class="me-5">

              <c:choose>
              	<c:when test="${funcionario.situacao == 'ATIVO'}">
                <input id="ativo" class="form-check-input" type="radio" name="situacao" value="ATIVO" checked required>
                <label class="form-check-label" for="ativo">Ativo</label>
              	</c:when>
              	<c:otherwise>
                  <input id="ativo" class="form-check-input" type="radio" name="situacao" value="ATIVO">
                  <label class="form-check-label" for="ativo">Ativo</label>
              	</c:otherwise>
              </c:choose>

              <c:choose>
              	<c:when test="${funcionario.situacao == 'INATIVO'}">
                <input id="inativo" class="form-check-input" type="radio" name="situacao" value="INATIVO" checked required>
                <label class="form-check-label" for="inativo">Inativo</label>
              	</c:when>
              	<c:otherwise>
                <input id="inativo" class="form-check-input" type="radio" name="situacao" value="INATIVO">
                <label class="form-check-label" for="inativo">Inativo</label>
              	</c:otherwise>
              </c:choose>

              </div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="d-flex flex-wrap justify-content-between text-center botoes">
        <div>
          <button id="limpar" class="btn btn-primary" type="reset">Limpar formulário</button>
        </div>
        <div>
          <button class="btn btn-primary" type="submit">Alterar</button>
          <a href="/Sprint4-POO/listaFuncionarios" class="btn btn-primary">Voltar</a>
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