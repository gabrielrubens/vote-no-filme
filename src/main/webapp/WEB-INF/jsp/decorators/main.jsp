<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Vote no Filme!">
    <meta name="author" content="Gabriel Rubens">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><decorator:title default="Vote no Filme!"/></title>
		
		<link href="${bootstrap}/css/bootstrap.css" rel="stylesheet">
	    <!-- Custom CSS for the 'Thumbnail Gallery' Template -->
		<link href="${bootstrap}/css/2-col-portfolio.css" rel="stylesheet">
	
    <decorator:head/>
  </head>
  <body>
    <decorator:body/>
    <%-- <script src="${jsDir}/jquery.min.js"></script> --%>
	<script src="${bootstrap}/js/jquery-1.10.2.js"></script>
	<script src="${jsDir}/app.js"></script>
	<script src="${jsDir}/voto.js"></script>
	<script src="${bootstrap}/js/bootstrap.js"></script>
  </body>
</html>
