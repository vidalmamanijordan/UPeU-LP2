var upeu = (function($) {

	return {
		cargarUrl : function(url) {
			var xhr = $.get(url);
			xhr.done(function(data) {
				$("#contenido").html(data);
				
			});
		},
		
		enviarFormulario : function(parametros) {
			var opciones = {
				target : '#' + parametros.target
			};

			$("#" + parametros.id).ajaxForm(opciones);

		},
		
	};

})(jQuery);