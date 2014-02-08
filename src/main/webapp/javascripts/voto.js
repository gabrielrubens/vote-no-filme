var Voto = (function($){
	var app, _private;
	
	app = {
		votar: function($form, $btn, $filmeVotado) {
			$filmeVotado.val($($btn).data('filme'));
			//$form.submit();
			console.log('app.votar()');
			$.ajax({
				type: 'POST',
				url: 'voto/votar',
				data: $form.serialize(),
				success: function(json) {
					console.log('pronto');
					console.log(json);
					//if($('#temCandidatos').val()){
						_private.preencherNovoVoto(json);
					/*}else{
						_private.mostrarOpcaoDeLogin();
					}*/
				},
				error: function (erro){
					_private.mostrarOpcaoDeLogin();
				},
				dataType: 'json'
			});
		},
		
		ranking: function(){
			console.log('ranking');
		}
	
	};
	
	_private = {
		preencherNovoVoto: function(json){
			//$('#')
			var filme1 = json.candidatos.filme1;
			var filme2 = json.candidatos.filme2;

			$('#candidatos.filme1.id').val(filme1.id);
			$('#candidatos.filme2.id').val(filme2.id);
			
			$('#idImgFilme1').prop('src', 'http://placehold.it/300x350');
			$('#idImgFilme2').prop('src', 'http://placehold.it/300x350');
			
			
			$('#idNmFilme1').html(filme1.nome);
			$('#idNmFilme2').html(filme2.nome);
			
			$('#btnFilme1').data('filme', filme1.id);
			$('#btnFilme2').data('filme', filme2.id);
		},
		
		mostrarOpcaoDeLogin: function(){
			$('#idNovoUsuarioModal').modal('show');
		}
	}
	
	return app;
	
})(jQuery);