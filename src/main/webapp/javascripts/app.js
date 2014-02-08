(function($){

	$('#btnFilme1, #btnFilme2').click(function(){
		Voto.votar($('#formVotos'), this, $('#filmeVotado'));
	});

	$('#btnSalvarUsuario').click(function(){
		Voto.ranking();
	});
	
})(jQuery);