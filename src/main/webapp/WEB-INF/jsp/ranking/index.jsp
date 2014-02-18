<%@page contentType="text/html; charset=UTF-8"%>

<div class="row">
	<div class="col-lg-6 col-md-6 portfolio-item">
		<h1 class="page-header">Seu Ranking</h1>
	</div>

	<div class="col-lg-6 col-md-6 portfolio-item">
		<h1 class="page-header">Ranking Geral</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-6 col-md-6 portfolio-item">
		<table class="table-striped">
			<thead>
				<tr>
					<th class="col-lg-5">Nome do filme</th>
					<th class="col-lg-1">Votos</th>
				</tr>
			</thead>
			<tbody id="idTbodyUsuario">
			</tbody>
		</table>
	</div>

	<div class="col-lg-6 col-md-6 portfolio-item">
		<table class="table-striped">
			<thead>
				<tr>
					<th class="col-lg-5">Nome do filme</th>
					<th class="col-lg-1">Votos</th>
				</tr>
			</thead>
			<tbody id="idTbodyGeral">
			</tbody>
		</table>
	</div>
</div>

<div class="row">
	<div class="col-lg-6 col-md-6 portfolio-item">
		<div id="containerColumnChartUsuario" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>

	<div class="col-lg-6 col-md-6 portfolio-item">
		<div id="containerColumnChartGeral" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>
</div>

<div class="row">
	<div class="col-lg-6 col-md-6 portfolio-item">
		<div id="containerPieChartUsuario" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>

	<div class="col-lg-6 col-md-6 portfolio-item">
		<div id="containerPieChartGeral" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>
</div>

<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script src="${jsDir}/ranking.js"></script>
