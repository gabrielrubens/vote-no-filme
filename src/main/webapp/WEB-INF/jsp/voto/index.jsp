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
			<input type="hidden" name="candidatos.filme1.id" id="candidatos.filme1.id"  value="${candidatos.filme1.id}"/>
			<input type="hidden" name="candidatos.filme2.id" id="candidatos.filme2.id"  value="${candidatos.filme2.id}"/>
			<input type="hidden" id="filmeVotado" name="filmeVotado.id" value=""/>
			<input type="hidden" id="temCandidatos" name="temCandidatos" value="${temCandidatos}"/>
		
	        <div class="row">
	
	            <div class="col-lg-12">
	                <h1 class="page-header">Vote no seu filme preferido.
	                    <small>Escolha uma das op��o</small>
	                </h1>
	            </div>
	
	        </div>
	
	        <div class="row">
	
	            <div class="col-lg-6 col-md-6 portfolio-item">
	                <img id="idImgFilme1" class="img-responsive img-thumbnail" src="http://placehold.it/300x350">
	                <h3 id="idNmFilme1">${candidatos.filme1.nome}</h3>
	                <button type="button" id="btnFilme1" class="btn btn-success btn-lg" data-filme="${candidatos.filme1.id}">Votar</button>
	            </div>
	
	            <div class="col-lg-6 col-md-6 portfolio-item">
	                <img id="idImgFilme2" class="img-responsive img-thumbnail" src="http://placehold.it/300x350">
	                <h3 id="idNmFilme2">${candidatos.filme2.nome}</h3>
	                <button type="button" id="btnFilme2" class="btn btn-success btn-lg" data-filme="${candidatos.filme2.id}">Votar</button>
	            </div>
	
	        </div>
		</form>
        <hr>
		
		<!-- Modal -->
		<div class="modal fade" id="idNovoUsuarioModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					</div>
					<form id="formUsuarios" action="usuario/atualizar">
						<div class="modal-body">
							<div class="form-group">
								<label for="nome">Nome</label> 
								<input type="text" class="form-control" id="nome" placeholder="Informe o seu nome">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email</label> 
								<input type="email" class="form-control" id="email" placeholder="Informe o seu email">
							</div>
						</div>
					</form>
					<div class="modal-footer">
						<button type="button" id="btnSalvarUsuario" class="btn btn-success">Save changes</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal -->

    </div>