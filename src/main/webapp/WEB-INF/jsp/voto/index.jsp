    <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Vote!</a>
            </div>
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">
		<form action="#" id="formVotos">
	        <div class="row">
	
	            <div class="col-lg-12">
	                <h1 class="page-header">Vote no seu filme preferido.
	                    <small>Escolha uma das opção</small>
	                </h1>
	            </div>
	
	        </div>
	
	        <div class="row">
	
	            <div class="col-lg-6 col-md-6 portfolio-item">
	                <img class="img-responsive img-thumbnail" src="http://placehold.it/300x350">
	                <h3>${candidatos.filme1.nome}</h3>
	                <button type="button" id="btnFilme1" class="btn btn-success btn-lg">Votar</button>
	            </div>
	
	            <div class="col-lg-6 col-md-6 portfolio-item">
	                <img class="img-responsive img-thumbnail" src="http://placehold.it/300x350">
	                <h3>${candidatos.filme2.nome}</h3>
	                <button type="button" id="btnFilme2" class="btn btn-success btn-lg ">Votar</button>
	            </div>
	
	        </div>
		</form>
        <hr>

        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; <a href="http://gabrielrubens.com.br" target="_blank">Gabriel Rubens</a> 2014</p>
                </div>
            </div>
        </footer>

    </div>