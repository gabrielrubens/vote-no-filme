<%@page contentType="text/html; charset=UTF-8"%>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1><fmt:message key="erro.oops"/></h1>
                <h2><fmt:message key='erro.nao.ha.filme.no.banco'/></h2>
                <h3><fmt:message key='erro.nao.entre.panico'/></h3>
                <div class="error-details">
                    <fmt:message key='erro.clique.no.botao.criar.filmes.de.teste'/>
               	</div>
                <div class="error-details">
                    <fmt:message key='erro.se.der.tudo.ok.voce.sera.redirecionado'/>
                </div>
                <div class="error-actions">
                    <a href="/filme/inserirBaseDeTeste" class="btn btn-success btn-lg" id="btnCriarFilmesDeTeste">
                    <span class="glyphicon glyphicon-home"></span>
                        <fmt:message key='btn.criar.filme.de.teste'/>
                    </a>
                    <a href="mailto:gabrielrubens@gmail.com?Subject=<fmt:message key='msg.melhoria.no.sistema'/>" target="_blank" class="btn btn-default btn-lg">
                    	<span class="glyphicon glyphicon-envelope"></span> 
                    	<fmt:message key='btn.entre.em.contato'/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
