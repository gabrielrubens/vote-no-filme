var Usuario = (function($){
	var app, _private;
	
	app = {
		mostrarOpcaoDeLogin: function(){
			$('#idNovoUsuarioModal').modal('show');
		},
		
		atualizar: function(){
			$('#formUsuarios').submit();
		}
	};
	
	_private = {
	};
	
	return app;
	
})(jQuery);