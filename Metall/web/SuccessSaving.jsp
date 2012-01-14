<%-- 
    Document   : SuccessSaving
    Created on : Jan 5, 2012, 10:41:14 AM
    Author     : a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Metall - Costume Rentall Application</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
    <div id="logo">
	<h1>Metall - Costume Rentall Application</h1>
	<p>Aplikasi Persewaan Kostum</p>
    </div>
<div id="page">
	<div>
		<div id="content">
			<div class="post">
				<div class="entry">
                                    <p><font color="red"><%=  request.getAttribute("message")  %></font></p>
                                    <a href="javascript:history.go(-1)" onMouseOver="self.status=document.referrer;return true">Kembali</a> ||<a href="<%=  request.getAttribute("page")  %>"> Ke Daftar </a>
				</div>
			</div>

		</div>
         </div>
</div>
<div id="footer">
	<p>Design by Kelompok 4</p>
</div>
</div>
<!-- end #footer -->
</body>
</html>
