<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%entity.DaftarKostum dk= new entity.DaftarKostum();%>
<%entity.DaftarPelanggan dp= new entity.DaftarPelanggan();%>
<%entity.Pelanggan p= new entity.Pelanggan();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Vastra CRM</title>
<link href="baru.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="mainPan">
  <div id="leftPan">
  	<div id="leftTopPan">
		<a href="index.html"><img src="images/logo.gif" title="Consultant" alt="Consultant" width="160" height="39" border="0" /></a> </div>
		<ul>
			<li><a href="Home">Home </a></li>
			<li><a href="TambahBarang">Tambah Barang </a></li>
		</ul>
		
		
  </div>
  
  <div id="rightPan">
  	<h1>Vastra <br />
  	  <span>CRM Software for Clothing online shop<br />
    </span></h1>
	<h4>Barang Toko </h4>
	<p> <table  border="1" bgcolor="#FFFFFF">
                                        <tr>
                                            <td style="font-weight: bold">ID</td>
                                            <td style="font-weight: bold">Kode</td>
					    <td style="font-weight: bold">Nama</td>
					    <td style="font-weight: bold">Jumlah</td>
					    <td style="font-weight: bold">Harga</td>
					    <td style="font-weight: bold">Kategori</td>	
                                            <td style="font-weight: bold">Deskripsi</td>	

                                            <td style="font-weight: bold">Ubah</td>
                                             <td style="font-weight: bold">Hapus</td>
                                            
                                        </tr>
                                        <%Iterator itr;%>
                                        <% List kostum_list = (List) request.getAttribute("kostum");
                                        
                                        if(dk.cekKostum()){
                                            for (itr = kostum_list.iterator(); itr.hasNext();) {
                                                entity.Kostum kostum = (entity.Kostum) itr.next();
                                        %>
                                        <tr>
                                        <input type="hidden" name="id" value="<%=kostum.getId()%>">
                                        <td><%=kostum.getId()%></td>
                                        <td><%=kostum.getKode_kostum()%></td>
                                        <td><%=kostum.getNama_kostum()%></td>
                                        <td><%=kostum.getJumlah_kostum()%></td>
                                        <td><%=kostum.getHarga_kostum()%></td>
                                        <td><%=kostum.getKategori_kostum()%></td>
                                        <td><%=kostum.getDeskripsi_kostum()%></td>
                                       
                                        <td><a href="editkostum?id=<%=kostum.getId()%>">Ubah</a></td>
                                        <td><a href="hapuskostum?id=<%=kostum.getId()%>">Hapus</a></td>
              </tr>
                                                    <%}}%>
</table>
  </div>
</div>
  
<div id="footermainPan">
  <div id="footerPan">
  	<ul>
  	<li><a href="#">Home</a>| </li>
  	<li><a href="#">About us</a> | </li>
  	<li><a href="#">Network</a>| </li>
  	<li><a href="#">Submission</a> | </li>
  	<li><a href="#">Archives</a> |</li>
	
	<li><a href="#">Contact</a></li>
	</ul>
	<p class="copyright">©vastra all right reaserved</p>
	
	<ul class="templateworld">
  	<li>Design By:</li>
	<li> Kelompok 3 </li>
  </ul>
  </div>
</div>
</body>
</html>
