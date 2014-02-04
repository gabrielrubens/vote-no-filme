var Voto = (function($){
	var app;
	
	app = {
		votar: function($form, $btn, $filmeVotado) {
			$filmeVotado.val($($btn).data('filme'));
			$form.submit();
		}
	};
	
	return app;
	
})(jQuery);