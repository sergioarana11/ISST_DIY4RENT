< !DOCTYPE html >
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="author" content="Grupo7">

        <title><%= title %></title>



        <link href="././resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


        <link href="././resources/vendor/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>


        <link href="css/clean-blog.min.css" rel="stylesheet">

    </head>
    <header>


        <title>Diy4ent</title>
           
        <link rel="stylesheet" type="text/css" href="index.css">

    </header>
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
        <div class="container">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu <i class="fas fa-bars"></i> </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                        <a class="nav-link" href="index.js">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="herramientas.html">Herramientas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="gestiona.html">Gestiona</a>
                </li>
                </ul>

                <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                        <a class="nav-link" href="registro.js">Registro</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="inicio.html">Iniciar Sesión</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="info.html">Sobre nosotros</a>
                </li>
                </ul>  
            </div>
        </div>
    </nav>

    <body>
        <h1><%= funcion %></h1>
        <section>
            <%- section>    
        </section>

    </body>
    <section>
            
    </section>


   

  <script src="././resources/vendor/jquery/jquery.min.js"></script>
  <script src="././resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


  <footer>
    DIY4ENT Grupo7
  </footer>

</html>