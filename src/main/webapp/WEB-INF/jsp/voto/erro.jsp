<%@page contentType="text/html; charset=UTF-8"%>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>
                <h2>Não há filmes no banco de dados</h2>
                <h3>NÃO ENTRE EM PÂNICO!</h3>
                <div class="error-details">
                    Clique no botão "Criar Filmes de Teste" e continue Votando.
               	</div>
                <div class="error-details">
                    Se der tudo OK você será redirecionado para a página inicial.
                </div>
                <div class="error-actions">
                    <a href="/filme/inserirBaseDeTeste" class="btn btn-success btn-lg" id="btnCriarFilmesDeTeste">
                    <span class="glyphicon glyphicon-home"></span>
                        Criar Filmes de Teste
                    </a>
                    <a href="mailto:gabrielrubens@gmail.com?Subject=Melhoria no sistema Vote no Filme" target="_blank" class="btn btn-default btn-lg">
                    	<span class="glyphicon glyphicon-envelope"></span> 
                    	Entre em contado 
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
