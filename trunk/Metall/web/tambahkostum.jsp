<%-- 
    Document   : tambahkostum
    Created on : Dec 7, 2011, 6:05:35 PM
    Author     : a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tambah Kostum</h1>
        <p>
        <form action="TambahKostum" method="post" name="TambahKostum">
            
               Kode Kostum: 
               <input type="text" name="kodekostum" /><br />
               Nama Kostum: 
               <input type="text" name="namakostum" /><br /> 
               Kategori Kostum: 
               <input type="text" name="kategorikostum" /><br />
               Jumlah Kostum: 
                <input type="password" name="jumlahkostum" />
               Harga Kostum: 
                <input type="password" name="hargakostum" />
               Deskripsi Kostum: 
                <input type="password" name="password" />
                <input type="submit" value="Submit" />
            
        </form>    
        </p>
    </body>
</html>
