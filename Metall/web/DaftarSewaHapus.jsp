<%-- 
    Document   : DaftarSewa
    Created on : Dec 13, 2011, 12:14:38 PM
    Author     : Rifanda Putri
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US">
<head>
<title>Sistem Persewaan Kostum Online</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta http-equiv="CONTENT-LANGUAGE" content="EN-US">
<META NAME="DESCRIPTION" CONTENT="">
<META NAME="KEYWORDS" CONTENT="Sistem Persewaan Kostum Online">


<link href="style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="">
<SCRIPT src="anim.js"></SCRIPT>

<style type="text/css">
<!--
body {
	background-color: #39F;
}
-->
</style></head>

<body>

<br>
<center>
<div id="main">
<table width="900" class="border_colapse" >
  <tr>
   <td class=align_left_top>
    	<table width=898>
  			<tr>

<!--            	<td width=297>
                	<table width=297 height=97 style="font-weight:bold">
                    	<tr><td align=right width=94>ALamat :</td><td>jal</td>
                        </tr>
                    	<tr><td align=right width=94>Kota :</td><td>lkjlk ,kjl</td>
                        </tr>

                        </tr>
                    </table>
            	</td>-->
            	<td width=897>&nbsp;</td>

            </tr>
     	<table>
    <td align="right"><a href="#">Logout</a></tr>
 
<tr>
	<td align="center" bgcolor="#99CC99"><table width="690" border="0" cellpadding="0" cellspacing="0" >

        <tr class='menu'>
          <td align="center" class="text_putih">
            <a class="klikmenu" href="index.php"><strong>Kostum</strong></a><strong>&nbsp;|&nbsp;	
            <a class="klikmenu" href="cara.php">Toko</a>&nbsp;|&nbsp;
            <a class="klikmenu" href="tanya.php">Pelanggan</a>&nbsp;|&nbsp;
            <a class="klikmenu" href="prosespay.php">Sewa Kostum</a></strong></td></tr>
    </table>
</td>
</tr>		

   <tr align="right">
    <td><table width="100%">
      <tr>
        <td class="align_left_top2"  valign="top" ></td>
        <td width="585" rowspan="8" align="left" valign="top"><table width="100%">
          <tr>
            <td ><h4>Sistem Persewaan Kostum Online</h4></td>
          </tr>
          <tr>
            <td colspan="2" class="text_orange"><center>
              <marquee>
                <h2><b>Daftar Sewa </b></h2>
              </marquee>
            </center></td>
          </tr>
          <tr>
            <td >&nbsp;</td>
          </tr>
          <tr>
            <td colspan="2"><table width="837" border="1">
              <tr>
                <th width="35" scope="col">No.</th>
                <th width="50" scope="col">ID</th>
                <th width="104" scope="col">Username</th>
                <th width="113" scope="col">Kode Kostum </th>
                <th width="116" scope="col">Tgl. Sewa </th>
                <th width="137" scope="col">Tgl. Kembali </th>
                <th width="134" scope="col">Total Harga </th>
                <th colspan="2" scope="col">&nbsp; </th>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td width="48">Edit</td>
                <td width="42">Hapus</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td width="60%" ><div align="right"></div></td>
            <td width="31%" ><div align="center"><a href="#">OK          </a></div></td>
			<td width="9%" >&nbsp;</td>
          </tr>
          <tr>
            <td >&nbsp;</td>
            <td ><div align="center"><a href="TambahSewa.jsp">Tambah Sewa </a></div></td>
          </tr>
          <tr> </tr>
        </table></td>
        <td width="159" colspan="2" rowspan="8" align="left" valign="top" class="kolom_kanan"><div id="kolom_kanan">
          <table width="100%">
            <tr>
              <td align="left" class="detilkanan"><blockquote>
                <blockquote>
                  <p><b class="text_biru" >CariBarang</b></p>
                </blockquote>
              </blockquote></td>
            </tr>
            <tr>
              <td style="padding-left:5px;">&nbsp;</td>
            </tr>
            <tr>
              <td><table class="tabel_kanan" width=100% cellspacing="1">
                <form style="padding:0; margin:0;" name="formid" action="viewzoom.php" method="post">
                  <tr>
                    <td align="center">Masukkan Masukkan Username atau ID Sewa: </td>
                  </tr>
                  <tr>
                    <td align="center"><input type="text" name="iditemf" size="20" maxlength="10" class="text_box_kanan" autocomplete="off" ></td>
                  </tr>
                  <tr>
                    <td align="center"><input type="submit" name="Enter" value="Enter" class="button_submit"></td>
                  </tr>
                </form>
              </table></td>
            </tr>
            <tr>
              <td >&nbsp;</td>
            </tr>
          </table>
        </div>
          <br></td>
      </tr>
      <tr>
        <td width="175" align="left" valign="top" class="kolom_kiri">    
      <tr>
        <td align="left" valign="top" class="kolom_kiri">    
     </table></td>
  </tr>

  <tr align="right">
    <td align="left" class="footer_bg">
<div id="footer"></div>	
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));

</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-11522604-1");
pageTracker._trackPageview();
} catch(err) {}</script>

</td>
  </tr>

</table>
</body>
</html>