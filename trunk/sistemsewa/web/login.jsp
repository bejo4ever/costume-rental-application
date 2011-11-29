<%-- 
    Document   : login
    Created on : Nov 29, 2011, 11:15:16 AM
    Author     : Aspire
--%>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<h1>Sewa Kostum Online</h1>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="195" height="117" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" bgcolor="#F0F0F0" class="login-header">Member Login </td>
  </tr>
  <tr>
    <td width="65">Username</td>
    <td width="110"><input id="tUser" name="tUser" type="text" class="login-input" size="18" maxlength="40" /></td>
  </tr>
  <tr>
    <td>Password</td>
    <td><input id="tPass" name="tPass" type="password" class="login-input" size="18" maxlength="40" /></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input
										   type="button"
										   name="groovybtn1"
										   class="login-button"
										   value="Login"
										   title=""
										   onmouseover="goLite(this.form.name,this.name)"
   									   onmouseout="goDim(this.form.name,this.name)" 
											onclick="cekValid();" /></td>
  </tr>
</table>
<blockquote>
  <blockquote>
    <blockquote>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
    </blockquote>
  </blockquote>
</blockquote>
</body>
</html>