<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista de linhas - BusEye</title>
<link rel="shortcut icon" href="./fav.ico?" type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet" href="./css/lista.css">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
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
	
  <main class="px-4 py-3">
	<h5 class="ps-3 mb-2">Lista de linhas</h5>

	<c:if test="${alterado == true}">
	  <div class="d-flex justify-content-center mb-2">
	  	<p class="fs-5 bg-success p-2 m-0 rounded branco">Linha ${linha.nome} alterada</p>
	  </div>
	</c:if>

	<c:if test="${removido == true}">
	  <div class="d-flex justify-content-center mb-2">
	  	<p class="fs-5 bg-danger p-2 m-0 rounded branco">Linha ${linha.nome} removida</p>
	  </div>
	</c:if>

	<div class="table-responsive">

	<c:choose>
	<c:when test="${not empty linhas}">
	<table class="table table-light table-striped table-hover table-bordered border-dark mb-2">
	  <thead>
		<tr class="text-center">
		  <th>ID</th>
		  <th>Nome</th>
		  <th>Duração do percurso (hh:mm)</th>
		  <th>ID do funcionário</th>
		  <th>Ações</th>
		</tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${linhas}" var="linha">
		<tr>
		  <td>${linha.idLinha}</td>
		  <td>${linha.nome}</td>
		  <td>${linha.duracaoPercurso}</td>
		  <td>${linha.idFuncionario}</td>
		  <td>
			<div class="d-flex justify-content-around">
			  <a href="/Sprint4-POO/formAlterarLinha?id=${linha.idLinha}" title="Editar">
				<span class="fas fa-edit acoes"></span>
			  </a>
			  <a href="/Sprint4-POO/removerLinha?id=${linha.idLinha}"  title="Remover">
				<span class="fas fa-trash acoes"></span>
			  </a>
			</div>
		  </td>
		</tr>
	  </c:forEach>
	  </tbody>
	</table>
	</c:when>
	<c:otherwise>
	  <p class="fs-2 mb-3 text-center branco">Não há registros de linhas</p>
	</c:otherwise>
	</c:choose>

  </div>

  <div class="d-flex justify-content-end mt-3">
	<a href="/Sprint4-POO/formLinha" class="btn btn-primary">Voltar</a>
  </div>

  </main>
  
  <footer class="py-3">
    <p class="text-center mb-0 branco">Equipe Ctrl+Alt+Del © 2021.</p>
  </footer>
</body>
</html>