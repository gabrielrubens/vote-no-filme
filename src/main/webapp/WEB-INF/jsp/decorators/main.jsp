<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="UTF-8">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" view="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" view="pt-BR" />
<meta name="description" content="Vote no Filme!">
<meta name="author" content="Gabriel Rubens">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">



<title><decorator:title default="Vote no Filme!" /></title>

<link href="${bootstrap}/css/bootstrap.css" rel="stylesheet">
<!-- Custom CSS for the 'Thumbnail Gallery' Template -->
<link href="${bootstrap}/css/2-col-portfolio.css" rel="stylesheet">
<script src="${bootstrap}/js/jquery-1.10.2.js"></script>
<decorator:head />
</head>
<body>

<!-- ERROS -->
	<c:if test="${not empty errors}">
		<div class="alert alert-danger">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<c:forEach items="${errors}" var="error">
				<b><fmt:message key="${error.category}" /></b> - ${error.message}
			</c:forEach>
		</div>
	</c:if>
<!-- ERROS -->

	<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}">Vote!</a>
			</div>

			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">
		<decorator:body />
	</div>

	<%-- <script src="${jsDir}/jquery.min.js"></script> --%>
	<script src="${jsDir}/app.js"></script>
	<script src="${jsDir}/voto.js"></script>
	<script src="${jsDir}/usuario.js"></script>
	<script src="${bootstrap}/js/bootstrap.js"></script>
</body>
</html>
