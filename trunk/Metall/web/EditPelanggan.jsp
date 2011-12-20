<%-- 
    Document   : EditPelanggan
    Created on : Dec 13, 2011, 12:41:35 PM
    Author     : Denia
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

</head>

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
            	<td width=897><img src="headban/logohead.png" width=896 height=254 >
                </td>

            </tr>
     	<table>
    
    <td align="right"><a href="#">Logout</a></tr>
  
<tr>
	<td align="center" bgcolor="#99CC99"><table width="690" border="0" cellpadding="0" cellspacing="0" >

        <tr class='menu'>
          <td align="center" class="text_putih">
            <a class="klikmenu" href="index.php">Daftar Kostum</a>&nbsp;|&nbsp;	
            <a class="klikmenu" href="cara.php">Toko</a>&nbsp;|&nbsp;
            <a class="klikmenu" href="tanya.php">Pelanggan</a>&nbsp;|&nbsp;
            <a class="klikmenu" href="prosespay.php">Sewa Kostum</a>&nbsp;|&nbsp;
            <a class="klikmenu" href="prosespay.php">Pengingat</a>&nbsp;|&nbsp;
            

                   
		</td></tr>
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
            
                <h2><b>Edit Daftar Pelanggan</b></h2>
            </center></td>
          </tr>
          <tr>
            <td >&nbsp;</td>
          </tr>
          <tr>
            <td colspan="2"><table width="577" height="232" border="0">
              <tr>
                <td width="117">Username</td>

                <td width="450"><form name="form2" method="post" action="">
                  <label>
                    <input name="nama_kostum" type="text" id="textfield2">
                  </label>
                </form></td>
              </tr>
              <tr>
                <td>Password</td>
                <td><label>
                  <input type="text" name="jumlah" id="textfield3">
                </label></td>
              </tr>
              <tr>
                <td>Nama Pelanggan</td>
                <td><label>
                  <input name="harga" type="text" id="textfield4" size="40">
                </label></td>
              </tr>
              <tr>
                <td>Alamat</td>
                <td><form name="form4" method="post" action="">
                  <p>
                    <input name="textfield" type="text" id="textfield5" size="70">
                    <br>
                  </p>
                </form></td>
              </tr>
              <tr>
                <td height="30">No. Telp</td>
                <td><input type="text" name="textfield2" id="textfield6"></td>
              </tr>
              <tr>
                <td height="26">&nbsp;</td>
                <td align="center"><a href="#">Simpan</a></td>
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
                    <td align="center">Masukkan Username/Nama/Kategori/Ukuran Kostum :</td>
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
  <script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));

  </script>
  <script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-11522604-1");
pageTracker._trackPageview();
} catch(err) {}</script>
</div></td>
  </tr>

</table>
</body>
</html>
