<%--
Document : DaftarKostum
Created on : Dec 7, 2011, 8:12:11 PM
Author : Putri
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

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
        </style>
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

                                    <!-- <td width=297>
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
                                                    <td class="align_left_top2" valign="top" ></td>
                                                    <td width="585" rowspan="8" align="left" valign="top"><table width="100%">
                                                            <tr>
                                                            <b><h4>Sistem Persewaan Kostum Online</h4></b>
                                                </tr>
                                                <tr>
                                                    <td colspan="2" class="text_orange"><center>
                                                            <marquee>
                                                                <td><b>Daftar Pelanggan</td></h2>
                                                            </marquee>
                                                        </center></td>
                                                </tr>
                                                <tr>
                                                    <td ><a href="#"></a></td>
                                                </tr>
                                                <tr>
                                                    <td height="169" colspan="2"><table width="579" border="1">
                                                            <form method='post'  action=''>
                                                                <table border="1">
                                                                    <tr>
                                                                        <td>ID</td> 
                                                                        <td>Username</td>
                                                                        <td>Nama</td>
                                                                        <td>Alamat</td>
                                                                        <td>No. Telpon</td>
                                                                        <td>Tipe</td>
                                                                        <td>Edit / Hapus</td>
                                                                    </tr>

                                                                    <%Iterator itr;%>
                                                                    <% List plgn = (List) request.getAttribute("pelanggan");
                                                                     
                                                                        for (itr = plgn.iterator(); itr.hasNext();) {
                                                                            entity.Pelanggan pelanggan = (entity.Pelanggan) itr.next();
                                                                    %>
                                                                    <tr>
                                                                    <input type="hidden" name="username" value="<%=pelanggan.getUsername()%>">
                                                                    <td><%=pelanggan.getId()%></td>
                                                                    <td><%=pelanggan.getUsername()%></td>
                                                                    <td><%=pelanggan.getNama_pelanggan()%></td>
                                                                    <td><%=pelanggan.getAlamat_pelanggan()%></td>
                                                                    <td><%=pelanggan.getTelpon_pelanggan()%></td>
                                                                    <%
                                                                        String tipe = "";
                                                                        if (pelanggan.getTipe() == 0) {
                                                                            tipe = "admin";
                                                                        } else if (pelanggan.getTipe() == 1) {
                                                                            tipe = "penyewa kostum";
                                                                        } 
                                                                    %>
                                                                    <td><%out.print(tipe);%></td>
                                                                    <td><a href="editpelanggan?username=<%=pelanggan.getUsername()%>">Edit</a> / <a href="hapuspelanggan2?pelangganid=<%=pelanggan.getId()%>">Hapus</a></td>
                                                                    </tr>
                                                                    <%}%>

                                                                </table></form></td>
                                                </tr>
                                                <tr>
                                                    <td width="50%" >&nbsp;</td>
                                                    <td width="50%" ><a href="tambahpelanggan">Tambah Pelanggan</a></td>
                                                </tr>
                                                <tr> </tr>
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
                                                                        <td align="center">Masukkan Kode/Nama/Kategori kostum</td>
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

