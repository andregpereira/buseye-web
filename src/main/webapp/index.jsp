<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BusEye</title>
<link rel="shortcut icon" href="./fav.ico?" type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/main.css">
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
	  <h1 class="mb-4 mt-1">Bem-vindo ao site do BusEye!</h1>
	  <h3 class="mb-2">Selecione um formulário abaixo</h3>
    </div>
  </nav>

  <main class="px-4 pt-3 pb-2">
	<div class="container">
	  <ul class="px-4 my-auto">
		<li>
		  <a href="/Sprint4-POO/formFuncionario" class="btn btn-primary d-block mb-3">Funcionário</a>
		</li>
		<li>
		  <a href="/Sprint4-POO/formUsuario" class="btn btn-primary d-block mb-3">Usuário</a>
		</li>
		<li>
		  <a href="/Sprint4-POO/formLinha" class="btn btn-primary d-block mb-3">Linha</a>
		</li>
		<li>
		  <a href="/Sprint4-POO/formOnibus" class="btn btn-primary d-block mb-3">Ônibus</a>
		</li>
		<li>
		  <a href="/Sprint4-POO/formListaFavoritos" class="btn btn-primary d-block mb-2">Lista de favoritos</a>
		</li>
	  </ul>
	</div>
  </main>
  
  <footer class="py-3">
    <p class="text-center mb-0 branco">Equipe Ctrl+Alt+Del © 2021.</p>
  </footer>
</body>
</html>