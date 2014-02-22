<%@page contentType="text/html; charset=UTF-8"%>
	<form action="voto/votar" method="post" id="formVotos">
		<input type="hidden" name="candidatos.filme1.id" id="candidatos.filme1.id"  value="${candidatos.filme1.id}"/>
		<input type="hidden" name="candidatos.filme2.id" id="candidatos.filme2.id"  value="${candidatos.filme2.id}"/>
		<input type="hidden" id="filmeVotado" name="filmeVotado.id" value=""/>
		<input type="hidden" id="temCandidatos" name="temCandidatos" value="${temCandidatos}"/>
	
        <div class="row">

            <div class="col-lg-12">
                <h1 class="page-header"><fmt:message key="msg.escolha.um.filme"/></h1>
            </div>

        </div>

        <div class="row">

            <div class="col-lg-6 col-md-6 portfolio-item">
                <img id="idImgFilme1" class="img-responsive img-thumbnail" src="${imgDir}/${candidatos.filme1.capa}.jpg" width="280" height="350">
                <h3 id="idNmFilme1">${candidatos.filme1.nome}</h3>
                <button type="button" id="btnFilme1" class="btn btn-success btn-lg" data-filme="${candidatos.filme1.id}"><fmt:message key='btn.votar'/></button>
            </div>

            <div class="col-lg-6 col-md-6 portfolio-item">
                <!-- <img id="idImgFilme2" class="img-responsive img-thumbnail" src="http://placehold.it/300x350"> -->
                <img id="idImgFilme2" class="img-responsive img-thumbnail" src="${imgDir}/${candidatos.filme2.capa}.jpg" width="280" height="350">
                <h3 id="idNmFilme2">${candidatos.filme2.nome}</h3>
                <button type="button" id="btnFilme2" class="btn btn-success btn-lg" data-filme="${candidatos.filme2.id}"><fmt:message key='btn.votar'/></button>
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
					<h4 class="modal-title" id="myModalLabel"><fmt:message key='msg.informe.seu.nome.e.email'/>. <fmt:message key='msg.voce.nao.recebera.spams'/></h4>
					<h4 class="modal-title" id="myModalLabel"></h4>
					
				</div>
				<form id="formUsuarios" action="usuario/atualizar">
					<div class="modal-body">
						<div class="form-group">
							<label for="nome"><fmt:message key='msg.nome'/></label> 
							<input type="text" class="form-control" id="nome" placeholder="<fmt:message key='msg.informe.seu.nome'/>">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1"><fmt:message key='msg.email'/></label> 
							<input type="email" class="form-control" id="email" placeholder="<fmt:message key='msg.informe.seu.email'/>">
						</div>
					</div>
				</form>
				<div class="modal-footer">
					<button type="button" id="btnSalvarUsuario" class="btn btn-success"><fmt:message key="btn.enviar"/></button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
