$(function($) {
	$.ajax({
		url : 'ranking',
		data : '',
		success : function(json) {
			Tabela.popular(json.list);
			Chart.criar(json.list);
		},
		error : function(erro) {
			Tabela.erro(erro);
		},
		dataType : 'json'
	});
	
});

var Tabela = (function() {
	var app, _private;

	app = {
		popular : function(json) {
			_private.geral(json[0]);
			_private.usuario(json[1]);
		},
		erro : function(erro) {
			console.log(erro);
		}
	};

	_private = {
		geral : function(lista) {
			this.criarLinha($('#idTbodyUsuario'), lista);
		},
		usuario : function(lista) {
			this.criarLinha($('#idTbodyGeral'), lista);
		},
		criarLinha : function($tbody, lista) {
			$.each(lista, function(i, item) {
				var row = 	'<tr>' +
								'<td>' + lista[i].filme.nome + '</td>' +
								'<td>' + lista[i].quantidadeDeVotos + '</td>'+
							'</tr>';

				$tbody.append(row);
			});
		}
	}

	return app;
})();

var Chart = (function($){
	var app, _private;
	
	app = {
		criar: function(json) {
			_private.columnUsuario(json[0]);
			_private.columnGeral(json[1]);
			_private.pieUsuario(json[0]);
			_private.pieGeral(json[1]);
		}
	};
	
	_private = {
		columnUsuario: function(lista){
			var nomes = new Array();
			var votos = new Array();
			
			$.each(lista, function(i, item) {
				nomes.push(lista[i].filme.nome);
				votos.push(lista[i].quantidadeDeVotos);
			});
			
		    $('#containerColumnChartUsuario').highcharts({
		        chart: {
		            type: 'column',
		            margin: [ 50, 50, 100, 80]
		        },
		        title: {
		            text: 'Seus Votos'
		        },
		        xAxis: {
		            categories: nomes,
		            labels: {
		                rotation: -45,
		                align: 'right',
		                style: {
		                    fontSize: '13px',
		                    fontFamily: 'Verdana, sans-serif'
		                }
		            }
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: 'Quantidade'
		            }
		        },
		        legend: {
		            enabled: false
		        },
		        tooltip: {
		            pointFormat: 'Quantidade de votos: <b>{point.y:.1f}</b>',
		        },
		        series: [{
		            name: 'Votos',
		            data: votos,
		            dataLabels: {
		                enabled: true,
		                rotation: -90,
		                color: '#FFFFFF',
		                align: 'right',
		                x: 4,
		                y: 10,
		                style: {
		                    fontSize: '13px',
		                    fontFamily: 'Verdana, sans-serif',
		                    textShadow: '0 0 3px black'
		                }
		            }
		        }]
		    });
		},
		columnGeral: function(lista){
			var nomes = new Array();
			var votos = new Array();
			
			$.each(lista, function(i, item) {
				nomes.push(lista[i].filme.nome);
				votos.push(lista[i].quantidadeDeVotos);
			});
			
		    $('#containerColumnChartGeral').highcharts({
		        chart: {
		            type: 'column',
		            margin: [ 50, 50, 100, 80]
		        },
		        title: {
		            text: 'Todos os Votos'
		        },
		        xAxis: {
		            categories: nomes,
		            labels: {
		                rotation: -45,
		                align: 'right',
		                style: {
		                    fontSize: '13px',
		                    fontFamily: 'Verdana, sans-serif'
		                }
		            }
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: 'Quantidade'
		            }
		        },
		        legend: {
		            enabled: false
		        },
		        tooltip: {
		            pointFormat: 'Quantidade de votos: <b>{point.y:.1f}</b>',
		        },
		        series: [{
		            name: 'Votos',
		            data: votos,
		            dataLabels: {
		                enabled: true,
		                rotation: -90,
		                color: '#FFFFFF',
		                align: 'right',
		                x: 4,
		                y: 10,
		                style: {
		                    fontSize: '13px',
		                    fontFamily: 'Verdana, sans-serif',
		                    textShadow: '0 0 3px black'
		                }
		            }
		        }]
		    });
		},
		pieUsuario: function(lista){
			var filmes = [];
			
			$.each(lista, function(i, item) {
   				filmes.push( [lista[i].filme.nome, lista[i].quantidadeDeVotos] ); 
   			});
			
			$('#containerPieChartUsuario').highcharts({
		        chart: {
		            plotBackgroundColor: null,
		            plotBorderWidth: null,
		            plotShadow: false
		        },
		        title: {
		            text: 'Seus votos'
		        },
		        tooltip: {
		    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		        },
		        plotOptions: {
		            pie: {
		                allowPointSelect: true,
		                cursor: 'pointer',
		                dataLabels: {
		                    enabled: false,
		                    color: '#000000',
		                    connectorColor: '#000000',
		                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
		                }
		            }
		        },
		        series: [{
		            type: 'pie',
		            name: 'Votos',
		            data: filmes
		        }]
		    });
		},
		
		pieGeral: function(lista){
			var filmes = [];
			
			$.each(lista, function(i, item) {
   				filmes.push( [lista[i].filme.nome, lista[i].quantidadeDeVotos] ); 
   			});
			
			$('#containerPieChartGeral').highcharts({
		        chart: {
		            plotBackgroundColor: null,
		            plotBorderWidth: null,
		            plotShadow: false
		        },
		        title: {
		            text: 'Todos os votos'
		        },
		        tooltip: {
		    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		        },
		        plotOptions: {
		            pie: {
		                allowPointSelect: true,
		                cursor: 'pointer',
		                dataLabels: {
		                	enabled: false,
		                    color: '#000000',
		                    connectorColor: '#000000',
		                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
		                }
		            }
		        },
		        series: [{
		            type: 'pie',
		            name: 'Votos',
		            data: filmes
		        }]
		    });
		},
	}
	
	return app;
	
})(jQuery);

$(function () {
    /*$('#containerPieChartUsuario').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Seus votos'
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                {
                    name: 'Chrome',
                    y: 12.8,
                    sliced: true,
                    selected: true
                },
                ['Safari',    8.5],
                ['Opera',     6.2],
                ['Others',   0.7]
            ]
        }]
    });*/
});