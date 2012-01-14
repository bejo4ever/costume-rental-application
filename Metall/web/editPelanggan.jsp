<%-- 
    Document   : editPelanggan
    Created on : Jan 6, 2012, 1:08:16 PM
    Author     : Putri
--%>


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
            <td width="50%" ><marquee><h4>Sistem Persewaan Kostum Online</h4></marquee></td>
          </tr>
          <tr>
            <td width="50%" colspan="2" class="text_orange"><center>
            
                <h2><b>Edit Pelanggan</b></h2>
            </center></td>
          </tr>
          <tr>
            <td >&nbsp;</td>
          </tr>
          <tr>
            <td colspan="2"><table width="577" height="232" border="0">
            </tr>  
                 <form method='post' action='editpelanggan'>
                <fieldset>
                  
              <tr>
                <td width="117">Username</td>
                   <td>:</td>
                 <td><input type ='text' name='username' value='${pelanggan.username}'/></td>
                    </tr>
              <tr>
                <td>Password</td>
                <td>:</td>
                 <td><input type ='password' name='password' value='${pelanggan.password}'/></td>
                    </tr>
              <tr>
                <td>Nama Pelanggan</td>
                <td>:</td>
                 <td><input type ='text' name='nama_pelanggan' value='${pelanggan.nama_pelanggan}'/></td>
                    </tr>
                    <tr>
                                                                <td>Tipe pengguna</td>
                                                                <td>:</td>
                                                                <td>
                                                                    <select name="tipe">
                                                                        <option value="1">Penyewa Kostum</option>
                                                                    </select>
                                                                </td>
                                                            </tr>
              <tr>
                <td>Alamat</td>
                <td>:</td>
                 <td><input type ='text' name='alamat_pelanggan' value='${pelanggan.alamat_pelanggan}'/></td>
                    </tr>
              <tr>
                 <td>No. Telp</td>
                 <td>:</td>
                 <td><input type ='text' name='telpon_pelanggan' value='${pelanggan.telpon_pelanggan}'/></td>
              </tr>
              <tr>
                <td height="26">&nbsp;</td>
                <td>               </td>
              <tr>
                <td><input type ='submit' value='Edit Pelanggan'/><a href="listpelanggan2">Batalkan</a></td>
              </tr>
                </fieldset></form>
              </tr> 
</tr>
  
            </table></td>
          </tr>
        </table></td>
        <td width="159" colspan="2" rowspan="8" align="left" valign="top" class="kolom_kanan"><div id="kolom_kanan">
          <table width="100%">
            <tr>
              <td class="detilkanan"><img src='kanant.gif' width=12 height=12 /><b class="text_biru" >&nbsp;Cari Kostum</b></td>
            </tr>
            <tr>
              <td style="padding-left:5px;">&nbsp;</td>
            </tr>
            <tr>
              <td><table class="tabel_kanan" width=100% cellspacing="1">
                <form style="padding:0; margin:0;" name="formid" action="viewzoom.php" method="post">
                  <tr>
                    <td align="center">Masukkan Username/Nama/Kategori Kostum :</td>
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
<div id="footer">
  <p>* field harus diisi</p>
</div>	
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
