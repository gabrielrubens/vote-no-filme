var Voto = (function($){
	var app, _private;
	
	app = {
		votar: function($form, $btn, $filmeVotado) {
			$filmeVotado.val($($btn).data('filme'));
			$.ajax({
				type: 'POST',
				url: 'voto/votar',
				data: $form.serialize(),
				success: function(json) {
					_private.preencherNovoVoto(json);
				},
				error: function (erro){
					_private.mostrarOpcaoDeLogin();
				},
				dataType: 'json'
			});
		}
	};
	
	_private = {
		preencherNovoVoto: function(json){
			var filme1 = json.candidatos.filme1;
			var filme2 = json.candidatos.filme2;

			var capa1 = filme1.nome.replace(/\s/g, "");
			var capa2 = filme2.nome.replace(/\s/g, "");
			capa1 = capa1.toLowerCase();
			capa2 = capa2.toLowerCase();
			
			$('#candidatos.filme1.id').val(filme1.id);
			$('#candidatos.filme2.id').val(filme2.id);
			
			$('#idImgFilme1').prop('src', 'images/'+ capa1 +'.jpg');
			$('#idImgFilme2').prop('src', 'images/'+ capa2 +'.jpg');
			
			
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