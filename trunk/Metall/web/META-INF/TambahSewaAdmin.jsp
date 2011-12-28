<%-- 
    Document   : TambahSewaAdmin
    Created on : Dec 28, 2011, 10:25:46 PM
    Author     : Rifanda Putri
--%>

 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US">
<head>
<title>Sistem Persewaan Kostum Online</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta http-equiv="CONTENT-LANGUAGE" content="EN-US">
<META NAME="DESCRIPTION" CONTENT="Toko Grosir busana wanita">
<META NAME="KEYWORDS" CONTENT="Sistem Persewaan Kostum Online">


<link href="style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="http://www.bajubaruku.com/logoside.ico">
<SCRIPT src="anim.js"></SCRIPT>

<style type="text/css">
<!--
body {
	background-image: url(../Poster/wallpaper/simple.jpg);
}
-->
</style></head>

<body><center><br>
<center>
<div id="main">
<table width="900" class="border_colapse" >
<tr>
  <td class=align_left_top>
   	   <center>
         <img src="../Poster/logo/logo fix/JUST METALL NO LINE.png" width="591" height="178" alt="metall">
    </center>
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
		     <td width=497><center></center></td>

           </tr>
    <table>
    
      <td align="right"><a href="#"> Logout</a></tr> 
<tr>
	<td align="center" bgcolor="#66CCFF"><table width="690" border="0" cellpadding="0" cellspacing="0" >

        <tr class='menu'>
          <td align="center" bgcolor="#66CCCC" class="text_putih">
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
        <td width="585" rowspan="8" align="center" valign="top"><table width="100%">
  <td width="44%" >&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2" class="text_orange"><center>
      <marquee><h4>Costume Rental Application</h4>
      </marquee>
    </center></td>
  </tr>
  <tr>
    <td colspan="2" class="text_orange"><center>
      <h2><b>Tambah Sewa</b></h2>
    </center></td>
  </tr>
  <tr>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td><blockquote>
      <blockquote>
        <p>Username</p>
      </blockquote>
    </blockquote></td>
    <td width="56%"><form name="form1" method="post" action="">
      <label>
        <input name="id" type="text" id="textfield" size="40">
      </label>
    </form></td>
  </tr>
  <tr>
    <td><blockquote>
      <blockquote>
        <p>Kode Kostum</p>
      </blockquote>
    </blockquote></td>
    <td><form name="form2" method="post" action="">
      <input type="text" name="textfield2" id="textfield2">
    </form></td>
  </tr>
  <tr>
    <td><blockquote>
      <blockquote>
        <p>Tanggal Sewa</p>
      </blockquote>
    </blockquote></td>
    <td><label>
<input type="text" name="jumlah" id="textfield3">
dd/mm/yyyy
    </label></td>
  </tr>
  <tr>
    <td><blockquote>
      <blockquote>
        <p>Tanggal Kembali</p>
      </blockquote>
    </blockquote></td>
    <td><label>
      <input type="text" name="harga" id="textfield4">
    dd/mm/yyyy</label></td>
  </tr>
  <tr>
    <td valign="top"><blockquote>
      <blockquote>
        <p>Total Harga</p>
      </blockquote>
    </blockquote></td>
    <td><form name="form4" method="post" action="">
      <p>
        <input type="text" name="textfield" id="textfield5">
        <br>
      </p>
    </form></td>
  </tr>
  <tr>
    <td valign="top"><blockquote>
      <blockquote>
        <p>&nbsp;</p>
        <p><a href="#">
          <input type="submit" name="Enter2" value="Simpan" class="button_submit">
        </a></p>
      </blockquote>
    </blockquote></td>
    <td><p>&nbsp;</p>
      <form name="form4" method="post" action="">
      <p><a href="#">
        <input type="submit" name="Enter3" value="Cetak" class="button_submit">
      </a><br>
      </p>
    </form></td>
  </tr>
  <tr>
    <td colspan="2"><table width="652" height="2" border="0">
      </table></td>
  </tr>
        </table>
          <p><a href="#"></a></p></td>
        <td width="159" colspan="2" rowspan="8" align="left" valign="top" class="kolom_kanan"><div id="kolom_kanan">
          <table width="100%">
            <tr>
              <td class="detilkanan"><blockquote>
                <p>&nbsp;</p>
              </blockquote></td>
            </tr>
            <tr>
              <td align="center" style="padding-left:5px;"><b class="text_biru" >Cari Barang</b></td>
            </tr>
            <tr>
              <td><table class="tabel_kanan" width=100% cellspacing="1">
                <form style="padding:0; margin:0;" name="formid" action="viewzoom.php" method="post">
                  <tr>
                    <td align="center">Masukkan Kode/Nama/Kategori/Ukuran Kostum :</td>
                  </tr>
                  <tr>
                    <td align="center"><input type="text" name="iditemf" size="20" maxlength="10" class="text_box_kanan" autocomplete="off" ></td>
                  </tr>
                  <tr>
                    <td align="center"><a href="file:///D:/THE%20JUNIORS%20!/UNIVERSITY/ITS/SEMESTER%205/RBPL/FP%20RBPL/dreamweaver/Daftar%20Kostum%20Admin%20Edit.jsp"> <input type="submit" name="Enter" value="Enter" class="button_submit"></td>
                  </tr>
                </form>
              </table></td>
            </tr>
            <tr>
              <td >&nbsp;</td>
            </tr>
          </table>
        </div>
          <p><br>
          </p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>&nbsp; </p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p></td>
      </tr>
      <tr>
        <td width="175" align="left" valign="top" class="kolom_kiri">    
      <tr>
        <td align="left" valign="top" class="kolom_kiri">    
     </table></td>
  </tr>

  <tr align="right">
    <td height="40" align="center" class="footer_bg">
<div id="footer">
  <p>&nbsp;</p>
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
