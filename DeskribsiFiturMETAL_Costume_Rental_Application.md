# Penjelasan Fitur METAL (Costume Rental Application) #

**_Berikut ini akan dejelaskan mengenai fitur yang dipakai, kebutuhan fungsional dan alur operasi:_**

  * **Fitur Toko**
    * Kebutuhan fungsional:
      * Menambahkan data toko seperti nama, alamat, telepon, email/fax, dan nama pemilik
      * Mengupdate data toko
    * Alur operasi normal:
      * Pengisian form oleh admin toko pada data toko yang telah tersedia Konfirmasi penyimpanan data
      * Data tersimpan di database
      * Data ditampilkan pada header aplikasi
  * **Fitur Barang**
    * Kebutuhan fungsional:
      * Menambahkan data barang seperti kode, jangka waktu menyewa, aksesoris, jenis, nama, foto dan harga sewa kostume
  * Alur operasi normal:
    * Pengisian form oleh admin toko pada data barang yang telah tersedia
      * Konfirmasi penyimpanan data
      * Data tersimpan di database
      * Data ditampilkan pada interface sistem pertama khusus user dii halaman daftar barang dan di fitur sewa pada sistem kedua

  * **Fitur Profil Penyewa**
    * Kebutuhan fungsional:
      * Menambahkan data penyewa baru seperti kode, nama, jenis kelamin, umur, alamat, telepon dan email/fax penyewa baru
      * Mengupdate data profil penyewa
    * Alur operasi normal:
      * Pengisian form oleh admin toko pada profil penyewa  yang telah tersedia
      * Konfirmasi penyimpanan data
      * Data tersimpan di database
      * Data ditampilkan hanya pada sistem yang kedua milik admin di halaman lihat profil penyewa

  * **Fitur Sewa**
    * Kebutuhan fungsional:
      * Persewaan
        * Menambahkan tanggal sewa dan pengembalian barang, kode barang yang disewa, kode pelanggan yang menyewa, dan total biaya sewa
        * Mengupdate data barang yang disewa seperti menambah lama sewa barang
      * Pengembalian
        * Mencocokkan kode pelanggan yang menyewa dengan konten database
    * Alur operasi normal:
      * Persewaan
        * Pengisian form oleh admin toko pada halaman data persewaan yang telah tersedia
        * Konfirmasi penyimpanan data
        * Data tersimpan di database
        * Data ditampilkan hanya pada sistem yang kedua milik admin di halaman sewa barang
      * Pengembalian
        * Menuliskan kata kunci pada kolom kode pelanggan
        * Sistem melakukan proses pencarian dengan pencocokan kode pelanggan  yang dimasukkan dengan data yang ada di database
        * Menampilkan hasil pencarian kode pelanggan beserta barang yang disewa
  * **Fitur Pengingat**
    * Kebutuhan fungsional:
      * Menambahkan data pelanggan, kostum yang disewakan dan waktu pengingat pengembalian barang
    * Alur operasi normal:
      * Pengisian form oleh admin toko pada halaman pengingat   yang telah tersedia
      * Konfirmasi penyimpanan data
      * Data tersimpan di database
      * Ketika waktu sewa habis maka pop-up akan tampil dan menampilkan pengingat pada sistem kedua milik admin
  * **Fitur Pencari**
    * Kebutuhan fungsional:
      * Mencocokkan kata kunci dengan konten database
    * Alur operasi normal:
      * Menuliskan kata kunci pada kolom pencarian
      * Sistem melakukan proses pencarian dengan pencocokan kata kunci yang dimasukkan dengan data yang ada di database
      * Menampilkan hasil pencarian kata kunci yang dilakukan
