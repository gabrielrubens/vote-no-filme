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
		<form action="voto/votar" method="post" id="formVotos">
			<input type="hidden" name="candidatos.filme1.id" value="${candidatos.filme1.id}"/>
			<input type="hidden" name="candidatos.filme2.id" value="${candidatos.filme2.id}"/>
			<input type="hidden" id="filmeVotado" name="filmeVotado.id" value=""/>
		
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
	                <button type="button" id="btnFilme1" class="btn btn-success btn-lg" data-filme="${candidatos.filme1.id}">Votar</button>
	            </div>
	
	            <div class="col-lg-6 col-md-6 portfolio-item">
	                <img class="img-responsive img-thumbnail" src="http://placehold.it/300x350">
	                <h3>${candidatos.filme2.nome}</h3>
	                <%-- <a href="${linkTo[VotoController].votar(candidatos, candidatos.filme2.id)}" class="btn btn-primary btn-lg active" role="button">Votar</a> --%>
	                <a href="${linkTo[VotoController].votar(candidatos, candidatos.filme2)}">votar</a>
	                <button type="button" id="btnFilme2" class="btn btn-success btn-lg" data-filme="${candidatos.filme2.id}">Votar</button>
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